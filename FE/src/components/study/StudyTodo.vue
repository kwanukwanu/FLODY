<template>
  <b-card style="border-color: #a48282; max-width: 35rem; height:304px; overflow-y: scroll;" id="tab_todo">
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
    <ul style="list-style-type :none;">
      <study-todo-items v-for="(item, index) in todo_list" :key="item.index = index" v-bind="item">
      </study-todo-items>
    </ul>
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
    const todo_list = computed(() => store.state.calendarStore.todo_list);
    return { isTodos, store, todo_list };
  },
  mounted() {
    console.log("todolist");
    console.log(this.todo_list);
  },
  methods: {
    // addRow() {
    // var tbody = document.getElementById('mytest_2');
    // var row = tbody.insertRow(tbody.rows.length); // 하단에 추가
    // var cell1 = row.insertCell(0);
    // var cell2 = row.insertCell(1);
    // cell1.innerHTML = document.getElementById('holder').outerHTML;
    // cell2.innerHTML = document.getElementById('delete').outerHTML;
    // },

    // deleteRow() {
    // var tbody = document.getElementById('mytest_2');
    // tbody.deleteRow(this.row);
    // },

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

#todosField::-webkit-scrollbar {
  width: 6px;
}

#todosField::-webkit-scrollbar-track {
  background-color: transparent;
}

#todosField::-webkit-scrollbar-thumb {
  border-radius: 3px;
  background-color: gray;
}

#todosField::-webkit-scrollbar-button {
  width: 0;
  height: 0;
}
</style>