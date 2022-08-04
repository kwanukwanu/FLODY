<template>
  <b-row>
    <b-col cols="2" style="padding: 4px;">
      <div class="avatar">
        <b-avatar variant="info" :src="profile" size="50px"></b-avatar>
      </div>
    </b-col>
    <b-col>
      <b-row>
        <b-col style="text-align: left; padding: 0px;">
          <div style="text-align: left; padding: 0px; font-weight: bold;">{{ userId }}</div>
        </b-col>
        <b-col cols="3" style="text-align: right; padding-left: 4px;">
          <a style="text-align: right; padding: 0px; font-weight: bold; text-decoration: none;">🤍</a>
          <!--좋아요 눌렀다면 아래 코드-->
          <!-- <a style="text-align: right; padding: 0px; font-weight: bold; text-decoration: none;">❤️</a> -->
        </b-col>
      </b-row>
      <b-row>
        <div style="text-align: left; padding: 0px">{{ contents }}</div>
      </b-row>
      <!-- <b-row style="margin-bottom: 5px;">
                <b-col cols="3" style="text-align: left; padding: 0px;">
                  <div style="text-align: left; padding: 0px; color: gray; font-size: small; display: inline;">14시간전
                  </div>
                </b-col>
                <b-col cols="3" style="text-align: left; padding: 0px;">
                  <div style="text-align: left; padding: 0px; color: gray; font-size: small; display: inline;">좋아요 18개
                  </div>
                </b-col>
                <b-col style="text-align: left; padding-right: 2px;">
                  <a
                    style="text-align: left; padding: 0px; color: gray; font-size: small; display: inline; text-decoration: none;">답글
                    달기</a>
                </b-col>
              </b-row> -->
      <b-row>
        <b-col style="padding:0px;">
          <span class="bottom_time_line">14시간&nbsp;&nbsp;&nbsp;</span>
          <span class="bottom_like_comment">좋아요 {{ favor }}개&nbsp;&nbsp;&nbsp;</span>
          <span class="bottom_like_comment">답글 달기</span>
        </b-col>
      </b-row>
    </b-col>
  </b-row>
</template>

<script>
export default {
  props: {
    userId: String,
    contents: String,
    tags: Array,
    times: String,
    favor: Number,
    profile: String,
  },
  mounted() {
    console.log(this.userId + "\n" + this.contents + "\n" + this.tags + "\n" + this.favor);
  }
};
</script>

<style>
</style>
