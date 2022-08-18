<template>
  <b-container>
    <b-card style="max-width: 70rem; border-color: #a48282; max-height: 120rem">
      <b-row>
        <b-col>
          <span style="
              margin-left: 7px;
              font-size: large;
              color: #064635;
              text-align: left;
            ">{{ boardListname }}
          </span>

          <hr />
          <b-table-simple responsive hover>
            <!-- 글 머리 -->
            <b-thead style="background-color: #f8f8ff">
              <b-tr>
                <b-th>카테고리</b-th>
                <b-th>글번호</b-th>
                <b-th>제목</b-th>
                <b-th>작성자</b-th>
                <b-th>작성일</b-th>
                <b-th>조회수</b-th>
              </b-tr>
            </b-thead>
            <tbody>
              <board-list-item v-for="(item, index) in items_popular" :key="(item.index = index)" v-bind="item">
              </board-list-item>
            </tbody>
          </b-table-simple>
          <!-- <b-table fixed hover :items="items_popular" class="common"> </b-table> -->
          <!-- 오늘의 인기글 클릭 시 글쓰기 버튼 안 보이도록 해야 함-->
          <div style="text-align: right">
            <b-button variant="link"
              style="padding: 0px 12px; background-color: #E3D6D6; text-decoration: none; color:black;"
              v-b-modal.modal-2>
              글쓰기</b-button>
          </div>
        </b-col>
      </b-row>
    </b-card>
    <br />
    <div class="paging">
      <span v-if="page > 5">
        <b-button variant="link" style="color: black; text-decoration: none; font-weight: 100"
        @click="movePage(-5)">&lt;
      </b-button>
      </span>
      <span v-else></span>
      <span v-if="page > 3">
      <b-button variant="link" style="color: black; text-decoration: none; font-weight: 100"
        @click="movePage(-3)">{{ page - 3 }}</b-button>
      </span>
      <span v-else></span>
      <span v-if="page > 2">
      <b-button variant="link" style="color: black; text-decoration: none; font-weight: 100" 
        @click="movePage(-2)">{{ page - 2 }}</b-button>
      </span>
      <span v-else></span>
      <span v-if="page > 1">
      <b-button variant="link" style="color: black; text-decoration: none; font-weight: 100" 
        @click="movePage(-1)">{{ page - 1 }}</b-button>
      </span>
      <span v-else></span>
      <b-button variant="link" style="color: black; text-decoration: none; font-weight: 100">{{ page }}</b-button>
      <span v-if="page < max - 1">
      <b-button variant="link" style="color: black; text-decoration: none; font-weight: 100" 
        @click="movePage(1)">{{ page + 1 }}</b-button>
      </span>
      <span v-else></span>
      <span v-if="page < max - 2">
      <b-button variant="link" style="color: black; text-decoration: none; font-weight: 100" 
        @click="movePage(2)">{{ page + 2 }}</b-button>
      </span>
      <span v-else></span>
      <span v-if="page < max - 3">
      <b-button variant="link" style="color: black; text-decoration: none; font-weight: 100" 
        @click="movePage(3)">{{ page + 3 }}</b-button>
      </span>
      <span v-else></span>
      <span v-if="page < max - 5">
      <b-button variant="link" style="color: black; text-decoration: none; font-weight: 100" 
        @click="movePage(5)">&gt;</b-button>
      </span>
      <span v-else></span>
    </div>
  </b-container>
  <br />

  <b-row style="margin-bottom: 10px">
    <b-col cols="3">
      <b-form-select v-model="selected" :options="options" class="mb-3" value-field="item" text-field="name"
        disabled-field="notEnabled" style="border-color: rgb(164, 130, 130);">

      </b-form-select>
    </b-col>
    <b-col cols="3">
      <b-form-select v-model="selected_2" :options="options_2" class="mb-3" value-field="item" text-field="name"
        disabled-field="notEnabled" style="border-color: rgb(164, 130, 130);"></b-form-select>
    </b-col>
    <b-col cols="5">
      <b-form-input placeholder="검색어를 입력해주세요" style="border-color: rgb(164, 130, 130);"></b-form-input>
    </b-col>
    <b-col cols="1">
      <b-button style="color: #453535; background-color: #e1d3d2; border: none"><svg width="22" height="22" fill="none"
          xmlns="http://www.w3.org/2000/svg">
          <path d="m19.25 19.25-3.988-3.988m2.155-5.179a7.333 7.333 0 1 1-14.667 0 7.333 7.333 0 0 1 14.667 0Z"
            stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
        </svg>
      </b-button>
    </b-col>
  </b-row>

  <b-modal hide-footer id="modal-2" centered title="새 게시물 만들기" style="text-align: center">
    <b-card style="height: 29rem; max-width: 30rem; background-color: #f8f3f3">
      <b-container ref="form">
        <!-- <h2 style="text-align: center;">목표 등록</h2> -->
        <b-row style="margin-bottom: 10px">
          <b-col>
            <b-form-input placeholder="제목을 입력하세요" required style="border: none"></b-form-input>
          </b-col>
        </b-row>
        <b-row style="margin-bottom: 10px">
          <b-col>
            <b-form-select style="border: none" v-model="selected_3" :options="options_3" class="mb-3"
              value-field="item" text-field="name" disabled-field="notEnabled"></b-form-select>
          </b-col>
        </b-row>
        <b-row style="margin-bottom: 10px">
          <b-col>
            <b-form-textarea id="content" placeholder="내용 입력..." rows="10" max-rows="15" required style="border: none">
            </b-form-textarea>
          </b-col>
        </b-row>
        <br />
        <b-button text @click="submit" style="color: #453535; background-color: #e1d3d2; border: none">게시</b-button>
      </b-container>
    </b-card>
  </b-modal>
