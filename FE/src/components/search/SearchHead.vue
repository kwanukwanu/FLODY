<template>
  <b-row style="margin-bottom: 18px">
    <b-col cols="2">
      <b-form-select style="border-color: #a48282" v-model="selected" :options="options"></b-form-select>
    </b-col>
    <b-col cols="2">
      <b-form-select style="border-color: #a48282" v-model="selected_2" :options="options_2"></b-form-select>
    </b-col>
    <b-col cols="6">
      <b-form-input
        placeholder="자격증 이름 또는 학과 이름"
        required
        style="border-color: #a48282"
      ></b-form-input>
    </b-col>
    <b-col cols="2">
      <b-button style="color: #453535; background-color: #e1d3d2; border: none"
        >검색</b-button
      >
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

<style></style>
