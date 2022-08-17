import { get_todo_list, get_group_list_by_mygroups, get_group_by_keyword } from "@/api/group";

const groupStore = {
  namespaced: true,
  state: {
    isMyGroup: false,
    myGroupItem: [],
    groupSearchResult: [],
    selectGroups: {
      name: "none",
      goal: "none",
      date: null,
    },
    groupNum: 0,
    selectedDate: {
      year: 2022,
      months: 8,
      days: 11,
    },
    todos: [
      {
        dates: { years: 2022, months: 8, days: 11 },
        isComplete: false,
        color: "red",
        nums: 0,
      },
    ],
    todo_list: [
      {
        dates: { years: 2022, months: 8, days: 11 },
        description: "네트워크 뽀사기",
        isComplete: false,
      },
      {
        dates: { years: 2022, months: 8, days: 11 },
        description: "보안 유형 정복",
        isComplete: true,
      },
      {
        dates: { years: 2022, months: 8, days: 11 },
        description: "21년 2회차 실기풀이",
        isComplete: false,
      },
      {
        dates: { years: 2022, months: 8, days: 11 },
        description: "java 뽀사기",
        isComplete: true,
      },
      {
        dates: { years: 2022, months: 8, days: 11 },
        description: "22년 2회차 실기풀이",
        isComplete: false,
      },
      {
        dates: { years: 2022, months: 8, days: 11 },
        description: "3차 스터디 회의",
        isComplete: false,
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
    SET_TODO_LIST: (state, todo_list) => {
      state.todo_list = todo_list;
    },
    SET_MY_GROUP_ITEM: (state, myGroupItem) => {
      state.myGroupItem = myGroupItem;
    },
    SET_GROUP_SEARCH_RESULT: (state, groupSearchResult) => {
      state.groupSearchResult = groupSearchResult;
    }
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
    async set_todo_list({ commit }, date) {
      await get_todo_list(
        date,
        (response) => {
          console.log("message : " + response);
          console.log(response);
          if (response.msg == "SUCCESS") {
            console.log("리스트 받아오기 성공");
            commit("SET_TODO_LIST", response.item.list);
          } else {
            console.log("받아오기 실패");
          }
        },
        () => {},
      );
    },
    async set_my_group_item({commit}) {
      await get_group_list_by_mygroups(
        (response) => {
          console.log(response);
          if(response.data.msg == "SUCCESS") {
            console.log("성공");
            commit("SET_MY_GROUP_ITEM", response.data.item);
          } else {
            console.log("실패");
          }
        },
        (error) => {
          console.log(error);
        }
      )
    },
    async set_group_search_result({commit}, keyword) {
      await get_group_by_keyword(
        keyword,
        (response) => {
          console.log(response);
          if(response.data.msg == "SUCCESS") {
            console.log("스터디 검색 완료!!!");
            commit("SET_GROUP_SEARCH_RESULT", response.data.item);
          } else {
            console.log("스터디 검색 실패 ㅠㅠ");
          }
        },
        (error) => {
          console.log(error);
        }
      ) 
    },
    init_group_search_result({commit}) {     
      commit("SET_GROUP_SEARCH_RESULT", null);
    },
    
  },
};

export default groupStore;
