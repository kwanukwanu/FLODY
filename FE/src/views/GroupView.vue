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
    <group-header></group-header>

    <!--
    전체 todos를 가져온다.
    기본 날짜를 현재 날짜로 정한다
    해당 날짜에 해당하는 todolist를 받아온다
    todolist를 체크할때마다 해당 list의 complete 값을 변경해준다 (axios 변경)
    todolist의 success 개수를 체크해 최대값이 되면 
    -->
    <br>
    <b-row>
      <b-col>
        <b-card style="max-width:25rem; border-color: #a48282;">
          <group-calendar></group-calendar>
        </b-card>
      </b-col>
      <b-col>
        <group-todo></group-todo>
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
import { computed } from "vue";
import { useStore } from "vuex";

import GroupHeader from "@/components/group/GroupHeader.vue";
import GroupCalendar from "@/components/group/GroupCalandar.vue";
import GroupTodo from "@/components/group/GroupTodo.vue";

export default {
  components: {
    GroupHeader,
    GroupCalendar,
    GroupTodo,
  },
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
    const todos = computed(() => store.state.calendarStore.todos);

    return { store, todos };
  },
  methods: {
  },
  computed: {
  },

};
</script>

<style>
li {
  margin-bottom: 15px;
}

input[type=checkbox]:checked+label.strikethrough {
  text-decoration: line-through;
  text-decoration-color: #BC6464;
  color: #9F9F9F;
}

.checkbox {
  accent-color: #E3D6D6;
}
</style>