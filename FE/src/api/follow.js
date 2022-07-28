import { apiInstance } from "./index.js";

const api = apiInstance();

function listInterest(userid, success, fail) {
  //#### Spring의 api구문에 따라 수정한다.
  //api.get(`/interestapi/list/${userid}`).then(success).catch(fail);
}
function deleteInterest(params, success, fail) {
  //api.get(`/boardapi/`, { params: param }).then(success).catch(fail);
  /*
  api
    .delete(`/interestapi/delete/no=${params.no}&id=${params.id}`)
    .then(success)
    .catch(fail);
  */
}

export { listInterest, deleteInterest };
