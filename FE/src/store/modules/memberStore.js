//import jwt_decode from "vue-jwt-decode";
import { login } from "@/api/member.js";
import { getUserInfo } from "../../api/member";
import { get_goals } from "@/api/goal.js";
import { api } from "@/api";
import { get_user_schedule_ofDay } from "@/api/schedule";
// 회원가입 및 로그인을 수행하는 js파일

//const api = apiInstance();

const memberStore = {
  namespaced: true,
  state: () => ({
    isLogin: false, // 로그인 여부
    isLoginError: null, // 로그인 에러 확인
    userInfo: null,
    selectedDate: null,
    goals: [
      {
        name: "정보처리기사",
        dueDate: "2022-09-01",
      },
      {
        name: "OPIC",
        dueDate: "2022-08-30",
      },
    ],
    todo_list: [],
    todos: [],
  }),
  getters: {
    checkUserInfo: function (state) {
      return state.userInfo;
    },
  },
  mutations: {
    SET_IS_LOGIN: (state, isLogin) => {
      state.isLogin = isLogin;
    },
    SET_IS_LOGIN_ERROR: (state, isLoginError) => {
      state.isLoginError = isLoginError;
    },
    SET_USER_INFO: (state, userInfo) => {
      state.isLogin = true;
      state.userInfo = userInfo;
    },
    SET_GOALS: (state, goals) => {
      state.goals = goals;
    },
    SET_TODO_LIST: (state, todo_list) => {
      state.todo_list = todo_list;
    },
    SET_SELECTEDDATE: (state, selectedDate) => {
      state.selectedDate = selectedDate;
    },
  },
  actions: {
    async userConfirm({ commit }, user) {
      // axios 작업
      console.log("login 시작");
      await login(
        user,
        (response) => {
          console.log("message : " + response);
          console.log(response);
          if (response.data.msg == "SUCCESS") {
            console.log("로그인 성공");
            let token = response.data.token;
            commit("SET_IS_LOGIN", true);
            commit("SET_IS_LOGIN_ERROR", false);
            sessionStorage.setItem(`token`, token);
            api.defaults.headers[`token`] = token;
          } else {
            console.log("로그인 실패");
            commit("SET_IS_LOGIN", false);
            commit("SET_IS_LOGIN_ERROR", false);
          }
        },
        () => {},
      );
      console.log("login 끝");
    },

    setLogout({ commit }) {
      commit("SET_USER_INFO", " ");
      commit("SET_IS_LOGIN", false);
      sessionStorage.removeItem("token"); //로그 아웃하면 액세스 토큰을 지워라
      api.defaults.headers["token"] = null;
    },

    async getUserInfo({ commit }, token) {
      //let decode_token = jwt_decode(token);
      console.log(token);
      // axios 필요
      await getUserInfo(
        //decode_token.userid,
        token,
        (response) => {
          console.log("여기까지는 온다");
          console.log(response.data.msg);
          if (response.data.msg === "SUCCESS") {
            console.log("확인");
            console.log(response.data.item);
            commit("SET_USER_INFO", response.data.item);
          } else {
            console.log("유저 정보 없음!!");
          }
        },
        (error) => {
          console.log(error);
        },
      );
    },

    setgoals({ commit }) {
      get_goals(
        (success) => {
          console.log("목표 전달 응답 확인");
          console.log(success);
          if (success.data.msg === "SUCCESS") {
            console.log("목표 저장");
            commit("SET_GOALS", success.data.item);
          } else {
            console.log(" set_goals : 응답 실패!");
          }
        },
        (error) => {
          console.log(" set_goals :: 연결 실패!");
          console.log(error);
        },
      );
    },
    async set_todo_list({ commit }, selectedDate) {
      console.log(selectedDate);
      await get_user_schedule_ofDay(
        selectedDate,
        (response) => {
          console.log(response);
          if (response.data.msg === "SUCCESS") {
            console.log("todoList setting");
            commit("SET_TODO_LIST", response.data.item);
          }
        },
        (error) => {
          console.log(error);
        },
      );
    },
    set_selectedDate({ commit }, selectedDate) {
      commit("SET_SELECTEDDATE", selectedDate);
    },
  },
};

export default memberStore;
