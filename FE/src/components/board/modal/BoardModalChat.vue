<template>
  <div class="container-sm mt-20">
    <div class="mx-5">
      <chat-message v-for="{ id, text, userPhotoURL, userName, userId, createdAt } in messages" :key="id" :name="userName"
        :photo-url="userPhotoURL" :sender="userId === user?.uid" :date="createdAt">
        {{ text }}
      </chat-message>
    </div>
  </div>
  <div ref="bottom" class="mt-20" />
  <div class="bottom">
    <div>
      <form v-if="isLogin" @submit.prevent="send">
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
import {ref, watch, nextTick} from "vue";
import { useAuth, useChat } from '@/firebase';

import ChatMessage from '@/components/chat/ChatMessage.vue';

export default {
    components:{
        ChatMessage,
    },
    setup() {
         // 채팅부분
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
        return { user, isLogin, messages, bottom, message, send };
    }
}
</script>

<style>

</style>