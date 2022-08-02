<template>
  <board-comments-list-item
    v-for="item in items_popular"
    :key="item"
    v-bind="item"
  ></board-comments-list-item>
  <div style="margin-bottom: 10px">
    <b-row>
      <b-col cols="1" style="padding: 4px; text-align: right">
        <b-avatar
          variant="info"
          src="https://placekitten.com/300/260"
          size="26px"
        ></b-avatar>
      </b-col>
      <b-col>
        <b-row>
          <b-col>
            <div style="text-align: left">
              <a style="padding: 0px; font-weight: bold; text-decoration: none">
                Giri_man</a
              >
            </div>
          </b-col>
        </b-row>
        <b-row>
          <b-col>
            <div style="text-align: left; padding: 0px">화이팅ㅠㅠ</div>
          </b-col>
          <b-col>
            <div style="text-align: right">
              <a>신고</a>
            </div>
          </b-col>
        </b-row>
        <b-row>
          <b-col cols="1">
            <div style="color: #9f9f9f">22.07.11.</div>
          </b-col>
          <b-col cols="1">
            <div style="color: #9f9f9f">18:51</div>
          </b-col>
          <b-col cols="2">
            <a
              href=""
              style="
                color: #9f9f9f;
                text-align: left;
                font-weight: bold;
                text-decoration: none;
              "
              >답글 쓰기</a
            >
          </b-col>
        </b-row>
      </b-col>
    </b-row>
  </div>
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
          userId: "Girl_Girl",
          contents: "화이팅이욥 ㅠㅠ",
          date: "22.07.11",
          time: "18:55",
          child: {},
        },
        {
          profile: "https://placekitten.com/300/260",
          userId: "Girl_man",
          contents: "화이팅ㅠㅠ",
          date: "22.07.11",
          time: "18:51",
          child: {
            profile: "https://placekitten.com/300/260",
            userId: "Girl_boy",
            contents: "화이팅ㅠㅠ",
            date: "22.07.11",
            time: "18:52",
          },
        },
      ],
    };
  },
};
</script>

<style></style>
