<template>
  <b-row>
    <b-col>
      <study-flower></study-flower>
    </b-col>
  </b-row>
  <b-row>
    <b-col>
      <study-calender></study-calender>
    </b-col>
    <b-col>
      <study-todo></study-todo>
    </b-col>
  </b-row>
  <b-row>
    <study-field></study-field>
  </b-row>
</template>

<script>
import StudyCalender from '@/components/study/StudyCalender.vue'
import StudyTodo from '@/components/study/StudyTodo.vue'
import StudyFlower from '@/components/study/StudyFlower.vue'
import StudyField from '@/components/study/StudyField.vue'
export default {
  components: { StudyCalender, StudyTodo, StudyFlower, StudyField },

}
</script>

<style>
</style>