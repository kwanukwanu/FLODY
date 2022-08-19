<template>
  <b-modal hide-footer id="modal-8" centered no-stacking title="할 일 등록" style="text-align: center">
    <study-todo-modal-items></study-todo-modal-items>
  </b-modal>
</template>

<script>
import StudyTodoModalItems from "./item/StudyTodoModalItems.vue";
export default {
  components: {
    StudyTodoModalItems,
  }
}
</script>

<style>
</style>