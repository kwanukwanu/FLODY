const groupStore = {
  namespaced: true,
  state: {
    isMyGroup: false,
    selectGroups: {
      name: "none",
    },
    groupNum: 0,
    todos: [
      {
        description: "mike's birthdays.",
        isComplete: false,
        dates: { months: 7, days: 18 },
        color: "red",
      },
      {
        description: "computer science study.",
        isComplete: true,
        dates: { weekdays: 6 },
        color: "blue",
      },
    ],
  },
  getters: {
    getSelectGroup: function(state){
      return state.selectGroups;
    }
  },
  mutations: {
    SET_SELECT_GROUP:(state, selectGroups)=>{
      state.selectGroups = selectGroups;
    }
  },
  actions: {
    selectGroups({commit},group){
      commit("SET_SELECT_GROUP",group);
    }
  },
};

export default groupStore;
