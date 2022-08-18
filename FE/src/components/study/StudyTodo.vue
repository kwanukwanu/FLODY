<template>
  <b-card style="border-color: #a48282; max-width: 35rem; height:304px;">
    <b-row>
      <b-col cols="10">
        <span style="text-align:left; font-weight:bold; font-size: large; vertical-align:-webkit-baseline-middle;">Todo
          List</span>
      </b-col>
      <b-col cols="2">
        <span style="text-align:right;">
          <b-button size="sm" style="background-color:white; border-color:white;" v-b-modal.modal-8><svg width="24"
              height="24" fill="none" xmlns="http://www.w3.org/2000/svg">
              <path d="M12 5v14m-7-7h14" stroke="#444" stroke-width="2" stroke-linecap="round"
                stroke-linejoin="round" />
            </svg></b-button>
        </span>
      </b-col>
    </b-row>
    <hr />
    <div id="tab_todo" style="height:205px; overflow-y: scroll;">
      <ul style="list-style-type :none;">
        <study-todo-items v-for="(item, index) in todo_list" :key="item.index = index" v-bind="item">
        </study-todo-items>
      </ul>
    </div>
  </b-card>
  <study-todo-modals></study-todo-modals>
</template>

<script>
import { computed } from "vue";
import { useStore } from "vuex";

import StudyTodoItems from "./items/StudyTodoItems.vue";
import StudyTodoModals from "./modals/StudyTodoModals.vue";

export default {
  components: {
    StudyTodoItems,
    StudyTodoModals,
  },
  setup() {
    const isTodos = false;

    const store = useStore();
    const todo_list = computed(() => store.state.memberStore.todo_list);
    return { isTodos, store, todo_list };
  },
  methods: {

  }
}

</script>

<style>
.checkbox {
  accent-color: #E3D6D6;
}

li {
  margin-bottom: 15px;
}

input[type=checkbox]:checked+label.strikethrough {
  text-decoration: line-through;
  text-decoration-color: #BC6464;
  color: #9F9F9F;
}

#tab_todo::-webkit-scrollbar {
  width: 10px;
}

#tab_todo::-webkit-scrollbar-track {
  background-color: transparent;
}

#tab_todo::-webkit-scrollbar-thumb {
  border-radius: 10px;
  background-color: #E4DADA;
}

#tab_todo::-webkit-scrollbar-button {
  width: 0;
  height: 0;
}
</style>