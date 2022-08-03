<template>
  <b-row>
    <b-col>
      <!--타 이용자의 게시물일 시 이 div 안 보여야 함-->
      <div style="text-align: left; margin-left: 7px">
        <b-button
          variant="link"
          style="
            padding: 0px 12px;
            color: black;
            text-decoration: none;
            background-color: #e3d6d6;
          "
          >수정</b-button
        >
        <b-button
          variant="link"
          style="
            padding: 0px 12px;
            color: black;
            text-decoration: none;
            background-color: #e3d6d6;
            margin-left: 12px;
          "
        >
          삭제</b-button
        >
      </div>
    </b-col>
    <b-col>
      <div style="text-align: right; margin-right: 7px">
        <a
          style="
            padding: 2px 12px;
            color: black;
            text-decoration: none;
            background-color: #e3d6d6;
            border-radius: 15%;
          "
          ><svg
            width="15"
            height="16"
            fill="none"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              d="M3.75 9.69 7.5 6.12l3.75 3.571"
              stroke="#444"
              stroke-width="2"
              stroke-linecap="round"
              stroke-linejoin="round"
            />
          </svg>
          이전글</a
        >
        <a
          style="
            padding: 2px 12px;
            color: black;
            text-decoration: none;
            background-color: #e3d6d6;
            margin-left: 12px;
            border-radius: 15%;
          "
          ><svg
            width="15"
            height="15"
            fill="none"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              d="M3.75 5.344 7.5 8.906l3.75-3.562"
              stroke="#444"
              stroke-width="2"
              stroke-linecap="round"
              stroke-linejoin="round"
            />
          </svg>
          다음글</a
        >
        <a
          style="
            padding: 2px 12px;
            color: black;
            text-decoration: none;
            background-color: #e3d6d6;
            margin-left: 12px;
            border-radius: 15%;
          "
          >목록</a
        >
      </div>
    </b-col>
  </b-row>
  <br />
  <a style="color: #064635; margin-left: 20px; font-size: large"
    >자유게시판 ></a
  >
  <br /><br />
  <div
    style="
      font-size: x-large;
      margin-left: 20px;
      margin-right: 20px;
      margin-bottom: 10px;
    "
  >
    {{ title }}
  </div>
  <b-row>
    <b-col cols="1" style="padding: 4px; text-align: right">
      <b-avatar
        variant="info"
        src="https://placekitten.com/300/300"
        size="35px"
      ></b-avatar>
    </b-col>
    <b-col>
      <b-row>
        <b-col cols="2">
          <div style="text-align: left">
            <a
              href=""
              style="
                color: black;
                padding: 0px;
                font-weight: bold;
                text-decoration: none;
                font-size: large;
              "
            >
              Brown_Cat</a
            >
          </div>
        </b-col>
        <b-col>
          <div style="text-align: left">
            <!-- 타 이용자의 게시글일 경우만 보여야 함 -->
            <b-button
              size="sm"
              variant="link"
              style="
                color: white;
                background-color: #83a39a;
                text-decoration: none;
                font-weight: 100;
                border: 1px solid;
              "
            >
              1:1 채팅</b-button
            >
          </div>
        </b-col>
      </b-row>
      <b-row>
        <b-col cols="1">
          <div style="text-align: left; color: #9f9f9f; padding: 0px">
            22.07.11.
          </div>
        </b-col>
        <b-col cols="1">
          <div style="text-align: left; color: #9f9f9f; padding: 0px">
            18:55
          </div>
        </b-col>
        <b-col cols="2">
          <div style="text-align: left; color: #9f9f9f; padding: 0px">
            조회 7,799
          </div>
        </b-col>
        <b-col
          cols="8"
          style="padding: 0px 0px; text-align: right; padding-right: 10px"
        >
          <svg
            width="22"
            height="17"
            fill="none"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              d="M6.875 7.438h.01m4.115 0h.01m4.115 0h.01M9.074 13.6l1.338 1.379c.2.205.299.308.42.344a.585.585 0 0 0 .333 0c.122-.037.222-.14.42-.344l1.339-1.379c.269-.277.403-.415.567-.521.218-.14.476-.24.753-.291.208-.038.432-.038.88-.038 1.281 0 1.922 0 2.427-.162.674-.215 1.21-.63 1.489-1.15.209-.39.209-.885.209-1.876V5.526c0-1.19 0-1.785-.3-2.24-.263-.4-.684-.725-1.201-.928-.589-.232-1.359-.232-2.899-.232h-7.7c-1.54 0-2.31 0-2.898.232-.518.203-.939.528-1.202.928-.3.455-.3 1.05-.3 2.24v4.037c0 .99 0 1.486.21 1.876.278.52.814.935 1.488 1.15.505.162 1.146.162 2.427.162.448 0 .672 0 .88.038.277.05.535.15.753.291.164.106.298.244.567.521ZM7.333 7.438c0 .195-.205.354-.458.354s-.458-.159-.458-.354c0-.196.205-.355.458-.355s.458.159.458.354Zm4.125 0c0 .195-.205.354-.458.354s-.458-.159-.458-.354c0-.196.205-.355.458-.355s.458.159.458.354Zm4.125 0c0 .195-.205.354-.458.354s-.458-.159-.458-.354c0-.196.205-.355.458-.355s.458.159.458.354Z"
              stroke="#444"
              stroke-width="2"
              stroke-linecap="round"
              stroke-linejoin="round"
            />
          </svg>
          댓글 1
        </b-col>
      </b-row>
    </b-col>
  </b-row>
  <hr />

  <b-row>
    <br />
    <b-col>
      <div style="margin-left: 20px; margin-right: 20px">
        {{ contents }}
      </div>
    </b-col>
  </b-row>
  <br />

  <b-row>
    <b-col cols="1" style="padding: 4px; text-align: right">
      <b-avatar
        variant="info"
        src="https://placekitten.com/300/300"
        size="35px"
      ></b-avatar>
    </b-col>
    <b-col>
      <b-row>
        <b-col cols="4">
          <a
            href=""
            style="
              color: black;
              padding: 0px 0px;
              text-align: left;
              font-weight: bold;
              text-decoration: none;
              vertical-align: -webkit-baseline-middle;
            "
          >
            {{ author }}님의 게시글 더보기</a
          >
        </b-col>
      </b-row>
    </b-col>
  </b-row>
  <br />
  <b-row>
    <b-col cols="2" style="padding: 0px 12px; text-align: right">
      <a style="text-align: right; padding: 0px; text-decoration: none">🤍❤️</a>
      좋아요 8
    </b-col>
    <b-col cols="2" style="padding: 0px 0px; text-align: left">
      <svg
        width="22"
        height="17"
        fill="none"
        xmlns="http://www.w3.org/2000/svg"
      >
        <path
          d="M6.875 7.438h.01m4.115 0h.01m4.115 0h.01M9.074 13.6l1.338 1.379c.2.205.299.308.42.344a.585.585 0 0 0 .333 0c.122-.037.222-.14.42-.344l1.339-1.379c.269-.277.403-.415.567-.521.218-.14.476-.24.753-.291.208-.038.432-.038.88-.038 1.281 0 1.922 0 2.427-.162.674-.215 1.21-.63 1.489-1.15.209-.39.209-.885.209-1.876V5.526c0-1.19 0-1.785-.3-2.24-.263-.4-.684-.725-1.201-.928-.589-.232-1.359-.232-2.899-.232h-7.7c-1.54 0-2.31 0-2.898.232-.518.203-.939.528-1.202.928-.3.455-.3 1.05-.3 2.24v4.037c0 .99 0 1.486.21 1.876.278.52.814.935 1.488 1.15.505.162 1.146.162 2.427.162.448 0 .672 0 .88.038.277.05.535.15.753.291.164.106.298.244.567.521ZM7.333 7.438c0 .195-.205.354-.458.354s-.458-.159-.458-.354c0-.196.205-.355.458-.355s.458.159.458.354Zm4.125 0c0 .195-.205.354-.458.354s-.458-.159-.458-.354c0-.196.205-.355.458-.355s.458.159.458.354Zm4.125 0c0 .195-.205.354-.458.354s-.458-.159-.458-.354c0-.196.205-.355.458-.355s.458.159.458.354Z"
          stroke="#444"
          stroke-width="2"
          stroke-linecap="round"
          stroke-linejoin="round"
        />
      </svg>
      댓글 1
    </b-col>
    <b-col>
      <div style="text-align: right">
        <a>신고</a>
      </div>
    </b-col>
  </b-row>
  <hr />

  <div
    style="
      font-weight: bold;
      margin-left: 36px;
      font-size: large;
      margin-bottom: 10px;
    "
  >
    댓글
  </div>
  <board-comments-list></board-comments-list>

  <br />

  <div style="margin-left: 15px">
    <b-row style="margin-top: 15px">
      <b-col>
        <div style="text-align: right">
          <svg
            width="24"
            height="24"
            fill="none"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              d="M8 14s1.5 2 4 2 4-2 4-2m-1-5h.01M9 9h.01M22 12c0 5.523-4.477 10-10 10S2 17.523 2 12 6.477 2 12 2s10 4.477 10 10Zm-6.5-3a.5.5 0 1 1-1 0 .5.5 0 0 1 1 0Zm-6 0a.5.5 0 1 1-1 0 .5.5 0 0 1 1 0Z"
              stroke="#444"
              stroke-width="2"
              stroke-linecap="round"
              stroke-linejoin="round"
            />
          </svg>
        </div>
      </b-col>
      <b-col cols="10">
        <b-form-input class="comment" placeholder="댓글 달기..."></b-form-input>
      </b-col>
      <b-col>
        <div style="color: #bc6464; padding: 6px 0px; font-weight: bold">
          게시
        </div>
      </b-col>
    </b-row>
  </div>
</template>

<script>
import BoardCommentsList from "@/components/board/comments/BoardCommentsList.vue";

export default {
  components: {
    BoardCommentsList,
  },
  props: {
    index: Number,
    number: Number,
    title: String,
    author: String,
    date: String,
    hits: Number,
    contents: String,
  },
};
</script>

<style>
.material-symbols-outlined {
  font-variation-settings: "FILL" 0, "wght" 400, "GRAD" 0, "opsz" 48;
}
.comment {
  border-color: #a48282;
}
</style>
