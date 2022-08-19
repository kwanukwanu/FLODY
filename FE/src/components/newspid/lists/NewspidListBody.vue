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
          <time style="text-align: left; padding: 0px; color: gray; font-size: 12px;">{{ setTimes }}</time>
        </b-row>
      </b-col>
    </b-row>
    <b-row>
      <newspid-item v-for="(item, index) in comments" :key="item.index = index" v-bind="item">
        <!-- <newspid-item v-for="{ contents, favor, profile, tags, times, userId, index } in comments" :key="index"
        :contents="contents" :favor="favor" :profilePic="profile" :tags="tags" :times="times" :userId="userId"> -->
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
//import { getcomments } from "@/api/newspid.js";

export default {
  props: {
    pidNo: Number,          // 뉴스피드 번호
    author: String,         // 뉴스피드 작성자
    profile: String,        // 작성자 사진
    contents: String,       // 작성 내용 
    tags: Array,            // 태그
    creativetimes: Object,    // 작성 날짜
    comments: Array,

  },
  components: {
    NewspidItem,
  },
  data() {
    return {
      //comments: null,
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
    //this.comments = getcomments(this.pidNo);
    console.log("ListBody----------------------");
    console.log(this.comments);
  },
  computed: {
    setTimes() {
      const now = new Date();
      const year = this.creativetimes.year;
      const month = this.creativetimes.month;
      const date = this.creativetimes.date;
      const hour = this.creativetimes.hour;
      const min = this.creativetimes.min;

      console.log("year : " + year);
      if (now.getFullYear() - year > 0)
        return (now.getFullYear() - year) + "년 전";
      else if (now.getMonth() - month > 0) // year = 0 이므로
        return (now.getMonth() - month) + "개월 전";
      else if (now.getDate() - date > 0)
        return (now.getDate() - date) + "일 전";
      else if (now.getHours() - hour > 0)
        return (now.getHours() - hour) + "시간 전";
      else if (now.getMinutes() - min > 0)
        return (now.getMinutes() - min) + "분 전";
      else return "방금 전";
    }
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