const boardStore = {
  namespaced: true,
  state: {
    isMyBoard: false,
    selectedBoard: {
      num: 0,
      author: "ssafy001",
      category: "자유",
      title: "오픽 공부 하기 싫다",
      content: " 오픽 너무 어렵네요.. 다른분들은 어떠신가요?",
      hit: 7799,
    },
    boardNum: 0,
  },
  getters: {},
  mutations: {},
  actions: {},
};

export default boardStore;
