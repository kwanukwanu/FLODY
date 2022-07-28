<template>
  <div>
    <b-card>
      <b-container>
        <h2>스터디 가입하기</h2>
        <b-row id="header">
          <b-col id="header_name" cole="2">
            <div style="padding: 6px 6px; font-weight: bold;">스터디 명 :</div>
          </b-col>
          <b-col id="header_input" cols="8">
            <b-form-input required style="border: none; background-color: #F1EBEB;"></b-form-input>
          </b-col>
          <b-col id="header_button" cols="2">
            <b-button>검색</b-button>
          </b-col>
        </b-row>
        <hr />
        <!-- 테이블 -->
        <h5 id="table_name" style="text-align: left; font-weight: bold;">해당 이름을 가진 스터디 목록 (5개씩 페이징 처리)</h5>
        <b-table :items="items" :fields="fields" striped responsive="sm">
          <template #cell(show_details)="row">
            <b-button size="sm" @click="row.toggleDetails" class="mr-2">
              {{ row.detailsShowing ? 'Hide' : 'Show'}} Details
            </b-button>

            <!-- As `row.showDetails` is one-way, we call the toggleDetails function on @change -->
            <b-form-checkbox v-model="row.detailsShowing" @change="row.toggleDetails">
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
        </b-table>
        <div id="table_pagination" style="text-align: center;">
          <b-button class="page_button" variant="link">&lt; </b-button>
          <b-button class="page_button" variant="link">1</b-button>
          <b-button class="page_button" variant="link">2</b-button>
          <b-button class="page_button" variant="link">3</b-button>
          <b-button class="page_button" variant="link">&gt; </b-button>
        </div>

        <b-row id="study_info">
          <b-col id="study_intro">
            <b-row id="study_intro_line">
              <h5 id="study_intro_title">해당 스터디의 정보 및 소개</h5>
            </b-row>
            <b-row id="study_intro_content">
              <div>의지박약 친구들끼리 머리 맞대고 공부하실분들을 찾습니다.</div>
            </b-row>
          </b-col>
          <b-col id="study_people">
            <b-row id="study_people_line">
              <h5 id="study_people_title">스터디원 목록</h5>
            </b-row>
            <b-row id="study_people_box">
              <ul id="study_people_group">
                <li class="study_people_person">Super_Mario</li>
                <li class="study_people_person">Bat_Man</li>
                <li class="study_people_person">Chinderella</li>
              </ul>
            </b-row>
          </b-col>
        </b-row>

        <b-row id="study_motive">
          <b-col id="study_motive_col">
            <b-row id="study_motive_line">
              <h5 id="study_motive_title">가입동기</h5>
            </b-row>
            <b-row id="study_motive_line2">
              <b-form-textarea id="study_motive_input" placeholder="Enter something..." rows="3" max-rows="6"></b-form-textarea>
            </b-row>
          </b-col>
        </b-row>
        <b-row id="study_button" align-h="around">
          <b-col id="study_button_make">
            <b-button id="study_button_make_button" text v-b-modal.study_create>스터디 생성하기
            </b-button>
          </b-col>
          <b-col id="study_button_application">
            <b-button id="study_button_application_button" text @click="gotoPage('/study')">
              신청하기</b-button>
          </b-col>
        </b-row>

      </b-container>
    </b-card>
  </div>

  <b-modal id="study_create" centered title="스터디 생성">
    <b-card id="modal_card" style="height: 15; max-width: 40rem; background-color: #F8F3F3;">
      <b-container id="modal_container" ref="form">
        <b-row id="study_name_line" style="margin-bottom: 10px;">
          <b-col id="study_name_title_space" cole="3" style="padding: 0">
            <div id="study_name_title" style="padding: 6px 6px; font-weight: bold;">스터디 명 :</div>
          </b-col>
          <b-col id="study_name_input_space" cols="9" style="padding: 0">
            <b-form-input id="study_name_input" required style="border: none;"></b-form-input>
          </b-col>
        </b-row>
        <b-row id="study_lookup_line" style="margin-bottom: 5px; text-align: left;">
          <div id="study_lookup_title" style="font-weight: bold;">스터디원 목록</div>
        </b-row>
        <b-row id="study_lookup_line2" style="margin-bottom: 10px;">
          <b-col id="study_lookup_input_space" cols="10" style="padding: 0; margin-left: 10px;">
            <b-form-input id="study_lookup_input" aria-placeholder="추가하고자 하는 스터디원의 아이디 입력" required style="border: none;"></b-form-input>
          </b-col>
          <b-col id="study_lookup_button_space" style="padding: 0; margin-left: 6px;">
            <b-button id="study_lookup-button" text style="color: #453535; background-color: #E1D3D2; border: none">추가</b-button>
          </b-col>
        </b-row>
        <b-row id="study_hold_line" style="margin-bottom: 5px; text-align: left;">
          <div id="study_hold_title" style="font-weight: bold;">스터디원 리스트</div>
        </b-row>
        <b-row id="study_hold_line2" style="margin-bottom: 10px;">
          <b-col id="study_hold_list_space">
            이 부분 고민
          </b-col>
        </b-row>
        <b-row id="study_letter_line" style="margin-bottom: 5px; text-align: left;">
          <div id="study_letter_title" style="font-weight: bold;">스터디 소개글</div>
        </b-row>
        <b-row id="study_letter_line2" style="margin-bottom: 10px;">
          <b-col id="study_letter_input_space">
            <b-form-textarea id="study_letter_input" v-model="textEx1" placeholder="Enter something..." rows="3" max-rows="6"
              style="border: 1px solid; border-color: #A48282;">
            </b-form-textarea>
          </b-col>
        </b-row>
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
export default{
  data() {
      return {
        fields: ['first_name', 'last_name', 'show_details'],
        items: [
          { isActive: true, age: 40, first_name: 'Dickerson', last_name: 'Macdonald' },
          { isActive: false, age: 21, first_name: 'Larsen', last_name: 'Shaw' },
          { isActive: false, age: 89, first_name: 'Geneva', last_name: 'Wilson', _showDetails: true},
          { isActive: true, age: 38, first_name: 'Jami', last_name: 'Carney' }
        ]
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

#study_info > #study_intro >#study_intro_content {
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
  color: #453535; 
  background-color: #E1D3D2; 
  border: none;
}

#study_button > #study_button_application {
  text-align: center;
}

#study_button > #study_button_application > #study_button_application_button {
  color: #453535; 
  background-color: #E1D3D2; 
  border: none;
}
</style>