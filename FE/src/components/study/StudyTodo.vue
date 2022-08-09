<template>
  <b-card style="border-color: #a48282; max-width: 35rem; height:304px; overflow-y: scroll;">
          <b-row>
            <b-col cols="10">
              <span
                style="text-align:left; font-weight:bold; font-size: large; vertical-align:-webkit-baseline-middle;">Todo
                List</span>
            </b-col>
            <b-col cols="2">
              <span style="text-align:right;">
                <b-button size="sm" style="background-color:white; border-color:white;" v-b-modal.modal-8><svg
                    width="24" height="24" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path d="M12 5v14m-7-7h14" stroke="#444" stroke-width="2" stroke-linecap="round"
                      stroke-linejoin="round" />
                  </svg></b-button>
              </span>
            </b-col>
          </b-row>
          <hr />
          <ul style="list-style-type :none;">
            <li>
              <div class="checkbox">
                <input type="checkbox" name="packersOff" id="packers" value="1" />
                <label for="packers" class="strikethrough">&nbsp;네트워크 뽀사기</label>
              </div>
            </li>
            <li>
              <div class="checkbox">
                <input type="checkbox" name="packersOff" id="packers_2" value="2" />
                <label for="packers_2" class="strikethrough">&nbsp;보안 유형 정복</label>
              </div>
            </li>
            <li>
              <div class="checkbox">
                <input type="checkbox" name="packersOff" id="packers_3" value="3" />
                <label for="packers_3" class="strikethrough">&nbsp;21년 2회차 실기 풀이</label>
              </div>
            </li>
            <li>
              <div class="checkbox">
                <input type="checkbox" name="packersOff" id="packers_4" value="4" />
                <label for="packers_4" class="strikethrough">&nbsp;java 뽀사기</label>
              </div>
            </li>
            <li>
              <div class="checkbox">
                <input type="checkbox" name="packersOff" id="packers_5" value="5" />
                <label for="packers_5" class="strikethrough">&nbsp;python 유형 정복</label>
              </div>
            </li>
            <li>
              <div class="checkbox">
                <input type="checkbox" name="packersOff" id="packers_6" value="6" />
                <label for="packers_6" class="strikethrough">&nbsp;22년 2회차 실기 풀이</label>
              </div>
            </li>
            <li>
              <div class="checkbox">
                <input type="checkbox" name="packersOff" id="packers_7" value="7" />
                <label for="packers_7" class="strikethrough">&nbsp;3차 스터디 회의</label>
              </div>
            </li>

          </ul>
        </b-card>

         <b-modal hide-footer id="modal-8" centered no-stacking title="할 일 등록" style="text-align: center">
    <b-card style="min-height: 12rem; max-width: 30rem; background-color: #f8f3f3">
      <b-container ref="form">
        <!-- <h2 style="text-align: center;">목표 등록</h2> -->
        <b-row style="margin-bottom: 20px">
          <b-col cols="11">
            <b-form-input placeholder="내용 입력..." required style="border: none"></b-form-input>
          </b-col>
          <b-col cols="1">
            <span style="vertical-align: middle;">
              <b-button size="sm" style="border:none; background:none; padding: 0px 0px">
                <svg width="20" height="20" fill="none" xmlns="http://www.w3.org/2000/svg">
                  <path d="M10 6.667v6.666M6.667 10h6.666m5 0a8.333 8.333 0 1 1-16.666 0 8.333 8.333 0 0 1 16.666 0Z"
                    stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
                </svg>
              </b-button>
            </span>
          </b-col>
        </b-row>

        <b-row style="margin-bottom: 20px">
          <b-col cols="11">
            <b-form-input placeholder="내용 입력..." required style="border: none"></b-form-input>
          </b-col>
          <b-col cols="1">
            <span style="vertical-align: middle;">
              <b-button size="sm" style="border:none; background:none; padding: 0px 0px">
                <svg width="20" height="20" fill="none" xmlns="http://www.w3.org/2000/svg">
                  <path d="M10 6.667v6.666M6.667 10h6.666m5 0a8.333 8.333 0 1 1-16.666 0 8.333 8.333 0 0 1 16.666 0Z"
                    stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
                </svg>
              </b-button>
            </span>
          </b-col>
        </b-row>

        <b-row style="margin-bottom: 20px">
          <b-col cols="11">
            <b-form-input placeholder="내용 입력..." required style="border: none"></b-form-input>
          </b-col>
          <b-col cols="1">
            <span style="vertical-align: middle;">
              <b-button size="sm" style="border:none; background:none; padding: 0px 0px">
                <svg width="20" height="20" fill="none" xmlns="http://www.w3.org/2000/svg">
                  <path d="M10 6.667v6.666M6.667 10h6.666m5 0a8.333 8.333 0 1 1-16.666 0 8.333 8.333 0 0 1 16.666 0Z"
                    stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
                </svg>
              </b-button>
            </span>
          </b-col>
        </b-row>

        <b-row style="margin-bottom: 20px">
          <b-col cols="11">
            <b-form-input placeholder="내용 입력..." required style="border: none"></b-form-input>
          </b-col>
          <b-col cols="1">
            <span style="vertical-align: middle;">
              <b-button size="sm" style="border:none; background:none; padding: 0px 0px">
                <svg width="20" height="20" fill="none" xmlns="http://www.w3.org/2000/svg">
                  <path d="M10 6.667v6.666M6.667 10h6.666m5 0a8.333 8.333 0 1 1-16.666 0 8.333 8.333 0 0 1 16.666 0Z"
                    stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
                </svg>
              </b-button>
            </span>
          </b-col>
        </b-row>

        <b-row style="margin-bottom: 20px">
          <b-col cols="11">
            <b-form-input placeholder="내용 입력..." required style="border: none"></b-form-input>
          </b-col>
          <b-col cols="1">
            <span style="vertical-align: middle;">
              <b-button size="sm" style="border:none; background:none; padding: 0px 0px">
                <svg width="20" height="20" fill="none" xmlns="http://www.w3.org/2000/svg">
                  <path d="M10 6.667v6.666M6.667 10h6.666m5 0a8.333 8.333 0 1 1-16.666 0 8.333 8.333 0 0 1 16.666 0Z"
                    stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
                </svg>
              </b-button>
            </span>
          </b-col>
        </b-row>
        <!-- <b-row style="margin-bottom: 20px">
          <b-col cols="2">
            <span style="vertical-align:middle; font-weight: bold;">시작</span>
          </b-col>
          <b-col cols="4">
            <input type="time" value="xxx" min="yyy" max="zzz">
          </b-col>
          <b-col cols="2">
            <span style="vertical-align:middle; font-weight: bold;">종료</span>
          </b-col>
          <b-col cols="4">
            <input type="time" value="xxx" min="yyy" max="zzz">
          </b-col>
        </b-row> -->
        <!-- <b-row>
          <b-col>
            <b-form-textarea id="content" placeholder="내용 입력..." rows="7" max-rows="15" required style="border: none">
            </b-form-textarea>
          </b-col>
        </b-row> -->
        <br />
        <b-button text @click="submit" style="color: #453535; background-color: #e1d3d2; border: none">등록</b-button>
      </b-container>
      <br />
    </b-card>
  </b-modal>
</template>

<script>
export default {

}
</script>

<style>
.checkbox{
  accent-color: #E3D6D6;
}
</style>