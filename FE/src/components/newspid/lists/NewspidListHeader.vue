<template>
  <b-col cols="2" style="padding: 4px;">
    <div class="avatar">
      <b-avatar variant="info" :src="profile" size="32px"></b-avatar>
    </div>
  </b-col>
  <b-col cols="9">
    <b-row>
      <span
        style="display: inline; padding: 0px; text-align: left; font-weight: 500; font-size: 14px; margin-top:5px; font-family : -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Helvetica, Arial, sans-serif; width:70%">
        <a @click="getClickNickname(author)">{{ author }}</a>
        <b-button
          style="color: black; background-color: white; border-color:white; width: 70px; text-decoration: none; padding: 0px 0px 0px 0px; font-family : -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Helvetica, Arial, sans-serif; font-weight: 600; font-size: 14px;"
          v-b-modal.modal-5>
          • 팔로잉</b-button>
      </span>
      <!--팔로우 안 한 상태라면 아래 코드-->
      <!-- <b-button
                style="color: blue; background-color: white; border-color:white; width: 70px; text-decoration: none; padding: 0px 0px 0px 0px; font-family : -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Helvetica, Arial, sans-serif; font-weight: 600; font-size: 14px;">
                • 팔로우</b-button> -->
    </b-row>
    <b-row style="font-size:12px; width:70%">대한민국</b-row>
  </b-col>
  <b-col cols="1" style="padding: 0px 0px; margin-top: 8px;">
    <b-button size="sm" variant="link" style="width: 40px; text-decoration: none; padding:0px 0px;" v-b-modal.modal-4>
      <svg width="24" height="24" fill="none" xmlns="http://www.w3.org/2000/svg">
        <path
          d="M12 13a1 1 0 1 0 0-2 1 1 0 0 0 0 2ZM19 13a1 1 0 1 0 0-2 1 1 0 0 0 0 2ZM5 13a1 1 0 1 0 0-2 1 1 0 0 0 0 2Z"
          stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
      </svg>
    </b-button>
  </b-col>
</template>

<script>
import { computed } from "vue";
import { useStore } from "vuex";

export default {
  props: {
    author: String,
    profile: String,
    contents: String,
    tags: Array,
    creativetimes: Object,
    favor: Number,
    comments: Array,
  },
  setup() {
    const store = useStore();
    //const profile = computed(() => store.state.newspidStore.profile);
    const userInfo = computed(() => store.state.memberStore.userInfo);
    const clickNickname = computed(() => store.state.newspidStore.clickNickname);
    return { store, userInfo, clickNickname };
  },
  methods: {
    getClickNickname(clickNickname) {
      console.log(clickNickname);
      this.store.dispatch("newspidStore/setClickNickname", clickNickname);
    }
  },
  mounted() {
    console.log("누구의 프로필 : " + this.clickNickname);
  }
}
</script>

<style>
.btn-link {
  --bs-btn-focus-shadow-rgb: white;
}

.btn-secondary {
  --bs-btn-focus-shadow-rgb: white;
}
</style>