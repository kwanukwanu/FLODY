import { get_boardList, get_board } from "@/api/board";
const boardStore = {
  namespaced: true,
  state: {
    isMyBoard: false,
    selectedBoard: {
      index: 0,
      number: 0,
      title: "오픽 공부 하기 싫다",
      author: "ssafy001",
      date: "2022-08-03",
      hits: 7799,
      contents: "오픽 너무 어렵네요.. 다른분들은 어떠신가요?",
      category: "자유",
    },
    boardNum: 0,
    boardListName: "null",
    boardList: [
      {
        번호: "102",
        제목: "오픽 공부 하기 싫다",
        글쓴이: "Super_Mario",
        날짜: "22.07.21",
        조회수: 7799,
      },
      {
        번호: "101",
        제목: "삼수 끝의 정보처리기사 합격 후기...",
        글쓴이: "Bat_Man",
        날짜: "22.07.21",
        조회수: 8677,
      },
      {
        번호: "100",
        제목: "toeic speaking honey tip 제공합니다 드루오세요",
        글쓴이: "Cinderellla",
        날짜: "22.07.21",
        조회수: 41000,
      },
      {
        번호: "99",
        제목: "정보보안기사 따면 좋나요?",
        글쓴이: "Brown_Cat",
        날짜: "22.07.21",
        조회수: 21000,
      },
      {
        번호: "98",
        제목: "오픽 보고 왔는데 네 번 연속 IH.. AL 포기 할까요",
        글쓴이: "Oh_My_Boy",
        날짜: "22.07.21",
        조회수: 10000,
      },
      {
        번호: "97",
        제목: "오픽 공부 하기 싫다ㅜㅜ",
        글쓴이: "Giri_Girl",
        날짜: "22.07.21",
        조회수: 7799,
      },
      {
        번호: "96",
        제목: "네트워크는 어려워",
        글쓴이: "science_joa",
        날짜: "22.07.21",
        조회수: 811,
      },
      {
        번호: "95",
        제목: "토익스피킹 공부하는데 현타가..",
        글쓴이: "Super_Mario",
        날짜: "22.07.21",
        조회수: 1334,
      },
      {
        번호: "94",
        제목: "정보보안기사 따면 좋나요?",
        글쓴이: "Bat_man",
        날짜: "22.07.21",
        조회수: 21000,
      },
      {
        번호: "93",
        제목: "오픽 보고 왔는데 네 번 연속 IH..",
        글쓴이: "heo_gak",
        날짜: "22.07.21",
        조회수: 10000,
      },
      {
        번호: "92",
        제목: "toeic speaking honey tip 제...",
        글쓴이: "eunji",
        날짜: "22.07.21",
        조회수: 41000,
      },
      {
        번호: "91",
        제목: "오픽 꿀팁!",
        글쓴이: "jaehyuni",
        날짜: "22.07.21",
        조회수: 10000,
      },
      {
        번호: "90",
        제목: "토익스피킹 나만의 꿀팁..",
        글쓴이: "sehan",
        날짜: "22.07.21",
        조회수: 30000,
      },
      {
        번호: "89",
        제목: "정보보안기사 꿀팁입니다",
        글쓴이: "kyojun",
        날짜: "22.07.21",
        조회수: 20000,
      },
      {
        번호: "88",
        제목: "한능검 꿀팁 드려요",
        글쓴이: "aeri",
        날짜: "22.07.21",
        조회수: 5444,
      },
      {
        번호: "87",
        제목: "오픽 세 번 만의 AL 달성 후기",
        글쓴이: "jonghwan",
        날짜: "22.07.21",
        조회수: 1799,
      },
    ],
    items_popular: [
      { 카테고리: "자유", 제목: "오픽 공부 하기 싫다", 조회수: "7,799" },
      {
        카테고리: "후기",
        제목: "삼수 끝의 정보처리기사 합격 후기...",
        조회수: "8,677",
      },
      {
        카테고리: "꿀팁",
        제목: "toeic speaking honey tip 제공합니다 드루오세요",
        조회수: "4.1만",
      },
      { 카테고리: "자유", 제목: "정보보안기사 따면 좋나요?", 조회수: "2.1만" },
      {
        카테고리: "자유",
        제목: "오픽 보고 왔는데 네 번 연속 IH.. AL 포기 할까요",
        조회수: "1만",
      },
    ],
    items_free: [
      { 카테고리: "자유", 제목: "오픽 공부 하기 싫다ㅜㅜ", 조회수: "7,799" },
      { 카테고리: "자유", 제목: "네트워크는 어려워", 조회수: "811" },
      {
        카테고리: "자유",
        제목: "토익스피킹 공부하는데 현타가..",
        조회수: "1,334",
      },
      { 카테고리: "자유", 제목: "정보보안기사 따면 좋나요?", 조회수: "2.1만" },
      {
        카테고리: "자유",
        제목: "오픽 보고 왔는데 네 번 연속 IH..",
        조회수: "1만",
      },
    ],
    items_honey: [
      {
        카테고리: "꿀팁",
        제목: "toeic speaking honey tip 제...",
        조회수: "4.1만",
      },
      { 카테고리: "꿀팁", 제목: "오픽 꿀팁!", 조회수: "1만" },
      { 카테고리: "꿀팁", 제목: "토익스피킹 나만의 꿀팁..", 조회수: "3만" },
      { 카테고리: "꿀팁", 제목: "정보보안기사 꿀팁입니다", 조회수: "2만" },
      { 카테고리: "꿀팁", 제목: "한능검 꿀팁 드려요", 조회수: "5,444" },
    ],
    items_review: [
      {
        카테고리: "후기",
        제목: "오픽 세 번 만의 AL 달성 후기",
        조회수: "1,799",
      },
      {
        카테고리: "후기",
        제목: "삼수 끝의 정보처리기사 합격 후기...",
        조회수: "8,677",
      },
      {
        카테고리: "후기",
        제목: "정보보안기사 합격 후기입니다.",
        조회수: "4,001",
      },
      {
        카테고리: "후기",
        제목: "토익스피킹 레벨 7 생생 후기!",
        조회수: "3,221",
      },
      { 카테고리: "후기", 제목: "임상심리사 합격 후기", 조회수: "1,211" },
    ],
    category: "",
    page: 1,
    max: 10,
  },
  getters: {
    getSelectedBoard: function (state) {
      return state.selectedBoard;
    },
    getboardListName: function (state) {
      return state.boardListName;
    },
    getboardList: function (state) {
      return state.boardList;
    },
    getCategory: function (state) {
      return state.category;
    },
  },
  mutations: {
    SET_SELECTED_BOARD: (state, selectedBoard) => {
      state.selectedBoard = selectedBoard;
    },
    SET_BOARD_LIST_NAME: (state, boardListName) => {
      state.boardListName = boardListName;
    },
    SET_BOARD_LIST: (state, boardList) => {
      state.boardList = boardList;
    },
    SET_CATEGORY: (state, category) => {
      state.category = category;
    },
    SET_ITEMS_POPULAR: (state, items_popular) => {
      state.items_popular = items_popular;
    },
    SET_ITEMS_FREE: (state, items_free) => {
      state.items_free = items_free;
    },
    SET_ITEMS_HONEY: (state, items_honey) => {
      state.items_honey = items_honey;
    },
    SET_ITEMS_REVIEW: (state, items_review) => {
      state.items_review = items_review;
    },
  },
  actions: {
    async set_selectedBoard({ commit }, boardNo) {
      await get_board(
        boardNo,
        (response) => {
          if (response.data.msg === "SUCCESS") {
            console.log("게시판 불러오기 성공");
            commit("SET_SELECTED_BOARD", response.data.item);
          } else {
            console.log("게시판 불러오기 오류");
          }
        },
        () => {},
      );
    },

    boardListName({ commit }, boardListName) {
      commit("SET_BOARD_LIST_NAME", boardListName);
    },

    // 카테고리에 따라서 보드리스트를 적용한다.
    async set_boardList({ commit }, category) {
      const data = {
        page: 1,
        category: category,
        board: 15,
      };
      await get_boardList(
        data,
        (response) => {
          if (response.data.msg === "SUCCESS") {
            console.log("게시판 불러오기 성공");
            commit("SET_BOARD_LIST", response.data.item);
          } else {
            console.log("게시판 불러오기 오류");
          }
        },
        () => {},
      );
    },
    set_category({ commit }, category) {
      commit("SET_CATEGORY", category);
    },
    async set_items_popular({ commit }) {
      const data = {
        page: 1,
        category: "게시판",
        board: 5,
      };
      await get_boardList(
        data,
        (response) => {
          if (response.data.msg === "SUCCESS") {
            console.log("게시판 불러오기 성공");
            commit("SET_ITEMS_POPULAR", response.data.item);
          } else {
            console.log("게시판 불러오기 오류");
          }
        },
        () => {},
      );
    },
    async set_items_free({ commit }) {
      const data = {
        page: 1,
        category: "자유",
        board: 5,
      };
      await get_boardList(
        data,
        (response) => {
          if (response.data.msg === "SUCCESS") {
            console.log("게시판 불러오기 성공");
            commit("SET_ITEMS_FREE", response.data.item);
          } else {
            console.log("게시판 불러오기 오류");
          }
        },
        () => {},
      );
    },
    async set_items_honey({ commit }) {
      const data = {
        page: 1,
        category: "정보공유",
        board: 5,
      };
      await get_boardList(
        data,
        (response) => {
          if (response.data.msg === "SUCCESS") {
            console.log("게시판 불러오기 성공");
            commit("SET_ITEMS_HONEY", response.data.item);
          } else {
            console.log("게시판 불러오기 오류");
          }
        },
        () => {},
      );
    },
    async set_items_review({ commit }) {
      const data = {
        page: 1,
        category: "스터디홍보",
        board: 5,
      };
      await get_boardList(
        data,
        (response) => {
          if (response.data.msg === "SUCCESS") {
            console.log("게시판 불러오기 성공");
            commit("SET_ITEMS_REVIEW", response.data.item);
          } else {
            console.log("게시판 불러오기 오류");
          }
        },
        () => {},
      );
    },
  },
};

export default boardStore;
