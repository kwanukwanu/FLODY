<template>
  <!-- <div v-if="clickNickname == ' '"></div> -->
  <b-container v-if="profile.email != userInfo.email">
    <br>
    <b-row style="margin-bottom:27px">
      <b-col cols="3" style="padding: 0px; text-align: center;">
        <b-avatar variant="info" :src="profile.profile" size="145px"></b-avatar>
      </b-col>
      <b-col>
        <b-row style="margin-bottom:10px;">
          <b-col style="text-align: left; padding: 0px;">
            <span style="font-weight: 100; font-size: 25px; margin-right: 12px;"
              @click="getClickNickname(profile.nickname)">{{ profile.nickname }}</span>
            <b-button size="sm" variant="link"
              style="color: black; text-decoration: none; font-weight: 100; border: 1px solid; vertical-align:super;"
              v-b-modal.chatting2 @click="getTargetId(profile.email)">
              메시지 보내기</b-button>
            <b-button size="sm" variant="link"
              style="color: black; background-color: white; text-decoration: none; font-weight: 100; border: 1px solid; margin-left: 12px; vertical-align:super;"
              v-b-modal.modal-5>
              &nbsp;&nbsp;&nbsp;&nbsp;
              <svg width="16" height="16" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path
                  d="M8 10.333H5c-.93 0-1.396 0-1.774.115a2.666 2.666 0 0 0-1.778 1.778c-.115.378-.115.844-.115 1.774m9.334-2L12 13.333l2.667-2.666M9.667 5a3 3 0 1 1-6 0 3 3 0 0 1 6 0Z"
                  stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
              </svg>&nbsp;&nbsp;&nbsp;&nbsp;
            </b-button>
            <!--팔로우 하지 않은 상태라면 아래 코드-->
            <!-- <b-button size="sm" variant="link"
              style="color: white; background-color: #83A39A; text-decoration: none; font-weight: 100; border: 1px solid; margin-left: 12px; vertical-align:super;">
              팔로우</b-button> -->

          </b-col>
        </b-row>
        <b-row style="margin-bottom:10px;">
          <b-col style="text-align: left; padding: 0;">
            <span>게시글 </span><span style="font-weight:bold;">
            <!-- {{ profile.posts }} -->
            5
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
            <a style="cursor:pointer" v-b-modal.modal-10><span>팔로워
              </span><span style="font-weight:bold;">&nbsp;
              <!-- {{ profile.followers }} -->
              101
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></a>
            <a style="cursor:pointer" v-b-modal.modal-11><span>팔로우 </span><span style="font-weight:bold;">&nbsp;
            <!-- {{profile.followings}} -->
            98
            </span></a>
          </b-col>
        </b-row>
        <b-row style="font-weight: bold;">
          <b-col style="text-align: left; padding: 0;">
            <div>{{ profile.name }}</div>
          </b-col>
        </b-row>
        <b-row>
          <b-col style="text-align: left; padding: 0;">
            <div>{{ profile.introduction }}</div>
          </b-col>
        </b-row>
      </b-col>
    </b-row>
  </b-container>
  <!-- <hr> -->

  <b-container v-else-if="profile.email == userInfo.email">
    <br>
    <!-- <b-row align-v="center"> -->
    <b-row style="margin-bottom:27px">
      <b-col cols="3" style="padding: 0px; text-align: center;">
        <b-avatar variant="info" :src="userInfo.profile" size="145px"></b-avatar>
      </b-col>
      <b-col>
        <b-row style="margin-bottom:10px;">
          <b-col style="text-align: left; padding: 0px;">
            <span style="font-weight: 100; font-size: 25px; margin-right: 12px;">{{ userInfo.nickname }}</span>
            <router-link :to="{ name: 'newspidsettings' }"><svg width="24" height="24" fill="none"
                xmlns="http://www.w3.org/2000/svg">
                <path d="M12 15a3 3 0 1 1 0-6 3 3 0 0 1 0 6Z" stroke="#444" stroke-width="2" stroke-linecap="round"
                  stroke-linejoin="round" />
                <path
                  d="M5.273 14.727a1.5 1.5 0 0 1-.3 1.655l-.055.054a1.817 1.817 0 0 0 0 2.573 1.819 1.819 0 0 0 2.573 0l.054-.055a1.5 1.5 0 0 1 1.655-.3 1.5 1.5 0 0 1 .91 1.373v.155a1.818 1.818 0 1 0 3.636 0V20.1a1.5 1.5 0 0 1 .981-1.373 1.5 1.5 0 0 1 1.655.3l.054.055a1.816 1.816 0 0 0 2.573 0 1.818 1.818 0 0 0 0-2.573l-.055-.055a1.5 1.5 0 0 1-.3-1.654 1.5 1.5 0 0 1 1.373-.91h.155a1.818 1.818 0 1 0 0-3.636H20.1a1.5 1.5 0 0 1-1.373-.981 1.5 1.5 0 0 1 .3-1.655l.055-.054a1.818 1.818 0 0 0-1.287-3.106 1.818 1.818 0 0 0-1.286.533l-.055.054a1.5 1.5 0 0 1-1.654.3h-.073a1.5 1.5 0 0 1-.909-1.372v-.155a1.818 1.818 0 0 0-3.636 0V3.9a1.5 1.5 0 0 1-.91 1.373 1.5 1.5 0 0 1-1.654-.3l-.054-.055A1.818 1.818 0 1 0 4.99 7.491l.054.054a1.5 1.5 0 0 1 .3 1.655v.073a1.5 1.5 0 0 1-1.372.909h-.155a1.818 1.818 0 0 0 0 3.636H3.9a1.499 1.499 0 0 1 1.373.91Z"
                  stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
              </svg></router-link>
          </b-col>
          <b-col cols="4">
            <div style="text-align:left;">
              <b-button size="sm" variant="link"
                style="color: black; border-color: #e1d3d2; background-color: #e1d3d2; text-decoration: none; font-weight: 100; margin-left: 12px; vertical-align:super;"
                v-b-modal.modal-3><svg width="19" height="20" fill="none" xmlns="http://www.w3.org/2000/svg">
                  <path
                    d="M8.333 3.333H5.152c-1.273 0-1.91 0-2.396.273-.428.24-.775.622-.993 1.092-.248.535-.248 1.235-.248 2.635v7c0 1.4 0 2.1.248 2.635.218.47.565.853.993 1.093.486.272 1.123.272 2.396.272h6.363c1.273 0 1.91 0 2.396-.272.427-.24.775-.622.993-1.093.248-.535.248-1.235.248-2.635v-3.5m-9.091 2.5h1.268c.37 0 .556 0 .73-.046.155-.04.303-.108.438-.2.153-.102.284-.246.546-.535l7.245-7.969c.628-.69.628-1.81 0-2.5a1.506 1.506 0 0 0-2.273 0l-7.244 7.97c-.262.287-.393.432-.487.6-.083.149-.144.311-.182.482-.041.191-.041.395-.041.803v1.395Z"
                    stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
                </svg>
                새 게시물 만들기</b-button>
            </div>
          </b-col>
        </b-row>
        <b-row style="margin-bottom:10px;">
          <b-col style="text-align: left; padding: 0;">
            <span>게시글 </span>
            <a style="cursor:pointer" v-b-modal.modal-10>
              <span style="font-weight:bold;">
                <!-- {{ profile.posts }} -->
                3
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              </span>
              <span>팔로워</span>
              <span style="font-weight:bold;">
                <!-- {{ profile.followers }} -->
                75
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              </span>
            </a>
            <a style="cursor:pointer" v-b-modal.modal-11>
              <span style="font-weight:bold;"></span>
              <span>팔로우</span>
              <span style="font-weight:bold;">
                <!-- {{ profile.followings }} -->
                88
              </span>
            </a>
          </b-col>
        </b-row>
        <b-row style="font-weight: bold;">
          <b-col style="text-align: left; padding: 0;">
            <div>{{ userInfo.name }}</div>
          </b-col>
        </b-row>
        <b-row>
          <b-col cols="8" style="text-align: left; padding: 0;">
            <div>{{ userInfo.introduction }}
            </div>
          </b-col>
          <!-- <b-col cols="4">
            <div style="text-align:right;">
              <b-button size="sm" variant="link"
                style="color: black; border-color: #e1d3d2; background-color: #e1d3d2; text-decoration: none; font-weight: 100; margin-left: 12px; vertical-align:super;"
                v-b-modal.modal-3><svg width="19" height="20" fill="none" xmlns="http://www.w3.org/2000/svg">
                  <path
                    d="M8.333 3.333H5.152c-1.273 0-1.91 0-2.396.273-.428.24-.775.622-.993 1.092-.248.535-.248 1.235-.248 2.635v7c0 1.4 0 2.1.248 2.635.218.47.565.853.993 1.093.486.272 1.123.272 2.396.272h6.363c1.273 0 1.91 0 2.396-.272.427-.24.775-.622.993-1.093.248-.535.248-1.235.248-2.635v-3.5m-9.091 2.5h1.268c.37 0 .556 0 .73-.046.155-.04.303-.108.438-.2.153-.102.284-.246.546-.535l7.245-7.969c.628-.69.628-1.81 0-2.5a1.506 1.506 0 0 0-2.273 0l-7.244 7.97c-.262.287-.393.432-.487.6-.083.149-.144.311-.182.482-.041.191-.041.395-.041.803v1.395Z"
                    stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
                </svg>
                새 게시물 만들기</b-button>
            </div>
          </b-col> -->
        </b-row>
      </b-col>
    </b-row>
  </b-container>
  <hr>
  <newspid-header-modals></newspid-header-modals>
</template>

<script>
import { computed } from "vue";
import { useStore } from "vuex";

import NewspidHeaderModals from "./modal/NewspidHeaderModals.vue";

export default {
  components: {
    NewspidHeaderModals,
  },
  setup() {
    const store = useStore();
    const profile = computed(() => store.state.newspidStore.profile);
    const userInfo = computed(() => store.state.memberStore.userInfo);
    const clickNickname = computed(() => store.state.newspidStore.clickNickname);
    return { store, profile, userInfo, clickNickname };
  },
  methods: {
    getTargetId(targetId) {
      console.log(targetId);
      this.store.dispatch("chatStore/set_targetId", targetId);
    },
    getClickNickname(clickNickname) {
      console.log(clickNickname);
      this.store.dispatch("newspidStore/setClickNickname", clickNickname);
    }
  },
  mounted() {
  }
}
</script>

<style>
.person {
  text-align: left;
}

.nickname {
  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Helvetica, Arial, sans-serif;
  font-size: 14px;
  font-weight: 500;
}

.realname {
  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Helvetica, Arial, sans-serif;
  font-size: 14px;
  color: #8E8E8E;
}
</style>