import { apiInstance } from "./index.js";

const api = apiInstance();

// 로그인 (수정 완)
async function login(user, success, fail) {
  console.log("로그인 시도");
  console.log(user);
  await api
    .post(`/users/login`, JSON.stringify(user))
    .then(success)
    .catch(fail);
}

// 보류
async function findById(userid, success, fail) {
  console.log("토큰 확인");
  console.log(userid);
  api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
  await api.get(`/userapi/inform/${userid}`).then(success).catch(fail);
}

// 보류
async function getUserInfo(userid, success, fail) {
  api.get(`/userapi/userinfo/${userid}`).then(success).catch(fail);
}

// 회원정보 수정(완)
function modifyMember(user, success, fail) {
  console.log("멤버 수정");
  console.log(user);
  // 수정할 유저 정보 전체를 보낸다.
  api.put(`/users/${user.id}`, JSON.stringify(user)).then(success).catch(fail);
}

// 회원가입
function registMember(user, success, fail) {
  console.log("멤버 등록");
  console.log(user);
  api.post(`/users/signup`, JSON.stringify(user)).then(success).catch(fail);
}
// 회원탈퇴
async function userDelete(userid, success, fail) {
  api.delete(`/users/${userid}`).then(success).catch(fail);
}

// 로그아웃은 필요 없음
// function logout(success, fail)

export { login, findById, getUserInfo, modifyMember, registMember, userDelete };
