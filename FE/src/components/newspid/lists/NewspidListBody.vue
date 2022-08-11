<template>
  <div class="scroll" style="height:297px; overflow-y: scroll;">
    <b-row>
      <b-col cols="2" style="padding: 0px;">
        <div class="avatar">
          <b-avatar variant="info" src="https://placekitten.com/300/300" size="32px"></b-avatar>
        </div>
      </b-col>
      <b-col>
        <b-row>
          <span
            style="text-align: left; padding: 0px; font-family : -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Helvetica, Arial, sans-serif; font-weight:500; font-size: 14px; width:92%">
              <a @click="getClickNickname(profile.nickName)">Brown_Cat</a>
            오늘도 나는 공부를 놓지 않는다. 내 자신에 취한다.</span>
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
      <newspid-item v-for="{contents, favor, profile, tags, times, userId, index} in items" :key="index"
        :contents="contents" :favor="favor" :profilePic="profile" :tags="tags" :times="times" :userId="userId">
      </newspid-item>
    </b-row>
    <b-row
      style="padding:0px; font-family : -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Helvetica, Arial, sans-serif; margin-left: 55px;">
      <span style="font-size: 12px;" class="bottom_time_line">---답글 보기(1개)</span>
    </b-row>
  </div>
</template>

<script>
import NewspidItem from "@/components/newspid/items/NewspidItem.vue"

import { computed } from "vue";
import { useStore } from "vuex";

export default {
    components: {
        NewspidItem,
    },
    data() {
        return {
            tags: ["영국", "런던", "스터디"],
            Myname: "Brown_Cat",
        }
    },
    setup() {
        const store = useStore();
        const items = computed(() => store.state.newspidStore.comments);
        const profile = computed(() => store.state.newspidStore.profile);
        const userInfo = computed(() => store.state.memberStore.userInfo);
        const clickNickname = computed(() => store.state.newspidStore.clickNickname);
        return { store, items, profile, userInfo, clickNickname };
    },
    methods: {
        getClickNickname(clickNickname) {
        console.log(clickNickname);
        console.log(this.profile.nickName);
        console.log(this.userInfo.nickname);
        this.store.dispatch("newspidStore/setClickNickname", clickNickname);
      }
    },
    mounted() {
        console.log(this.items)
    }
}
</script>

<style>

.avatar{
    text-align: center;
}
.scroll{
    -ms-overflow-style: none; /* IE and Edge */
    scrollbar-width: none; /* Firefox */
}

 .scroll::-webkit-scrollbar {
    display: none; /* Chrome, Safari, Opera*/
   
}
</style>