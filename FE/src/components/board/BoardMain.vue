<template>
  <b-container>
    <b-card style="max-width:70rem; border-color: #A48282; max-height: 19.5rem;">
      <b-row>
        <b-col>
          <router-link :to="{name:'boardlist'}" style="text-decoration:none; color: inherit;" @click="gotoList('오늘의 인기글')">
            <span style="margin-left:7px; font-size:large; color: #064635; text-align: left; cursor: pointer;">오늘의 인기글
            </span>
          </router-link>
          <router-link :to="{name:'boardlist'}"><svg id="move" width="18" height="18" fill="none"
              xmlns="http://www.w3.org/2000/svg">
              <path
                d="m9 12 3-3m0 0L9 6m3 3H6m-.15 6.75h6.3c1.26 0 1.89 0 2.371-.245.424-.216.768-.56.984-.984.245-.48.245-1.11.245-2.371v-6.3c0-1.26 0-1.89-.245-2.371a2.25 2.25 0 0 0-.984-.984c-.48-.245-1.11-.245-2.371-.245h-6.3c-1.26 0-1.89 0-2.371.245a2.25 2.25 0 0 0-.984.984c-.245.48-.245 1.11-.245 2.371v6.3c0 1.26 0 1.89.245 2.371.216.424.56.768.984.984.48.245 1.11.245 2.371.245Z"
                stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
            </svg></router-link>
          <hr>
          <b-table-simple fixed hover class="popular_and_review">
            <tbody>
              <board-main-list-item-favorite v-for="(item, index) in items_popular" :key="(item.index = index)"
                v-bind="item">
              </board-main-list-item-favorite>
            </tbody>
          </b-table-simple>
        </b-col>
      </b-row>
    </b-card>
    <br>
    <b-row>

      <b-col>
        <b-card style="max-width:35rem; border-color: #A48282; max-height: 19.5rem;">
          <router-link :to="{name:'boardlist'}" style="text-decoration:none; color: inherit;" @click="gotoList('자유게시판')">
            <span
              style="margin-left:7px; font-size:large; color: #064635; text-align: left; cursor: pointer; text-decoration: none;">자유게시판
            </span>
          </router-link>
          <router-link :to="{name:'boardlist'}"><svg id="move" width="18" height="18" fill="none"
              xmlns="http://www.w3.org/2000/svg">
              <path
                d="m9 12 3-3m0 0L9 6m3 3H6m-.15 6.75h6.3c1.26 0 1.89 0 2.371-.245.424-.216.768-.56.984-.984.245-.48.245-1.11.245-2.371v-6.3c0-1.26 0-1.89-.245-2.371a2.25 2.25 0 0 0-.984-.984c-.48-.245-1.11-.245-2.371-.245h-6.3c-1.26 0-1.89 0-2.371.245a2.25 2.25 0 0 0-.984.984c-.245.48-.245 1.11-.245 2.371v6.3c0 1.26 0 1.89.245 2.371.216.424.56.768.984.984.48.245 1.11.245 2.371.245Z"
                stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
            </svg></router-link>
          <hr>
          <b-table-simple fixed hover :items="items" class="free_and_honey">
            <tbody>
              <board-main-list-item v-for="(item, index) in items_free" :key="(item.index = index)" v-bind="item">
              </board-main-list-item>
            </tbody>
          </b-table-simple>
        </b-card>
      </b-col>

      <b-col>
        <b-card style="max-width:35rem; border-color: #A48282; max-height: 19.5rem;">
          <router-link :to="{name:'boardlist'}" style="text-decoration:none; color: inherit;" @click="gotoList('공부 꿀팁')">
            <span
              style="margin-left:7px; font-size:large; color: #064635; text-align: left; cursor: pointer; text-decoration: none;">공부
              꿀팁 </span>
          </router-link>
          <router-link :to="{name:'boardlist'}"><svg id="move" width="18" height="18" fill="none"
              xmlns="http://www.w3.org/2000/svg">
              <path
                d="m9 12 3-3m0 0L9 6m3 3H6m-.15 6.75h6.3c1.26 0 1.89 0 2.371-.245.424-.216.768-.56.984-.984.245-.48.245-1.11.245-2.371v-6.3c0-1.26 0-1.89-.245-2.371a2.25 2.25 0 0 0-.984-.984c-.48-.245-1.11-.245-2.371-.245h-6.3c-1.26 0-1.89 0-2.371.245a2.25 2.25 0 0 0-.984.984c-.245.48-.245 1.11-.245 2.371v6.3c0 1.26 0 1.89.245 2.371.216.424.56.768.984.984.48.245 1.11.245 2.371.245Z"
                stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
            </svg></router-link>
          <hr>
          <b-table-simple fixed hover class="free_and_honey">
            <tbody>
              <board-main-list-item v-for="(item,index) in items_honey" :key="item.index = index" v-bind="item">
              </board-main-list-item>
            </tbody>
          </b-table-simple>
        </b-card>
      </b-col>
    </b-row>
    <br>
    <b-card style="max-width:70rem; border-color: #A48282; max-height: 19.5rem;">
      <b-row>
        <b-col>
          <router-link :to="{name:'boardlist'}" style="text-decoration:none; color: inherit;" @click="gotoList('합격 후기')">
            <span
              style="margin-left:7px; font-size:large; color: #064635; text-align: left; cursor: pointer; text-decoration: none;">합격
              후기 </span>
          </router-link>
          <router-link :to="{name:'boardlist'}"><svg id="move" width="18" height="18" fill="none"
              xmlns="http://www.w3.org/2000/svg">
              <path
                d="m9 12 3-3m0 0L9 6m3 3H6m-.15 6.75h6.3c1.26 0 1.89 0 2.371-.245.424-.216.768-.56.984-.984.245-.48.245-1.11.245-2.371v-6.3c0-1.26 0-1.89-.245-2.371a2.25 2.25 0 0 0-.984-.984c-.48-.245-1.11-.245-2.371-.245h-6.3c-1.26 0-1.89 0-2.371.245a2.25 2.25 0 0 0-.984.984c-.245.48-.245 1.11-.245 2.371v6.3c0 1.26 0 1.89.245 2.371.216.424.56.768.984.984.48.245 1.11.245 2.371.245Z"
                stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
            </svg></router-link>
          <hr>
          <b-table-simple fixed hover class="popular_and_review">
            <tbody>
              <board-main-list-item v-for="(item, index) in items_review" :key="(item.index = index)" v-bind="item">
              </board-main-list-item>
            </tbody>
          </b-table-simple>
        </b-col>
      </b-row>
    </b-card>
  </b-container>
