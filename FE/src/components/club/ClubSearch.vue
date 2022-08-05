<template>
  <div>
    <b-card>
      <b-container>
        <h5 style="text-align:left; font-weight: 600; color:#064635;">스터디 가입하기</h5>
        <br>
        <b-row id="header">
          <b-col id="header_name" cols="2">
            <div style="padding: 6px 6px; font-weight: bold; font-size: large; margin-left: 12px;">스터디 명 :</div>
          </b-col>
          <b-col id="header_input" cols="9">
            <b-form-input style="border-color: #a48282"></b-form-input>
          </b-col>
          <b-col id="header_button" cols="1">
            <b-button style="color: #453535; background-color: #e1d3d2; border: none"><svg width="22" height="22" fill="none"
          xmlns="http://www.w3.org/2000/svg">
          <path d="m19.25 19.25-3.988-3.988m2.155-5.179a7.333 7.333 0 1 1-14.667 0 7.333 7.333 0 0 1 14.667 0Z"
            stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
        </svg>
      </b-button>
          </b-col>
        </b-row>
        <hr/>
        <!-- 테이블 -->
        <!-- <h5 id="table_name" style="text-align: left; font-weight: bold;">해당 이름을 가진 스터디 목록 (5개씩 페이징 처리)</h5> -->
        <!-- <b-table :items="items" :fields="fields" striped responsive="sm">
          <template #cell(show_details)="row">
            <b-button size="sm" @click="row.toggleDetails" class="mr-2">
              {{ row.detailsShowing ? 'Hide' : 'Show'}} Details
            </b-button> -->

        <!-- As `row.showDetails` is one-way, we call the toggleDetails function on @change -->
        <!-- <b-form-checkbox v-model="row.detailsShowing" @change="row.toggleDetails">
              Details via check
            </b-form-checkbox>
          </template>

          <template #row-details="row">
            <b-card>
              <b-row class="mb-2">
                <b-col sm="3" class="text-sm-right"><b>Age:</b></b-col>
                <b-col>{{ row.item.age }}</b-col>
              </b-row>

              <b-row class="mb-2">
                <b-col sm="3" class="text-sm-right"><b>Is Active:</b></b-col>
                <b-col>{{ row.item.isActive }}</b-col>
              </b-row>

              <b-button size="sm" @click="row.toggleDetails">Hide Details</b-button>
            </b-card>
          </template>
        </b-table> -->

        <b-table style="cursor:pointer" fixed hover :items="items"></b-table>

        <div id="table_pagination" style="text-align: center; margin-bottom: 60px;">
          <b-button class="page_button" variant="link">&lt; </b-button>
          <b-button class="page_button" variant="link">1</b-button>
          <b-button class="page_button" variant="link">2</b-button>
          <b-button class="page_button" variant="link">3</b-button>
          <b-button class="page_button" variant="link">&gt; </b-button>
        </div>

        <b-row id="study_info">
          <b-col cols="8" id="study_intro" >
            <b-row id="study_intro_line">
              <h6 id="study_intro_title">해당 스터디의 정보 및 소개</h6>
            </b-row>
            <b-row>
              <b-card class="study_intro_content" style="height:150px; overflow-y: scroll;">
                <b-container fluid="sm">
                  의지박약 친구들끼리 머리 맞대고 공부하실분들을 찾습니다!</b-container>
              </b-card>
            </b-row>
          </b-col>
          <b-col cols="3" id="study_people" style="padding:0px 0px 20px 12px; margin-left: 50px;">
            <b-row id="study_people_line">
              <h6 id="study_people_title">스터디원 목록</h6>
            </b-row>
            <b-row>
              <b-card class="study_intro_content" style="height:150px; overflow-y: scroll;">
                <b-container fluid="sm">
                  <div style="text-align:left">
                    <!-- <ul id="study_people_group">
                    <li class="study_people_person"><b-avatar variant="info" src="https://placekitten.com/300/200" size="20px"></b-avatar> Super_girl</li>
                    <li class="study_people_person"><b-avatar variant="info" src="https://placekitten.com/300/201" size="20px"></b-avatar> Bat_Man</li>
                    <li class="study_people_person"><b-avatar variant="info" src="https://placekitten.com/300/202" size="20px"></b-avatar> pussycat</li>
                    <li class="study_people_person"><b-avatar variant="info" src="https://placekitten.com/300/203" size="20px"></b-avatar> codingwang</li>
                    <li class="study_people_person"><b-avatar variant="info" src="https://placekitten.com/300/204" size="20px"></b-avatar> Super_boy</li>
                    <li class="study_people_person"><b-avatar variant="info" src="https://placekitten.com/300/205" size="20px"></b-avatar> Bat_girl</li>
                    <li class="study_people_person"><b-avatar variant="info" src="https://placekitten.com/300/206" size="20px"></b-avatar> fire_boy</li>
                    <li class="study_people_person"><b-avatar variant="info" src="https://placekitten.com/300/207" size="20px"></b-avatar> chicken_grandma</li>
                  </ul> -->
                    <div class="person">
                      <b-avatar variant="info" src="https://placekitten.com/300/200" size="20px"></b-avatar> Super_girl
                    </div>
                    <div class="person">
                      <b-avatar variant="info" src="https://placekitten.com/300/300" size="20px"></b-avatar> Bat_Man
                    </div>
                    <div class="person">
                      <b-avatar variant="info" src="https://placekitten.com/300/202" size="20px"></b-avatar> pussycat
                    </div>
                    <div class="person">
                      <b-avatar variant="info" src="https://placekitten.com/300/203" size="20px"></b-avatar> codingwang
                    </div>
                    <div class="person">
                      <b-avatar variant="info" src="https://placekitten.com/300/204" size="20px"></b-avatar> Super_boy
                    </div>
                    <div class="person">
                      <b-avatar variant="info" src="https://placekitten.com/300/205" size="20px"></b-avatar> Bat_girl
                    </div>
                    <div class="person">
                      <b-avatar variant="info" src="https://placekitten.com/300/206" size="20px"></b-avatar> fire_boy
                    </div>
                    <div class="person">
                      <b-avatar variant="info" src="https://placekitten.com/300/207" size="20px"></b-avatar>
                      chicken_papa
                    </div>
                  </div>
                </b-container>
              </b-card>
            </b-row>
          </b-col>
        </b-row>

        <b-row id="study_motive" style="margin-top:20px">
          <b-col id="study_motive_col">
            <b-row id="study_motive_line">
              <h6 id="study_motive_title">가입 동기</h6>
            </b-row>
            <b-row id="study_motive_line2">
              <b-form-textarea id="study_motive_input" placeholder="가입 동기를 입력하세요." rows="3" max-rows="6">
              </b-form-textarea>
            </b-row>
          </b-col>
        </b-row>
        <b-row id="study_button" align-h="around">
          <b-col id="study_button_application">
            <b-button id="study_button_application_button" text @click="gotoPage('/study')" style="margin-top: 20px;">
              신청하기</b-button>
          </b-col>
        </b-row>
        <br><br>
        <b-row id="study_button" align-h="around">
          <b-col id="study_button_make">
            <span style="font-size:small; margin-right: 10px;">마음에 드는 스터디가 없으신가요? 그럼 직접 스터디를 만들어보세요! <svg width="15"
                height="15" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path
                  d="M13.125 7.5 8.75 3.125v2.5H2.375c-.175 0-.263 0-.33.034a.313.313 0 0 0-.136.137c-.034.066-.034.154-.034.329v2.75c0 .175 0 .263.034.33.03.058.078.106.137.136.066.034.154.034.329.034H8.75v2.5L13.125 7.5Z"
                  stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
              </svg></span>
            <b-button size="sm" id="study_button_make_button" text v-b-modal.study_create>스터디 만들기
            </b-button>
          </b-col>
        </b-row>

      </b-container>
    </b-card>
  </div>

  <b-modal id="study_create" hide-footer centered title="스터디 생성" style="text-align:center;">
    <b-card id="modal_card" style="height: 22rem; max-width: 40rem; background-color: #F8F3F3;">
      <b-container id="modal_container" ref="form">
        <!-- <b-row id="study_name_line" style="margin-bottom: 10px;">
          <b-col id="study_name_title_space" cols="3" style="padding: 0">
            <div id="study_name_title" style="padding: 6px 6px; font-weight: bold; text-align: left; margin-left: 6px;">스터디 명 :</div>
          </b-col>
          <b-col id="study_name_input_space" cols="9" style="padding: 0">
            <b-form-input id="study_name_input" required style="border: none;"></b-form-input>
          </b-col>
        </b-row> -->
        <b-row>
          <b-col>
            <b-form-input id="study_name_input" required style="border: none; margin-bottom: 20px;" placeholder="스터디명을 입력하세요."></b-form-input>
          </b-col>
        </b-row>
        <b-row id="study_lookup_line" style="margin-bottom: 5px; text-align: left;">
          <div id="study_lookup_title">스터디원 목록</div>
        </b-row>
        <b-row id="study_lookup_line2" style="margin-bottom: 10px;">
          <b-col id="study_lookup_input_space" cols="10" style="padding: 0; margin-left: 10px;">
            <b-form-input id="study_lookup_input" aria-placeholder="추가하고자 하는 스터디원의 아이디 입력" required
              style="border: none;"></b-form-input>
          </b-col>
          <b-col id="study_lookup_button_space" style="padding: 0; margin-left: 6px;">
            <div style="text-align:center"><b-button size="sm" id="study_lookup-button" text style="color: #453535; background-color: #E1D3D2; border: none; vertical-align:-webkit-baseline-middle;">추가
            </b-button></div>
          </b-col>
        </b-row>
        <!-- <b-row id="study_hold_line" style="margin-bottom: 5px; text-align: left;">
          <div id="study_hold_title" style="font-weight: bold;">스터디원 리스트</div>
        </b-row>
        <b-row id="study_hold_line2" style="margin-bottom: 10px;">
          <b-col id="study_hold_list_space">
            이 부분 고민
          </b-col>
        </b-row> -->
        <!-- <b-row id="study_letter_line" style="margin-bottom: 5px; text-align: left;">
          <div id="study_letter_title" style="font-weight: bold;">스터디 소개글</div>
        </b-row> -->
        <b-row id="study_letter_line2" style="margin-bottom: 35px; margin-top: 20px;">
          <b-col id="study_letter_input_space">
            <b-form-textarea id="study_letter_input" v-model="textEx1" placeholder="스터디 소개글을 입력하세요." rows="3"
              max-rows="6" style="border: none">
            </b-form-textarea>
          </b-col>
        </b-row>
        <b-button text @click="submit" style="color: #453535; background-color: #e1d3d2; border: none">만들기</b-button>
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
export default{
  data() {
      return {
        // fields: ['first_name', 'last_name', 'show_details'],
        // items: [
        //   { isActive: true, age: 40, first_name: 'Dickerson', last_name: 'Macdonald' },
        //   { isActive: false, age: 21, first_name: 'Larsen', last_name: 'Shaw' },
        //   { isActive: false, age: 89, first_name: 'Geneva', last_name: 'Wilson', _showDetails: true},
        //   { isActive: true, age: 38, first_name: 'Jami', last_name: 'Carney' }
        // ],

        items: [
        {
          번호: "1",
          스터디이름: "정처기 뿌셔",
          스터디장: "Super_Mario",
        },
        {
          번호: "2",
          스터디이름: "2022 정보처리기사 2회 실기 스터디",
          스터디장: "aeri",
        },
        {
          번호: "3",
          스터디이름: "정처기 합격하면 그냥 저녁 쏩니다",
          스터디장: "kim_min_jae",
        },
      ],
      }
  },
  methods: {
    gotoPage(link) {
      console.log(link);
      this.$router.push(link);
    },
  },
}
</script>

