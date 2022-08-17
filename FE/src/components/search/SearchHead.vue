<template>
  <b-row style="margin-bottom: 18px">
    <b-col cols="2">
      <b-form-select style="border-color: #a48282" v-model="selected" :options="options"></b-form-select>
    </b-col>
    <b-col cols="2">
      <b-form-select style="border-color: #a48282" v-model="selected_2" :options="options_2"></b-form-select>
    </b-col>
    <b-col cols="7">
      <b-form-input
        placeholder="자격증 이름 또는 학과 이름"
        required
        style="border-color: #a48282"
      ></b-form-input>
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
</template>

<script>
export default {
  data() {
      return {
        selected: 'null',
        options: [
          { value: 'null', text: '대분류' },
          { value: 'a', text: '정보통신' },
          // { value: 'b', text: 'Selected Option' },
        ],
        selected_2: 'null',
        options_2: [
           { value: 'null', text: '중분류' },
          { value: 'a', text: '정보기술' },
          // { value: 'b', text: 'Selected Option' },
        ]
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
