import { apiInstance } from "./index.js";
const api = apiInstance();

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

// 유저 스케줄 목록 : doc.13
async function get_schedules(userId, success, fail) {
  console.log("목표 가져오기");
  console.log(userId);
  await api
    .get(`/user/schedules`, JSON.stringify(userId))
    .then(success)
    .catch(fail);
}

// 단일 스케줄 조회
async function get_schedule_one(usNo, success, fail) {
  console.log("단일 스케줄 조회");
  console.log(usNo);
  await api.get(`/user/schedule?usNo=${usNo}`).then(success).catch(fail);
}

// 스케줄 추가
async function add_schedule(token, success, fail) {
  console.log("스케줄 추가");
  console.log(token);
  await api
    .post(`/user/schedule`, JSON.stringify(token))
    .then(success)
    .catch(fail);
}

// 스케줄 수정
async function modify_schedule(usNo, goals, success, fail) {
  console.log("목표 수정하기");
  console.log(usNo);
  console.log(goals);
  await api
    .put(`/user/schedule?usNo=${usNo}`, JSON.stringify(goals))
    .then(success)
    .catch(fail);
}

// 스케줄 삭제
async function delete_schedule(usNo, success, fail) {
  console.log("목표 삭제하기");
  await (await api.delete(`/user/schedule?usNo=${usNo}`))
    .then(success)
    .catch(fail);
}

export {
  get_todo_list,
  get_todos,
  modify_todo,
  get_schedules,
  get_schedule_one,
  add_schedule,
  modify_schedule,
};
