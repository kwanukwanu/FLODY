const groupStore = {
  namespaced: true,
  state: {
    isMyGroup: false,
    selectGroups: {
      name: "none",
    },
    groupNum: 0,
    selectedDate: {
      year: 2022,
      months: 8,
      days: 11,
    },
    todos: [
      {
        description: "네트워크 뽀사기",
        isComplete: false,
        dates: { years: 2022, months: 8, days: 11 },
        color: "red",
      },
      {
        description: "보안 유형 정복",
        isComplete: false,
        dates: { years: 2022, months: 8, days: 11 },
        color: "red",
      },
      {
        description: "21년 2회차 실기풀이",
        isComplete: false,
        dates: { years: 2022, months: 8, days: 11 },
        color: "red",
      },
      {
        description: "java 뽀사기",
        isComplete: false,
        dates: { years: 2022, months: 8, days: 11 },
        color: "red",
      },
      {
        description: "22년 2회차 실기풀이",
        isComplete: false,
        dates: { years: 2022, months: 8, days: 11 },
        color: "red",
      },
      {
        description: "3차 스터디 회의",
        isComplete: false,
        dates: { years: 2022, months: 8, days: 11 },
        color: "red",
      },
    ],
  },
  getters: {
    getSelectGroup: function (state) {
      return state.selectGroups;
    },
  },
  mutations: {
    SET_SELECT_GROUP: (state, selectGroups) => {
      state.selectGroups = selectGroups;
    },
    SET_TODOS: (state, todos) => {
      state.todos = todos;
    },
    SET_SELECTED_DATE: (state, selectedDate) => {
      state.selectedDate = selectedDate;
    },
  },
  actions: {
    selectGroups({ commit }, group) {
      commit("SET_SELECT_GROUP", group);
    },
    set_todos({ commit }, todos) {
      commit("SET_TODOS", todos);
    },
    set_selectedDate({ commit }, selectedDate) {
      commit("SET_SELECTED_DATE", selectedDate);
    },
  },
};

export default groupStore;
