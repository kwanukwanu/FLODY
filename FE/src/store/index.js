import { createStore } from "vuex";

import memberStore from "./modules/memberStore.js";
import boardStore from "./modules/boardStore.js";
import groupStore from "./modules/groupStore.js";

export default createStore({
  state() {
    return {
      count: 10,
    };
  },
  getters: {
    time2(state) {
      return state.count * 2;
    },
  },
  mutations: {
    setCounter(state, value) {
      state.count = value;
    },
  },
  actions: {},
  modules: {
    modules: { memberStore, boardStore, groupStore },
  },
});
