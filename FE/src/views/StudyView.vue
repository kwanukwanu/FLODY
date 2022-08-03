<template>
  <b-row>
    <b-col>
      <study-flower></study-flower>
    </b-col>
  </b-row>
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
import StudyFlower from '@/components/study/StudyFlower.vue'
export default {
  components: { StudyCalender,StudyTodo, StudyFlower },

}
</script>

<style>

</style>