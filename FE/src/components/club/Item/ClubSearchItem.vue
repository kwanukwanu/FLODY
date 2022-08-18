<template>
  <b-tr style="padding: 5" @click="studyInfo()">
    <b-td>{{ index + 1 }}</b-td>
    <b-td>{{ name }}</b-td>
    <b-td>{{ leader }}</b-td>
  </b-tr>
</template>

<script>
import { get_group_member_list_by_groNo } from "@/api/group";
import {computed} from "vue";
import {useStore} from "vuex";

export default {
  props: {
    index: Number,
    groNo: Number,
    name: String,
    introduction: String,
    foundDate: String,
  },
  data() {
    return {
      leader: "",
    }
  },
  setup(){
    const store = useStore();
    const groupInfo = computed(() => store.state.groupStore.groupInfo);
    const groupMember = computed(() => store.state.groupStore.groupMember);

    return {store, groupInfo, groupMember};
  },
  mounted() {
    get_group_member_list_by_groNo(
      this.groNo,
      (response) => {
        console.log(response);
        if(response.data.msg == "SUCCESS") {
          console.log("멤버 탐색!!!");
          for(let idx = 0; idx < response.data.item.length; idx++) {
            if(response.data.item[idx].role == "OWNER") {
              this.leader = response.data.item[idx].email;
            }
            console.log(this.index + "의 " + this.leader);
          }
        } else {
          console.log("멤버 탐색 실패 ㅠㅠ");
        }
      },
      (error) => {
        console.log(error);
      }
    ) 
  },
  methods: {
    async studyInfo() {
      console.log("get_group_one 시작");
      await this.store.dispatch("groupStore/set_group_info", this.groNo);
      console.log(this.groupInfo);
      console.log("get_group_one 종료");
      console.log("get_group_member_list_by_groNo 시작");
      await this.store.dispatch("groupStore/set_group_member", this.groNo);
      console.log(this.groupMember);
      console.log("get_group_member_list_by_groNo 종료");
    }
  }
};
</script>

<style></style>
