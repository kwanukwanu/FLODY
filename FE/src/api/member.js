// import { apiInstance } from "./index.js";

// const api = apiInstance();

// // 로그인
// async function login(user, success, fail) {
//   console.log(user);

//   await api
//     .post(`/userapi/login`, JSON.stringify(user))
//     .then(success)
//     .catch(fail);
// }

// // 아이디 탐색
// async function findById(userid, success, fail) {
//   console.log("토큰 확인");
//   console.log(userid);
//   api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");

//   await api.get(`/userapi/inform/${userid}`).then(success).catch(fail);
// }

// // 유저정보 획득
// async function getUserInfo(userid, success, fail) {
//   api.get(`/userapi/userinfo/${userid}`).then(success).catch(fail);
// }

// function modifyMember(user, success, fail) {
//   console.log("멤버 수정");
//   console.log(user);

//   api.put(`/userapi/update/`, JSON.stringify(user)).then(success).catch(fail);
// }

// function registMember(user, success, fail) {
//   console.log("멤버 등록");
//   console.log(user);

//   api.post(`/userapi/regist/`, JSON.stringify(user)).then(success).catch(fail);
// }

// // 멤버 삭제
// async function userDelete(userid, success, fail) {
//   api.delete(`/userapi/delete/${userid}/`).then(success).catch(fail);
// }

// // function logout(success, fail)

// export { login, findById, getUserInfo, modifyMember, registMember, userDelete };
