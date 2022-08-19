<template>
  <li>
    <div class="checkbox">
      <input type="checkbox" name="packersOff" :id="index" :checked="done" @click="logingCheckbox()"
        style="margin-right: 7px" />
      <label :for="index" class="strikethrough">{{ title }}</label>
      <b-button @click="delete_todo()" style="color: #453535; background-color: white; border: none; padding-left: 5px; margin-bottom: 5px;">
        <svg id="delete" width="20" height="20" fill="none" xmlns="http://www.w3.org/2000/svg"
          style="vertical-align: sub; cursor: pointer;">
          <path d="M6.667 10h6.666m5 0a8.333 8.333 0 1 1-16.666 0 8.333 8.333 0 0 1 16.666 0Z" stroke="#444"
            stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
        </svg>
      </b-button>
    </div>
  </li>
</template>

<script>
import { computed } from "vue";
import { useStore } from "vuex";

import { delete_group_schedule, modify_group_schedule } from "@/api/group";


export default {
  props: {
    index: Number,
    gsNo: Number,
    title: String,
    detail: String,
    startDate: String,
    endDate: String,
    done: Boolean,
  },
  data() {
    return {

    }
  },
  mounted() {
    // console.log(this.index + " , " + this.description);
  },
  setup() {
    const store = useStore();
    const selectGroup = computed(() => store.state.groupStore.selectGroups);
    const selectDate = computed(() => store.state.groupStore.selectedDate);
    return { store, selectGroup, selectDate };
  },
  methods: {
    async logingCheckbox() {
      console.log(this.title);
      console.log(this.startDate);
      console.log(this.endDate);
      console.log(this.done);
      const data = {
        title: this.title,
        detail: this.detail,
        startDate: this.startDate,
        endDate: this.endDate,
        done: !this.done,
      };
      console.log("data");
      console.log(data);
      const data2 = {
        groNo: this.selectGroup.groNo,
        selectedDate: this.selectDate,
      };
      console.log("data2");
      console.log(data2);
      await modify_group_schedule(
        this.gsNo, data,
        (response) => {
          console.log(response);
          if (response.data.msg === "SUCCESS") {
            console.log("수정 완료!");
            this.store.dispatch("groupStore/set_todo_list", data2);
          }
        },
        (error) => {
          console.log(error);
        }
      );
    },
    async delete_todo() {
      const data = {
        groNo: this.selectGroup.groNo,
        selectedDate: this.selectDate,
      };
      await delete_group_schedule(
        this.gsNo,
        (response) => {
          console.log(response);
          if (response.data.msg === "SUCCESS") {
            this.store.dispatch("groupStore/set_todo_list", data);
            this.$swal.fire({
              title: '삭제되었습니다.',
              text: "",
              icon: 'warning',
            })
          }
        },
        (error) => {
          console.log(error);
        }
      );
    },
  }
}
</script>

<style>
</style>