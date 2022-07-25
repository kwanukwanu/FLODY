<template>
  <h1>StudyView</h1>
  <ul>
    <li><router-link to="/study/calandar">스터디 캘린더</router-link></li>    
    <li><router-link to="/study/todo">스터디 ToDo</router-link></li>    
  </ul>
  <router-view/>
</template>

<script>
export default {

}
</script>

<style>

</style>