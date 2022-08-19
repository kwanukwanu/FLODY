<template>
  <v-calendar is-expanded :attributes="attributes" @dayclick="onDayClick" @update:from-page="onUpdatePage"
    @update:to-page="onUpdatePageTo" @dayfocusin="onDayFocusIn" @dayfocusout="onDayFocusOut"
    @transition-start="onTransitionStart" @transition-end="onTransitionEnd"></v-calendar>
</template>

<script>
import { computed } from "vue";
import { useStore } from "vuex";
export default {
  data() {
    return {
      incId: this.todos.length,
      days: [],
    };
  },
  setup() {
    const store = useStore();
    const todos = computed(() => store.state.groupStore.todos);
    const todo_list = computed(() => store.state.groupStore.todo_list);
    const selectGroup = computed(() => store.state.groupStore.selectGroups);
    return { store, todos, todo_list, selectGroup };
  },
  mounted() {
    console.log("date : ");
    const date = new Date();
    const d = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate();
    const data = {
      groNo: this.selectGroup.groNo,
      selectedDate: d
    }
    this.store.dispatch("groupStore/set_todo_list", data);
    console.log(this.todo_list);
  },
  methods: {
    // 참고 : https://vcalendar.io/examples/datepickers.html
    onDayClick(day) {
      this.store.dispatch("groupStore/set_selectedDate", day.id);
      const data = {
        groNo: this.selectGroup.groNo,
        selectedDate: day.id,
      }
      this.store.dispatch("groupStore/set_todo_list", data);
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
    //todo : description(할 일), isComplete(완료여부), dates(날짜), color(색상표시)

    // 참고 : https://vcalendar.io/api/v1.0/date-patterns.html#weekdays
    // dates : 날짜를 지정한다
    // years, months, days : 년, 월, 일
    // weekdays : 요일, 1(일),2(월),3(화),4(수),5(목),6(금),7(토)
    // 날짜별 속성을 지정하려면 여기서
    attributes() {
      return [
        // 현재날짜 확인
        {
          key: 'today',
          highlight: {
            fillMode: 'outline',
            color: 'green',
          },
          dates: new Date(),
        },

        // todo가 존재하는 곳 dot로 찍기
        ...this.todos.map((todo) => ({
          dates: todo.dates,
          dot: {
            color: todo.color,
            class: todo.isComplete ? "opacity-75" : "",
          },
        })),

        // popover 생성
        ...this.todo_list.map((item) => ({
          dates: item.endDate,
          popover: {
            label: item.title,
            visibility: 'focus',
          }
        })),

        // todos data를 Attribute에 저장
        // ...this.todos.map((todo) => ({
        // dates: todo.dates,
        //   dot: {
        //     color: todo.color,
        //     class: todo.isComplete ? "opacity-75" : "",
        //   },
        //   popover: {
        //     label: todo.description,
        //     visibility: "focus",
        //   },
        //   customData: todo,
        // })),

        // // range 지정
        // {
        //   // 범위만큼 색 칠하기
        //   highlight: {
        //     start: { fillMode: "light" }, // 연한색으로 칠하기
        //     base: { fillMode: "light" },
        //     end: { fillMode: "light" },
        //   },
        //   // 범위 지정
        //   // '월'은 0부터 11까지(원하는 월 -1로 설정)
        //   dates: { start: new Date(2022, 6, 14), end: new Date(2022, 6, 18) },
        // },
      ];
    },
  },
};
</script>

<style>
</style>