<template>
  <b-container>
    <b-card style="max-width:70rem; border-color: #A48282; max-height: 19.5rem;">
      <b-row>
        <b-col>
          <router-link :to="{ name: 'boardlist' }" style="text-decoration:none; color: inherit;"
            @click="gotoList('오늘의 인기글', '게시판')">
            <span style="margin-left:7px; font-size:large; color: #064635; text-align: left; cursor: pointer;">오늘의 인기글
            </span>
          </router-link>
          <router-link :to="{ name: 'boardlist' }"><svg id="move" width="18" height="18" fill="none"
              @click="gotoList('오늘의 인기글', '게시판')" xmlns="http://www.w3.org/2000/svg">
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
          <router-link :to="{ name: 'boardlist' }" style="text-decoration:none; color: inherit;"
            @click="gotoList('자유게시판', '자유')">
            <span
              style="margin-left:7px; font-size:large; color: #064635; text-align: left; cursor: pointer; text-decoration: none;">자유게시판
            </span>
          </router-link>
          <router-link :to="{ name: 'boardlist' }"><svg id="move" width="18" height="18" fill="none"
              @click="gotoList('자유게시판', '자유')" xmlns="http://www.w3.org/2000/svg">
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
          <router-link :to="{ name: 'boardlist' }" style="text-decoration:none; color: inherit;"
            @click="gotoList('공부 꿀팁', '정보공유')">
            <span
              style="margin-left:7px; font-size:large; color: #064635; text-align: left; cursor: pointer; text-decoration: none;">공부
              꿀팁 </span>
          </router-link>
          <router-link :to="{ name: 'boardlist' }"><svg id="move" width="18" height="18" fill="none"
              @click="gotoList('공부 꿀팁', '정보공유')" xmlns="http://www.w3.org/2000/svg">
              <path
                d="m9 12 3-3m0 0L9 6m3 3H6m-.15 6.75h6.3c1.26 0 1.89 0 2.371-.245.424-.216.768-.56.984-.984.245-.48.245-1.11.245-2.371v-6.3c0-1.26 0-1.89-.245-2.371a2.25 2.25 0 0 0-.984-.984c-.48-.245-1.11-.245-2.371-.245h-6.3c-1.26 0-1.89 0-2.371.245a2.25 2.25 0 0 0-.984.984c-.245.48-.245 1.11-.245 2.371v6.3c0 1.26 0 1.89.245 2.371.216.424.56.768.984.984.48.245 1.11.245 2.371.245Z"
                stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
            </svg></router-link>
          <hr>
          <b-table-simple fixed hover class="free_and_honey">
            <tbody>
              <board-main-list-item v-for="(item, index) in items_honey" :key="item.index = index" v-bind="item">
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
          <router-link :to="{ name: 'boardlist' }" style="text-decoration:none; color: inherit;"
            @click="gotoList('합격 후기', '스터디홍보')">
            <span
              style="margin-left:7px; font-size:large; color: #064635; text-align: left; cursor: pointer; text-decoration: none;">
              합격 후기
            </span>
          </router-link>
          <router-link :to="{ name: 'boardlist' }"><svg id="move" width="18" height="18" fill="none"
              @click="gotoList('합격 후기', '스터디홍보')" xmlns="http://www.w3.org/2000/svg">
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
import { computed } from "vue";
import { useStore } from "vuex";

import BoardMainListItemFavorite from './Items/BoardMainListItemFavorite.vue';
import BoardMainListItem from './Items/BoardMainListItem.vue';

export default {
  components: {
    BoardMainListItemFavorite,
    BoardMainListItem,
  },
  setup() {
    const store = useStore();
    const items_popular = computed(() => store.state.boardStore.items_popular);
    const items_honey = computed(() => store.state.boardStore.items_honey);
    const items_free = computed(() => store.state.boardStore.items_free);
    const items_review = computed(() => store.state.boardStore.items_review);
    return { store, items_popular, items_honey, items_free, items_review };
  },
  data() {
    return {

    }
  },
  methods: {
    gotoList(listname, category) {
      console.log(listname);
      this.store.dispatch("boardStore/boardListName", listname);
      this.store.dispatch("boardStore/set_category", category);
    }
  },
  mounted() {
    // 아직 미완성이라 주석처리함
    //this.store.dispatch("boardStore/set_items_popular");
    //this.store.dispatch("boardStore/set_items_free");
    //this.store.dispatch("boardStore/set_items_honey");
    //this.store.dispatch("boardStore/set_items_review");
  }
}

</script>

<style>
.popular_and_review {
  margin-bottom: 1.8rem;
  border-color: #e4dada;
  max-width: 70rem;
}

.free_and_honey {
  margin-bottom: 1.8rem;
  border-color: #e4dada;
  max-width: 32rem;
}

.table {
  --bs-table-hover-bg: #f8f4f4
}
</style>