<style>


#header > #header_name {
  text-align: center;
  padding: 0
}

#header > #header_input {
  padding: 0;
}

hr {
  margin: 10px 0px;
}

#table_pagination {
  text-align: center;
}

#table_pagination > .page_button {
  color: black; 
  text-decoration: none; 
  font-weight: 100;
}

#study_info {
  margin-top: 10px;
}

#study_info > #study_intro {
  margin-right: 10px;
}

#study_info > #study_intro > #study_intro_line >#study_intro_title {
  text-align: left; 
  font-weight: bold;
}

.study_intro_content {
  border: 1px solid; 
  border-color: #A48282; 
  border-radius: 7px;
}

#study_info > #study_people > #study_people_line > #study_people_title {
  text-align: left; 
  font-weight: bold;
}

#study_info > #study_people > #study_people_box {
  border: 1px solid; 
  border-color: #A48282; 
  border-radius: 7px;
}

#study_info >#study_people > #study_people_box > #study_people_group {
  list-style-position: inside; 
  margin: 0;
}

#study_info > #study_people > #study_people_box > #study_people_group > .study_people_person{
  text-align: left; 
  padding-left: 6rem;
}

#study_motive {
  margin-top: 10px;
}

#study_motive > #study_motive_col > #study_motive_line > #study_motive_title {
  text-align: left; 
  font-weight: bold;
}

#study_motive > #study_motive_col > #study_motive_line2 > #study_motive_input {
  border: 1px solid; 
  border-color: #A48282;
}

#study_button {
  margin-top: 10px;
}

#study_button > #study_button_make {
  text-align: center;
}

#study_button > #study_button_make > #study_button_make_button {
  /* color: #453535; 
  background-color: #E1D3D2; 
  background-color: white;
  border: none; */
  color: white;
  background-color: #83a39a;
  text-decoration: none;
  font-weight: 100;
  border: 1px solid;
}

#study_button > #study_button_application {
  text-align: center;
}

#study_button > #study_button_application > #study_button_application_button {
  color: #453535; 
  background-color: #E1D3D2; 
  border: none;
}
dl, ol, ul {
    list-style: none;
}
.person{
  margin-bottom: 5px;
}
</style>