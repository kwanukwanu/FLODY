import { createStore } from "vuex";

import createdPersistedState from "vuex-persistedstate";

import memberStore from "@/store/modules/memberStore.js";
import groupStore from "@/store/modules/groupStore.js";
import calendarStore from "@/store/modules/calendarStore.js";
import boardStore from "@/store/modules/boardStore.js";
import newspidStore from "@/store/modules/newspidStore.js";

export default createStore({
  modules: { memberStore, groupStore, calendarStore, boardStore, newspidStore },
  plugins: [createdPersistedState()],
});
