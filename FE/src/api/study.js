//import { apiInstance } from "./index.js";
//const api = apiInstance();
import {api} from "./index.js";

// 날짜별 todolist를 받는다
async function get_todo_list(dates, success, fail) {
  console.log("");
  console.log(dates);
  await api
    .post(`/study/todo_list`, JSON.stringify(dates))
    .then(success)
    .catch(fail);
}

// 날짜별 리스트를 받아온다. (캘린더에 저장할)
async function get_todos(dates, success, fail) {
  console.log("todos 불러오기");
  console.log(dates);
  await api
    .post("/study/todos", JSON.stringify(dates))
    .then(success)
    .catch(fail);
}

async function modify_todo(todo_no, success, fail) {
  console.log("todo 수정");
  await api.put(`/study?todo_no=${todo_no}`).then(success).catch(fail);
}

export { get_todo_list, get_todos, modify_todo };
