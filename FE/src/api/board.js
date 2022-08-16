import { apiInstance } from "./index.js";
const api = apiInstance();

// category별 게시글을 받아온다.
async function get_boardList(category, success, fail) {
  console.log("get_boardList의 axios 수행 시작");
  console.log(category);
  await api.get(`/posts?category=${category}`).then(success).catch(fail);
}

// 단일 게시글 조회
async function get_board(posNo, success, fail) {
  console.log("get_board의 axios 수행 시작");
  console.log(posNo);
  await api
    .get(`/post?posNo=${posNo}`, JSON.stringify(posNo))
    .then(success)
    .catch(fail);
}

// 게시글 추가
async function regist_board(boardInfo, success, fail) {
  console.log("regist_board의 axios 수행 시작");
  console.log(boardInfo);
  await api.post(`/post`, JSON.stringify(boardInfo)).then(success).catch(fail);
}

// 게시글 수정
async function modify_board(boardInfo, success, fail) {
  console.log("modify_board의 axios 수행 시작");
  console.log(boardInfo);
  await api.put(`/post`, JSON.stringify(boardInfo)).then(success).catch(fail);
}

// 게시글 삭제
async function delete_board(posNo, success, fail) {
  console.log("delete_board의 axios 수행 시작");
  console.log(posNo);
  await api.delete(`/post?posNo=${posNo}`).then(success).catch(fail);
}

// 댓글 목록
async function get_comments(posNo, success, fail) {
  console.log("get_comments의 axios 수행 시작");
  console.log(posNo);
  await api
    .get(`/commnets?posNo=${posNo}`, JSON.stringify(posNo))
    .then(success)
    .catch(fail);
}

// 댓글 추가
async function regist_comment(commentInfo, success, fail) {
  console.log("regist_comment의 axios 수행 시작");
  console.log(commentInfo);
  await api
    .post(`/comment`, JSON.stringify(commentInfo))
    .then(success)
    .catch(fail);
}

// 댓글 수정
async function modify_comment(commentInfo, success, fail) {
  console.log("modify_comment의 axios 수행 시작");
  console.log(commentInfo);
  await api
    .put(`/comment`, JSON.stringify(commentInfo))
    .then(success)
    .catch(fail);
}

// 댓글 삭제
async function delete_comment(comNo, success, fail) {
  console.log("delete_comment의 axios 수행 시작");
  console.log(comNo);
  await api.delete(`/comment?comNo=${comNo}`).then(success).catch(fail);
}

export {
  get_boardList,
  get_board,
  regist_board,
  modify_board,
  delete_board,
  get_comments,
  regist_comment,
  modify_comment,
  delete_comment,
};
