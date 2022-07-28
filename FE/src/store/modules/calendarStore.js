const calendarStore = {
  namespaced: true,
  state: {
    todos: [
      {
        description: "Take Noah to basketball practice.",
        isComplete: false,
        dates: { months: 7, days: 18 },
        color: "red",
      },
      {
        description: "Take Noah to basketball practice.",
        isComplete: true,
        dates: { weekdays: 5 },
        color: "blue",
      },
    ],
  },
  getters: {},
  mutations: {},
  actions: {},
};

export default boardStore;
