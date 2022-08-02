<template>
  <div>
    <h2 v-if="user">Signed In User : {{ user }}</h2>
    <div id="firebaseui-auth-container"></div>
    <div id="loader">Loading...</div>
    <br />
    <div v-if="isSignedIn">
      <button @click="handleSignedOut">로그아웃</button>
    </div>
  </div>
</template>

<script>
import { ref } from 'vue';
import firebaseConfig from '@/firebaseConfig';
import firebase from 'firebase/compat/app';

firebase.initializeApp(firebaseConfig);

import * as firebaseui from 'firebaseui';
import 'firebaseui/dist/firebaseui.css';

import { getAuth, signOut } from "firebase/auth";
const auth = getAuth();


// import { useRoute } from 'vue-router';

// import { useRouter } from 'vue-router' // import router
// const email = ref('')
// const password = ref('')
// const router = useRouter() // get a reference to our vue router
// const register = () => {
//   firebase
//     .auth() // get the auth api
//     .createUserWithEmailAndPassword(email.value, password.value) // need .value because ref()
//     .then((data) => {
//       console.log('Successfully registered!');
//       router.push('/feed') // redirect to the feed
//     })
//     .catch(error => {
//       console.log(error.code)
//       alert(error.message);
//     });
// }

export default {
  setup() {
    const user = ref(null);
    const isSignedIn = ref(false);

    const uiConfig = {
      signInFlow: 'popup',
      signInSuccessUrl: "http://localhost:8080/main",
      signInOptions: [
        firebase.auth.GoogleAuthProvider.PROVIDER_ID,
        //firebase.auth.FacebookAuthProvider.PROVIDER_ID,
        //firebase.auth.TwitterAuthProvider.PROVIDER_ID,
        //firebase.auth.GithubAuthProvider.PROVIDER_ID
      ],
      callbacks: {
        signInSuccessWithAuthResult: function(authResult) {
          user.value = authResult.user.displayName;
          console.log(authResult);
          isSignedIn.value = true;
          console.log('Signed in by user ' + user.value);

          // so it doesn't refresh the page
          return false;
        },
        uiShown: function() {
          // The widget is rendered.
          // Hide the loader.
          document.getElementById('loader').style.display = 'none';
        }
      }
    }

    // Initialize the FirebaseUI Widget using Firebase.
    var ui = new firebaseui.auth.AuthUI(firebase.auth());

    ui.start('#firebaseui-auth-container', uiConfig);

    const handleSignedOut = () => {
      signOut(auth).then(() => {
        // Sign-out successful.
        user.value = null;
        isSignedIn.value = false;
        console.log('signed out');
        ui.start('#firebaseui-auth-container', uiConfig);
      }).catch((error) => {
        // An error happened.
        console.log(error);
      });
    }

    return {
      user,
      isSignedIn,
      handleSignedOut
    }
  }
}
</script>

<style>

</style>