import {
  get_license_list,
  get_license_fields,
  get_license_middle_fields
} from '@/api/license'

const licenseStore = {
  namespaced: true,
  state: {
    searchResult: [],
    bigField: [],
    middleField: [],
    searchInformation: [],
  },
  getters: {

  },
  mutations: {
    SET_SEARCH_RESULT: (state, searchResult) => {
      state.searchResult = searchResult;
    },
    SET_BIG_FIELD: (state, bigField) => {
      state.bigField = bigField;
    },
    SET_MIDDLE_FIELD: (state, middleField) => {
      state.middleField = middleField;
    },
    SET_SEARCH_INFO: (state, searchInformation) => {
      state.searchInformation = searchInformation;
    }
  },
  actions: {
    async set_search_result({ commit }, licenseInfo) {
      await get_license_list(
        licenseInfo,
        (response) => {
          console.log(response);
          if (response.data.msg === "SUCCESS") {
            console.log("라이센스 검색 성공");
            commit("SET_SEARCH_RESULT", response.data.item);
          } else {
            console.log("라이센스 검색 실패")
          }
        },
        (error) => {
          console.log(error);
        },
      )
    },
    async set_big_field({ commit }) {
      await get_license_fields(
        (response) => {
          console.log(response);
          if (response.data.msg === "SUCCESS") {
            console.log("라이센스 대분류 조회");
            commit("SET_BIG_FIELD", response.data.item);
          } else {
            console.log("라이센스 대분류 조회 실패")
          }
        },
        (error) => {
          console.log(error);
        },
      )
    },
    async set_middle_field({ commit }, fldnm) {
      await get_license_middle_fields(
        fldnm,
        (response) => {
          console.log(response);
          if (response.data.msg === "SUCCESS") {
            console.log("라이센스 중분류 조회");
            commit("SET_MIDDLE_FIELD", response.data.item);
          } else {
            console.log("라이센스 중분류 조회 실패")
          }
        },
        (error) => {
          console.log(error);
        },
      )
    },
    set_search_info({commit}, searchInfo) {
      commit("SET_SEARCH_INFO", searchInfo);
    }
  }
};

export default licenseStore;