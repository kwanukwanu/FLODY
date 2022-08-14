import { apiInstance } from "./index.js";
const api = apiInstance();

// 날짜별 todolist를 받는다 (년, 월 을 받는다)
async function get_todo_list(dates, success, fail) {
  console.log("");
  console.log(dates);
  await api
    .post(`/group/todo_list`, JSON.stringify(dates))
    .then(success)
    .catch(fail);
}

// 날짜별 리스트를 받아온다.
async function get_todos(dates, success, fail) {
  console.log("todos 불러오기");
  console.log(dates);
  await api
    .post("/group/todos", JSON.stringify(dates))
    .then(success)
    .catch(fail);
}

// todo 수정
async function modify_todo(todo_no, success, fail) {
  console.log("todo 수정");
  await api.put(`/group?todo_no=${todo_no}`).then(success).catch(fail);
}

// 로그인 그룹 목록 조회
async function get_group_list_by_userId(userId, success, fail) {
  console.log("axios 수행 시작");
  console.log(userId);
  await api.get(`/groups?userId=${userId}`, JSON.stringify(userId)).then(success).catch(fail);
}

// 단일 그룹 목록 조회
async function get_group_one(groNo, success, fail) {
  console.log("axios 수행 시작");
  console.log(groNo);
  await api
    .get(`/group?groNo=${groNo}`, JSON.stringify(groNo)).then(success).catch(fail);
}

// 그룹 추가
async function insert_group(name, success, fail) {
  console.log("axios 수행 시작");
  console.log(name);
  await api.post(`/group`, JSON.stringify(name)).then(success).catch(fail);
}

// 그룹 수정
async function modify_group(groupInfo, success, fail) {
  console.log("axios 수행 시작");
  console.log(groupInfo);
  await api.put(`/group`, JSON.stringify(groupInfo)).then(success).catch(fail);
}

// 그룹 삭제
async function delete_group(groNo, success, fail) {
  console.log("axios 수행 시작");
  console.log(groNo);
  await api.delete(`/group?groNo=${groNo}`).then(success).catch(fail);
}

// 그룹 내 멤버 전체 목록 조회
async function get_group_member_list_by_groNo(groNo, success, fail) {
  console.log("axios 수행 시작");
  console.log(groNo);
  await api.get(`/group/members?groNo=${groNo}`, JSON.stringify(groNo)).then(success).catch(fail);
}

// 그룹 내 단일 멤버 조회
async function get_group_member_one(gmNo, success, fail) {
  console.log("axios 수행 시작");
  console.log(gmNo);
  await api.get(`/group/member?gmNo=${gmNo}`, JSON.stringify(gmNo)).then(success).catch(fail);
}

// 그룹 내 멤버 추가
async function insert_group_member(memberInfo, success, fail) {
  console.log("axios 수행 시작");
  console.log(memberInfo);
  await api.post(`/group/member`, JSON.stringify(memberInfo)).then(success).catch(fail);
}

// 그룹 내 멤버 수정
async function modify_group_member(memberInfo, success, fail) {
  console.log("axios 수행 시작");
  console.log(memberInfo);
  await api.put(`/group/member`, JSON.stringify(memberInfo)).then(success).catch(fail);
}

// 명세서에 groNo로 삭제한다고 되어 있어서 groNo로 코드 작성했지만
// 그룹 내 멤버 번호는 gmNo여서 명세서에 오타라고 생각됨
// 그룹 내 멤버 삭제
async function delete_group_member(groNo, success, fail) {
  console.log("axios 수행 시작");
  console.log(groNo);
  await api.delete(`/group/member?groNo=${groNo}`).then(success).catch(fail);
}

export {
  get_todo_list,
  get_todos,
  modify_todo,
  get_group_list_by_userId,
  get_group_one,
  insert_group,
  modify_group,
  delete_group,
  get_group_member_list_by_groNo,
  get_group_member_one,
  insert_group_member,
  modify_group_member,
  delete_group_member
};
