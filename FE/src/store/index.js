import { createStore } from "vuex";

import { memberStore } from "@/store/modules/memberStore.js";
import { boardStore } from "@/store/modules/boardStore.js";
import { groupStore } from "@/store/modules/groupStore.js";

export default createStore({
  modules: {
    modules: { memberStore, boardStore, groupStore },
  },
});
