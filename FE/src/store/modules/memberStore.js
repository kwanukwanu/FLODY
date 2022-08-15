//import jwt_decode from "vue-jwt-decode";
import { login } from "@/api/member.js";
import { getUserInfo } from "../../api/member";
import { get_goal_one } from "@/api/goal.js";
// 회원가입 및 로그인을 수행하는 js파일

const memberStore = {
  namespaced: true,
  state: () => ({
    isLogin: false, // 로그인 여부
    isLoginError: null, // 로그인 에러 확인
    userInfo: null,
    goals: [
      {
        subject: "정보처리기사",
        mod: 10,
      },
      {
        subject: "OPIC",
        mod: 3,
      },
    ],
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
            let token = response.data["access-token"];
            commit("SET_IS_LOGIN", true);
            commit("SET_IS_LOGIN_ERROR", false);
            sessionStorage.setItem("access-token", token);
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

    getUserInfo({ commit }, token) {
      //let decode_token = jwt_decode(token);
      console.log(token);
      // axios 필요
      getUserInfo(
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
    setLogout({ commit }) {
      commit("SET_USER_INFO", " ");
      commit("SET_IS_LOGIN", false);
      sessionStorage.removeItem("access-token"); //로그 아웃하면 액세스 토큰을 지워라
    },
    setgoals({ commit }, userId) {
      console.log(userId);
      get_goal_one(
        userId,
        (response) => {
          console.log("응답 확인");
          if (response.msg === "SUCCESS") {
            console.log("목표 저장");
            commit("SET_GOALS", response);
          } else {
            console.log("응답 실패!");
          }
        },
        (error) => {
          console.log("응답 실패!");
          console.log(error);
        },
      );
    },
  },
};

export default memberStore;
