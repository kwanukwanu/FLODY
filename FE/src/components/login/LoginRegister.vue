<template>
  <div>
    <!-- <h2 v-if="user">Signed In User : {{ user }}</h2>
    <div id="firebaseui-auth-container"></div>
    <div id="loader">Loading...</div> -->
    <img src="@/assets/google_logo.png" @click="googleSignIn" style="height: 40px; width: 40px; cursor: pointer;"/>
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

// import * as firebaseui from 'firebaseui';
import 'firebaseui/dist/firebaseui.css';

// import { getAuth, signOut, GoogleAuthProvider, signInWithPopup } from "firebase/auth";
import { getAuth, GoogleAuthProvider, signInWithPopup } from "firebase/auth";
// const auth = getAuth();

export default {
  setup() {
    const user = ref(null);
    const isSignedIn = ref(false);

    // const uiConfig = {
    //   signInFlow: 'popup',
    //   signInSuccessUrl: "http://localhost:8080/main",
    //   signInOptions: [
    //     firebase.auth.GoogleAuthProvider.PROVIDER_ID,
    //     firebase.auth.FacebookAuthProvider.PROVIDER_ID,
    //     //firebase.auth.TwitterAuthProvider.PROVIDER_ID,
    //     //firebase.auth.GithubAuthProvider.PROVIDER_ID
    //   ],
    //   callbacks: {
    //     signInSuccessWithAuthResult: function(authResult) {
    //       user.value = authResult.user.displayName;
    //       console.log(authResult);
    //       isSignedIn.value = true;
    //       console.log('Signed in by user ' + user.value);

    //       // so it doesn't refresh the page
    //       return false;
    //     },
    //     uiShown: function() {
    //       // The widget is rendered.
    //       // Hide the loader.
    //       document.getElementById('loader').style.display = 'none';
    //     }
    //   }
    // }

    // Initialize the FirebaseUI Widget using Firebase.
    // var ui = new firebaseui.auth.AuthUI(firebase.auth());

    // ui.start('#firebaseui-auth-container', uiConfig);

    // const handleSignedOut = () => {
    //   signOut(auth).then(() => {
    //     // Sign-out successful.
    //     user.value = null;
    //     isSignedIn.value = false;
    //     console.log('signed out');
    //     ui.start('#firebaseui-auth-container', uiConfig);
    //   }).catch((error) => {
    //     // An error happened.
    //     console.log(error);
    //   });
    // }

    const googleSignIn = () => {
        const provider = new GoogleAuthProvider();
        signInWithPopup(getAuth(), provider)
          .then((result) => {
            console.log(result.user);
            console.log('Signed in by user ' + result.user.displayName);
          })
          .catch((error) => {
            console.log(error);
          })

      };

    return {
      user,
      isSignedIn,
      // handleSignedOut,
      googleSignIn
    }
  }
}
</script>

<style>

</style>