<template>
  <div v-if="clickNickname == ' '"></div>
  <b-container v-else-if="clickNickname != userInfo.nickname">
    <br>
    <b-row style="margin-bottom:27px">
      <b-col cols="3" style="padding: 0px; text-align: center;">
        <b-avatar variant="info" src="https://placekitten.com/300/200" size="145px"></b-avatar>
      </b-col>
      <b-col>
        <b-row style="margin-bottom:10px;">
          <b-col style="text-align: left; padding: 0px;">
            <span style="font-weight: 100; font-size: 25px; margin-right: 12px;"
              @click="getClickNickname(profile.nickName)">{{ profile.nickName }}</span>
            <b-button size="sm" variant="link"
              style="color: black; text-decoration: none; font-weight: 100; border: 1px solid; vertical-align:super;"
              v-b-modal.chatting2 @click="getTargetId(profile.nickName)">
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
            <span>게시글 </span><span style="font-weight:bold;">{{ profile.board_num }}
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
            <a style="cursor:pointer" v-b-modal.modal-10><span>팔로워
              </span><span style="font-weight:bold;">{{ profile.follower
                }}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></a>
            <a style="cursor:pointer" v-b-modal.modal-11><span>팔로우 </span><span style="font-weight:bold;">{{
                profile.follow
                }}</span></a>
          </b-col>
        </b-row>
        <b-row style="font-weight: bold;">
          <b-col style="text-align: left; padding: 0;">
            <div>{{ profile.name }}</div>
          </b-col>
        </b-row>
        <b-row>
          <b-col style="text-align: left; padding: 0;">
            <div>{{ profile.contents }}</div>
          </b-col>
        </b-row>
      </b-col>
    </b-row>
  </b-container>
  <!-- <hr> -->

  <b-container v-else-if="clickNickname == userInfo.nickname">
    <br>
    <!-- <b-row align-v="center"> -->
    <b-row style="margin-bottom:27px">
      <b-col cols="3" style="padding: 0px; text-align: center;">
        <b-avatar variant="info" src="https://placekitten.com/300/300" size="145px"></b-avatar>
      </b-col>
      <b-col>
        <b-row style="margin-bottom:10px;">
          <b-col style="text-align: left; padding: 0px;">
            <span style="font-weight: 100; font-size: 25px; margin-right: 12px;">{{ profile.nickName }}</span>
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
            <span>게시글 </span><a style="cursor:pointer" v-b-modal.modal-10><span style="font-weight:bold;">{{
                profile.board_num
                }}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span>팔로워
              </span><span style="font-weight:bold;">{{ profile.follower
                }}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></a><a style="cursor:pointer" v-b-modal.modal-11><span
                style="font-weight:bold;"></span><span>팔로우
              </span><span style="font-weight:bold;">{{ profile.follow }}</span></a>
          </b-col>
        </b-row>
        <b-row style="font-weight: bold;">
          <b-col style="text-align: left; padding: 0;">
            <div>{{ profile.name }}</div>
          </b-col>
        </b-row>
        <b-row>
          <b-col cols="8" style="text-align: left; padding: 0;">
            <div>{{ profile.contents }}</div>
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

  <b-modal hide-footer id="modal-10" centered title="팔로워" style="text-align: center;">
    <b-container fluid="sm">
      <b-list-group style="overflow-y: scroll; height:240px">
        <b-list-group-item>
          <div class="person">
            <b-row>
              <b-col cols="2">
                <b-avatar variant="info" src="https://placekitten.com/300/202" size="44px"></b-avatar>
              </b-col>
              <b-col cols="7">
                <b-row class="nickname">super_girl <b-button
                    style="color: #0095F6; background-color: white; border-color:white; width: 70px; text-decoration: none; padding: 0px 0px 0px 0px; font-family : -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Helvetica, Arial, sans-serif; font-weight: 600; font-size: 12px;">
                    • 팔로우</b-button>
                </b-row>
                <b-row class="realname">김미료</b-row>
              </b-col>
              <!-- 팔로우 누르면 버튼 사라지고, 팔로우됨 -->
              <b-col cols="3" style="text-align:right">
                <b-button size="sm" style="color:black; background-color:white; font-size: 14px; padding:5px 9px;" data-bs-dismiss="modal" aria-label="Close" v-b-modal.modal-13 >삭제
                </b-button>
              </b-col>
            </b-row>
          </div>
        </b-list-group-item>
        <b-list-group-item>
          <div class="person">
            <b-row>
              <b-col cols="2">
                <b-avatar variant="info" src="https://placekitten.com/300/203" size="44px"></b-avatar>
              </b-col>
              <b-col cols="7">
                <b-row class="nickname">bat_man <b-button
                    style="color: #0095F6; background-color: white; border-color:white; width: 70px; text-decoration: none; padding: 0px 0px 0px 0px; font-family : -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Helvetica, Arial, sans-serif; font-weight: 600; font-size: 12px;">
                    • 팔로우</b-button>
                </b-row>
                <b-row class="realname">최재현</b-row>
              </b-col>
              <b-col cols="3" style="text-align:right">
                <b-button size="sm" style="color:black; background-color:white; font-size: 14px; padding:5px 9px;" data-bs-dismiss="modal" aria-label="Close" v-b-modal.modal-13>삭제
                </b-button>
              </b-col>
            </b-row>
          </div>
        </b-list-group-item>
        <b-list-group-item>
          <div class="person">
            <b-row>
              <b-col cols="2">
                <b-avatar variant="info" src="https://placekitten.com/300/204" size="44px"></b-avatar>
              </b-col>
              <b-col cols="7">
                <b-row class="nickname">pussycat <b-button
                    style="color: #0095F6; background-color: white; border-color:white; width: 70px; text-decoration: none; padding: 0px 0px 0px 0px; font-family : -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Helvetica, Arial, sans-serif; font-weight: 600; font-size: 12px;">
                    • 팔로우</b-button>
                </b-row>
                <b-row class="realname">신영제</b-row>
              </b-col>
              <b-col cols="3" style="text-align:right">
                <b-button size="sm" style="color:black; background-color:white; font-size: 14px; padding:5px 9px;" data-bs-dismiss="modal" aria-label="Close" v-b-modal.modal-13>삭제
                </b-button>
              </b-col>
            </b-row>
          </div>
        </b-list-group-item>
        <b-list-group-item>
          <div class="person">
            <b-row>
              <b-col cols="2">
                <b-avatar variant="info" src="https://placekitten.com/300/205" size="44px"></b-avatar>
              </b-col>
              <b-col cols="7">
                <b-row class="nickname">keeper_yang <b-button
                    style="color: #0095F6; background-color: white; border-color:white; width: 70px; text-decoration: none; padding: 0px 0px 0px 0px; font-family : -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Helvetica, Arial, sans-serif; font-weight: 600; font-size: 12px;">
                    • 팔로우</b-button>
                </b-row>
                <b-row class="realname">양한빈</b-row>
              </b-col>
              <b-col cols="3" style="text-align:right">
                <b-button size="sm" style="color:black; background-color:white; font-size: 14px; padding:5px 9px;" data-bs-dismiss="modal" aria-label="Close" v-b-modal.modal-13>삭제
                </b-button>
              </b-col>
            </b-row>
          </div>
        </b-list-group-item>
        <b-list-group-item>
          <div class="person">
            <b-row>
              <b-col cols="2">
                <b-avatar variant="info" src="https://placekitten.com/300/206" size="44px"></b-avatar>
              </b-col>
              <b-col cols="7">
                <b-row class="nickname">puppy_jisung <b-button
                    style="color: #0095F6; background-color: white; border-color:white; width: 70px; text-decoration: none; padding: 0px 0px 0px 0px; font-family : -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Helvetica, Arial, sans-serif; font-weight: 600; font-size: 12px;">
                    • 팔로우</b-button>
                </b-row>
                <b-row class="realname">박지성</b-row>
              </b-col>
              <b-col cols="3" style="text-align:right">
                <b-button size="sm" style="color:black; background-color:white; font-size: 14px; padding:5px 9px;" data-bs-dismiss="modal" aria-label="Close" v-b-modal.modal-13>삭제
                </b-button>
              </b-col>
            </b-row>
          </div>
        </b-list-group-item>
        <b-list-group-item>
          <div class="person">
            <b-row>
              <b-col cols="2">
                <b-avatar variant="info" src="https://placekitten.com/300/207" size="44px"></b-avatar>
              </b-col>
              <b-col cols="7">
                <b-row class="nickname">nalgangdo <b-button
                    style="color: #0095F6; background-color: white; border-color:white; width: 70px; text-decoration: none; padding: 0px 0px 0px 0px; font-family : -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Helvetica, Arial, sans-serif; font-weight: 600; font-size: 12px;">
                    • 팔로우</b-button>
                </b-row>
                <b-row class="realname">날강두</b-row>
              </b-col>
              <b-col cols="3" style="text-align:right">
                <b-button size="sm" style="color:black; background-color:white; font-size: 14px; padding:5px 9px;" data-bs-dismiss="modal" aria-label="Close" v-b-modal.modal-13>삭제
                </b-button>
              </b-col>
            </b-row>
          </div>
        </b-list-group-item>
        <b-list-group-item>
          <div class="person">
            <b-row>
              <b-col cols="2">
                <b-avatar variant="info" src="https://placekitten.com/300/208" size="44px"></b-avatar>
              </b-col>
              <b-col cols="7">
                <b-row class="nickname">kevin_d <b-button
                    style="color: #0095F6; background-color: white; border-color:white; width: 70px; text-decoration: none; padding: 0px 0px 0px 0px; font-family : -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Helvetica, Arial, sans-serif; font-weight: 600; font-size: 12px;">
                    • 팔로우</b-button>
                </b-row>
                <b-row class="realname">김덕배</b-row>
              </b-col>
              <b-col cols="3" style="text-align:right">
                <b-button size="sm" style="color:black; background-color:white; font-size: 14px; padding:5px 9px;" data-bs-dismiss="modal" aria-label="Close" v-b-modal.modal-13>삭제
                </b-button>
              </b-col>
            </b-row>
          </div>
        </b-list-group-item>
        <b-list-group-item>
          <div class="person">
            <b-row>
              <b-col cols="2">
                <b-avatar variant="info" src="https://placekitten.com/300/300" size="44px"></b-avatar>
              </b-col>
              <b-col cols="7">
                <b-row class="nickname">kimmich <b-button
                    style="color: #0095F6; background-color: white; border-color:white; width: 70px; text-decoration: none; padding: 0px 0px 0px 0px; font-family : -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Helvetica, Arial, sans-serif; font-weight: 600; font-size: 12px;">
                    • 팔로우</b-button>
                </b-row>
                <b-row class="realname">김미희</b-row>
              </b-col>
              <b-col cols="3" style="text-align:right">
                <b-button size="sm" style="color:black; background-color:white; font-size: 14px; padding:5px 9px;" data-bs-dismiss="modal" aria-label="Close" v-b-modal.modal-13>삭제
                </b-button>
              </b-col>
            </b-row>
          </div>
        </b-list-group-item>
      </b-list-group>
    </b-container>
  </b-modal>

  <b-modal hide-footer id="modal-11" centered title="팔로우" style="text-align: center;">
    <b-container fluid="sm">
      <b-list-group style="overflow-y: scroll; height:240px">
        <b-list-group-item>
          <div class="person">
            <b-row>
              <b-col cols="2">
                <b-avatar variant="info" src="https://placekitten.com/300/202" size="44px"></b-avatar>
              </b-col>
              <b-col cols="7">
                <b-row class="nickname">super_girl</b-row>
                <b-row class="realname">김미료</b-row>
              </b-col>
              <!-- 팔로잉 누르면 모달 생성 -->
              <b-col cols="3" style="text-align:right">
                <b-button size="sm" style="color:black; background-color:white; font-size: 14px; padding:5px 9px;"
                  data-bs-dismiss="modal" aria-label="Close" v-b-modal.modal-12>팔로잉</b-button>
              </b-col>
            </b-row>
          </div>
        </b-list-group-item>
        <b-list-group-item>
          <div class="person">
            <b-row>
              <b-col cols="2">
                <b-avatar variant="info" src="https://placekitten.com/300/203" size="44px"></b-avatar>
              </b-col>
              <b-col cols="7">
                <b-row class="nickname">bat_man </b-row>
                <b-row class="realname">최재현</b-row>
              </b-col>
              <b-col cols="3" style="text-align:right">
                <b-button size="sm" style="color:black; background-color:white; font-size: 14px; padding:5px 9px;"
                data-bs-dismiss="modal" aria-label="Close" v-b-modal.modal-12>팔로잉
                </b-button>
              </b-col>
            </b-row>
          </div>
        </b-list-group-item>
        <b-list-group-item>
          <div class="person">
            <b-row>
              <b-col cols="2">
                <b-avatar variant="info" src="https://placekitten.com/300/204" size="44px"></b-avatar>
              </b-col>
              <b-col cols="7">
                <b-row class="nickname">pussycat </b-row>
                <b-row class="realname">신영제</b-row>
              </b-col>
              <b-col cols="3" style="text-align:right">
                <b-button size="sm" style="color:black; background-color:white; font-size: 14px; padding:5px 9px;"
                data-bs-dismiss="modal" aria-label="Close" v-b-modal.modal-12>팔로잉
                </b-button>
              </b-col>
            </b-row>
          </div>
        </b-list-group-item>
        <b-list-group-item>
          <div class="person">
            <b-row>
              <b-col cols="2">
                <b-avatar variant="info" src="https://placekitten.com/300/205" size="44px"></b-avatar>
              </b-col>
              <b-col cols="7">
                <b-row class="nickname">keeper_yang </b-row>
                <b-row class="realname">양한빈</b-row>
              </b-col>
              <b-col cols="3" style="text-align:right">
                <b-button size="sm" style="color:black; background-color:white; font-size: 14px; padding:5px 9px;"
                data-bs-dismiss="modal" aria-label="Close" v-b-modal.modal-12>팔로잉
                </b-button>
              </b-col>
            </b-row>
          </div>
        </b-list-group-item>
        <b-list-group-item>
          <div class="person">
            <b-row>
              <b-col cols="2">
                <b-avatar variant="info" src="https://placekitten.com/300/206" size="44px"></b-avatar>
              </b-col>
              <b-col cols="7">
                <b-row class="nickname">puppy_jisung </b-row>
                <b-row class="realname">박지성</b-row>
              </b-col>
              <b-col cols="3" style="text-align:right">
                <b-button size="sm" style="color:black; background-color:white; font-size: 14px; padding:5px 9px;"
                data-bs-dismiss="modal" aria-label="Close" v-b-modal.modal-12>팔로잉
                </b-button>
              </b-col>
            </b-row>
          </div>
        </b-list-group-item>
        <b-list-group-item>
          <div class="person">
            <b-row>
              <b-col cols="2">
                <b-avatar variant="info" src="https://placekitten.com/300/207" size="44px"></b-avatar>
              </b-col>
              <b-col cols="7">
                <b-row class="nickname">nalgangdo </b-row>
                <b-row class="realname">날강두</b-row>
              </b-col>
              <b-col cols="3" style="text-align:right">
                <b-button size="sm" style="color:black; background-color:white; font-size: 14px; padding:5px 9px;"
                data-bs-dismiss="modal" aria-label="Close" v-b-modal.modal-12>팔로잉
                </b-button>
              </b-col>
            </b-row>
          </div>
        </b-list-group-item>
        <b-list-group-item>
          <div class="person">
            <b-row>
              <b-col cols="2">
                <b-avatar variant="info" src="https://placekitten.com/300/208" size="44px"></b-avatar>
              </b-col>
              <b-col cols="7">
                <b-row class="nickname">kevin_d </b-row>
                <b-row class="realname">김덕배</b-row>
              </b-col>
              <b-col cols="3" style="text-align:right">
                <b-button size="sm" style="color:black; background-color:white; font-size: 14px; padding:5px 9px;"
                data-bs-dismiss="modal" aria-label="Close" v-b-modal.modal-12>팔로잉
                </b-button>
              </b-col>
            </b-row>
          </div>
        </b-list-group-item>
        <b-list-group-item>
          <div class="person">
            <b-row>
              <b-col cols="2">
                <b-avatar variant="info" src="https://placekitten.com/300/300" size="44px"></b-avatar>
              </b-col>
              <b-col cols="7">
                <b-row class="nickname">kimmich </b-row>
                <b-row class="realname">김미희</b-row>
              </b-col>
              <b-col cols="3" style="text-align:right">
                <b-button size="sm" style="color:black; background-color:white; font-size: 14px; padding:5px 9px;"
                data-bs-dismiss="modal" aria-label="Close" v-b-modal.modal-12>팔로잉
                </b-button>
              </b-col>
            </b-row>
          </div>
        </b-list-group-item>
      </b-list-group>
    </b-container>
  </b-modal>

  <b-modal hide-footer hide-title hide-header no-stacking centered id="modal-12" size="md" style="text-align: center;">
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
          leave @super_girl?
        </b-col>
      </b-row>
      <hr />
      <b-row style="cursor: pointer; color: red; font-weight: bold;">
        <div style="text-align:center;">팔로우 취소</div>
      </b-row>
      <hr />
      <b-row @click="Cancel" style="text-align:center; cursor: pointer;" data-bs-dismiss="modal" aria-label="Close">
        <div style="text-align:center;">취소</div>
      </b-row>
    </b-container>
  </b-modal>

  <b-modal hide-footer hide-title hide-header no-stacking centered id="modal-13" style="text-align: center;">
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
        <b-col style="margin-bottom:12px; font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Helvetica, Arial, sans-serif;">
          <div style="font-size: 22px; margin-bottom: 8px;">팔로워를 삭제하시겠어요?</div>
          <span style="font-size: 14px; color: #8E8E8E;">super_girl님은 회원님의 팔로워 리스트에서 삭제된<br>사실을 알 수 없습니다</span>
        </b-col>
      </b-row>
      <hr />
      <b-row style="cursor: pointer; color: red; font-weight: bold;">
        <div style="text-align:center;">팔로우 취소</div>
      </b-row>
      <hr />
      <b-row @click="Cancel" style="text-align:center; cursor: pointer;" data-bs-dismiss="modal" aria-label="Close">
        <div style="text-align:center;">취소</div>
      </b-row>
    </b-container>
  </b-modal>
</template>

<script>
import {computed} from "vue";
import {useStore} from "vuex";

import NewspidHeaderModals from "./modal/NewspidHeaderModals.vue";

export default {
  components:{
    NewspidHeaderModals,
  },
  setup() {
    const store = useStore();
    const profile = computed(() => store.state.newspidStore.profile);
    const userInfo = computed(() => store.state.memberStore.userInfo);
    const clickNickname = computed(() => store.state.newspidStore.clickNickname);
    return { store, profile,userInfo, clickNickname };
  },
  methods:{
    getTargetId(targetId){
      console.log(targetId);
      this.store.dispatch("chatStore/set_targetId",targetId);
    },
    getClickNickname(clickNickname) {
      console.log(clickNickname);
      this.store.dispatch("newspidStore/setClickNickname", clickNickname);
    }
  },
  mounted() {
    console.log("누구의 프로필 : "+this.clickNickname);
  }
}
</script>

<style>
.person{
  text-align: left;
}
.nickname{
  font-family : -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Helvetica, Arial, sans-serif;
  font-size: 14px;
  font-weight: 500;
}
.realname{
    font-family : -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Helvetica, Arial, sans-serif;
  font-size: 14px;
  color:#8E8E8E;
}

</style>