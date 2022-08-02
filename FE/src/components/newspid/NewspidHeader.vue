<template>
  <b-container>
    <div>내 뉴스피드</div>
    <br>
    <b-row align-v="center">
      <b-col cols="2" style="padding: 0px; text-align: center;">
        <b-avatar variant="info" src="https://placekitten.com/300/300" size="90px"></b-avatar>
      </b-col>
      <b-col>
        <b-row>
          <b-col cols="2" style="text-align: left; padding: 0px;">
            <div style="text-align: left; padding: 0px; font-weight: bold; font-size: 25px;">dfsdf</div>
          </b-col>
          <b-col cols="7" style="text-align: left; padding: 4px;">
            <b-button size="sm" variant="link"
              style="color: black; text-decoration: none; font-weight: 100; border: 1px solid;">프로필
              편집</b-button>
            <b-button size="sm" variant="link"
              style="color: white; background-color: #83A39A; text-decoration: none; font-weight: 100; border: 1px solid; margin-left: 12px;"
              v-b-modal.modal-3>
              새 게시물 만들기</b-button>
            <!--온클릭해서 게시글 작성 모달로 이동하도록-->
          </b-col>
        </b-row>
        <b-row>
          <b-col cols="2" style="text-align: left; padding: 0;">
            <div>게시글 4</div>
          </b-col>
          <b-col cols="2" style="text-align: left; padding: 0;">
            <div>팔로워 222</div>
          </b-col>
          <b-col style="text-align: left; padding: 0;">
            <div>팔로우 124</div>
          </b-col>
        </b-row>
      </b-col>
    </b-row>
  </b-container>
  <br>
  <hr style="margin: 5px;" />
  <br>
  <b-container>
    <div>다른사람 뉴스피드</div>
    <br>
    <b-row align-v="center">
      <b-col cols="2" style="padding: 0px; text-align: center;">
        <b-avatar variant="info" src="https://placekitten.com/300/200" size="90px"></b-avatar>
      </b-col>
      <b-col>
        <b-row>
          <b-col cols="2" style="text-align: left; padding: 0px;">
            <div style="text-align: left; padding: 0px; font-weight: bold; font-size: 25px;">Giri_Girl</div>
          </b-col>
          <b-col cols="7" style="text-align: left; padding: 4px;">
            <b-button size="sm" variant="link"
              style="color: black; text-decoration: none; font-weight: 100; border: 1px solid;">메시지 보내기</b-button>
            <b-button size="sm" variant="link"
              style="color: white; background-color: #83A39A; text-decoration: none; font-weight: 100; border: 1px solid; margin-left: 12px;">
              팔로우</b-button>

          </b-col>
        </b-row>
        <b-row>
          <b-col cols="2" style="text-align: left; padding: 0;">
            <div>게시글 4</div>
          </b-col>
          <b-col cols="2" style="text-align: left; padding: 0;">
            <div>팔로워 222</div>
          </b-col>
          <b-col style="text-align: left; padding: 0;">
            <div>팔로우 124</div>
          </b-col>
        </b-row>
      </b-col>
    </b-row>
  </b-container>
  <!-- <hr style="margin: 5px;" /> -->

  <b-modal hide-footer id="modal-3" centered title="새 게시물 만들기" style="text-align: center">
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
  </b-modal>
</template>

<script>
export default {

}
</script>

<style>

</style>