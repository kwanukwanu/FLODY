<template>
  <b-tr style="padding: 5" @click="intoBoard()">
    <b-td>{{ 카테고리 }}</b-td>
    <b-td>{{ 번호 }}</b-td>
    <b-td>{{ 제목 }}</b-td>
    <b-td>{{ 글쓴이 }}</b-td>
    <b-td>{{ 날짜 }}</b-td>
    <b-td>{{ 조회수 }}</b-td>
  </b-tr>
</template>

<script>
import {useStore} from "vuex";

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
  setup(){
    const store = useStore();
    return {store};
  },
  methods: {
    intoBoard() {
      console.log(this.제목);
      const board = {
          index: this.index,
          number: this.번호,
          title: this.제목,
          author: this.글쓴이,
          date: this.날짜,
          hits: this.조회수,
          contents: "이것은 글의 내용입니다.",
      };
      this.store.dispatch("boardStore/selectedBoard",board);
      console.log("after::");
      console.log(board);
      this.$router.push({
        path: "/board/Detail"
      });
    },
  },
};
</script>

<style></style>
