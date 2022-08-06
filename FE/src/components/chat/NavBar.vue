<template>
  <nav>
    <div>
      <h1><strong>Vue</strong> Chat App</h1>

      <div v-if="isLogin" class="login">
        <chat-avatar :src="user.photoURL" />
        <!-- <Avatar :src="user.photoURL" /> -->
        <button class="text-gray-400 hover:text-white" @click="signOut">
          Sign Out
        </button>
      </div>

      <button v-else class="bg-green-500 hover:bg-green-600" @click="signIn">
        Sign in
      </button>
    </div>
  </nav>
</template>

<script>
import { useAuth } from '@/firebase'
import ChatAvatar from './ChatAvatar.vue'
export default {
  components: { ChatAvatar },
  setup() {
    const { user, isLogin, signOut, signIn } = useAuth()
    return { user, isLogin, signOut, signIn }
  }
}
</script>
Footer
© 2022 GitHub, Inc.
Footer navigation
Terms
Privacy
Security
Status
