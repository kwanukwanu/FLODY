<template>
  <div style="margin-bottom: 10px; margin-left: 45px">
    <b-row>
      <b-col cols="1" style="padding: 4px; text-align: right">
        <b-avatar variant="info" :src="pics" size="26px"></b-avatar>
      </b-col>
      <b-col>
        <b-row>
          <b-col cols="2">
            <div style="text-align: left">
              <a style="padding: 0px; font-weight: bold; text-decoration: none">
                {{userId}}
              </a>
            </div>
          </b-col>
        </b-row>
        <b-row>
          <b-col>
            <div style="text-align: left; padding: 0px">{{contents}}</div>
          </b-col>
          <b-col>
            <div style="text-align: right">
              <a style="cursor:pointer" v-b-modal.modal-6>신고</a>
            </div>
          </b-col>
        </b-row>
        <b-row>
          <b-col cols="1">
            <div style="color: #9f9f9f">{{date}}</div>
          </b-col>
          <b-col cols="1">
            <div style="color: #9f9f9f">{{time}}</div>
          </b-col>
          <b-col cols="2">
            <a href="" style="
                color: #9f9f9f;
                text-align: left;
                font-weight: bold;
                text-decoration: none;
              ">답글 쓰기</a>
          </b-col>
        </b-row>
      </b-col>
    </b-row>
  </div>
</template>

<script>
export default {
  data() {
    return {
      pics: "https://placekitten.com/300/250",
    };
  },
  props: {
    profile: String,
    userId: String,
    contents: String,
    date: String,
    time: String,
  },
  mounted() {
    this.pics = this.profile;
    console.log(this.profile);
    console.log(this.userId);
    console.log(this.date);
    console.log(this.time);
  },
};
</script>

<style></style>
