<template>
  <div>
    <h1>ChatMain</h1>
    <nav-bar></nav-bar>
    <chat-board></chat-board>
  </div>
</template>

<script>
import NavBar from "./NavBar.vue";
import ChatBoard from "./ChatBoard.vue";

export default {
    components: { NavBar, ChatBoard }
}
</script>

<style>

</style>