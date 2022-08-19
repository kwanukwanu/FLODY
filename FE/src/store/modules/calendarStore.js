import { get_schedules_date } from "@/api/goal";

const calendarStore = {
  namespaced: true,
  state: {
    selectedDate: {
      year: 2022,
      months: 8,
      days: 11,
    },
    todos: [],
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
  getters: {},
  mutations: {
    SET_TODOS: (state, todos) => {
      state.todos = todos;
    },
    SET_TODO_LIST: (state, todo_list) => {
      state.todo_list = todo_list;
    },
  },
  actions: {
    async set_todos({ commit }, dates) {
      await get_schedules_date(
        dates,
        (response) => {
          if (response.data.msg === "SUCCESS") {
            console.log("success todos");
            commit("SET_TODOS", response.data.item);
          } else {
            console.log("responseError");
          }
        },
        (error) => {
          console.log(error);
        },
      );
    },
  },
};

export default calendarStore;
