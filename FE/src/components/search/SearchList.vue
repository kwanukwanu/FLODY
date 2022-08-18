<template>
  <div>
    <!-- <b-table responsive hover :items="items"></b-table> -->
    <b-table-simple fixed hover>
          <b-thead style="background-color: #f8f8ff">
              <b-tr>
                <b-th>번호</b-th>
                <b-th>대분류</b-th>
                <b-th>중분류</b-th>
                <b-th>자격증 명</b-th>
              </b-tr>
            </b-thead>
            <tbody v-for="(item, index) in searchResult" :key="(item.index = index)" v-bind="item">
              <b-tr style="padding: 5">
                <b-td>{{ index + 1 }}</b-td>
                <b-td>{{ item.fldnm }}</b-td>
                <b-td>{{ item.mfldnm }}</b-td>
                <b-td>{{ item.jmnm }}</b-td>
              </b-tr>
            </tbody>
        </b-table-simple>
    <!-- <div class="paging">
      <b-button
        variant="link"
        style="color: black; text-decoration: none; font-weight: 100"
        >&lt;
      </b-button>
      <b-button
        variant="link"
        style="color: black; text-decoration: none; font-weight: 100"
        >1</b-button
      >
      <b-button
        variant="link"
        style="color: black; text-decoration: none; font-weight: 100"
        >2</b-button
      >
      <b-button
        variant="link"
        style="color: black; text-decoration: none; font-weight: 100"
        >3</b-button
      >
      <b-button
        variant="link"
        style="color: black; text-decoration: none; font-weight: 100"
        >&gt;
      </b-button>
    </div> -->
  </div>
</template>

<script>
import { computed } from "vue";
import { useStore } from "vuex";

export default {
  data() {
    return {
      items: [
        {
          "자격증 명": "정보처리기사",
          대분류: "정보통신",
          중분류: "정보기술",
          학과: "컴퓨터공학과",
        },
        {
          "자격증 명": "정보보안기사",
          대분류: "정보통신",
          중분류: "정보기술",
          학과: "컴퓨터공학과",
        },
      ],
    };
  },
  setup() {
    const store = useStore();
    const searchResult = computed(() => store.state.licenseStore.searchResult);
    const searchInformation = computed(() => store.state.licenseStore.searchInformation);

    return { store, searchResult, searchInformation };
  },
   mounted() {
    
    // console.log(this.searchResult);
  }
};
</script>

<style>
.paging {
  text-align: center;
}
.table{
  --bs-table-hover-bg: #f8f4f4
}
</style>
