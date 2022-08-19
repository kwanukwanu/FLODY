<template>
  <b-card style="max-width: 20rem; background-color: #F8F3F3;" class="p-0">
    <b-container>
      <b-row>
        <b-col cols="3">
          <div class="pic">
            <b-avatar variant="info" :src="userInfo.profile" size="44px"></b-avatar>
          </div>
        </b-col>

        <b-col cols="9">
          <b-row>
            <b-col>
              <b-card-text style="margin-left:3px; font-weight: bold; font-size: large;"
                @click="getClickNickname(userInfo.nickname, userInfo.profile)">{{ userInfo.nickname }}</b-card-text>
            </b-col>
          </b-row>
          <b-row>
            <b-col cols="6">
              <b-button variant="link"
                style="padding: 0px 0px; color: #B99B9A; text-decoration: none; text-align: left;" v-b-modal.modal-1>목표
                등록</b-button>
            </b-col>
            <b-col cols="6">
              <b-button variant="link"
                style="padding: 0px 0px; color: #B99B9A; text-decoration: none; text-align: right;" @click="logout()">
                LOGOUT</b-button>
            </b-col>
          </b-row>
        </b-col>
      </b-row>
      <hr>

      <my-page-items v-for="plan in plans" :key="plan" v-bind="plan">
      </my-page-items>
    </b-container>
  </b-card>

  <b-modal hide-footer id="modal-1" centered title="목표 등록" style="text-align: center;">
    <b-card style="height: 15; max-width: 40rem; background-color: #F8F3F3;">
      <b-container ref="form">
        <!-- <h2 style="text-align: center;">목표 등록</h2> -->
        <b-row style="margin-bottom: 10px;">
          <b-col>
            <b-form-input v-model="name" placeholder="시험 이름을 입력하세요." required style="border: none;"></b-form-input>
          </b-col>
        </b-row>
        <b-row style="margin-bottom: 10px;">
          <b-col>
            <b-form-input v-model="dueDate" type="date" placeholder="날짜 선택" style="border: none;"></b-form-input>
          </b-col>
        </b-row>
        <br>
        <b-button text @click="addPlans()" style="color: #453535; background-color: #E1D3D2; border: none" data-bs-dismiss="modal" aria-label="Close">등록</b-button>
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
import { add_goal } from "@/api/goal.js";

import MyPageItems from './items/MyPageItems.vue';

const store = useStore();
const userInfo = computed(() => store.state.memberStore);

console.dir(userInfo);
export default {
  components: { MyPageItems },
  setup() {
    const store = useStore();
    const profile = computed(() => store.state.newspidStore.profile);
    const userInfo = computed(() => store.state.memberStore.userInfo);
    const clickNickname = computed(() => store.state.newspidStore.clickNickname);
    const plans = computed(() => store.state.memberStore.goals);
    return { plans, store, userInfo, profile, clickNickname };
  },
  data() {
    return {
      count: 0,
      dueDate: null,
      name: "",
    }
  },
  // 개수, 즉 count 가 변화하면 getPlans를 다시 호출한다.
  watch: {
    count: `getPlans`,
  },
  methods: {
    logout() {
      console.log("logout");
      this.store.dispatch("memberStore/setLogout");
      if (this.$route.path != "/")
        this.$router.push({ name: "home" });
    },
    getClickNickname(clickNickname, profile) {
      console.log(clickNickname);
      const data = {
        nickName: clickNickname,  // 닉네임 적용
        profile: profile,         // 사진 변경
        board_num: 44,
        follower: 22,
        follow: 13,
        name: "홍시영",
        contents: "비트 찍고 랩하지만 코딩도 잘 하는 기리보이입니다.",
      }
      this.store.dispatch("newspidStore/setprofile", data);
    },
    async addPlans() {
      console.log(this.name);
      console.log(this.dueDate);
      const data = {
        name: this.name,
        dueDate: this.dueDate,
      };
      this.name = "";
      this.dueDate = null;
      await add_goal(
        data,
        ({ data }) => {
          // let msg = "등록에 문제가 발생하였습니다!";
          if (data.msg === "SUCCESS") {
            // msg = "등록 완료";
          }
          // alert(msg);
          this.count++;
        },
        (error) => {
          console.log(error);
        });
    },
    async getPlans() {
      // 여기서 axios를 통해 목표를 받아온다.
      await this.store.dispatch("memberStore/setgoals");
    },
  },
  mounted() {
    this.getPlans();
    this.count = this.plans.length;
  }
}
</script>

<style>
.test_name {
  text-align: right;
}

.howmuchleft {
  text-align: left;
}

.pic {
  margin-top: 6px;
}

.btn-link {
    --bs-btn-focus-shadow-rgb: white;
}
</style>