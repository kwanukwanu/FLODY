<template>
  <b-tr style="padding: 5">
    <b-td>{{ index + 1 }}</b-td>
    <b-td>{{ name }}</b-td>
    <b-td>{{ leader }}</b-td>
  </b-tr>
</template>

<script>
import { get_group_member_list_by_groNo } from "@/api/group";
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
    return {store};
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
          }
        } else {
          console.log("멤버 탐색 실패 ㅠㅠ");
        }
      },
      (error) => {
        console.log(error);
      }
    ) 
  }
};
</script>

<style></style>
