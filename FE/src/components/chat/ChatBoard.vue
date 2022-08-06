<template>
  <div class="container-sm mt-20">
    <div class="mx-5">
      <chat-message v-for="{ id, text, userPhotoURL, userName, userId, createdAt } in messages" :key="id" :name="userName"
        :photo-url="userPhotoURL" :sender="userId === user?.uid" :date="createdAt">
        {{ text }}
      </chat-message>
      <!-- <chat-message 
        v-for="{ message } in messages"
        :key="message"
        v-bind="message"
        >
        {{text }}
        </chat-message> -->
      <!-- <Message
        v-for="{ id, text, userPhotoURL, userName, userId } in messages"
        :key="id"
        :name="userName"
        :photo-url="userPhotoURL"
        :sender="userId === user?.uid"
      >
        {{ text }}
      </Message> -->
    </div>
  </div>
  <div ref="bottom" class="mt-20" />
  <div class="bottom">
    <div>
      <form v-if="isLogin" @submit.prevent="send">
        <!-- <input v-model="message" placeholder="Message" required />
        <button type="submit">
          <send-icon />
        </button> -->
        <b-row style="margin-top: 15px;">
          <b-col cols="1">
            <div></div>
          </b-col>
          <b-col cols="9">
            <b-form-input v-model="message" placeholder="Message..." required style="border-color: #A48282;">
            </b-form-input>
          </b-col>
          <b-col cols="1">
            <b-button size="sm" type="submit">
              <span class="material-icons">send</span>
            </b-button>
          </b-col>
        </b-row>
      </form>
    </div>
  </div>
</template>
<script>
import { ref, watch, nextTick } from 'vue'
import { useAuth, useChat } from '@/firebase'
import ChatMessage from './ChatMessage.vue'
export default {
  components: { ChatMessage },
  setup() {
    const { user, isLogin } = useAuth()
    const { messages, sendMessage } = useChat()
    const bottom = ref(null)
    watch(
      messages,
      () => {
        nextTick(() => {
          bottom.value?.scrollIntoView({ behavior: 'smooth' })
        })
      },
      { deep: true }
    )
    const message = ref('')
    const send = () => {
      sendMessage(message.value)
      message.value = ''
    }
    return { user, isLogin, messages, bottom, message, send }
  },
}
</script>