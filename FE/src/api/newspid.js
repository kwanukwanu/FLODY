import { apiInstance } from "./index.js";
const api = apiInstance();

// 로그인 (수정 완)
async function getcomments(pidNo, success, fail) {
  console.log(pidNo);
  await api.post(`/newspid/comments?pidNo=${pidNo}`).then(success).catch(fail);
}

async function addcomments(comments, success, fail) {
  console.log("콘솔 추가");
  console.log(comments);
  await api
    .post(`/newspid/comments`, JSON.stringify(comments))
    .then(success)
    .catch(fail);
}

export { getcomments, addcomments };
