<template>
  <div>
    <b-table striped hover :items="items"></b-table>
    <div class="paging">
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
    </div>
  </div>
</template>

<script>
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
};
</script>

<style>
.paging {
  text-align: center;
}
</style>
