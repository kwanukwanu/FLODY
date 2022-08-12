<template>
  <div style="text-align:left">
    <b-row>
      <b-col cols="1">

      </b-col>
      <b-col cols="1" style="text-align:right">
        <!-- <chat-avatar class="mt-1" :src="photoUrl" /> -->
        <b-avatar size="24px" src="https://placekitten.com/300/300" style="padding:0px 0px"></b-avatar>
      </b-col>
      <b-col cols="9" style="font-weight:bold; text-align: left; padding:0px 0px">
        김정수
      </b-col>
    </b-row>
    <hr>
  </div>
  <div class="container-sm mt-20" style="height:450px; overflow-y: scroll;">
    <div class="mx-5" style="font-size: 14px;">
      <chat-message v-for="{ id, text, userPhotoURL, userName, userId, createdAt } in messages" :key="id"
        :name="userName" :photo-url="userPhotoURL" :sender="userId === user?.uid" :date="createdAt">
        {{ text }}
      </chat-message>
    </div>
  </div>
  <div ref="bottom" class="mt-20" />
  <div class="bottom">
    <div>
      <form v-if="isLogin" @submit.prevent="send">
        <b-row style="margin-top: 25px;">
          <b-col cols="1">
            <div></div>
          </b-col>
          <b-col cols="9">
            <b-form-input v-model="message" placeholder="Message..." required style="border-color: #A48282;">
            </b-form-input>
          </b-col>
          <b-col cols="1">
            <b-button size="sm" type="submit" style="background-color: white; color:#A48282; border-color: #A48282;">
              <span class="material-icons">send</span>
            </b-button>
          </b-col>
        </b-row>
      </form>
    </div>
  </div>
</template>

<script>
import {computed, ref, watch, nextTick} from "vue";
import { useAuth, useChat } from '@/firebase';
import {useStore} from "vuex";
// import ChatAvatar from './ChatAvatar.vue'
import ChatMessage from '@/components/chat/ChatMessage.vue';

export default {
    components:{
        ChatMessage,
        // ChatAvatar, 
    },
    setup() {
         // 채팅부분
        const store = useStore();
        const targetId = computed(()=>store.state.chatStore.targetId);
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
        return { store, targetId, user, isLogin, messages, bottom, message, send };
    },
    mounted(){
      console.log(this.targetId);
    },
}
</script>

<style>
</style>