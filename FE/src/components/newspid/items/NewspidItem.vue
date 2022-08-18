<template>
  <div style="padding-bottom: 0px 0px;">
    <b-row style="margin-bottom:10px;">
      <b-col cols="2" style="padding: 0px;">
        <div class="avatar">
          <b-avatar variant="info" :src="profile" size="32px"></b-avatar>
        </div>
      </b-col>
      <b-col>
        <b-row
          style="font-family : -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Helvetica, Arial, sans-serif;">
          <span style="padding: 0px; font-size: 14px; width:80%">
            <a style="font-weight:500;" @click="getClickNickname(userId)">{{ userId }}</a>
            {{ contents }}
          </span>
          <span style="width:20%; text-align:right">
            <a v-if="!isfavor" style="text-align: right; padding: 0px; font-weight: bold; text-decoration: none;"
              @click="set_favor(isfavor)">
              <svg width="12" height="12" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path fill-rule="evenodd" clip-rule="evenodd"
                  d="M6 2.844c-.407 0-.773-.275-.926-.697l-.001-.002c-.007-.014-.047-.094-.143-.217a2.262 2.262 0 0 0-.425-.412 1.901 1.901 0 0 0-1.393-.382c-.837.102-1.353.545-1.673 1.086a3.376 3.376 0 0 0-.433 1.857c.04.598.1 1.06.383 1.654.3.633.885 1.477 2.086 2.716 1.135 1.17 1.929 1.931 2.435 2.39.042.039.074.044.09.044s.048-.005.09-.044c.506-.459 1.3-1.22 2.435-2.39 1.201-1.239 1.785-2.083 2.086-2.716.283-.595.344-1.056.383-1.654a3.37 3.37 0 0 0-.436-1.856 2.156 2.156 0 0 0-1.67-1.087c-.485-.06-.956.116-1.353.4-.196.14-.356.293-.47.428-.106.125-.141.197-.142.196 0 0 0-.004.003-.01-.153.42-.52.696-.926.696ZM5.327.806c.358.33.59.688.673.919.082-.226.33-.573.696-.895.551-.488 1.372-.922 2.3-.809 2.29.28 3.099 2.556 2.995 4.138-.087 1.335-.31 2.556-2.789 5.111-1.145 1.181-1.956 1.96-2.482 2.437-.431.39-1.009.39-1.44 0-.526-.478-1.336-1.256-2.482-2.437C.318 6.715.096 5.494.008 4.16-.094 2.577.707.301 3.005.021 4.008-.1 4.803.323 5.327.806Z"
                  fill="#000" />
              </svg>
            </a>

            <!--좋아요 눌렀다면 아래 코드-->
            <a v-else style="text-align: right; padding: 0px; font-weight: bold; text-decoration: none;"
              @click="set_favor(isfavor)">
              <svg width="12" height="12" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path
                  d="M3.004.021C4.694-.184 5.794 1.157 6 1.725 6.207 1.157 7.454-.167 8.996.021c2.29.28 3.099 2.556 2.995 4.138-.087 1.335-.31 2.556-2.789 5.111-1.145 1.181-1.956 1.96-2.482 2.437-.431.39-1.009.39-1.44 0-.526-.478-1.336-1.256-2.482-2.437C.318 6.715.096 5.494.008 4.16-.094 2.577.707.301 3.005.021Z"
                  fill="#F0355B" />
              </svg></a>
          </span>
        </b-row>

        <b-row>
          <b-col
            style="padding:0px; font-family : -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Helvetica, Arial, sans-serif;">
            <span style="font-size: 12px;" class="bottom_time_line">14시간&nbsp;&nbsp;&nbsp;</span>
            <span style="font-size: 12px;" class="bottom_like_comment">좋아요 {{ isfavor ? (favor + 1) : (favor)
            }}개&nbsp;&nbsp;&nbsp;</span>
            <span style="font-size: 12px;" class="bottom_like_comment">답글 달기</span>
          </b-col>
        </b-row>
      </b-col>
    </b-row>
  </div>
</template>

<script>
import { computed } from "vue";
import { useStore } from "vuex";

export default {
  data() {
    return {
      isfavor: false,
    }
  },
  props: {
    userId: String,
    contents: String,
    tags: Array,
    times: Object,
    favor: Number,
    profile: String,
  },
  setup() {
    const store = useStore();
    const profiles = computed(() => store.state.newspidStore.profile);
    const userInfo = computed(() => store.state.memberStore.userInfo);
    const clickNickname = computed(() => store.state.newspidStore.clickNickname);
    return { store, profiles, userInfo, clickNickname };
  },
  methods: {
    getClickNickname(clickNickname) {
      console.log(clickNickname);
      this.store.dispatch("newspidStore/setClickNickname", clickNickname);
    },
    set_favor(isfavor) {
      if (isfavor)
        this.isfavor = false;
      else
        this.isfavor = true;
    }
  },
  mounted() {
    console.log(this.userId + "\n" + this.contents + "\n" + this.tags + "\n" + this.favor);
  }
};
</script>

<style>
.avatar {
  text-align: center;
}
</style>
