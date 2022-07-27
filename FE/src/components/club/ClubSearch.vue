<template>
  <div>
    <b-card>
      <b-container>
        <h2>스터디 가입하기</h2>
        <b-row>
          <b-col cole="2">
            <div style="padding: 6px 6px; font-weight: bold;">스터디 명 : </div>
          </b-col>
          <b-col cols="8">
            <b-form-input required style="border: none; background-color: #F1EBEB;"></b-form-input>
          </b-col>
          <b-col cols="2">
            <b-button>검색</b-button>
          </b-col>
        </b-row>
        <hr>
        <!-- 테이블 -->
        <h5 style="text-align: left; font-weight: bold;">해당 이름을 가진 스터디 목록 (5개씩 페이징 처리)</h5>
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
        <b-button variant="link" style="color: black; text-decoration: none; font-weight: 100;">&lt; </b-button>
        <b-button variant="link" style="color: black; text-decoration: none; font-weight: 100;">1</b-button>
        <b-button variant="link" style="color: black; text-decoration: none; font-weight: 100;">2</b-button>
        <b-button variant="link" style="color: black; text-decoration: none; font-weight: 100;">3</b-button>
        <b-button variant="link" style="color: black; text-decoration: none; font-weight: 100;">&gt; </b-button>

        <b-row style="margin-top: 10px;">
          <b-col style="margin-right: 10px;">
            <b-row>
              <h5 style="text-align: left; font-weight: bold;">해당 스터디의 정보 및 소개</h5>
            </b-row>
            <b-row style="border: 1px solid; border-color: #A48282; border-radius: 7px;">
              <div>의지박약 친구들끼리 머리 맞대고 공부하실분들을 찾습니다.</div>
            </b-row>
          </b-col>
          <b-col>
            <b-row>
              <h5 style="text-align: left; font-weight: bold;">스터디원 목록</h5>
            </b-row>
            <b-row style="border: 1px solid; border-color: #A48282; border-radius: 7px;">
              <ul style="list-style-position: inside; margin: 0;">
                <li style="text-align: left; padding-left: 6rem;">Super_Mario</li>
                <li style="text-align: left; padding-left: 6rem;">Bat_Man</li>
                <li style="text-align: left; padding-left: 6rem;">Chinderella</li>
              </ul>
            </b-row>
          </b-col>
        </b-row>
        <b-row style="margin-top: 10px;">
          <b-col>
            <b-row>
              <h5 style="text-align: left; font-weight: bold;">가입동기</h5>
            </b-row>
            <b-row>
              <b-form-textarea id="textarea" v-model="textEx1" placeholder="Enter something..." rows="3" max-rows="6"
                style="border: 1px solid; border-color: #A48282;">
              </b-form-textarea>
            </b-row>
          </b-col>
        </b-row>
        <b-row align-h="around" style="margin-top: 10px;">
          <b-col>
            <b-button text style="color: #453535; background-color: #E1D3D2; border: none" v-b-modal.modal-2>스터디 생성하기
            </b-button>
          </b-col>
          <b-col>
            <b-button text style="color: #453535; background-color: #E1D3D2; border: none" @click="gotoPage('/study')">
              신청하기</b-button>
          </b-col>
        </b-row>

      </b-container>
    </b-card>
  </div>

  <b-modal id="modal-2" centered title="스터디 생성" style="text-align: center;">
    <b-card style="height: 15; max-width: 40rem; background-color: #F8F3F3;">
      <b-container ref="form">
        <b-row style="margin-bottom: 10px;">
          <b-col cole="3" style="padding: 0">
            <div style="padding: 6px 6px; font-weight: bold;">스터디 명 :</div>
          </b-col>
          <b-col cols="9" style="padding: 0">
            <b-form-input required style="border: none;"></b-form-input>
          </b-col>
        </b-row>
        <b-row style="margin-bottom: 5px; text-align: left;">
          <div style="font-weight: bold;">스터디원 목록</div>
        </b-row>
        <b-row style="margin-bottom: 10px;">
          <b-col cols="10" style="padding: 0; margin-left: 10px;">
            <b-form-input aria-placeholder="추가하고자 하는 스터디원의 아이디 입력" required style="border: none;"></b-form-input>
          </b-col>
          <b-col style="padding: 0; margin-left: 6px;">
            <b-button text style="color: #453535; background-color: #E1D3D2; border: none">추가</b-button>
          </b-col>
        </b-row>
        <b-row style="margin-bottom: 5px; text-align: left;">
          <div style="font-weight: bold;">스터디원 리스트</div>
        </b-row>
        <b-row style="margin-bottom: 10px;">
          <b-col>
            이 부분 고민
          </b-col>
        </b-row>
        <b-row style="margin-bottom: 5px; text-align: left;">
          <div style="font-weight: bold;">스터디 소개글</div>
        </b-row>
        <b-row style="margin-bottom: 10px;">
          <b-col>
            <b-form-textarea id="textarea" v-model="textEx1" placeholder="Enter something..." rows="3" max-rows="6"
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
</style>