//import { getcomments } from "@/api/newspid.js";

const newspidStore = {
  namespaced: true,
  state: {
    clickNickname: false,
    comments: [
      [
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
      [
        {
          userId: "adrianycc",
          contents: "OPIC 너무 어렵다ㅠㅠ",
          tags: null,
          times: new Date(2022, 8, 10, 0, 13, 32),
          favor: 15,
          profile: "https://placekitten.com/300/900",
        },
        {
          userId: "giri_man",
          contents: "모두 AL 받을때까지 화이팅!",
          tags: null,
          times: new Date(2022, 8, 10, 1, 15, 35),
          favor: 18,
          profile: "https://placekitten.com/300/200",
        },
        {
          userId: "Oh_My_girl",
          contents: "영어는 정말 싫다...",
          tags: null,
          times: new Date(2022, 8, 10, 3, 55, 37),
          favor: 16,
          profile: "https://placekitten.com/300/800",
        },
        {
          userId: "stupid_birds",
          contents: "화이팅...",
          tags: null,
          times: new Date(2022, 8, 10, 8, 42, 53),
          favor: 19,
          profile: "https://placekitten.com/300/600",
        },
      ],
    ],
    isMyBoard: false,
    follows:[],
    followers:[],
    selectedPid: {},
    profile:{},
    newspids: [
      {
        pidNo: 0,
        author: "adrianycc",
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
        picture: "https://placekitten.com/400/",
        favor: 878,
      },
      {
        pidNo: 1,
        author: "Brown_Cat",
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
    SET_PROFILE:(state, profile)=>{
      state.profile = profile;
    }
  },
  actions: {
    selectedBoard({ commit }, board) {
      commit("SET_SELECTED_BOARD", board);
      console.log(board);
    },
    setcomments({ commit }, comments) {
      commit("SET_COMMENTS",comments);
      console.log("setcomments");
      console.log(comments);
    },
    setClickNickname({ commit }, clickNickname) {
      commit("SET_CLICK_NICKNAME", clickNickname);
    },
    setFollowers({commit}, followers){
      commit("SET_FOLLOWERS",followers);
    },
    set_profile({commit},userInfo){
      const profile={
        profile: userInfo.profile,
        name: userInfo.name,
        nickname: userInfo.nickname,
        followers: userInfo.followers,
        followings: userInfo.followings,
        posts: userInfo.posts,
        introduction: userInfo.introduction,
      }
      commit("SET_PROFILE",profile);
    }
  },
};

export default newspidStore;
