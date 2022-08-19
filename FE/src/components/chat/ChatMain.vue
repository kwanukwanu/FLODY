<template>
  <div style="text-align:left;">
    <b-row>
      <b-col cols="1" style="text-align:right;;">
        <!-- <chat-avatar class="mt-1" :src="photoUrl" /> -->
        <b-avatar size="27px" src="https://placekitten.com/300/300" style="padding:0px 0px"></b-avatar>
      </b-col>
      <b-col cols="8" style="font-weight:bold; font-size: 17.5px; text-align: left; padding:0px 0px;">
        {{targetId2}}
      </b-col>
      <b-col cols="3" style="text-align:right;">
        <b-button @click="Cancel" size="sm" style="color: #A48282; background-color:white; border-color: white; padding: 0px 8px"
          data-bs-dismiss="modal" aria-label="Close"><svg width="24" height="24" fill="none"
            xmlns="http://www.w3.org/2000/svg">
            <path d="M18 6 6 18M6 6l12 12" stroke="#444" stroke-width="2" stroke-linecap="round"
              stroke-linejoin="round" />
          </svg></b-button>
      </b-col>
    </b-row>
    <hr style="margin: 5px">
  </div>
  <div id="chatField" class="container-sm mt-20" style="height:450px; overflow-y: scroll;">
    <div class="mx-5" style="font-size: 14px;">
      <chat-message v-for="{ id, text, userPhotoURL, userName, userId, createdAt, targetId } in messages" :key="id"
        :name="userName" :photo-url="userPhotoURL" :sender="userId2 === userId" :date="createdAt" 
        :target="(targetId2 === targetId && userId2 === userId) || (targetId2 ===  userId && userId2 === targetId)">
        {{ text }}
        <!-- <span v-if="targetId2 === targetId">{{text}}</span> -->
      </chat-message>
    </div>
  </div>
  <div ref="bottom" class="mt-20" />
  <div class="bottom">
    <div>
      <!-- <form v-if="isLogin" @submit.prevent="send"> -->
      <form @submit.prevent="send">
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
// import { useAuth, useChat } from '@/firebase';
import { useChat } from '@/firebase';
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
        const targetId2 = computed(()=>store.state.chatStore.targetId);
        const userName2 = computed(()=>store.state.memberStore.userInfo.nickname);
        const userId2 = computed(()=>store.state.memberStore.userInfo.email);
        const userPhotoURL2 = computed(()=>store.state.memberStore.userInfo.profile);
        // const { user, isLogin } = useAuth()
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
        // return { store, targetId, user, isLogin, messages, bottom, message, send };
        return { store, targetId2, userName2, userId2, userPhotoURL2, messages, bottom, message, send };
    },
    mounted(){
      console.log(this.targetId2);
    },
}
</script>

<style>
#chatField::-webkit-scrollbar {
  width: 6px;
}
#chatField::-webkit-scrollbar-track {
  background-color: transparent;
}
#chatField::-webkit-scrollbar-thumb {
  border-radius: 3px;
  background-color: gray;
}
#chatField::-webkit-scrollbar-button {
  width: 0;
  height: 0;
}
</style>