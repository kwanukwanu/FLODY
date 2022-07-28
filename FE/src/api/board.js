import { apiInstance } from "./index.js";

const api = apiInstance();

function listArticle(param, success, fail) {
  //api.get(`/boardapi/`, { params: param }).then(success).catch(fail);
  api
    .get(`/boardapi/keyword=${param.key}&nowPage=${param.pg}`)
    .then(success)
    .catch(fail);
}

function pagingListArticle(param, success, fail) {
  api
    .get(`/boardapi/keyword=${param.key}&nowPage=${param.pg}`, {
      params: param,
    })
    .then(success)
    .catch(fail);
}

function writeArticle(article, success, fail) {
  api.post(`/boardapi/`, JSON.stringify(article)).then(success).catch(fail);
}

function getArticle(articleno, success, fail) {
  api.get(`/boardapi/num=${articleno}`).then(success).catch(fail);
}

function modifyArticle(article, success, fail) {
  console.log("수정");
  api
    .put(`/boardapi/update/`, JSON.stringify(article))
    .then(success)
    .catch(fail);
}

function searchArticle(keyword, success, fail) {
  api.get(`/boardapi/search/${keyword}`).then(success).catch(fail);
}

function deleteArticle(articleno, success, fail) {
  api.delete(`/boardapi/delete/${articleno}`).then(success).catch(fail);
}

export {
  listArticle,
  writeArticle,
  getArticle,
  modifyArticle,
  deleteArticle,
  searchArticle,
  pagingListArticle,
};
