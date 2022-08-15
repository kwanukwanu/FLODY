import { apiInstance } from "./index.js";
const api = apiInstance();

// 로그인 (수정 완)
async function get_goals(token, success, fail) {
  console.log(token);
  await api.post(`/user/goal`).then(success).catch(fail);
}

async function get_goal_one(userNo, success, fail) {
  console.log(userNo);
  await api.get(`/user/goal?ugNo=${userNo}`).then(success).catch(fail);
}

async function add_goal(token, goal, success, fail) {
  console.log(token);
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

export { get_goals, get_goal_one, add_goal, modify_goal, delete_goal };
