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
          <b-row rows="2">
            <b-col cols="2" style="padding: 4px;">
              <div class="avatar">
                <b-avatar variant="info" src="https://placekitten.com/300/300" size="35px"></b-avatar>
              </div>
            </b-col>
            <b-col cols="9">
              <b-row>
                <span style="width: 90px; display: inline; padding: 4px 0px; text-align: left; font-weight: bold; font-size: small;">
                  Brown_Cat</span>
                <b-button
                  style="color: black; background-color: white; border-color:white; width: 70px; text-decoration: none; padding: 0px 0px 0px 0px;"
                  v-b-modal.modal-5>
                  • 팔로잉</b-button>
                <!--팔로우 안 한 상태라면 아래 코드-->
                <!-- <b-button
                  style="color: blue; background-color: white; border-color:white; width: 70px; text-decoration: none; padding: 0px 0px 0px 0px;">
                  • 팔로우</b-button> -->
              </b-row>
              <b-row style="font-size:small;">런던</b-row>
            </b-col>
            <b-col cols="1" style="padding: 0px 0px; margin-top: 16px;">

              <b-button size="sm" variant="link" style="width: 40px; text-decoration: none;" v-b-modal.modal-4><svg
                  width="24" height="24" fill="none" xmlns="http://www.w3.org/2000/svg">
                  <path
                    d="M12 13a1 1 0 1 0 0-2 1 1 0 0 0 0 2ZM19 13a1 1 0 1 0 0-2 1 1 0 0 0 0 2ZM5 13a1 1 0 1 0 0-2 1 1 0 0 0 0 2Z"
                    stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
                </svg>
              </b-button>

            </b-col>
          </b-row>
          <hr style="margin: 5px;">
          <b-row rows="7">
            <b-col cols="2" style="padding: 4px;">
              <div class="avatar">
                <b-avatar variant="info" src="https://placekitten.com/300/300" size="50px"></b-avatar>
              </div>
            </b-col>
            <b-col>
              <b-row>
                <div style="text-align: left; padding: 0px; font-weight: bold;">Brown_Cat</div>
              </b-row>
              <b-row>
                <div style="text-align: left; padding: 0px;">공부를 놓지 않는다. 취한다.</div>
              </b-row>
              <b-row>
                <div style="text-align: left; padding: 0px; color: #255D4E">#영국 #런던 #스터디</div>
              </b-row>
              <b-row style="margin-bottom: 5px;">
                <div style="text-align: left; padding: 0px; color: gray; font-size: small;">15시간전</div>
              </b-row>
            </b-col>
          </b-row>
          <b-row rows="3">
            <b-col cols="2" style="padding: 4px;">
              <div class="avatar">
                <b-avatar variant="info" src="https://placekitten.com/300/900" size="50px"></b-avatar>
              </div>
            </b-col>
            <b-col>
              <b-row>
                <b-col style="text-align: left; padding: 0px;">
                  <div style="text-align: left; padding: 0px; font-weight: bold;">Oh_My_Boy</div>
                </b-col>
                <b-col cols="3" style="text-align: right; padding-left: 4px;">
                  <a style="text-align: right; padding: 0px; font-weight: bold; text-decoration: none;">🤍</a>
                  <!--좋아요 눌렀다면 아래 코드-->
                  <!-- <a style="text-align: right; padding: 0px; font-weight: bold; text-decoration: none;">❤️</a> -->
                </b-col>
              </b-row>
              <b-row>
                <div style="text-align: left; padding: 0px">ㅋㅋㅋㅋㅋㅋ 저도 영국</div>
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
                  <span class="bottom_like_comment">좋아요 18개&nbsp;&nbsp;&nbsp;</span>
                  <span class="bottom_like_comment">답글 달기</span>
                </b-col>
              </b-row>
            </b-col>
          </b-row>
          <b-row>
            <b-col cols="2" style="padding: 4px;">
              <div class="avatar">
                <b-avatar variant="info" src="https://placekitten.com/300/200" size="50px"></b-avatar>
              </div>
            </b-col>
            <b-col>
              <b-row>
                <b-col style="text-align: left; padding: 0px;">
                  <div style="text-align: left; padding: 0px; font-weight: bold;">girl_girls</div>
                </b-col>
                <b-col cols="3" style="text-align: right; padding-left: 4px;">
                  <a style="text-align: right; padding: 0px; font-weight: bold; text-decoration: none;">🤍</a>
                  <!--좋아요 눌렀다면 아래 코드-->
                  <!-- <a style="text-align: right; padding: 0px; font-weight: bold; text-decoration: none;">❤️</a> -->
                </b-col>
              </b-row>
              <b-row>
                <div style="text-align: left; padding: 0px">와 너무 부럽</div>
              </b-row>
              <!-- <b-row style="margin-bottom:5px;">
                <b-col cols="3" style="text-align: left; padding: 0px;">
                  <div style="text-align: left; padding: 0px; color: gray; font-size: small; display: inline;">12시간전
                  </div>
                </b-col>
                <b-col cols="3" style="text-align: left; padding: 0px;">
                  <div style="text-align: left; padding: 0px; color: gray; font-size: small; display: inline;">좋아요 13개
                  </div>
                </b-col>
                <b-col style="text-align: left; padding-right: 2px;">
                  <a
                    style="text-align: left; padding: 0px; color: gray; font-size: small; display: inline; text-decoration: none;">답글
                    달기</a>
                </b-col>
              </b-row>
              <b-row>
                <a
                  style="text-align: left; padding: 0px; color: gray; font-size: small; display: inline; text-decoration: none; margin-bottom: 5px;">_____
                  답글 보기(1개)</a>
              </b-row> -->

              <b-row>
                <b-col style="padding:0px;">
                  <span class="bottom_time_line">14시간&nbsp;&nbsp;&nbsp;</span>
                  <span class="bottom_like_comment">좋아요 18개&nbsp;&nbsp;&nbsp;</span>
                  <span class="bottom_like_comment">답글 달기</span>
                </b-col>
              </b-row>

              <b-row>
                <b-col style="padding:0px;">
                  <span class="bottom_time_line">---&nbsp;&nbsp;&nbsp;</span>
                  <span class="bottom_like_comment">답글 보기(1개)</span>
                </b-col>
              </b-row>


            </b-col>
          </b-row>
          <hr style="margin: 5px;">
          <b-row>
            <b-col cols="1" style="padding-right: 5px; text-align: left;">
              <a style="text-decoration: none;">
                <svg width="20" height="20" fill="none" xmlns="http://www.w3.org/2000/svg">
                  <path
                    d="M8.926 3.408a.503.503 0 0 0-.03-.067 2.653 2.653 0 0 0-.285-.435 4.27 4.27 0 0 0-.805-.781c-.667-.497-1.571-.866-2.68-.731-1.57.19-2.557 1.037-3.157 2.05-.625 1.057-.859 2.349-.791 3.384.067 1.022.175 1.864.685 2.938.535 1.123 1.549 2.577 3.57 4.66 1.897 1.956 3.228 3.232 4.08 4.006a.72.72 0 0 0 .487.202c.16 0 .33-.06.487-.202l-.29-.319.29.319c.852-.774 2.183-2.05 4.08-4.005 2.021-2.084 3.035-3.537 3.57-4.66.51-1.075.619-1.917.685-2.939.068-1.032-.168-2.324-.796-3.382-.602-1.016-1.59-1.862-3.153-2.052-.968-.119-1.877.235-2.605.755a4.86 4.86 0 0 0-.875.799c-.101.119-.172.216-.219.287l-.017.026a.5.5 0 0 0-.083.147c-.194.532-.634.833-1.074.833-.44 0-.88-.301-1.074-.833Zm2.356.618.253-.426-.253.426Zm-1.752-.98a.5.5 0 0 0 .94 0c.098-.269.444-.78 1.02-1.289C12.35 1 13.58.367 14.932.532c1.731.21 2.896 1.168 3.623 2.392.735 1.24 1.012 2.744.932 3.975-.071 1.085-.194 2.078-.782 3.314-.595 1.25-1.68 2.78-3.727 4.89-1.904 1.963-3.247 3.25-4.114 4.038-.528.479-1.2.479-1.728 0-.867-.787-2.21-2.075-4.114-4.038-2.047-2.11-3.132-3.64-3.727-4.89C.707 8.977.585 7.984.514 6.9c-.08-1.232.193-2.737.926-3.975C2.164 1.7 3.329.743 5.068.532 6.555.35 7.74.974 8.539 1.71c.554.51.885 1.043.991 1.335Z"
                    fill="#fff" stroke="#000" stroke-linejoin="round" />
                </svg>
              </a>
            </b-col>
            <b-col cols="1" style="padding-right: 5px; text-align: left;">
              <a style="text-decoration: none;">
                <svg width="23" height="23" fill="none" xmlns="http://www.w3.org/2000/svg">
                  <path fill-rule="evenodd" clip-rule="evenodd"
                    d="M2.453 7.581c-1.809.606-1.874 3.14-.098 3.838l6.47 2.541c.106.042.19.125.231.231l2.542 6.471c.697 1.776 3.232 1.71 3.837-.098l5.229-15.627c.535-1.598-.987-3.12-2.585-2.584L2.453 7.58Zm.499 2.317a.408.408 0 0 1 .02-.767l14.39-4.816-8.072 8.072-6.338-2.489Zm7.57 3.568c.02.042.038.085.055.128l2.541 6.47c.14.356.647.343.768-.019l5-14.943-8.364 8.364Z"
                    fill="#000" />
                </svg>
              </a>
            </b-col>
            <b-col style="padding-left: 5px; text-align: right;">
              <a style="text-decoration: none;">
                <svg width="25" height="25" fill="none" xmlns="http://www.w3.org/2000/svg">
                  <path fill-rule="evenodd" clip-rule="evenodd"
                    d="M5.357 4.464v14.428l5.607-3.925a2.679 2.679 0 0 1 3.072 0l5.607 3.925V4.464H5.357ZM20.536 2.68c.493 0 .893.4.893.892v17.036a.893.893 0 0 1-1.405.731l-7.012-4.908a.893.893 0 0 0-1.024 0l-7.012 4.908a.893.893 0 0 1-1.405-.731V3.57c0-.493.4-.892.893-.892h16.072Z"
                    fill="#000" />
                </svg>
              </a>
            </b-col>
          </b-row>
          <b-row>
            <b-col style="padding-right: 5px; text-align: left; font-weight: bold;">좋아요 878개</b-col>
          </b-row>
          <b-row>
            <b-col style="color:gray; font-size: x-small;">
              1일 전
            </b-col>
          </b-row>
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

  <b-modal hide-footer hide-title hide-header centered id="modal-4" size="sm" style="text-align: center;">
    <b-container>
      <!-- 본인 게시물이라면 신고 안 보이도록 해야 함 -->
      <b-row @click="Delete" style="text-align:center; cursor: pointer; color: red; font-weight: 600;">
        <div style="text-align:center;">신고</div>
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

  <b-modal hide-footer hide-title hide-header centered id="modal-5" size="md" style="text-align: center;">
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
        <div style="text-align:center;">취소</div>
      </b-row>
    </b-container>
  </b-modal>
</template>

<script>
export default {
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