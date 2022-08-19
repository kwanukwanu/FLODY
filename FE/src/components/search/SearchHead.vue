<template>
  <b-row style="margin-bottom: 18px">
    <b-col cols="2">
      <b-form-select style="border-color: #a48282" v-model="selected" :options="options">
        <template #first>
          <b-form-select-option :value="null" disabled selected>-- 대분류 --</b-form-select-option>
        </template>
      </b-form-select>
    </b-col>
    <b-col cols="2">
      <b-form-select style="border-color: #a48282" v-model="selected_2" :options="options_2">
        <template #first>
          <b-form-select-option :value="null" disabled>-- 중분류 --</b-form-select-option>
        </template>
      </b-form-select>
    </b-col>
    <b-col cols="2">
      <b-form-select style="border-color: #a48282" v-model="selected_3" :options="options_3">
        <template #first>
          <b-form-select-option :value="null" disabled>-- 카테고리 --</b-form-select-option>
        </template>
      </b-form-select>
    </b-col>
    <b-col cols="5">
      <b-form-input
        placeholder="자격증 이름 또는 학과 이름"
        required
        style="border-color: #a48282"
        v-model="searchKeyword"
      ></b-form-input>
    </b-col>
    <b-col cols="1">
      <b-button @click="submit" style="color: #453535; background-color: #e1d3d2; border: none"><svg width="22" height="22" fill="none"
          xmlns="http://www.w3.org/2000/svg">
          <path d="m19.25 19.25-3.988-3.988m2.155-5.179a7.333 7.333 0 1 1-14.667 0 7.333 7.333 0 0 1 14.667 0Z"
            stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
        </svg>
      </b-button>
    </b-col>
  </b-row>
  <div style="display: none;">{{selected}}</div>
</template>

<script>
// import { 
//   get_license_list, 
//   get_license_fields,  
//   get_license_middle_fields 
// } from "@/api/license";
import { computed } from "vue";
import { useStore } from "vuex";

export default {
  data() {
    return {
      selected: null,
      options: [],
      selected_2: 'null',
      options_2: [],
      selected_3: 'null',
      options_3: [
          { value: '종목명', text: '종목명' },
        { value: '학과명', text: '학과명' },
        // { value: 'b', text: 'Selected Option' },
      ],
      searchKeyword: '',
      searchInfo: [],
    }
  },
  setup() {
    const store = useStore();
    const searchResult = computed(() => store.state.licenseStore.searchResult);
    const bigField = computed(() => store.state.licenseStore.bigField);
    const middleField = computed(() => store.state.licenseStore.middleField);

    return { store, searchResult, bigField, middleField };
  },
  mounted() {
    this.store.dispatch("licenseStore/set_big_field");
    console.log(this.bigField);
    this.options = this.bigField;
    this.options.push(null);
  },
  async updated() {
    await this.store.dispatch("licenseStore/set_middle_field", this.selected);
    console.log(this.middleField);
    this.options_2 = this.middleField;
  },
  methods: {
    async submit() {
      this.searchInfo.fldnm = this.selected;
      this.searchInfo.mfldnm = this.selected_2;
      this.searchInfo.category = this.selected_3;
      this.searchInfo.keyword = this.searchKeyword;

      console.log(this.searchInfo);
      // await this.store.dispatch("licenseStore/set_search_info", this.searchInfo);
      await this.store.dispatch("licenseStore/set_search_result", this.searchInfo);
      console.log(this.searchResult);
    }
  }
};
</script>

<style>
.form-select {
  box-shadow: none !important;
}
.form-control{
  box-shadow: none !important;
}
</style>