</template>

<script>
import { computed } from "vue";
import { useStore } from "vuex";

import BoardListItem from "./Items/BoardListItem.vue";

export default {
  components: { BoardListItem },
  data() {
    return {
      page: 1,
      max: 10,
      selected: 'A',
      options: [
        { item: 'A', name: '전체기간' },
        { item: 'B', name: '1일' },
        { item: 'C', name: '1주' },
        { item: 'D', name: '1개월' },
        { item: 'E', name: '6개월' },
        { item: 'F', name: '1년' }
      ],

      selected_2: 'A',
      options_2: [
        { item: 'A', name: '게시글 + 댓글' },
        { item: 'B', name: '제목만' },
        { item: 'C', name: '글작성자' },
        { item: 'D', name: '댓글내용' },
        { item: 'E', name: '댓글작성자' }
      ],

      selected_3: 'A',
      options_3: [
        { item: 'A', name: '자유게시판' },
        { item: 'B', name: '공부 꿀팁' },
        { item: 'C', name: '합격 후기' }
      ],
    };
  },
  setup() {
    const store = useStore();
    const boardListname = computed(() => store.state.boardStore.boardListName);
    const category = computed(() => store.state.boardStore.category);
    const items_popular = computed(() => store.state.boardStore.boardList);
    return { store, category, boardListname, items_popular };
  },
  mounted() {
    console.log("selected list : ");
    console.log(this.boardListname);
    //this.store.dispatch("/boardStore/set_boardList",this.category);
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
  color: black;
}

.btn-secondary {
  --bs-btn-focus-shadow-rgb: white;
}

.btn-link {
  --bs-btn-focus-shadow-rgb: white;
}

.form-select {
  box-shadow: none !important;
  outline: none !important;
}

.form-control {
  box-shadow: none !important;
  outline: none !important;
}

/* .page-link{
  color:black;
}
.active>.page-link{
  background-color: #B1C5BF;
}
.justify-content-start {
    justify-content: center!important;
} */
</style>
