<template>
  <board-comments-list-item
    v-for="item,index in items_popular"
    :key="item.index = index"
    v-bind="item"
  ></board-comments-list-item>
</template>

<script>
import BoardCommentsListItem from "@/components/board/comments/BoardCommentsListItem.vue";
export default {
  components: { BoardCommentsListItem },
  data() {
    return {
      items_popular: [
        {
          profile: "https://placekitten.com/300/250",
          userId: "Giri_Girl",
          contents: "화이팅이욥 ㅠㅠ",
          date: "22.07.11",
          time: "18:55",
          child: null,
        },
        {
          profile: "https://placekitten.com/300/260",
          userId: "Giri_man",
          contents: "화이팅ㅠㅠ",
          date: "22.07.11",
          time: "18:51",
          child: [{
            profile: "https://placekitten.com/300/270",
            userId: "Giri_boy",
            contents: "화이팅ㅠㅠ",
            date: "22.07.11",
            time: "18:52",
          },]
        },
      ],
    };
  },
};
</script>

<style></style>
