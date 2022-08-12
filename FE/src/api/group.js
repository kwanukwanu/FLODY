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

export { get_todo_list };
