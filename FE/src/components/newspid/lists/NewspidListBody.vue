<template>
  <div class="scroll" style="height:297px; overflow-y: scroll;">
    <b-row>
      <b-col cols="2" style="padding: 0px;">
        <div class="avatar">
          <b-avatar variant="info" :src="profile" size="32px"></b-avatar>
        </div>
      </b-col>
      <b-col>
        <b-row>
          <span
            style="text-align: left; padding: 0px; font-family : -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Helvetica, Arial, sans-serif; font-weight:500; font-size: 14px; width:92%">
            <a @click="getClickNickname(author)">{{ author }}</a>
            {{ contents }}</span>
        </b-row>
        <b-row>
          <span
            style="text-align: left; padding: 0px; font-family : -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Helvetica, Arial, sans-serif; font-size: 14px; width:92%">
            <a v-for="tag in tags" :key="tag" style="text-align: left; padding: 0px; color: #255D4E">
              #{{ tag }}</a>
          </span>
        </b-row>
        <b-row style="margin-bottom: 10px;">
          <time style="text-align: left; padding: 0px; color: gray; font-size: 12px;">15시간전</time>
        </b-row>
      </b-col>
    </b-row>
    <b-row>
      <!-- <newspid-item v-for="(item) in items" :key="item.index" v-bind="item"> -->
      <newspid-item v-for="{ contents, favor, profile, tags, times, userId, index } in comments" :key="index"
        :contents="contents" :favor="favor" :profilePic="profile" :tags="tags" :times="times" :userId="userId">
      </newspid-item>
    </b-row>
    <b-row
      style="padding:0px; font-family : -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Helvetica, Arial, sans-serif; margin-left: 55px;">
      <span style="font-size: 12px;" class="bottom_time_line">--- &nbsp;&nbsp;답글 보기(1개)</span>
    </b-row>
  </div>
</template>

<script>
import NewspidItem from "@/components/newspid/items/NewspidItem.vue"

import { computed } from "vue";
import { useStore } from "vuex";

export default {
  props: {
    pidNo: Number,          // 뉴스피드 번호
    author: String,         // 뉴스피드 작성자
    profile: String,        // 작성자 사진
    contents: String,       // 작성 내용 
    tags: Array,            // 태그
    creativetimes: Date,    // 작성 날짜
    picture: String,        // 사진
    favor: Number,          // 좋아요 개수
  },
  components: {
    NewspidItem,
  },
  data() {
    return {
      comments: null,
      //tags: ["영국", "런던", "스터디"],
      //Myname: "Brown_Cat",
    }
  },
  setup() {
    const store = useStore();
    //const items = computed(() => store.state.newspidStore.comments);
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
    this.comments = this.store.dispatch("newspidStore/setcomments", this.pidNo);
  }
}
</script>

<style>
.avatar {
  text-align: center;
}

.scroll {
  -ms-overflow-style: none;
  /* IE and Edge */
  scrollbar-width: none;
  /* Firefox */
}

.scroll::-webkit-scrollbar {
  display: none;
  /* Chrome, Safari, Opera*/

}
</style>