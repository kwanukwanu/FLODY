<template>
  <b-container>
    <b-card style="max-width:70rem; border-color: #A48282; max-height: 22rem;">
      <b-row>
        <b-col>
          <span style="margin-left:7px; font-size:large; color: #064635; text-align: left;">오늘의 인기글 </span>
          <router-link :to="{name:'boardlist'}"><svg id="move" width="18" height="18" fill="none"
              xmlns="http://www.w3.org/2000/svg">
              <path
                d="m9 12 3-3m0 0L9 6m3 3H6m-.15 6.75h6.3c1.26 0 1.89 0 2.371-.245.424-.216.768-.56.984-.984.245-.48.245-1.11.245-2.371v-6.3c0-1.26 0-1.89-.245-2.371a2.25 2.25 0 0 0-.984-.984c-.48-.245-1.11-.245-2.371-.245h-6.3c-1.26 0-1.89 0-2.371.245a2.25 2.25 0 0 0-.984.984c-.245.48-.245 1.11-.245 2.371v6.3c0 1.26 0 1.89.245 2.371.216.424.56.768.984.984.48.245 1.11.245 2.371.245Z"
                stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
            </svg></router-link>
          <hr>
          <b-table fixed hover :items="items_popular" class="popular_and_review">
          </b-table>
        </b-col>
      </b-row>
    </b-card>
<br>
    <b-row>

      <b-col>
        <b-card style="max-width:35rem; border-color: #A48282; max-height: 22rem;">
          <span style="margin-left:7px; font-size:large; color: #064635; text-align: left;">자유게시판 </span>
          <router-link :to="{name:'boardlist'}"><svg id="move" width="18" height="18" fill="none"
              xmlns="http://www.w3.org/2000/svg">
              <path
                d="m9 12 3-3m0 0L9 6m3 3H6m-.15 6.75h6.3c1.26 0 1.89 0 2.371-.245.424-.216.768-.56.984-.984.245-.48.245-1.11.245-2.371v-6.3c0-1.26 0-1.89-.245-2.371a2.25 2.25 0 0 0-.984-.984c-.48-.245-1.11-.245-2.371-.245h-6.3c-1.26 0-1.89 0-2.371.245a2.25 2.25 0 0 0-.984.984c-.245.48-.245 1.11-.245 2.371v6.3c0 1.26 0 1.89.245 2.371.216.424.56.768.984.984.48.245 1.11.245 2.371.245Z"
                stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
            </svg></router-link>
          <hr>
          <b-table fixed hover :items="items_free" class="free_and_honey">
          </b-table>
        </b-card>
      </b-col>

      <b-col>
        <b-card style="max-width:35rem; border-color: #A48282; max-height: 22rem;">
          <span style="margin-left:7px; font-size:large; color: #064635; text-align: left;">공부 꿀팁 </span>
          <router-link :to="{name:'boardlist'}"><svg id="move" width="18" height="18" fill="none"
              xmlns="http://www.w3.org/2000/svg">
              <path
                d="m9 12 3-3m0 0L9 6m3 3H6m-.15 6.75h6.3c1.26 0 1.89 0 2.371-.245.424-.216.768-.56.984-.984.245-.48.245-1.11.245-2.371v-6.3c0-1.26 0-1.89-.245-2.371a2.25 2.25 0 0 0-.984-.984c-.48-.245-1.11-.245-2.371-.245h-6.3c-1.26 0-1.89 0-2.371.245a2.25 2.25 0 0 0-.984.984c-.245.48-.245 1.11-.245 2.371v6.3c0 1.26 0 1.89.245 2.371.216.424.56.768.984.984.48.245 1.11.245 2.371.245Z"
                stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
            </svg></router-link>
          <hr>
          <b-table fixed hover :items="items_honey" class="free_and_honey">
          </b-table>
        </b-card>
      </b-col>
    </b-row>
    <br>
        <b-card style="max-width:70rem; border-color: #A48282; max-height: 22rem;">
    <b-row>
      <b-col>
        <span style="margin-left:7px; font-size:large; color: #064635; text-align: left;">합격 후기 </span>
        <router-link :to="{name:'boardlist'}"><svg id="move" width="18" height="18" fill="none"
            xmlns="http://www.w3.org/2000/svg">
            <path
              d="m9 12 3-3m0 0L9 6m3 3H6m-.15 6.75h6.3c1.26 0 1.89 0 2.371-.245.424-.216.768-.56.984-.984.245-.48.245-1.11.245-2.371v-6.3c0-1.26 0-1.89-.245-2.371a2.25 2.25 0 0 0-.984-.984c-.48-.245-1.11-.245-2.371-.245h-6.3c-1.26 0-1.89 0-2.371.245a2.25 2.25 0 0 0-.984.984c-.245.48-.245 1.11-.245 2.371v6.3c0 1.26 0 1.89.245 2.371.216.424.56.768.984.984.48.245 1.11.245 2.371.245Z"
              stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
          </svg></router-link>
        <hr>
        <b-table fixed hover :items="items_review" class="popular_and_review">
        </b-table>
      </b-col>
    </b-row>
    </b-card>
  </b-container>
</template>

<script>
export default {
  data() {
    return {
        items_popular: [
        { '제목': '자유 | 오픽 공부 하기 싫다', '조회수': '7,799'},
        { '제목': '후기 | 삼수 끝의 정보처리기사 합격 후기...', '조회수': '8,677'},
        { '제목': '꿀팁 | toeic speaking honey tip 제공합니다 드루오세요', '조회수': '4.1만'},
        { '제목': '자유 | 정보보안기사 따면 좋나요?', '조회수': '2.1만'},
        { '제목': '자유 | 오픽 보고 왔는데 네 번 연속 IH.. AL 포기 할까요', '조회수': '1만'},
        ],
        items_free: [
        { '제목': '오픽 공부 하기 싫다ㅜㅜ', '조회수': '7,799' },
        { '제목': '네트워크는 어려워', '조회수': '811' },
        { '제목': '토익스피킹 공부하는데 현타가..', '조회수': '1,334'},
        { '제목': '정보보안기사 따면 좋나요?', '조회수': '2.1만'},
        { '제목': '오픽 보고 왔는데 네 번 연속 IH..', '조회수': '1만'},
        ],
        items_honey: [
        { '제목': 'toeic speaking honey tip 제...', '조회수': '4.1만'},
        { '제목': '오픽 꿀팁!', '조회수': '1만'},
        { '제목': '토익스피킹 나만의 꿀팁..', '조회수': '3만'},
        { '제목': '정보보안기사 꿀팁입니다', '조회수': '2만'},
        { '제목': '한능검 꿀팁 드려요', '조회수': '5,444'},
        ],
        items_review: [
        { '제목': '오픽 세 번 만의 AL 달성 후기', '조회수': '1,799'},
        { '제목': '삼수 끝의 정보처리기사 합격 후기...', '조회수': '8,677'},
        { '제목': '정보보안기사 합격 후기입니다.', '조회수': '4,001'},
        { '제목': '토익스피킹 레벨 7 생생 후기!', '조회수': '3,221'},
        { '제목': '임상심리사 합격 후기', '조회수': '1,211'},
      ]     
  }
  }
}

</script>

<style>
.popular_and_review{
  margin-bottom: 1.8rem;
  border-color: #e4dada;
  max-width: 70rem; 
  max-height: 12rem;
}
.free_and_honey{
  margin-bottom: 1.8rem;
  border-color: #e4dada;
  max-width: 32rem; 
  max-height: 12rem
}
</style>