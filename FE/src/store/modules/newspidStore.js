const newspidStore = {
  namespaced: true,
  state: {
    isMyBoard: false,
    selectedPid: {
      index: 0,
      number: 0,
      title: "공부를 놓지 않는다. 취한다.",
      author: "Brown_Cat",
      date: "2022-08-03",
      hits: 7799,
      contents: "오픽 너무 어렵네요.. 다른분들은 어떠신가요?",
      category: "자유",
    },
    profile: {
      nickName: "Giri_boy",
      board_num: 44,
      follower: 22,
      follow: 13,
      name: "홍시영",
      contents: "비트 찍고 랩하지만 코딩도 잘 하는 기리보이입니다.",
    },
    comments: [
      {
        userId: "Oh_My_Boy",
        contents: "ㅋㅋㅋㅋㅋㅋ 저도 영국",
        tags: null,
        times: "2022.08.03.20:47:33",
        favor: 15,
        profile: "https://placekitten.com/300/900",
      },
      {
        userId: "girl_girls",
        contents: "와 너무 부럽",
        tags: null,
        times: "2022.08.03.21:42:33",
        favor: 18,
        profile: "https://placekitten.com/300/200",
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
    SET_PROFILE: (state, profile) => {
      state.profile = profile;
    },
    SET_COMMENTS: (state, comments) => {
      state.comments = comments;
    },
  },
  actions: {
    selectedBoard({ commit }, board) {
      commit("SET_SELECTED_BOARD", board);
      console.log(board);
    },
    setprofile({ commit }, profile) {
      commit("SET_PROFILE", profile);
    },
    setcomments({ commit }, comments) {
      commit("SET_COMMENTS", comments);
    },
  },
};

export default newspidStore;
