<template>
  <b-tr style="padding: 5" @click="intoBoard()">
    <b-td>{{ 카테고리 }}</b-td>
    <b-td>{{ 제목 }}</b-td>
    <b-td>{{ 조회수 }}</b-td>
  </b-tr>
</template>

<script>
import {useStore} from "vuex";

export default {
  props: {
    index:Number,
    카테고리:String,
    제목: String,
    조회수: Number,
  },
  setup(){
    const store = useStore();
    return {store};
  },
  methods: {
    intoBoard() {
      const board = {
          index: this.index,
          number: 102,
          title: this.제목,
          author: "Super_Mario",
          date: "22.07.21",
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
  mounted(){
    console.log(this.제목);
  }
};
</script>

<style>

</style>