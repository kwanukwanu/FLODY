import { createStore } from "vuex";

import memberStore from "@/store/modules/memberStore.js";
import groupStore from "@/store/modules/groupStore.js";
import calendarStore from "@/store/modules/calendarStore.js";
import boardStore from "@/store/modules/boardStore.js";

export default createStore({
  modules: { memberStore,groupStore,calendarStore,boardStore },
});
