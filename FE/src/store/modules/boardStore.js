const boardStore = {
  namespaced: true,
  state: {
    isMyBoard: false,
    selectedBoard: {
      index: 0,
      number:0,
      title: "오픽 공부 하기 싫다",
      author: "ssafy001",
      date: "2022-08-03",
      hits: 7799,
      contents: "오픽 너무 어렵네요.. 다른분들은 어떠신가요?",
      category:"자유",
    },
    boardNum: 0,
    boardListName:"null",
  },
  getters: {
    getSelectedBoard: function(state){
      return state.selectedBoard;
    },
    getboardListName: function(state){
      return state.boardListName;
    }
  },
  mutations: {
    SET_SELECTED_BOARD: (state, selectedBoard)=>{
      state.selectedBoard = selectedBoard;
    },
    SET_BOARD_LIST_NAME: (state, boardListName)=>{
      state.boardListName = boardListName;
    }
  },
  actions: {
    selectedBoard({commit}, board){
      commit("SET_SELECTED_BOARD",board);
      console.log(board);
    },
    boardListName({commit}, boardListName){
      commit("SET_BOARD_LIST_NAME",boardListName);
    },
  },
};

export default boardStore;
