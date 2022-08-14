import { apiInstance } from "./index.js";
const api = apiInstance();

// 로그인 (수정 완)
async function getcomments(pidNo, success, fail) {
  console.log(pidNo);
  await api.post(`/newspid/comments?pidNo=${pidNo}`).then(success).catch(fail);
}

export { getcomments };
