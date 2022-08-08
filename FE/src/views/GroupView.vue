<template>
  <!-- <h1>Group View</h1>
  <ul>
    <li><router-link to="/group/main">그룹 메인</router-link></li>    
    <li><router-link to="/group/calandar">그룹 캘린더</router-link></li>    
    <li><router-link to="/group/todo">그룹 todo리스트</router-link></li>    
    <li><router-link to="/group/chart">그룹 차트</router-link></li>    
  </ul> -->
  <router-view />
  <b-container>
    <b-row>
      <b-col>
        <b-row>
          <h4 style="font-weight:bold">정처기 뿌셔</h4>
        </b-row>
        <b-row>
          <h5>(정보처리기사)</h5>
        </b-row>
      </b-col>
      <b-col>
        <h1 style="color:red; font-weight:600; text-align: right;">D-3</h1>
      </b-col>
    </b-row>

    <br>
    <b-row>
      <b-col>
        <b-card style="max-width:25rem; border-color: #a48282;">
          <v-calendar is-expanded :attributes="attributes" @dayclick="onDayClick" @update:from-page="onUpdatePage"
            @update:to-page="onUpdatePageTo" @daymouseenter="onMouseEnter" @daymouseleave="onMouseLeave"
            @dayfocusin="onDayFocusIn" @dayfocusout="onDayFocusOut" @transition-start="onTransitionStart"
            @transition-end="onTransitionEnd"></v-calendar>
        </b-card>
      </b-col>
      <b-col>
        <b-card style="border-color: #a48282; max-width: 35rem; height:304px; overflow-y: scroll;">
          <b-row>
            <b-col cols="10">
              <span
                style="text-align:left; font-weight:bold; font-size: large; vertical-align:-webkit-baseline-middle;">Todo
                List</span>
            </b-col>
            <b-col cols="2">
              <span style="text-align:right;">
                <b-button size="sm" style="background-color:white; border-color:white;" v-b-modal.modal-8><svg
                    width="24" height="24" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path d="M12 5v14m-7-7h14" stroke="#444" stroke-width="2" stroke-linecap="round"
                      stroke-linejoin="round" />
                  </svg></b-button>
              </span>
            </b-col>
          </b-row>
          <hr />
          <ul style="list-style-type :none;">
            <li>
              <div class="checkbox">
                <input type="checkbox" name="packersOff" id="packers" value="1" />
                <label for="packers" class="strikethrough">&nbsp;네트워크 뽀사기</label>
              </div>
            </li>
            <li>
              <div class="checkbox">
                <input type="checkbox" name="packersOff" id="packers" value="1" />
                <label for="packers" class="strikethrough">&nbsp;보안 유형 정복</label>
              </div>
            </li>
            <li>
              <div class="checkbox">
                <input type="checkbox" name="packersOff" id="packers" value="1" />
                <label for="packers" class="strikethrough">&nbsp;21년 2회차 실기 풀이</label>
              </div>
            </li>
            <li>
              <div class="checkbox">
                <input type="checkbox" name="packersOff" id="packers" value="1" />
                <label for="packers" class="strikethrough">&nbsp;java 뽀사기</label>
              </div>
            </li>
            <li>
              <div class="checkbox">
                <input type="checkbox" name="packersOff" id="packers" value="1" />
                <label for="packers" class="strikethrough">&nbsp;python 유형 정복</label>
              </div>
            </li>
            <li>
              <div class="checkbox">
                <input type="checkbox" name="packersOff" id="packers" value="1" />
                <label for="packers" class="strikethrough">&nbsp;22년 2회차 실기 풀이</label>
              </div>
            </li>
            <li>
              <div class="checkbox">
                <input type="checkbox" name="packersOff" id="packers" value="1" />
                <label for="packers" class="strikethrough">&nbsp;3차 스터디 회의</label>
              </div>
            </li>

          </ul>
        </b-card>
      </b-col>
    </b-row>
  </b-container>

  <b-modal hide-footer id="modal-8" centered no-stacking title="할 일 등록" style="text-align: center">
    <b-card style="min-height: 12rem; max-width: 30rem; background-color: #f8f3f3">
      <b-container ref="form">
        <!-- <h2 style="text-align: center;">목표 등록</h2> -->
        <b-row style="margin-bottom: 20px">
          <b-col cols="11">
            <b-form-input placeholder="내용 입력..." required style="border: none"></b-form-input>
          </b-col>
          <b-col cols="1">
            <span style="vertical-align: middle;">
              <b-button size="sm" style="border:none; background:none; padding: 0px 0px">
                <svg width="20" height="20" fill="none" xmlns="http://www.w3.org/2000/svg">
                  <path d="M10 6.667v6.666M6.667 10h6.666m5 0a8.333 8.333 0 1 1-16.666 0 8.333 8.333 0 0 1 16.666 0Z"
                    stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
                </svg>
              </b-button>
            </span>
          </b-col>
        </b-row>

        <b-row style="margin-bottom: 20px">
          <b-col cols="11">
            <b-form-input placeholder="내용 입력..." required style="border: none"></b-form-input>
          </b-col>
          <b-col cols="1">
            <span style="vertical-align: middle;">
              <b-button size="sm" style="border:none; background:none; padding: 0px 0px">
                <svg width="20" height="20" fill="none" xmlns="http://www.w3.org/2000/svg">
                  <path d="M10 6.667v6.666M6.667 10h6.666m5 0a8.333 8.333 0 1 1-16.666 0 8.333 8.333 0 0 1 16.666 0Z"
                    stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
                </svg>
              </b-button>
            </span>
          </b-col>
        </b-row>

        <b-row style="margin-bottom: 20px">
          <b-col cols="11">
            <b-form-input placeholder="내용 입력..." required style="border: none"></b-form-input>
          </b-col>
          <b-col cols="1">
            <span style="vertical-align: middle;">
              <b-button size="sm" style="border:none; background:none; padding: 0px 0px">
                <svg width="20" height="20" fill="none" xmlns="http://www.w3.org/2000/svg">
                  <path d="M10 6.667v6.666M6.667 10h6.666m5 0a8.333 8.333 0 1 1-16.666 0 8.333 8.333 0 0 1 16.666 0Z"
                    stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
                </svg>
              </b-button>
            </span>
          </b-col>
        </b-row>

        <b-row style="margin-bottom: 20px">
          <b-col cols="11">
            <b-form-input placeholder="내용 입력..." required style="border: none"></b-form-input>
          </b-col>
          <b-col cols="1">
            <span style="vertical-align: middle;">
              <b-button size="sm" style="border:none; background:none; padding: 0px 0px">
                <svg width="20" height="20" fill="none" xmlns="http://www.w3.org/2000/svg">
                  <path d="M10 6.667v6.666M6.667 10h6.666m5 0a8.333 8.333 0 1 1-16.666 0 8.333 8.333 0 0 1 16.666 0Z"
                    stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
                </svg>
              </b-button>
            </span>
          </b-col>
        </b-row>

        <b-row style="margin-bottom: 20px">
          <b-col cols="11">
            <b-form-input placeholder="내용 입력..." required style="border: none"></b-form-input>
          </b-col>
          <b-col cols="1">
            <span style="vertical-align: middle;">
              <b-button size="sm" style="border:none; background:none; padding: 0px 0px">
                <svg width="20" height="20" fill="none" xmlns="http://www.w3.org/2000/svg">
                  <path d="M10 6.667v6.666M6.667 10h6.666m5 0a8.333 8.333 0 1 1-16.666 0 8.333 8.333 0 0 1 16.666 0Z"
                    stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
                </svg>
              </b-button>
            </span>
          </b-col>
        </b-row>
        <!-- <b-row style="margin-bottom: 20px">
          <b-col cols="2">
            <span style="vertical-align:middle; font-weight: bold;">시작</span>
          </b-col>
          <b-col cols="4">
            <input type="time" value="xxx" min="yyy" max="zzz">
          </b-col>
          <b-col cols="2">
            <span style="vertical-align:middle; font-weight: bold;">종료</span>
          </b-col>
          <b-col cols="4">
            <input type="time" value="xxx" min="yyy" max="zzz">
          </b-col>
        </b-row> -->
        <!-- <b-row>
          <b-col>
            <b-form-textarea id="content" placeholder="내용 입력..." rows="7" max-rows="15" required style="border: none">
            </b-form-textarea>
          </b-col>
        </b-row> -->
        <br />
        <b-button text @click="submit" style="color: #453535; background-color: #e1d3d2; border: none">등록</b-button>
      </b-container>
      <br />
    </b-card>
  </b-modal>
