<template>
  <!-- <div class="message">
    <span v-if="!sender">{{ name }}</span>
    <div class="flex" :class="sender ? 'flex-row-reverse' : ''">
      <chat-avatar class="mt-1" :src="photoUrl" /> -->
      <!-- <Avatar class="mt-1" :src="photoUrl" /> -->
      <!--<div class="text w-3/4" :class="sender ? 'bg-green-800' : 'bg-gray-700'">
        <slot/>
      </div>
    </div>
  </div> -->
  <b-container>
    <b-row>
      <!-- <b-col v-if="sender" cols ="3">
      </b-col>
      <b-col cols = "9">
        <div class="message">
          <span v-if="!sender">{{ name }}</span>
          <div class="flex" :class="sender ? 'flex-row-reverse' : ''">
            <chat-avatar class="mt-1" :src="photoUrl" />
            <slot/>
          </div>
        </div>
      </b-col> -->
      <!-- <b-col v-if="sender" cols ="3">
      </b-col>
      <b-col cols = "9"> -->
        <div v-if="!sender" style="text-align: left;">
          <div class="message">
            <span>{{ name }}</span>
            <div class="flex">
              <chat-avatar class="mt-1" :src="photoUrl" />
              <slot/>
              <div>{{ date }}</div>
            </div>
          </div>
        </div>
        <div v-else  style="text-align: right;">
          <div class="message">
            <div class="flex">
              <div>{{ date }}</div>
              <slot/>
              <chat-avatar class="mt-1" :src="photoUrl" />
            </div>
          </div>
        </div>
      <!-- </b-col> -->
    </b-row>
  </b-container>
</template>

<script>
import ChatAvatar from './ChatAvatar.vue'
export default {
  components: { ChatAvatar },
  props: {
    name: { type: String, default: '' },
    photoUrl: { type: String, default: '' },
    sender: { type: Boolean, default: false },
    date: {type: String, default: ''},
  },
  // props:{
  //   id: String, 
  //   text: String,
  //   userPhotoURL: String, 
  //   userName: String, 
  //   userId: String,
  //   itsMe: Boolean, 
  // },
  // mounted(){
  //   console.log(this.id+"\n"+this.text+"\n"+this.userPhotoURL+"\n"+this.userName+"\n"+this.userId+"\n"+this.itsMe);
  // }
}
</script>