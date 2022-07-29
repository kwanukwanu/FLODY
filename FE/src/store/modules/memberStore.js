import jwt_decode from "vue-jwt-decode";
//import { login } from "@/api/member.js";
//import { findById } from "../../api/member";

// 회원가입 및 로그인을 수행하는 js파일

const memberStore = {
  namespaced: true,
  state: () => ({
    isLogin: false, // 로그인 여부

    isLoginError: false, // 로그인 에러 확인
    userInfo: 0,
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
      //멤버 로그인에서 여기로

      console.log("userConfirm : " + user);

      // axios 작업
      // await login(
      //   user,
      //   (response) => {
      //     if (response.data.message == "success") {
      //       let token = response.data["access-token"];
      //       commit("SET_IS_LOGIN", true);
      //       commit("SET_IS_LOGIN_ERROR", false);
      //       sessionStorage.setItem("access-token", token);
      //     } else {
      //       commit("SET_IS_LOGIN", false);
      //       commit("SET_IS_LOGIN_ERROR", true);
      //     }
      //   },
      //   () => { },
      // );

      // 현재는 로그인이 되도록 설정
      commit("SET_IS_LOGIN", true);
      commit("SET_IS_LOGIN_ERROR", false);
    },

    getUserInfo({ commit }, token) {
      let decode_token = jwt_decode(token);
      console.log(decode_token.userid);

      // axios 필요
      /*
      findById(
        decode_token.userid,
        (response) => {
          console.log("여기까지는 온다");
          console.log(response.data.message);
          if (response.data.message === "success") {
            commit("SET_USER_INFO", response.data.userInfo);
          } else {
            console.log("유저 정보 없음!!");
          }
        },
        (error) => {
          console.log(error);
        },
      );
      */

      const data = {
        id: "ssafy",
        password: "1234",
        name: "김싸피",
      };
      commit("SET_USER_INFO", data);
    },
  },
};

export default memberStore;
