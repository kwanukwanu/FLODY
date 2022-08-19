<template>
  <!-- <router-view /> -->
  <b-container>
    <group-header></group-header>
    <br>
    <b-row style="height: 11.5rem;">
      <group-member-list></group-member-list>
    </b-row>
    <b-row>
      <b-col>
        <b-card style="max-width:35rem; border-color: #a48282;">
          <group-calendar></group-calendar>
        </b-card>
      </b-col>
      <b-col>
        <group-todo></group-todo>
      </b-col>
    </b-row>
    <b-row>
      <group-field></group-field>
    </b-row>
    <div style="text-align: center; margin-top: 20px; ">
      <b-button text @click="gotoPage('/study')" style="color: #453535; background-color: #E1D3D2; border: none;">
        스터디 나가기</b-button>
    </div>
  </b-container>

  <b-modal hide-footer id="modal-8" centered no-stacking title="할 일 등록" style="text-align: center">
    <b-card style="min-height: 12rem; max-width: 30rem; background-color: #f8f3f3">
      <b-container ref="form">
        <b-row style="margin-bottom: 10px;">
          <b-col cols="10" style="padding: 0; margin-left: 10px;">
            <b-form-input placeholder="내용 입력..." id="todo_content" aria-placeholder="할 일..." required
              style="border: none;"></b-form-input>
          </b-col>
          <b-col id="study_lookup_button_space" style="padding: 0; margin-left: 6px;">
            <div style="text-align:center">
              <b-button size="sm" id="study_lookup-button" text style="color: #453535; background-color: #E1D3D2; border: none; 
              vertical-align:-webkit-baseline-middle;" @click="todosInsert()">
                <svg width="20" height="20" fill="none" xmlns="http://www.w3.org/2000/svg" style="color:red;">
                  <path d="M10 6.667v6.666M6.667 10h6.666m5 0a8.333 8.333 0 1 1-16.666 0 8.333 8.333 0 0 1 16.666 0Z"
                    stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
                </svg>
              </b-button>
            </div>
          </b-col>
        </b-row>
        <div id="todosField" style="height:50px; overflow-y: scroll;">
        </div>
        <br />
        <b-button text @click="submit_todo" style="color: #453535; background-color: #e1d3d2; border: none" data-bs-dismiss="modal" aria-label="Close">등록
        </b-button>
      </b-container>
    </b-card>
  </b-modal>

</template>

<script>
import { get_group_member_list_by_groNo, delete_group_member, regist_group_schedule } from "@/api/group";
import { computed } from "vue";
import { useStore } from "vuex";

import GroupHeader from "@/components/group/GroupHeader.vue";
import GroupMemberList from "@/components/group/GroupMemberList.vue";
import GroupCalendar from "@/components/group/GroupCalandar.vue";
import GroupTodo from "@/components/group/GroupTodo.vue";
import GroupField from "@/components/group/GroupField.vue";