</template>

<script>
import {useStore} from "vuex";

import BoardMainListItemFavorite from './Items/BoardMainListItemFavorite.vue';
import BoardMainListItem from './Items/BoardMainListItem.vue';

export default {
  components:{
    BoardMainListItemFavorite,
    BoardMainListItem,
  },
  setup(){
    const store = useStore();
    return {store};
  },
  data() {
    return {
        items_popular: [
        { 카테고리:'자유', 제목: '오픽 공부 하기 싫다', 조회수: '7,799'},
        { 카테고리:'후기', 제목: '삼수 끝의 정보처리기사 합격 후기...', 조회수: '8,677'},
        { 카테고리:'꿀팁', 제목: 'toeic speaking honey tip 제공합니다 드루오세요', 조회수: '4.1만'},
        { 카테고리:'자유', 제목: '정보보안기사 따면 좋나요?', 조회수: '2.1만'},
        { 카테고리:'자유', 제목: '오픽 보고 왔는데 네 번 연속 IH.. AL 포기 할까요', 조회수: '1만'},
        ],
        items_free: [
        { 카테고리:'자유', 제목: '오픽 공부 하기 싫다ㅜㅜ', 조회수: '7,799' },
        { 카테고리:'자유', 제목: '네트워크는 어려워', 조회수: '811' },
        { 카테고리:'자유', 제목: '토익스피킹 공부하는데 현타가..', 조회수: '1,334'},
        { 카테고리:'자유', 제목: '정보보안기사 따면 좋나요?', 조회수: '2.1만'},
        { 카테고리:'자유', 제목: '오픽 보고 왔는데 네 번 연속 IH..', 조회수: '1만'},
        ],
        items_honey: [
        { 카테고리:'꿀팁', 제목: 'toeic speaking honey tip 제...', 조회수: '4.1만'},
        { 카테고리:'꿀팁', 제목: '오픽 꿀팁!', 조회수: '1만'},
        { 카테고리:'꿀팁', 제목: '토익스피킹 나만의 꿀팁..', 조회수: '3만'},
        { 카테고리:'꿀팁', 제목: '정보보안기사 꿀팁입니다', 조회수: '2만'},
        { 카테고리:'꿀팁', 제목: '한능검 꿀팁 드려요', 조회수: '5,444'},
        ],
        items_review: [
        { 카테고리:'후기', 제목: '오픽 세 번 만의 AL 달성 후기', 조회수: '1,799'},
        { 카테고리:'후기', 제목: '삼수 끝의 정보처리기사 합격 후기...', 조회수: '8,677'},
        { 카테고리:'후기', 제목: '정보보안기사 합격 후기입니다.', 조회수: '4,001'},
        { 카테고리:'후기', 제목: '토익스피킹 레벨 7 생생 후기!', 조회수: '3,221'},
        { 카테고리:'후기', 제목: '임상심리사 합격 후기', 조회수: '1,211'},
      ]     
    }
  },
  methods:{
    gotoList(listname){
      console.log(listname);
      this.store.dispatch("boardStore/boardListName",listname);
    }
  }
}

</script>

<style>
.popular_and_review{
  margin-bottom: 1.8rem;
  border-color: #e4dada;
  max-width: 70rem; 
}
.free_and_honey{
  margin-bottom: 1.8rem;
  border-color: #e4dada;
  max-width: 32rem; 
}
</style>