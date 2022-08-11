//import jwt_decode from "vue-jwt-decode";
import { login } from "@/api/member.js";
import { getUserInfo } from "../../api/member";

// 회원가입 및 로그인을 수행하는 js파일

const memberStore = {
  namespaced: true,
  state: () => ({
    isLogin: true, // 로그인 여부
    isLoginError: null, // 로그인 에러 확인
    userInfo: {
      name: "ssafy_test",
    },
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
  },
};

export default memberStore;
