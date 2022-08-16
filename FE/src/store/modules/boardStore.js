import { get_boardList } from "@/api/board";
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
  },
  actions: {
    selectedBoard({ commit }, board) {
      commit("SET_SELECTED_BOARD", board);
      console.log(board);
    },
    boardListName({ commit }, boardListName) {
      commit("SET_BOARD_LIST_NAME", boardListName);
    },

    // 카테고리에 따라서 보드리스트를 적용한다.
    async set_boardList({ commit }, category) {
      await get_boardList(
        category,
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
  },
};

export default boardStore;
