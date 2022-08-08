<template>
  <b-card style="height: 28rem; max-width: 30rem; background-color: #f8f3f3">
      <b-container ref="form">
        <!-- <h2 style="text-align: center;">목표 등록</h2> -->
        <b-row style="margin-bottom: 10px">
          <b-col cols="2">
            <b-avatar variant="info" src="https://placekitten.com/300/300" size="40px"></b-avatar>
          </b-col>
          <b-col cols="10" style="text-align: left; margin-top: 5px; font-weight: bold; padding-left: 0;">
            Brown_cat
          </b-col>
        </b-row>
        <b-row style="margin-bottom: 10px">
          <b-col>
            <b-form-textarea id="content" placeholder="문구 입력..." rows="10" max-rows="15" required style="border: none">
            </b-form-textarea>
          </b-col>
        </b-row>
        <!--반응형 구현 필요-->
        <b-row>
          <b-col cols="11">
            <b-form-input placeholder="위치 추가" required style="border: none;"></b-form-input>
          </b-col>
          <b-col cols="1" style="margin-top:2px;">
            <svg width="20" height="20" fill="none" xmlns="http://www.w3.org/2000/svg">
              <path d="M10 10.833a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5Z" stroke="#444" stroke-width="2"
                stroke-linecap="round" stroke-linejoin="round" />
              <path
                d="M10 18.333c3.333-3.333 6.667-6.318 6.667-10a6.667 6.667 0 0 0-13.334 0c0 3.682 3.334 6.667 6.667 10Z"
                stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
            </svg>
          </b-col>
        </b-row>
        <br />
        <b-button text @click="submit" style="color: #453535; background-color: #e1d3d2; border: none">게시</b-button>
      </b-container>
    </b-card>
</template>

<script>
export default {

}
</script>

<style>

</style>