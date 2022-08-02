<template>
  <b-tr style="padding: 5" @click="intoBoard()">
    <!-- <b-td>{{ 카테고리 }}</b-td> -->
    <b-td>{{ 번호 }}</b-td>
    <b-td>{{ 제목 }}</b-td>
    <b-td>{{ 글쓴이 }}</b-td>
    <b-td>{{ 날짜 }}</b-td>
    <b-td>{{ 조회수 }}</b-td>
  </b-tr>
</template>

<script>
export default {
  props: {
    index: Number,
    번호: Number,
    제목: String,
    글쓴이: String,
    날짜: String,
    조회수: Number,
    내용: String,
  },
  methods: {
    intoBoard() {
      console.log(this.제목);
      this.$router.push({
        path: "/board/Detail",
        params: { number: this.번호, title: this.제목, author: this.글쓴이 },
      });
    },
  },
};
</script>

<style></style>
