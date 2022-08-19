//import { getcomments } from "@/api/newspid.js";
import { get_boardList } from "@/api/board";
import { getUserInfo } from "@/api/member";

const newspidStore = {
  namespaced: true,
  state: {
    clickNickname: false,
    isMyBoard: false,
    follows: [],
    followers: [],
    selectedPid: {},
    profile: {},
    newspids: [
      {
        pidNo: 0,
        author: "dofl8787@naver.com",
        profile: "https://placekitten.com/300/300",
        contents: "오늘도 나는 공부를 놓지 않는다. 내 자신에 취한다",
        tags: ["영국", "런던", "스터디"],
        creativetimes: {
          year: 2022,
          month: 8,
          date: 10,
          hour: 11,
          min: 57,
          sec: 30,
        },
        picture: "https://placekitten.com/300/400",
        favor: 878,
        comments: [
          {
            userId: "Oh_My_Boy",
            contents: "ㅋㅋㅋㅋㅋㅋ 저도 영국",
            tags: null,
            times: {
              year: 2022,
              month: 8,
              date: 10,
              hour: 20,
              min: 47,
              sec: 33,
            },
            favor: 15,
            profile: "https://placekitten.com/300/900",
          },
          {
            userId: "giri_man",
            contents: "와 너무 부럽",
            tags: null,
            times: {
              year: 2022,
              month: 8,
              date: 10,
              hour: 20,
              min: 42,
              sec: 33,
            },
            favor: 18,
            profile: "https://placekitten.com/300/200",
          },
          {
            userId: "Oh_My_girl",
            contents: "ㅋㅋㅋㅋㅋㅋ 저도 영국",
            tags: null,
            times: {
              year: 2022,
              month: 8,
              date: 10,
              hour: 19,
              min: 47,
              sec: 33,
            },
            favor: 16,
            profile: "https://placekitten.com/300/800",
          },
          {
            userId: "stupid_birds",
            contents: "부럽..",
            tags: null,
            times: {
              year: 2022,
              month: 8,
              date: 10,
              hour: 18,
              min: 42,
              sec: 33,
            },
            favor: 19,
            profile: "https://placekitten.com/300/600",
          },
        ],
      },
      {
        pidNo: 1,
        author: "admin@ssafy.com",
        profile: "https://placekitten.com/300/400",
        contents: "오늘도 OPIC 공부 열심히 하기!",
        tags: ["OPIC", "스터디"],
        creativetimes: {
          year: 2022,
          month: 8,
          date: 9,
          hour: 23,
          min: 57,
          sec: 30,
        },
        picture: "https://placekitten.com/300/300",
        favor: 732,
        comments: [
          {
            userId: "adrianycc",
            contents: "OPIC 너무 어렵다ㅠㅠ",
            tags: null,
            times: {
              year: 2022,
              month: 8,
              date: 10,
              hour: 0,
              min: 13,
              sec: 32,
            },
            favor: 15,
            profile: "https://placekitten.com/300/900",
          },
          {
            userId: "giri_man",
            contents: "모두 AL 받을때까지 화이팅!",
            tags: null,
            times: {
              year: 2022,
              month: 8,
              date: 10,
              hour: 1,
              min: 15,
              sec: 35,
            },
            favor: 18,
            profile: "https://placekitten.com/300/200",
          },
          {
            userId: "Oh_My_girl",
            contents: "영어는 정말 싫다...",
            tags: null,
            times: {
              year: 2022,
              month: 8,
              date: 10,
              hour: 3,
              min: 55,
              sec: 37,
            },
            favor: 16,
            profile: "https://placekitten.com/300/800",
          },
          {
            userId: "stupid_birds",
            contents: "화이팅...",
            tags: null,
            times: {
              year: 2022,
              month: 8,
              date: 10,
              hour: 8,
              min: 42,
              sec: 53,
            },
            favor: 19,
            profile: "https://placekitten.com/300/600",
          },
        ],
      },
    ],
  },
  getters: {
    getSelectedBoard: function (state) {
      return state.selectedBoard;
    },
    getProfile: function (state) {
      return state.profile;
    },
    getComments: function (state) {
      return state.comments;
    },
  },
  mutations: {
    SET_SELECTED_BOARD: (state, selectedBoard) => {
      state.selectedBoard = selectedBoard;
    },
    SET_COMMENTS: (state, comments) => {
      state.comments = comments;
    },
    SET_CLICK_NICKNAME: (state, clickNickname) => {
      state.clickNickname = clickNickname;
    },
    SET_PROFILE: (state, profile) => {
      state.profile = profile;
    },
    SET_NEWSPIDS: (state, newspids) => {
      state.newspids = newspids;
    },
  },
  actions: {
    selectedBoard({ commit }, board) {
      commit("SET_SELECTED_BOARD", board);
      console.log(board);
    },
    setcomments({ commit }, comments) {
      commit("SET_COMMENTS", comments);
      console.log("setcomments");
      console.log(comments);
    },

    async setClickNickname({ commit }, clickNickname) {
      commit("SET_CLICK_NICKNAME", clickNickname);
      await getUserInfo(
        clickNickname,
        (response) => {
          console.log(response);
          if (response.data.msg === "SUCCESS") {
            const profile = {
              email: response.data.item.email,
              profile: response.data.item.profile,
              name: response.data.item.name,
              nickname: response.data.item.nickname,
              followers: response.data.item.followers,
              followings: response.data.item.followings,
              posts: response.data.item.posts,
              introduction: response.data.item.introduction,
            };
            commit("SET_PROFILE", profile);
            console.log("end");
          }
        },
        (error) => {
          console.log(error);
        },
      );
    },
    setFollowers({ commit }, followers) {
      commit("SET_FOLLOWERS", followers);
    },
    set_profile({ commit }, userInfo) {
      const profile = {
        email: userInfo.email,
        profile: userInfo.profile,
        name: userInfo.name,
        nickname: userInfo.nickname,
        followers: userInfo.followers,
        followings: userInfo.followings,
        posts: userInfo.posts,
        introduction: userInfo.introduction,
      };
      commit("SET_PROFILE", profile);
    },
    // 뉴스피드 불러오기
    async set_newspids({ commit }) {
      const data = {
        page: 1,
        category: "뉴스피드",
        board: 5,
      };
      await get_boardList(
        data,
        (response) => {
          if (response.data.msg === "SUCCESS") {
            console.log("게시판 불러오기 성공");
            commit("SET_NEWSPIDS", response.data.item);
          } else {
            console.log("게시판 불러오기 오류");
          }
        },
        () => {},
      );
    },
  },
};

export default newspidStore;