</template>

<script>
import {computed} from "vue";
import {useStore} from "vuex";
export default {
  data() {
    //todo : description(할 일), isComplete(완료여부), dates(날짜), color(색상표시)

    // 참고 : https://vcalendar.io/api/v1.0/date-patterns.html#weekdays
    // dates : 날짜를 지정한다
    // years, months, days : 년, 월, 일
    // weekdays : 요일, 1(일),2(월),3(화),4(수),5(목),6(금),7(토)
    return {
      incId: this.todos.length,
      days: [],
      prodArr: [] 
    };
  },
  setup() {
      const store = useStore();
      const todos = computed(()=>store.state.calendarStore.todos);

      return { store,todos };
  },
  methods: {
    // 참고 : https://vcalendar.io/examples/datepickers.html
    onDayClick(day) {
      console.log("click");
      console.log(day);
      console.log(day.id);
      const idx = this.days.findIndex((d) => d.id === day.id);
      if (idx >= 0) {
        this.days.splice(idx, 1);
      } else {
        this.days.push({
          id: day.id,
          date: day.date,
        });
      }
    },
    onUpdatePage(data) {
      //console.log("update:from-page");
      console.log(data);
    },
    onUpdatePageTo(data) {
      //console.log("update:to-page");
      console.log(data);
    },
    onMouseEnter(data) {
      //console.log("mouseEnter");
      console.log(data);
    },
    onMouseLeave(data) {
      //console.log("mouseLeave");
      console.log(data);
    },
    onDayFocusIn(data) {
      //console.log("focusIn");
      console.log(data);
    },
    onDayFocusOut(data) {
      //console.log("focusOut");
      console.log(data);
    },
    onTransitionStart(data) {
      //console.log("transitionStart");
      console.log(data);
    },
    onTransitionEnd(data) {
      //console.log("transitionEnd");
      console.log(data);
    },
  },
  computed: {
    dates() {
      return this.days.map((day) => day.date);
    },
    // 날짜별 속성을 지정하려면 여기서
    attributes() {
      return [
        // todos data를 Attribute에 저장
        ...this.todos.map((todo) => ({
          dates: todo.dates,
          dot: {
            color: todo.color,
            class: todo.isComplete ? "opacity-75" : "",
          },
          popover: {
            label: todo.description,
            visibility: "focus",
          },
          customData: todo,
        })),

        // range 지정
        {
          // 범위만큼 색 칠하기
          highlight: {
            start: { fillMode: "light" }, // 연한색으로 칠하기
            base: { fillMode: "light" },
            end: { fillMode: "light" },
          },
          // 범위 지정
          // '월'은 0부터 11까지(원하는 월 -1로 설정)
          dates: { start: new Date(2022, 6, 14), end: new Date(2022, 6, 18) },
        },
      ];
    },
  },

};
</script>

<style>
li{
  margin-bottom:15px;
}
input[type=checkbox]:checked + label.strikethrough{
  text-decoration: line-through;
  text-decoration-color:#BC6464;
  color:#9F9F9F;
}
</style>