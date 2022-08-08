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