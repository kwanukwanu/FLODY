<template>
  <b-container>
    <b-card style="max-width: 70rem; border-color: #a48282; max-height: 120rem">
      <b-row>
        <b-col>
          <span
            style="
              margin-left: 7px;
              font-size: large;
              color: #064635;
              text-align: left;
            "
            >자유게시판
          </span>

          <hr />
          <board-list-item
            v-for="(item, index) in items_popular"
            :key="(item.index = index)"
            v-bind="item"
          >
          </board-list-item>
          <!-- <b-table fixed hover :items="items_popular" class="common"> </b-table> -->
          <div style="text-align: right">
            <b-button
              variant="link"
              style="padding: 0px 12px; color: #b99b9a; text-decoration: none"
              v-b-modal.modal-2
            >
              글쓰기</b-button
            >
          </div>
        </b-col>
      </b-row>
    </b-card>
    <br />
    <div class="paging">
      <b-button
        variant="link"
        style="color: black; text-decoration: none; font-weight: 100"
        v-if="page > 5"
        @click="movePage(-5)"
        >&lt;
      </b-button>
      <b-button variant="link" v-else></b-button>
      <b-button
        variant="link"
        style="color: black; text-decoration: none; font-weight: 100"
        v-if="page > 3"
        @click="movePage(-3)"
        >{{ page - 3 }}</b-button
      >
      <b-button variant="link" v-else></b-button>
      <b-button
        variant="link"
        style="color: black; text-decoration: none; font-weight: 100"
        v-if="page > 2"
        @click="movePage(-2)"
        >{{ page - 2 }}</b-button
      >
      <b-button variant="link" v-else></b-button>
      <b-button
        variant="link"
        style="color: black; text-decoration: none; font-weight: 100"
        v-if="page > 1"
        @click="movePage(-1)"
        >{{ page - 1 }}</b-button
      >
      <b-button variant="link" v-else></b-button>
      <b-button
        variant="link"
        style="color: black; text-decoration: none; font-weight: 100"
        >{{ page }}</b-button
      >
      <b-button
        variant="link"
        style="color: black; text-decoration: none; font-weight: 100"
        v-if="page < max - 1"
        @click="movePage(1)"
        >{{ page + 1 }}</b-button
      >
      <b-button variant="link" v-else></b-button>
      <b-button
        variant="link"
        style="color: black; text-decoration: none; font-weight: 100"
        v-if="page < max - 2"
        @click="movePage(2)"
        >{{ page + 2 }}</b-button
      >
      <b-button variant="link" v-else></b-button>
      <b-button
        variant="link"
        style="color: black; text-decoration: none; font-weight: 100"
        v-if="page < max - 3"
        @click="movePage(3)"
        >{{ page + 3 }}</b-button
      >
      <b-button variant="link" v-else></b-button>
      <b-button
        variant="link"
        style="color: black; text-decoration: none; font-weight: 100"
        v-if="page < max - 5"
        @click="movePage(5)"
        >&gt;
      </b-button>
      <b-button variant="link" v-else></b-button>
    </div>
  </b-container>
  <br /><br />

  <b-row style="margin-bottom: 10px">
    <b-col cols="3">
      <b-form-select></b-form-select>
    </b-col>
    <b-col cols="3">
      <b-form-select></b-form-select>
    </b-col>
    <b-col cols="5">
      <b-form-input placeholder="검색어를 입력해주세요"></b-form-input>
    </b-col>
    <b-col cols="1">
      <b-button style="color: #453535; background-color: #e1d3d2; border: none"
        >검색</b-button
      >
    </b-col>
  </b-row>

  <!-- 임시-->
  <br /><br />
  <div style="text-align: center">
    <router-link :to="{ name: 'boarddetail' }">게시물 상세 보기</router-link>
  </div>

  <b-modal
    hide-footer
    id="modal-2"
    centered
    title="새 게시물 만들기"
    style="text-align: center"
  >
    <b-card style="height: 29rem; max-width: 30rem; background-color: #f8f3f3">
      <b-container ref="form">
        <!-- <h2 style="text-align: center;">목표 등록</h2> -->
        <b-row style="margin-bottom: 10px">
          <b-col>
            <b-form-input
              placeholder="제목을 입력하세요"
              required
              style="border: none"
            ></b-form-input>
          </b-col>
        </b-row>
        <b-row style="margin-bottom: 10px">
          <b-col>
            <b-form-select style="border: none"></b-form-select>
          </b-col>
        </b-row>
        <b-row style="margin-bottom: 10px">
          <b-col>
            <b-form-textarea
              id="content"
              placeholder="내용 입력..."
              rows="10"
              max-rows="15"
              required
              style="border: none"
            >
            </b-form-textarea>
          </b-col>
        </b-row>
        <br />
        <b-button
          text
          @click="submit"
          style="color: #453535; background-color: #e1d3d2; border: none"
          >게시</b-button
        >
      </b-container>
    </b-card>
  </b-modal>
