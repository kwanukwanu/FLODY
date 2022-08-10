import { apiInstance } from "./index.js";
const api = apiInstance();

// 로그인 (수정 완)
async function login(user, success, fail) {
  console.log(user);
  await api
    .post(`/user/login`, JSON.stringify(user))
    .then(success)
    .catch(fail);
}

// 유저 목록 받아오기
async function findById(success, fail) {
  console.log("findById");
  await api.get(`/users`).then(success).catch(fail);
}

// 회원정보 받아오기
async function getUserInfo(userid, success, fail) {
  console.log("getUserInfo");
  await api.get(`/user/${userid}`).then(success).catch(fail);
}

// 중복확인
async function userIdDuplicated(userid, success, fail) {
  api.get(`/user/checkEmail/${userid}`).then(success).catch(fail);
}

// 회원정보 수정(완)
function modifyMember(user, success, fail) {
  console.log("멤버 수정");
  console.log(user);
  // 수정할 유저 정보 전체를 보낸다.
  api.put(`/user`, JSON.stringify(user)).then(success).catch(fail);
}

// 회원가입
async function registMember(user, success, fail) {
  console.log("멤버 등록");
  console.log(user);
  await api.post(`/user`, JSON.stringify(user)).then(success).catch(fail);
}
// 회원탈퇴
async function userDelete(userid, success, fail) {
  api.delete(`/user/${userid}`).then(success).catch(fail);
}

// 로그아웃은 필요 없음
// function logout(success, fail)

export { login, findById, userIdDuplicated, getUserInfo, modifyMember, registMember, userDelete };
