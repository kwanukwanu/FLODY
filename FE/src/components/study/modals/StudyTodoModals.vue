<template>
    <b-modal hide-footer id="modal-8" centered no-stacking title="할 일 등록" style="text-align: center">
        <study-todo-modal-items></study-todo-modal-items>
    </b-modal>

    <!-- <h2 style="text-align: center;">목표 등록</h2> -->
    <!-- <b-table-simple>
          <tbody id="mytest">
            <tr style="margin-bottom: 20px">
              <td cols="11">
                <b-form-input id="holder" placeholder="내용 입력..." required style="border: none"></b-form-input>
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
</template>

<script>
import StudyTodoModalItems from "./item/StudyTodoModalItems.vue";
export default {
    components: {
        StudyTodoModalItems,
    }
}
</script>

<style>
</style>