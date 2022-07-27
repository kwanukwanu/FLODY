<template>
    <b-card style="max-width: 20rem; background-color: #F8F3F3;" class="p-0">
      <b-container>
        <b-row>
          <b-col cols="3">
            <div class="pic">
            <b-avatar variant="info" src="https://placekitten.com/300/300" size="47.5px"></b-avatar> </div>
          </b-col>
         
          <b-col cols="9">
          <b-row>
          <b-col>
              <b-card-text style="margin-left:3px; font-weight: bold; font-size: large;">Sofie_Marso_joayo</b-card-text>
            </b-col>
          </b-row>
            <b-row>
              <b-col cols="6">
                <b-button variant="link" style="padding: 0px 0px; color: #B99B9A; text-decoration: none; text-align: left;" v-b-modal.modal-1>목표 등록</b-button>
              </b-col>
              <b-col cols="6">
                <b-button variant="link" style="padding: 0px 0px; color: #B99B9A; text-decoration: none; text-align: right;">LOGOUT</b-button>
              </b-col>
            </b-row>
            </b-col>
          </b-row>
        <hr>


        <b-row>
          <b-col cols="8">
            <b-card-text class="test_name">정보처리기사</b-card-text>
          </b-col>
          <b-col cols="4">
            <b-card-text class="howmuchleft" style="color:#BC6464; font-weight: bold;">D-3</b-card-text>
          </b-col>
        </b-row>
        <b-row>
          <b-col cols="8">
            <b-card-text class="test_name">OPIC</b-card-text>
          </b-col>
          <b-col cols="4">
            <b-card-text class="howmuchleft" style="color:#BC6464; font-weight: bold;">D-6</b-card-text>
          </b-col>
        </b-row>
      </b-container>
    </b-card>

     <b-modal id="modal-1" centered title="목표 등록" style="text-align: center;">
      <b-card style="height: 15; max-width: 40rem; background-color: #F8F3F3;">
        <b-container ref="form">
          <h2 style="text-align: center;">목표 등록</h2>
          <b-row style="margin-bottom: 10px;">
            <b-col>
              <b-form-select style="border: none;"></b-form-select>
            </b-col>
            <b-col>
              <b-form-input placeholder="시험 이름" required style="border: none;"></b-form-input>
            </b-col>
          </b-row>
          <b-row style="margin-bottom: 10px;">
            <b-col>
              <b-form-input type="date" placeholder="날짜 선택" style="border: none;"></b-form-input>
            </b-col>
          </b-row>
          <b-button text @click="submit" style="color: #453535; background-color: #E1D3D2; border: none">등록</b-button>
          <template #modal-footer="{ cancel, ok }">
            <b-button size="sm" variant="danger" @click="cancel()">
              취소
            </b-button>
            <b-button size="sm" style="color: #453535; background-color: #E1D3D2; border: none" @click="ok()">
              등록
            </b-button>
          </template>
          </b-container>
      </b-card>
    </b-modal>

</template>

<script>
export default {

}
</script>

<style>
.test_name{
  text-align: right;
}
.howmuchleft {
  text-align: left;
}
.pic{
  margin-top: 5px;
}
</style>