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
      <b-card class="wrap-vertical">

        <!-- <b-card-group style="width:10rem; height:12rem; "><b-avatar variant="info" src="https://placekitten.com/300/300" size="44px"></b-avatar></b-card-group>
        <b-card-group style="width:10rem; height:12rem; "><b-avatar variant="info" src="https://placekitten.com/300/300" size="44px"></b-avatar></b-card-group>
        <b-card-group style="width:10rem; height:12rem; "><b-avatar variant="info" src="https://placekitten.com/300/300" size="44px"></b-avatar></b-card-group>
        <b-card-group style="width:10rem; height:12rem; "><b-avatar variant="info" src="https://placekitten.com/300/300" size="44px"></b-avatar></b-card-group>
        <b-card-group style="width:10rem; height:12rem; "><b-avatar variant="info" src="https://placekitten.com/300/300" size="44px"></b-avatar></b-card-group>
        <b-card-group style="width:10rem; height:12rem; "><b-avatar variant="info" src="https://placekitten.com/300/300" size="44px"></b-avatar></b-card-group>
        <b-card-group style="width:10rem; height:12rem; "><b-avatar variant="info" src="https://placekitten.com/300/300" size="44px"></b-avatar></b-card-group>
        <b-card-group style="width:10rem; height:12rem; "><b-avatar variant="info" src="https://placekitten.com/300/300" size="44px"></b-avatar></b-card-group>
        <b-card-group style="width:10rem; height:12rem; "><b-avatar variant="info" src="https://placekitten.com/300/300" size="44px"></b-avatar></b-card-group>
        <b-card-group style="width:10rem; height:12rem; "><b-avatar variant="info" src="https://placekitten.com/300/300" size="44px"></b-avatar></b-card-group>
         -->

        <div id="tab">
          <ul>
            <li>
              <b-avatar variant="info" src="https://placekitten.com/300/300" size="70px" style="margin-bottom:5px"></b-avatar><br/>chlwogus_
            </li>
            <li>
              <b-avatar variant="info" src="https://placekitten.com/300/300" size="70px" style="margin-bottom:5px"></b-avatar><br />mirikwon_
            </li>
            <li>
              <b-avatar variant="info" src="https://placekitten.com/300/300" size="70px" style="margin-bottom:5px"></b-avatar><br />hilooboys_
            </li>
            <li>
              <b-avatar variant="info" src="https://placekitten.com/300/300" size="70px" style="margin-bottom:5px"></b-avatar><br />dogandcat_
            </li>
            <li>
              <b-avatar variant="info" src="https://placekitten.com/300/300" size="70px" style="margin-bottom:5px"></b-avatar><br />maratangboy
            </li>
            <li>
              <b-avatar variant="info" src="https://placekitten.com/300/300" size="70px" style="margin-bottom:5px"></b-avatar><br />wearef5
            </li>
                        <li>
              <b-avatar variant="info" src="https://placekitten.com/300/300" size="70px" style="margin-bottom:5px"></b-avatar><br />chlwogus_
            </li>
            <li>
              <b-avatar variant="info" src="https://placekitten.com/300/300" size="70px" style="margin-bottom:5px"></b-avatar><br />mirikwon_
            </li>
            <li>
              <b-avatar variant="info" src="https://placekitten.com/300/300" size="70px" style="margin-bottom:5px"></b-avatar><br />hilooboys_
            </li>
            <li>
              <b-avatar variant="info" src="https://placekitten.com/300/300" size="70px" style="margin-bottom:5px"></b-avatar><br />dogandcat_
            </li>
            <li>
              <b-avatar variant="info" src="https://placekitten.com/300/300" size="70px" style="margin-bottom:5px"></b-avatar><br />maratangboy
            </li>
            <li>
              <b-avatar variant="info" src="https://placekitten.com/300/300" size="70px" style="margin-bottom:5px"></b-avatar><br />wearef5
            </li>
                        <li>
              <b-avatar variant="info" src="https://placekitten.com/300/300" size="70px" style="margin-bottom:5px"></b-avatar><br />chlwogus_
            </li>
            <li>
              <b-avatar variant="info" src="https://placekitten.com/300/300" size="70px" style="margin-bottom:5px"></b-avatar><br />mirikwon_
            </li>
            <li>
              <b-avatar variant="info" src="https://placekitten.com/300/300" size="70px" style="margin-bottom:5px"></b-avatar><br />hilooboys_
            </li>
            <li>
              <b-avatar variant="info" src="https://placekitten.com/300/300" size="70px" style="margin-bottom:5px"></b-avatar><br />dogandcat_
            </li>
            <li>
              <b-avatar variant="info" src="https://placekitten.com/300/300" size="70px" style="margin-bottom:5px"></b-avatar><br />maratangboy
            </li>
            <li>
              <b-avatar variant="info" src="https://placekitten.com/300/300" size="70px" style="margin-bottom:5px"></b-avatar><br />wearef5
            </li>
            
          </ul>
        </div>
      </b-card>
    </b-row>
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
        <!-- <b-table-simple>
          <tbody id="mytest">
            <tr style="margin-bottom: 20px">
              <td cols="11" style="text-align:left; font-weight: 600;">
                &nbsp;&nbsp;Todo 추가
              </td>
              <td cols="1">
                <span id="add" style="vertical-align: middle;">
                  <b-button size="sm" style="border:none; background:none; padding: 0px 0px" @click="addRow()">
                    <svg width="20" height="20" fill="none" xmlns="http://www.w3.org/2000/svg" style="color:red;">
                      <path
                        d="M10 6.667v6.666M6.667 10h6.666m5 0a8.333 8.333 0 1 1-16.666 0 8.333 8.333 0 0 1 16.666 0Z"
                        stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
                    </svg>
                  </b-button>
                </span>
              </td>
            </tr>
          </tbody>
          

          <tbody id="mytest_2">
            <tr style="margin-bottom: 20px">
              <td cols="11">
                <b-form-input id="holder" placeholder="내용 입력..." required style="border: none"></b-form-input>
              </td>
              <td cols="1">
                <span id="delete" style="vertical-align: middle;">
                  <b-button size="sm" style="border:none; background:none; padding: 0px 0px" @click="deleteRow()">
                    <svg width="20" height="20" fill="none" xmlns="http://www.w3.org/2000/svg">
                      <path d="M6.667 10h6.666m5 0a8.333 8.333 0 1 1-16.666 0 8.333 8.333 0 0 1 16.666 0Z" stroke="#444"
                        stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
                    </svg>
                  </b-button>
                </span>
              </td>
            </tr>
          </tbody>
        </b-table-simple> -->
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
        <b-button text @click="submit" style="color: #453535; background-color: #e1d3d2; border: none">등록</b-button>
      </b-container>
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
    // addRow() {
    // var tbody = document.getElementById('mytest_2');
    // var row = tbody.insertRow(tbody.rows.length); // 하단에 추가
    // var cell1 = row.insertCell(0);
    // var cell2 = row.insertCell(1);
    // cell1.innerHTML = document.getElementById('holder').outerHTML;
    // cell2.innerHTML = document.getElementById('delete').outerHTML;
    // },

    // deleteRow() {
    // var tbody = document.getElementById('mytest_2');
    // tbody.deleteRow(this.row);

    //   //   let field=document.getElementById('mytest');
    //   //   const text = document.getElementById('add');
    //   //   text.innerHTML =`
    //   //   <b-table-simple>
    //   //   <tbody id="mytest_2">
    //   //       <tr style="margin-bottom: 20px">
    //   //         <td cols="11">
    //   //           <b-form-input id="holder" placeholder="내용 입력..." required style="border: none"></b-form-input>
    //   //         </td>
    //   //         <td cols="1">
    //   //           <span id="delete" style="vertical-align: middle;">
    //   //             <b-button size="sm" style="border:none; background:none; padding: 0px 0px" @click="deleteRow()">
    //   //               <svg width="20" height="20" fill="none" xmlns="http://www.w3.org/2000/svg">
    //   //                 <path d="M6.667 10h6.666m5 0a8.333 8.333 0 1 1-16.666 0 8.333 8.333 0 0 1 16.666 0Z" stroke="#444"
    //   //                   stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
    //   //               </svg>
    //   //             </b-button>
    //   //           </span>
    //   //         </td>
    //   //       </tr>
    //   //     </tbody>
    //   //     </b-table-simple>          
    //   //     `;

    //   //   const deleteButton = document.getElementById('delete');
    //   //   deleteButton.innerHTML=`
    //   //               <svg width="20" height="20" fill="none" xmlns="http://www.w3.org/2000/svg">
    //   //                 <path d="M6.667 10h6.666m5 0a8.333 8.333 0 1 1-16.666 0 8.333 8.333 0 0 1 16.666 0Z" stroke="#444"
    //   //                   stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
    //   //               </svg>          
    //   //                         `;

        
    //   //   field.appendChild(text)

    //   //   deleteButton.addEventListener('click', (event) => {
    //   //       field.removeChild(event.currentTarget.parentNode)
    //   //   })
    //   // }
    // },
    todosInsert() {
      let todo_content = document.getElementById('todo_content');
      let todos_field = document.getElementById('todosField');
      console.log(todo_content.value);
      console.log(todos_field);
      if(todo_content.value !== '') {
        const item = document.createElement('div')
        // text
        const text = document.createElement('span');
        // 제거하기 버튼
        const deleteButton = document.createElement('a');
                                // <span id="delete" class="material-icons" style="vertical-align: sub; cursor: pointer;">delete</span>
        deleteButton.innerHTML=`
                                <svg id="delete" width="20" height="20" fill="none" xmlns="http://www.w3.org/2000/svg" style="vertical-align: sub; cursor: pointer;">
                                  <path d="M6.667 10h6.666m5 0a8.333 8.333 0 1 1-16.666 0 8.333 8.333 0 0 1 16.666 0Z" stroke="#444"
                                    stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
                                </svg>
                              `;

        text.textContent = todo_content.value
        todo_content.value=''
    
        item.appendChild(text)
        item.appendChild(deleteButton)
        todos_field.appendChild(item)

        deleteButton.addEventListener('click', (event) => {
            todos_field.removeChild(event.currentTarget.parentNode)
        })
        todo_content.value =''
      }
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
  width: 6px;
}
#todosField::-webkit-scrollbar-track {
  background-color: transparent;
}
#todosField::-webkit-scrollbar-thumb {
  border-radius: 3px;
  background-color: gray;
}
#todosField::-webkit-scrollbar-button {
  width: 0;
  height: 0;
}

.wrap-vertical{
  width:58rem; 
  border-color:#a48282; 
  margin-bottom:70px; 
  margin-left: 11px; 
  height: 10rem;
}
ul{
  list-style:none;
}
#tab ul{
  white-space:nowrap; 
  overflow-x: scroll; 
  text-align:center;
}
#tab ul li{
  display:inline-block;
  margin-right: 25px;
  font-family : -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Helvetica, Arial, sans-serif;
  font-size: 14px;
}
</style>