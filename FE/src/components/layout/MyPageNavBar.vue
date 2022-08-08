<template>
    <b-card style="max-width: 20rem; background-color: #F8F3F3;" class="p-0">
      <b-container>
        <b-row>
          <b-col cols="3">
            <div class="pic">
            <b-avatar variant="info" src="https://placekitten.com/300/300" size="44px"></b-avatar> </div>
          </b-col>
         
          <b-col cols="9">
          <b-row>
          <b-col>
              <b-card-text style="margin-left:3px; font-weight: bold; font-size: large;">{{userInfo.name}}</b-card-text>
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

        <my-page-items
        v-for="plan in plans"
        :key="plan"
        v-bind="plan">
        </my-page-items>
      </b-container>
    </b-card>

     <b-modal hide-footer id="modal-1" centered title="목표 등록" style="text-align: center;">
      <b-card style="height: 15; max-width: 40rem; background-color: #F8F3F3;">
        <b-container ref="form">
          <!-- <h2 style="text-align: center;">목표 등록</h2> -->
          <b-row style="margin-bottom: 10px;">
            <b-col>
              <b-form-input placeholder="시험 이름을 입력하세요." required style="border: none;"></b-form-input>
            </b-col>
          </b-row>
          <b-row style="margin-bottom: 10px;">
            <b-col>
              <b-form-input type="date" placeholder="날짜 선택" style="border: none;"></b-form-input>
            </b-col>
          </b-row>
          <br>
          <b-button text @click="submit" style="color: #453535; background-color: #E1D3D2; border: none">등록</b-button>
          <!-- <template #modal-footer="{ cancel, ok }">
            <b-button size="sm" variant="danger" @click="cancel()">
              취소
            </b-button>
            <b-button size="sm" style="color: #453535; background-color: #E1D3D2; border: none" @click="ok()">
              등록
            </b-button>
          </template> -->
          </b-container>
      </b-card>
    </b-modal>

</template>

<script>
import { computed } from "vue";
import { useStore } from "vuex";
import MyPageItems from './items/MyPageItems.vue';

const store = useStore();
const userInfo = computed(() => store.state.memberStore);

console.dir(userInfo);
export default {
  components: { MyPageItems },
  setup() {
    const store = useStore();
    const userInfo = computed(() => store.state.memberStore.userInfo);

    return { userInfo };
  },
  data(){
    return{
      plans:[
        {
          subject: "정보처리기사",
          mod:10,
        },
        {
          subject:"OPIC",
          mod: 3,
        }
      ],
    }
  }
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
  margin-top: 6px;
}
</style>