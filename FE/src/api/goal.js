//import { apiInstance } from "./index.js";
//const api = apiInstance();
import { api } from "./index.js";

// 로그인 (수정 완)
async function get_goals(success, fail) {
  await api.get(`/user/goals`).then(success).catch(fail);
}

async function get_goals_date(date, success, fail) {
  await api.get(`/user/daygoals?date=${date}`).then(success).catch(fail);
}

async function get_schedules_date(date, success, fail) {
  await api.get(`/user/dayschedules?date=${date}`).then(success).catch(fail);
}

async function get_schedules_month(date, success, fail) {
  await api.get(`/user/monthschedules?date=${date}`).then(success).catch(fail);
}

async function get_goal_one(userNo, success, fail) {
  console.log(userNo);
  await api.get(`/user/goal?ugNo=${userNo}`).then(success).catch(fail);
}

async function add_goal(goal, success, fail) {
  console.log(goal);
  await api.post(`/user/goal`, JSON.stringify(goal)).then(success).catch(fail);
}

async function modify_goal(request, success, fail) {
  console.log(request);
  await api
    .put(`/user/goal?ugNo=${request.no}`, JSON.stringify(request.goal))
    .then(success)
    .catch(fail);
}

async function delete_goal(ugNo, success, fail) {
  console.log(ugNo);
  await api.delete(`/user/goal?ugNo=${ugNo}`).then(success).catch(fail);
}

export {
  get_goals,
  get_goals_date,
  get_schedules_date,
  get_schedules_month,
  get_goal_one,
  add_goal,
  modify_goal,
  delete_goal,
};
