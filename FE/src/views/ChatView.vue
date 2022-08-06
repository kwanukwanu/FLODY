<template>
  <div>
    <h1>ChatMain</h1>
    <router-link to="/">home</router-link>
    <nav-bar></nav-bar>
    <chat-board></chat-board>
  </div>
</template>

<script>
import NavBar from "@/components/chat/NavBar.vue";
import ChatBoard from "@/components/chat/ChatBoard.vue";

export default {
    components: { NavBar, ChatBoard }
}
</script>

<style>

</style>