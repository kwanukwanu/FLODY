import firebase from 'firebase/compat/app'
import 'firebase/compat/auth'
import 'firebase/compat/firestore'
import firebaseConfig from '@/firebaseConfig'

// import Filter from 'bad-words'
import { ref, onUnmounted, computed } from 'vue'
import {useStore} from "vuex";

firebase.initializeApp(firebaseConfig)

const auth = firebase.auth()

export function useAuth() {
  const user = ref(null)
  const unsubscribe = auth.onAuthStateChanged(_user => (user.value = _user))
  onUnmounted(unsubscribe)
  const isLogin = computed(() => user.value !== null)

  const signIn = async () => {
    const googleProvider = new firebase.auth.GoogleAuthProvider()
    await auth.signInWithPopup(googleProvider)
  }
  const signOut = () => auth.signOut()

  return { user, isLogin, signIn, signOut }
}

const firestore = firebase.firestore()
const messagesCollection = firestore.collection('messages')
const messagesQuery = messagesCollection.orderBy('createdAt', 'desc').limit(100)
// const filter = new Filter()

export function useChat() {
  const messages = ref([])
  const unsubscribe = messagesQuery.onSnapshot(snapshot => {
    messages.value = snapshot.docs
      .map(doc => ({ id: doc.id, ...doc.data() }))
      .reverse()
  })
  onUnmounted(unsubscribe)
  
  const store = useStore();
  // const { user, isLogin } = useAuth()
  const sendMessage = text => {
    // if (!isLogin.value) return
    // const { photoURL, uid, displayName } = user.value
    console.log(store.state.memberStore.nickname)
    console.log(store.state.chatStore.targetId);
    messagesCollection.add({
      // userName: displayName,
      userName: store.state.memberStore.userInfo.nickname,
      // userId: uid,
      userId: store.state.memberStore.userInfo.email,
      // userPhotoURL: photoURL,
      userPhotoURL: store.state.memberStore.userInfo.profile,
      // text: filter.clean(text),
      text: text,
      createdAt: firebase.firestore.FieldValue.serverTimestamp(),
      // targetId: "ssafy",
      targetId: store.state.chatStore.targetId,
    })
  }

  return { messages, sendMessage }
}