import { createRouter, createWebHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView,
    redirect: "/main",
    children: [
      {
        path:'/main',
        name:'loginmain',
        component:()=>import("@/components/login/LoginMain.vue"),
      },
      {
        path:'/membership',
        name:'loginMembership',
        component:()=>import("@/components/login/LoginMembership.vue"),
      }
    ],
  },
  {
    path: '/study',
    name: 'study',
    component: () =>import("@/views/StudyView.vue")
  },
  {
    path:'/newspid',
    name:'newspid',
    component: () =>import("@/views/NewspidView.vue")
  },
  {
    path: '/search',
    name: 'search',
    component: () =>import("@/views/SearchView.vue")
  },
  {
    path:'/group',
    name:'group',
    component: () =>import("@/views/GroupView.vue"),
  },
  {
    path:'/board',
    name:'board',
    component: () =>import("@/views/BoardView.vue"),
    children:[
      {
        path:"main",
        name:"boardmain",
        component:() => import("@/components/board/BoardMain.vue"),
      },
      {
        path:"list",
        name:"boardlist",
        component: () => import("@/components/board/BoardList.vue"),
      },
      {
        path:"detail",
        name:"boarddetail",
        component:() => import("@/components/board/BoardDetail.vue"),
      }
    ],
  },
  
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
