<template>
  <b-card style="max-width: 70rem; background-color: #FBF1EE; margin-top: 27px;">
    <b-container ref="form" style="padding:0px 12px 0px 0px">
      <b-row>
        <b-col>
          <!-- fluid alt="Responsive image" -->

          <!-- 사진 종류에 따라 크기가 맞지 않음 = 조정 필요-->
          <b-img :src="picture"
            style="width: 100%; height: auto; max-width:700px; max-height: 440px; display:inline-block; margin:0 auto;">
          </b-img>
        </b-col>
        <b-col style="background-color: #ffffff;">
          <newspid-list v-bind="$props"></newspid-list>
        </b-col>
      </b-row>
      <b-row style="margin-top: 15px;">
        <b-col cols="1">
          <svg width="37" height="38" fill="none" xmlns="http://www.w3.org/2000/svg">
            <path
              d="M12.333 22.167s2.313 3.166 6.167 3.166c3.854 0 6.167-3.166 6.167-3.166m-1.542-7.917h.015m-9.265 0h.015M33.917 19c0 8.744-6.903 15.833-15.417 15.833S3.083 27.745 3.083 19c0-8.745 6.903-15.833 15.417-15.833S33.917 10.255 33.917 19Zm-10.021-4.75a.781.781 0 0 1-.771.792.781.781 0 0 1-.77-.792c0-.437.344-.792.77-.792.426 0 .77.355.77.792Zm-9.25 0a.781.781 0 0 1-.771.792.781.781 0 0 1-.77-.792c0-.437.344-.792.77-.792.426 0 .77.355.77.792Z"
              stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
          </svg>
        </b-col>
        <b-col cols="10">
          <b-form-input placeholder="댓글 달기..." required style="border: none;"></b-form-input>
        </b-col>
        <b-col cols="1">
          <div style="color: #BC6464; padding: 6px 0px; font-weight: bold;">게시</div>
        </b-col>
      </b-row>
    </b-container>
  </b-card>
  <newspid-detail-modals></newspid-detail-modals>

</template>

<script>
import { useStore } from "vuex";

import NewspidList from "@/components/newspid/NewspidList.vue";
import NewspidDetailModals from "@/components/newspid/modal/NewspidDetailModals.vue";


export default {
  components: { NewspidList, NewspidDetailModals },
  props: {
    pidNo: Number,          // 뉴스피드 번호
    author: String,         // 뉴스피드 작성자
    profile: String,        // 작성자 사진
    contents: String,       // 작성 내용 
    tags: Array,            // 태그
    creativetimes: Object,    // 작성 날짜
    picture: String,        // 사진
    favor: Number,          // 좋아요 개수
    comments: Array,        // 댓글들
  },
  setup() {
    const store = useStore();
    return { store };
  },
  mounted() {
    console.log("Detail-----------------------------");
    console.log(this.pidNo);
    console.log(this.author);
    console.log(this.comments);
  },
  methods: {
    Delete() {
      console.log("삭제");
    },
    Modify() {
      console.log("수정");
    },
    // 빠져나가는 함수 적용 필요
    Cancel() {
      console.log("취소");
    },
  },
}

</script>

<style>
.avatar {
  margin-left: 5px;
  margin-top: 5px;
}

.bottom_time_line {
  color: gray;
  font-size: small;
  text-align: left;
}

.bottom_like_comment {
  color: gray;
  font-size: small;
  text-align: left;
  font-weight: bold;
}
</style>