</template>

<script>
import BoardListItem from "./Items/BoardListItem.vue";

export default {
  components: { BoardListItem },
  data() {
    return {
      items_popular: [
        {
          번호: "102",
          제목: "오픽 공부 하기 싫다",
          글쓴이: "Super_Mario",
          날짜: "22.07.21",
          조회수: "7,799",
        },
        {
          번호: "101",
          제목: "삼수 끝의 정보처리기사 합격 후기...",
          글쓴이: "Bat_Man",
          날짜: "22.07.21",
          조회수: "8,677",
        },
        {
          번호: "100",
          제목: "toeic speaking honey tip 제공합니다 드루오세요",
          글쓴이: "Cinderellla",
          날짜: "22.07.21",
          조회수: "4.1만",
        },
        {
          번호: "99",
          제목: "정보보안기사 따면 좋나요?",
          글쓴이: "Brown_Cat",
          날짜: "22.07.21",
          조회수: "2.1만",
        },
        {
          번호: "98",
          제목: "오픽 보고 왔는데 네 번 연속 IH.. AL 포기 할까요",
          글쓴이: "Oh_My_Boy",
          날짜: "22.07.21",
          조회수: "1만",
        },
        {
          번호: "97",
          제목: "오픽 공부 하기 싫다ㅜㅜ",
          글쓴이: "Giri_Girl",
          날짜: "22.07.21",
          조회수: "7,799",
        },
        {
          번호: "96",
          제목: "네트워크는 어려워",
          글쓴이: "science_joa",
          날짜: "22.07.21",
          조회수: "811",
        },
        {
          번호: "95",
          제목: "토익스피킹 공부하는데 현타가..",
          글쓴이: "Super_Mario",
          날짜: "22.07.21",
          조회수: "1,334",
        },
        {
          번호: "94",
          제목: "정보보안기사 따면 좋나요?",
          글쓴이: "Bat_man",
          날짜: "22.07.21",
          조회수: "2.1만",
        },
        {
          번호: "93",
          제목: "오픽 보고 왔는데 네 번 연속 IH..",
          글쓴이: "heo_gak",
          날짜: "22.07.21",
          조회수: "1만",
        },
        {
          번호: "92",
          제목: "toeic speaking honey tip 제...",
          글쓴이: "eunji",
          날짜: "22.07.21",
          조회수: "4.1만",
        },
        {
          번호: "91",
          제목: "오픽 꿀팁!",
          글쓴이: "jaehyuni",
          날짜: "22.07.21",
          조회수: "1만",
        },
        {
          번호: "90",
          제목: "토익스피킹 나만의 꿀팁..",
          글쓴이: "sehan",
          날짜: "22.07.21",
          조회수: "3만",
        },
        {
          번호: "89",
          제목: "정보보안기사 꿀팁입니다",
          글쓴이: "kyojun",
          날짜: "22.07.21",
          조회수: "2만",
        },
        {
          번호: "88",
          제목: "한능검 꿀팁 드려요",
          글쓴이: "aeri",
          날짜: "22.07.21",
          조회수: "5,444",
        },
        {
          번호: "87",
          제목: "오픽 세 번 만의 AL 달성 후기",
          글쓴이: "jonghwan",
          날짜: "22.07.21",
          조회수: "1,799",
        },
      ],
      page: 1,
      max: 10,
    };
  },
  methods: {
    movePage(num) {
      console.log("click " + num);
      this.page = this.page + num;
      console.log("page : " + this.page);
    },
  },
};
</script>

<style>
.common {
  margin-bottom: 1.8rem;
  border-color: #e4dada;
  max-width: 70rem;
}
.paging {
  text-align: center;
}
</style>
