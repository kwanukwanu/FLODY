import { apiInstance } from "./index.js";
const api = apiInstance();

// 로그인 (수정 완)
async function get_todo_list(dates, success, fail) {
  console.log("axios 수행 시작");
  console.log(dates);
  await api.post(``, JSON.stringify(dates)).then(success).catch(fail);
}

// 로그아웃은 필요 없음
// function logout(success, fail)

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
  await api.get(`/group?groNo=${groNo}`, JSON.stringify(groNo)).then(success).catch(fail);
}

// 그룹 추가

// 그룹 수정

// 그룹 삭제
export { get_todo_list, get_group_list_by_userId, get_group_one };
