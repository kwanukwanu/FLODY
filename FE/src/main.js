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

const app = createApp(App);

app.use(store).use(router).use(BootstrapVue3).use(calendar).mount('#app');
