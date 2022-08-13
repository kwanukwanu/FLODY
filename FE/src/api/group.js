import { apiInstance } from "./index.js";
const api = apiInstance();

// 날짜별 todolist를 받는다 (년, 월 을 받는다)
async function get_todo_list(dates, success, fail) {
  console.log("");
  console.log(dates);
  await api
    .post(`/group/todo_list`, JSON.stringify(dates))
    .then(success)
    .catch(fail);
}

// 날짜별 리스트를 받아온다.
async function get_todos(dates, success, fail) {
  console.log("todos 불러오기");
  console.log(dates);
  await api
    .post("/group/todos", JSON.stringify(dates))
    .then(success)
    .catch(fail);
}

// todo 수정
async function modify_todo(todo_no, success, fail) {
  console.log("todo 수정");
  await api.put(`/group?todo_no=${todo_no}`).then(success).catch(fail);
}

// 로그인 그룹 목록 조회
async function get_group_list_by_userId(userId, success, fail) {
  console.log("axios 수행 시작");
  console.log(userId);
  await api.get(`/groups`, JSON.stringify(userId)).then(success).catch(fail);
}

// 단일 그룹 목록 조회
async function get_group_one(groNo, success, fail) {
  console.log("axios 수행 시작");
  console.log(groNo);
  await api
    .get(`/group?groNo=${groNo}`, JSON.stringify(groNo))
    .then(success)
    .catch(fail);
}

// 그룹 추가

// 그룹 수정

// 그룹 삭제
export {
  get_todo_list,
  get_todos,
  modify_todo,
  get_group_list_by_userId,
  get_group_one,
};
