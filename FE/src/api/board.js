import { apiInstance } from "./index.js";
const api = apiInstance();

// boardList를 받아온다.
async function get_boardList(page, success, fail) {
  console.log(page);
  await api.get(``, JSON.stringify(page)).then(success).catch(fail);
}

async function get_board(board_no, success, fail) {
  console.log(board_no);
  await api.get(``, JSON.stringify(board_no)).then(success).catch(fail);
}

export { get_boardList, get_board };
