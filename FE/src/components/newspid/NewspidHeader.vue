<template>
  <b-container>
    <br>
    <b-row style="margin-bottom:27px">
      <b-col cols="3" style="padding: 0px; text-align: center;">
        <b-avatar variant="info" src="https://placekitten.com/300/200" size="145px"></b-avatar>
      </b-col>
      <b-col>
        <b-row style="margin-bottom:10px;">
          <b-col style="text-align: left; padding: 0px;">
            <span style="font-weight: 100; font-size: 25px; margin-right: 12px;">Giri_boy</span>
            <b-button size="sm" variant="link"
              style="color: black; text-decoration: none; font-weight: 100; border: 1px solid; vertical-align:super;">
              메시지 보내기</b-button>
            <b-button size="sm" variant="link"
              style="color: white; background-color: #83A39A; text-decoration: none; font-weight: 100; border: 1px solid; margin-left: 12px; vertical-align:super;">
              팔로우</b-button>

          </b-col>
        </b-row>
        <b-row style="margin-bottom:10px;">
          <b-col style="text-align: left; padding: 0;">
            <span>게시글 </span><span
              style="font-weight:bold;">44&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span>팔로워
            </span><span style="font-weight:bold;">22&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span>팔로우 </span><span
              style="font-weight:bold;">13</span>
          </b-col>
        </b-row>
        <b-row style="font-weight: bold;">
          <b-col style="text-align: left; padding: 0;">
            <div>홍시영</div>
          </b-col>
        </b-row>
        <b-row>
          <b-col style="text-align: left; padding: 0;">
            <div>비트 찍고 랩하지만 코딩도 잘 하는 기리보이입니다.</div>
          </b-col>
        </b-row>
      </b-col>
    </b-row>
  </b-container>
  <hr>

  <b-container>
    <br>
    <!-- <b-row align-v="center"> -->
    <b-row style="margin-bottom:27px">
      <b-col cols="3" style="padding: 0px; text-align: center;">
        <b-avatar variant="info" src="https://placekitten.com/300/300" size="145px"></b-avatar>
      </b-col>
      <b-col>
        <b-row style="margin-bottom:10px;">
          <b-col style="text-align: left; padding: 0px;">
            <span style="font-weight: 100; font-size: 25px; margin-right: 12px;">hwangheechani</span>
            <router-link :to="{name:'newspidsettings'}"><svg width="24" height="24" fill="none"
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
            <span>게시글 </span><span style="font-weight:bold;">4&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span>팔로워
            </span><span style="font-weight:bold;">222&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span>팔로우 </span><span
              style="font-weight:bold;">123</span>
          </b-col>
        </b-row>
        <b-row style="font-weight: bold;">
          <b-col style="text-align: left; padding: 0;">
            <div>황희찬</div>
          </b-col>
        </b-row>
        <b-row>
          <b-col cols="8" style="text-align: left; padding: 0;">
            <div>축구 하는 코딩 보이 황희찬입니다.</div>
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

  <b-modal hide-footer id="modal-3" centered title="새 게시물 만들기" style="text-align: center">
    <b-card style="height: 28rem; max-width: 30rem; background-color: #f8f3f3">
      <b-container ref="form">
        <!-- <h2 style="text-align: center;">목표 등록</h2> -->
        <b-row style="margin-bottom: 10px">
          <b-col cols="2">
            <b-avatar variant="info" src="https://placekitten.com/300/300" size="40px"></b-avatar>
          </b-col>
          <b-col cols="10" style="text-align: left; margin-top: 5px; font-weight: bold; padding-left: 0;">
            Brown_cat
          </b-col>
        </b-row>
        <b-row style="margin-bottom: 10px">
          <b-col>
            <b-form-textarea id="content" placeholder="문구 입력..." rows="10" max-rows="15" required style="border: none">
            </b-form-textarea>
          </b-col>
        </b-row>
        <!--반응형 구현 필요-->
        <b-row>
          <b-col cols="11">
            <b-form-input placeholder="위치 추가" required style="border: none;"></b-form-input>
          </b-col>
          <b-col cols="1" style="margin-top:2px;">
            <svg width="20" height="20" fill="none" xmlns="http://www.w3.org/2000/svg">
              <path d="M10 10.833a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5Z" stroke="#444" stroke-width="2"
                stroke-linecap="round" stroke-linejoin="round" />
              <path
                d="M10 18.333c3.333-3.333 6.667-6.318 6.667-10a6.667 6.667 0 0 0-13.334 0c0 3.682 3.334 6.667 6.667 10Z"
                stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
            </svg>
          </b-col>
        </b-row>
        <br />
        <b-button text @click="submit" style="color: #453535; background-color: #e1d3d2; border: none">게시</b-button>
      </b-container>
    </b-card>
  </b-modal>
</template>

<script>
export default {

}
</script>

<style>

</style>