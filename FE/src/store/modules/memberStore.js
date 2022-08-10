import jwt_decode from "vue-jwt-decode";
import { login } from "@/api/member.js";
import { findById } from "../../api/member";

// 회원가입 및 로그인을 수행하는 js파일

const memberStore = {
  namespaced: true,
  state: () => ({
    isLogin: false, // 로그인 여부
    isLoginError: null, // 로그인 에러 확인
    userInfo: null,
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
      await login(
        user,
        (response) => {
          console.log("message : "+ response.data.message);
          if (response.data.message == "success") {
            console.log("응답 성공");
            console.log(response.data);
            if(response.data["msg"]==true)
            {
              let token = response.data["access-token"];
              commit("SET_IS_LOGIN", true);
              commit("SET_IS_LOGIN_ERROR", false);
              sessionStorage.setItem("access-token", token);
            }
            else{
              console.log("로그인 실패");
              commit("SET_IS_LOGIN", false);
              commit("SET_IS_LOGIN_ERROR", false);
            }
          } else {
            console.log("응답 실패");
          }
        },
        () => {},
      );
    },

    getUserInfo({ commit }, token) {
      let decode_token = jwt_decode(token);
      console.log(decode_token.userid);
      // axios 필요
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
    },
  },
};

export default memberStore;
