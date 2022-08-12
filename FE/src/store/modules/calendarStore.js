const calendarStore = {
  namespaced: true,
  state: {
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
  getters: {},
  mutations: {},
  actions: {},
};

export default calendarStore;
