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
              style="color: white; background-color: #83A39A; text-decoration: none; font-weight: 100; border: 1px solid; margin-left: 12px;" @click="gotoPage('/club')">
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
</template>

<script>
export default {

}
</script>

<style>

</style>