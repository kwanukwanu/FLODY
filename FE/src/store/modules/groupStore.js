import {
  get_group_list_by_mygroups,
  get_group_by_keyword,
  get_group_one,
  get_group_member_list_by_groNo,
  get_group_schedule_ofDay,
  get_group_schedule_ofMonth,
} from "@/api/group";

const groupStore = {
  namespaced: true,
  state: {
    isMyGroup: false,
    myGroupItem: [],
    groupSearchResult: [],
    groupInfo: [],
    groupMember: [],
    input: {
      keyword: "",
      pageNow: 0,
      size: 5,
    },
    selectGroups: {
      groNo: -1,
      name: "none",
      memberList: [],
      goal: "none",
      date: null,
    },
    groupNum: 0,
    selectedDate: "2022-08-18",
    todos: [],
    todo_list: [
      {
        title: "",
        detail: "",
        startDate: "yyyy-MM-dd",
        endDate: "yyyy-MM-dd",
        done: false,
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
    },
    SET_GROUP_INFO: (state, groupInfo) => {
      state.groupInfo = groupInfo;
    },
    SET_GROUP_MEMBER: (state, groupMember) => {
      state.groupMember = groupMember;
    },
  },
  actions: {
    selectGroups({ commit }, group) {
      commit("SET_SELECT_GROUP", group);
    },
    set_selectedDate({ commit }, selectedDate) {
      commit("SET_SELECTED_DATE", selectedDate);
      console.log(":: " + selectedDate);
    },
    async set_todo_list({ commit }, data) {
      console.log("set_todo_list");
      console.log(data.groNo);
      console.log(data.selectedDate);
      await get_group_schedule_ofDay(
        data.groNo,
        data.selectedDate,
        (response) => {
          console.log(response);
          if (response.data.msg === "SUCCESS") {
            console.log("todoList setting");
            commit("SET_TODO_LIST", response.data.item);
          }
        },
        (error) => {
          console.log(error);
        },
      );
    },

    async set_todos({ commit }, groNo, selectedDate) {
      await get_group_schedule_ofMonth(
        groNo,
        selectedDate,
        (response) => {
          console.log(response);
          if (response.data.msg === "SUCCESS") {
            console.log("todoList setting");
            commit("SET_TODOS", response.data.item);
          }
        },
        (error) => {
          console.log(error);
        },
      );
    },

    async set_my_group_item({ commit }) {
      await get_group_list_by_mygroups(
        (response) => {
          console.log(response);
          if (response.data.msg == "SUCCESS") {
            console.log("성공");
            commit("SET_MY_GROUP_ITEM", response.data.item);
          } else {
            console.log("실패");
          }
        },
        (error) => {
          console.log(error);
        },
      );
    },
    async set_group_search_result({ commit }, keyword) {
      await get_group_by_keyword(
        keyword,
        (response) => {
          console.log(response);
          if (response.data.msg == "SUCCESS") {
            console.log("스터디 검색 완료!!!");
            commit("SET_GROUP_SEARCH_RESULT", response.data.item);
          } else {
            console.log("스터디 검색 실패 ㅠㅠ");
          }
        },
        (error) => {
          console.log(error);
        },
      );
    },
    init_group_search_result({ commit }) {
      commit("SET_GROUP_SEARCH_RESULT", null);
    },
    async set_group_info({ commit }, groNo) {
      await get_group_one(
        groNo,
        (response) => {
          console.log(response);
          if (response.data.msg == "SUCCESS") {
            console.log("그룹 정보 탐색 성공!!!");
            commit("SET_GROUP_INFO", response.data.item);
          } else {
            console.log("그룹 정보 탐색 실패 ㅠㅠ");
          }
        },
        (error) => {
          console.log(error);
        },
      );
    },
    init_group_info({ commit }) {
      const data = "";
      commit("SET_GROUP_INFO", data);
    },
    async set_group_member({ commit }, groNo) {
      await get_group_member_list_by_groNo(
        groNo,
        (response) => {
          console.log(response);
          if (response.data.msg == "SUCCESS") {
            console.log("그룹 멤버 탐색 성공!!!");
            commit("SET_GROUP_MEMBER", response.data.item);
          } else {
            console.log("그룹 멤버 탐색 실패 ㅠㅠ");
          }
        },
        (error) => {
          console.log(error);
        },
      );
    },
    init_group_member({ commit }) {
      commit("SET_GROUP_MEMBER", null);
    },
  },
};

export default groupStore;
