<template>
  <b-row>
    <b-col cols="6">
      <study-calender></study-calender>
    </b-col>
    <b-col cols="6">
      <study-todo></study-todo>
    </b-col>
  </b-row>
</template>

<script>
import StudyCalender from '@/components/study/StudyCalender.vue'
import StudyTodo from '@/components/study/StudyTodo.vue'
export default {
  components: { StudyCalender,StudyTodo },

}
</script>

<style>

</style>