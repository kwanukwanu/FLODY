<template>
  <div>
    <!-- header -->
    <b-row rows="2">
      <newspid-list-header v-bind="$props"></newspid-list-header>
    </b-row>
    <hr style="margin: 5px;">
    <!-- body -->
    <b-row rows="8">
      <newspid-list-body v-bind="$props"></newspid-list-body>
    </b-row>
    <hr style="margin: 5px;">
    <!-- footer -->
    <b-row rows="2">
      <newspid-list-footer v-bind="$props"></newspid-list-footer>
    </b-row>
  </div>

</template>

<script>
import NewspidListHeader from "@/components/newspid/lists/NewspidListHeader.vue";
import NewspidListBody from "@/components/newspid/lists/NewspidListBody.vue";
import NewspidListFooter from "@/components/newspid/lists/NewspidListFooter.vue";

export default {
  props: {
    pidNo: Number,          // 뉴스피드 번호
    author: String,         // 뉴스피드 작성자
    profile: String,        // 작성자 사진
    contents: String,       // 작성 내용 
    tags: Array,            // 태그
    creativetimes: Object,    // 작성 날짜
    favor: Number,          // 좋아요 개수
    comments: Array,
  },
  components: {
    NewspidListHeader,
    NewspidListBody,
    NewspidListFooter
  },
  data() {
    return {
      listnum: 5,
    }
  },
  mounted() {
    console.log("NewspidList")
    console.log(this.comments);
  }

}
</script>

<style>
</style>