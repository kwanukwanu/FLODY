import { createApp } from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';
import calendar from 'v-calendar';
import BootstrapVue3 from 'bootstrap-vue-3';

import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';
import "v-calendar/dist/style.css";

// import 'firebase';

//   // Your web app's Firebase configuration
//   const firebaseConfig = {
//     apiKey: "AIzaSyDT13YHMOna2yd86BIDFfCUzni81ZZ3Mm0",
//     authDomain: "vue-firebase-automation-5c85c.firebaseapp.com",
//     projectId: "vue-firebase-automation-5c85c",
//     storageBucket: "vue-firebase-automation-5c85c.appspot.com",
//     messagingSenderId: "676310201724",
//     appId: "1:676310201724:web:c0614af27267a13fc860f9"
//   };

// // Initialize Firebase
// firebase.initializeApp(firebaseConfig);

const app = createApp(App);

app.use(store).use(router).use(BootstrapVue3).use(calendar).mount('#app');
