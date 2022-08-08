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
            <b-row>
              <b-col cols="2">
                <chat-avatar class="mt-1" :src="photoUrl" />
              </b-col>
              <b-col cols="10">
                <b-row>
                  <span style="font-size: 16px; font-weight: bold;">{{ name }}</span>
                </b-row>
                <b-row>
                  <div style="font-size: 24px; background-color: #F1EBEB; border-radius: 0px 20px 20px 20px; max-width: 300px;">
                    <slot />
                  </div>
                </b-row>
                <b-row>
                  <!-- <div>{{ date }}</div> -->
                  <!-- <div style="font-size: 12px;">{{ dateTime }}</div> -->
                </b-row>
              </b-col>
            </b-row>
          </div>
        </div>
        <div v-else  style="text-align: right;">
          <div class="message">
            <b-row>
              <b-col cols="10">
                <b-row align-h="end">
                  <div style="font-size: 24px; border-radius: 20px 20px 0px 20px; background-color: #f3f3f3; max-width: 300px; margin-top: 16px;">
                    <slot />
                  </div>
                </b-row>
                  <!-- <div>{{ date }}</div> -->
                  <!-- <div style="font-size: 12px;">{{ dateTime }}</div> -->
                <b-row>
                </b-row>
              </b-col>
              <b-col cols="2">
                <chat-avatar class="mt-1" :src="photoUrl" />
              </b-col>
            </b-row>
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
    date: {type: Date, default: ''},
  },
  data() {
    return {
      dateTime: this.date,
    }
  },
  // mounted() {
  //   console.log(this.date);
  //   this.dateTime = new Date(this.date.seconds * 1000).toLocaleString();
  // },
  // updated() {
  //   console.log(this.date);
  //   this.dateTime = new Date(this.date.seconds * 1000).toLocaleString();
  // },
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