export default {
  components: {
    GroupHeader,
    GroupMemberList,
    GroupCalendar,
    GroupTodo,
    GroupField
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
    const selectGroup = computed(() => store.state.groupStore.selectGroups);
    const myInfo = computed(() => store.state.memberStore.userInfo);
    const selectedDate = computed(() => store.state.groupStore.selectedDate);
    return { store, todos, selectGroup, myInfo, selectedDate };
  },
  methods: {
    todosInsert() {
      let todo_content = document.getElementById('todo_content');
      let todos_field = document.getElementById('todosField');
      console.log(todo_content.value);
      console.log(todos_field);
      if (todo_content.value !== '') {
        const item = document.createElement('div')
        // text
        const text = document.createElement('span');
        // 제거하기 버튼
        const deleteButton = document.createElement('a');
        // <span id="delete" class="material-icons" style="vertical-align: sub; cursor: pointer;">delete</span>
        deleteButton.innerHTML = `
                                <svg id="delete" width="20" height="20" fill="none" xmlns="http://www.w3.org/2000/svg" style="vertical-align: sub; cursor: pointer;">
                                  <path d="M6.667 10h6.666m5 0a8.333 8.333 0 1 1-16.666 0 8.333 8.333 0 0 1 16.666 0Z" stroke="#444"
                                    stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
                                </svg>
                              `;

        text.className = 'newTodos';
        text.textContent = todo_content.value
        todo_content.value = ''

        item.appendChild(text)
        item.appendChild(deleteButton)
        todos_field.appendChild(item)

        deleteButton.addEventListener('click', (event) => {
          todos_field.removeChild(event.currentTarget.parentNode)
        })
        todo_content.value = ''
      }
    },
    async submit_todo() {
      const todos = document.getElementsByClassName('newTodos');
      console.log("for문");
      for (let idx = 0; idx < todos.length; idx++) {
        console.log("idx : " + idx);
        let tmp = new Object();
        tmp.title = todos[idx].innerHTML;
        tmp.detail = null;
        tmp.startDate = this.selectedDate;
        tmp.endDate = this.selectedDate;
        tmp.done = false;
        console.log(tmp);
        // this.newStudyMember.push(tmp);

        await regist_group_schedule(
          this.selectGroup.groNo, tmp,
          (response) => {
            console.log(response);
            if (response.data.msg == "SUCCESS") {
              console.log("새로운 to-do 리스트 등록 완료!!!");
              alert("등록이 완료되었습니다.");

            } else {
              console.log("새로운 to-do 리스트 등록 실패 ㅠㅠ");
            }
          },
          (error) => {
            console.log(error);
          }
        )
      }
      const data = {
        groNo: this.selectGroup.groNo,
        selectedDate: this.selectedDate
      }
      this.store.dispatch("groupStore/set_todo_list", data);
    },
    async gotoPage(link) {
      // 선택한 스터디의 전체 멤버 조회
      let members = [];
      await get_group_member_list_by_groNo(
        this.selectGroup.groNo,
        (response) => {
          console.log(response);
          if (response.data.msg == "SUCCESS") {
            console.log("선택한 스터디의 전체 멤버 조회 완료!!!");
            members = response.data.item;
          } else {
            console.log("선택한 스터디의 전체 멤버 조회 실패 ㅠㅠ");
          }
        },
        (error) => {
          console.log(error);
        }
      )

      console.log(members);

      // 삭제할 그룹 멤버 넘버 조회
      let gmNoDelete = -1;
      for (let idx = 0; idx < members.length; idx++) {
        if (members[idx].email === this.myInfo.email) {
          gmNoDelete = members[idx].gmNo;
        }
      }

      await delete_group_member(
        gmNoDelete,
        (response) => {
          console.log(response);
          if (response.data.msg == "SUCCESS") {
            console.log("선택한 스터디 나가기 완료!!!");
            members = response.data.item;
          } else {
            console.log("선택한 스터디 나가기 실패 ㅠㅠ");
          }
        },
        (error) => {
          console.log(error);
        }
      )

      await this.store.dispatch("groupStore/set_my_group_item");


      console.log(link);
      this.$router.push(link);
    },
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

#todosField::-webkit-scrollbar {
  width: 5px;
}

#todosField::-webkit-scrollbar-track {
  background-color: transparent;
}

#todosField::-webkit-scrollbar-thumb {
  border-radius: 3px;
  background-color: #E4DADA;
}

#todosField::-webkit-scrollbar-button {
  width: 0;
  height: 0;
}

.wrap-vertical {
  width: 58rem;
  border-color: #a48282;
  margin-bottom: 70px;
  margin-left: 11px;
  height: 10rem;
}

ul {
  list-style: none;
}

#tab ul {
  white-space: nowrap;
  overflow-x: scroll;
  text-align: center;
}

#tab ul li {
  display: inline-block;
  margin-right: 25px;
  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Helvetica, Arial, sans-serif;
  font-size: 14px;
}

#tab ul::-webkit-scrollbar {
  height: 10px;
}

#tab ul::-webkit-scrollbar-track {
  background-color: transparent;
}

#tab ul::-webkit-scrollbar-thumb {
  border-radius: 10px;
  background-color: #E4DADA;
}

#tab ul::-webkit-scrollbar-button {
  width: 0;
  height: 0;
}
</style>