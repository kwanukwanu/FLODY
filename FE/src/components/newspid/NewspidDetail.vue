<template>
  <b-card style="max-width: 70rem; background-color: #FBF1EE; margin-top: 27px;">
    <b-container ref="form" style="padding:0px 12px 0px 0px">
      <b-row>
        <b-col>
          <!-- fluid alt="Responsive image" -->
          <b-img src="https://placekitten.com/300/"
            style="width: 100%; height: auto; max-width:700px; display:block; margin:0 auto;"></b-img>
        </b-col>
        <b-col style="background-color: #ffffff;">
          <newspid-list></newspid-list>
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

  <b-modal hide-footer hide-title hide-header  centered id="modal-4" size="sm" style="text-align: center;">
    <b-container>
      <!-- 본인 게시물이라면 신고 안 보이도록 해야 함 -->
      <b-row @click="Delete" style="text-align:center; cursor: pointer; color: red; font-weight: 600;">
        <div style="text-align:center;" v-b-modal.modal-7>신고</div>
      </b-row>
      <hr />
      <b-row @click="Delete" style="text-align:center; cursor: pointer; color: red; font-weight: 600;">
        <div style="text-align:center;">삭제</div>
      </b-row>
      <hr />
      <b-row @click="Modify" style="cursor: pointer;">
        <div style="text-align:center;">수정</div>
      </b-row>
      <hr />
      <b-row @click="Cancel" style="text-align:center; cursor: pointer;">
        <div style="text-align:center;">취소</div>
      </b-row>
    </b-container>
  </b-modal>

  <b-modal hide-footer hide-title hide-header no-stacking centered id="modal-5" size="md" style="text-align: center;">
    <b-container>
      <b-row>
        <b-col>
          <div style="text-align:center;">
            <b-avatar variant="info" src="https://placekitten.com/300/300" size="85px"></b-avatar>
          </div>
        </b-col>
      </b-row>
      <br>
      <b-row>
        <b-col style="margin-bottom:12px;">
          @Brown_Cat님의 팔로우를 취소하시겠어요?
        </b-col>
      </b-row>
      <hr />
      <b-row @click="Modify" style="cursor: pointer; color: red; font-weight: bold;">
        <div style="text-align:center;">팔로우 취소</div>
      </b-row>
      <hr />
      <b-row @click="Cancel" style="text-align:center; cursor: pointer;">
        <div style="text-align:center;" >취소</div>
      </b-row>
    </b-container>
  </b-modal>

  <b-modal hide-footer id="modal-7" centered no-stacking title="신고하기" style="text-align: center">
    <b-card style="height: 23rem; max-width: 30rem; background-color: #f8f3f3">
      <b-container ref="form">
        <b-row style="margin-bottom: 10px">
          <b-col>
            <b-form-textarea id="content" placeholder="신고 내용" rows="10" max-rows="15" required style="border: none">
            </b-form-textarea>
          </b-col>
        </b-row>
        <br />
        <b-button text @click="submit" style="color: #453535; background-color: #e1d3d2; border: none">제출</b-button>
      </b-container>
    </b-card>
  </b-modal>
</template>

<script>
import NewspidList from "@/components/newspid/NewspidList.vue";

export default {
  components:{ NewspidList },
  methods:{
    Delete(){
      console.log("삭제");
    },
    Modify(){
      console.log("수정");
    }, 
    // 빠져나가는 함수 적용 필요
    Cancel(){
      console.log("취소");
    }
    
  },
}

</script>

<style>


.avatar{
  margin-left: 5px;
  margin-top: 5px;
}
.bottom_time_line{
  color: gray; 
  font-size: small;
  text-align: left;
}
.bottom_like_comment{
  color: gray; 
  font-size: small;
  text-align: left;
  font-weight: bold;
}
</style>