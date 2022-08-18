import {api} from "./index.js";

// 자격증 검색 목록
async function get_license_list(licenseInfo, success, fail) {
  console.log("get_license_list의 axios 수행 시작");
  console.log(licenseInfo);
  await api.get(`/licenses?fldnm=${licenseInfo.fldnm}&mfldnm=${licenseInfo.mfldnm}&category=${licenseInfo.category}&keyword=${licenseInfo.keyword}`)
  .then(success)
  .catch(fail);
}

// 대분류 목록
async function get_license_fields(success, fail) {
  console.log("get_license_field의 axios 수행 시작");
  await api.get(`/license/fields`).then(success).catch(fail);
}

// 중분류 목록
async function get_license_middle_fields(fldnm, success, fail) {
  console.log("get_license_middle_fields의 axios 수행 시작");
  console.log(fldnm);
  await api.get(`/license/mfields?fldnm=${fldnm}`).then(success).catch(fail);
}
export {
  get_license_list,
  get_license_fields,
  get_license_middle_fields
}