//import { apiInstance } from "./index.js";
//const api = apiInstance();
import { api } from "./index.js";

// 유저 스케줄 목록 : doc.13
async function get_schedules(token, success, fail) {
  console.log("스케줄 목록");
  console.log(token);
  await api.get(`/user/schedules`).then(success).catch(fail);
}

// 단일 스케줄 조회
async function get_schedule_one(usNo, success, fail) {
  console.log("단일 스케줄 조회");
  console.log(usNo);
  await api.get(`/user/schedule?usNo=${usNo}`).then(success).catch(fail);
}

// 스케줄 추가
async function add_schedule(schedule, success, fail) {
  console.log("스케줄 추가");
  await api
    .post(`/user/schedule`, JSON.stringify(schedule))
    .then(success)
    .catch(fail);
}

async function get_user_schedule_ofMonth(date, success, fail) {
  console.log("스케줄 불러오기");
  await api
    .post(`/user/monthschedules`, JSON.stringify(date))
    .then(success)
    .catch(fail);
}

async function get_user_schedule_ofDay(date, success, fail) {
  console.log("스케줄 불러오기(일)");
  await api.post(`/user/dayschedules?date=${date}`).then(success).catch(fail);
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
  get_schedules,
  get_schedule_one,
  add_schedule,
  modify_schedule,
  delete_schedule,
  get_user_schedule_ofDay,
  get_user_schedule_ofMonth,
};
