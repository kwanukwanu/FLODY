<template>
  <b-container>
    <b-card style="max-width:70rem; border-color: #A48282; max-height: 120rem;">
      <b-row>
        <b-col>
          <span style="margin-left:7px; font-size:large; color: #064635; text-align: left;">자유게시판 </span>

          <hr>
          <b-table fixed hover :items="items_popular" class="common">
          </b-table>
          <router-link :to="{name:'boardwrite'}"><div class="pencil"><svg width="24" height="24" fill="none"
              xmlns="http://www.w3.org/2000/svg">
              <path
                d="m2.5 21.5 5.55-2.134c.354-.137.532-.205.698-.294.147-.08.288-.17.42-.273.149-.116.283-.25.552-.52L21 7a2.828 2.828 0 1 0-4-4L5.72 14.28c-.269.269-.403.403-.519.552a3.008 3.008 0 0 0-.273.42c-.089.166-.157.344-.294.699L2.5 21.5Zm0 0 2.058-5.351c.147-.383.221-.574.347-.662a.5.5 0 0 1 .38-.08c.15.028.295.173.585.463l2.26 2.26c.29.29.435.435.464.586a.5.5 0 0 1-.08.379c-.089.126-.28.2-.663.347L2.5 21.5Z"
                stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
            </svg></div></router-link>
        </b-col>
      </b-row>
    </b-card>
    <br>
    <div class="paging">
      <b-button variant="link" style="color: black; text-decoration: none; font-weight: 100;">&lt; </b-button>
      <b-button variant="link" style="color: black; text-decoration: none; font-weight: 100;">1</b-button>
      <b-button variant="link" style="color: black; text-decoration: none; font-weight: 100;">2</b-button>
      <b-button variant="link" style="color: black; text-decoration: none; font-weight: 100;">3</b-button>
      <b-button variant="link" style="color: black; text-decoration: none; font-weight: 100;">4</b-button>
      <b-button variant="link" style="color: black; text-decoration: none; font-weight: 100;">5</b-button>
      <b-button variant="link" style="color: black; text-decoration: none; font-weight: 100;">6</b-button>
      <b-button variant="link" style="color: black; text-decoration: none; font-weight: 100;">7</b-button>
      <b-button variant="link" style="color: black; text-decoration: none; font-weight: 100;">&gt; </b-button>
    </div>
  </b-container>
</template>

<script>
export default {
  data() {
    return {
        items_popular: [
        { '번호': '102', '제목': '오픽 공부 하기 싫다', '글쓴이': 'Super_Mario', '날짜' : '22.07.21', '조회수': '7,799'},
        { '번호': '101', '제목': '삼수 끝의 정보처리기사 합격 후기...', '글쓴이': 'Bat_Man', '날짜' : '22.07.21', '조회수': '8,677'},
        { '번호': '100', '제목': 'toeic speaking honey tip 제공합니다 드루오세요', '글쓴이': 'Cinderellla', '날짜' : '22.07.21', '조회수': '4.1만'},
        { '번호': '99', '제목': '정보보안기사 따면 좋나요?', '글쓴이': 'Brown_Cat', '날짜' : '22.07.21', '조회수': '2.1만'},
        { '번호': '98', '제목': '오픽 보고 왔는데 네 번 연속 IH.. AL 포기 할까요', '글쓴이': 'Oh_My_Boy', '날짜' : '22.07.21', '조회수': '1만'},
        { '번호': '97', '제목': '오픽 공부 하기 싫다ㅜㅜ', '글쓴이': 'Giri_Girl', '날짜' : '22.07.21', '조회수': '7,799' },
        { '번호': '96', '제목': '네트워크는 어려워', '글쓴이': 'science_joa', '날짜' : '22.07.21', '조회수': '811' },
        { '번호': '95', '제목': '토익스피킹 공부하는데 현타가..', '글쓴이': 'Super_Mario', '날짜' : '22.07.21', '조회수': '1,334'},
        { '번호': '94', '제목': '정보보안기사 따면 좋나요?', '글쓴이': 'Bat_man', '날짜' : '22.07.21', '조회수': '2.1만'},
        { '번호': '93', '제목': '오픽 보고 왔는데 네 번 연속 IH..', '글쓴이': 'heo_gak', '날짜' : '22.07.21', '조회수': '1만'},
        { '번호': '92', '제목': 'toeic speaking honey tip 제...', '글쓴이': 'eunji', '날짜' : '22.07.21', '조회수': '4.1만'},
        { '번호': '91', '제목': '오픽 꿀팁!', '글쓴이': 'jaehyuni', '날짜' : '22.07.21', '조회수': '1만'},
        { '번호': '90', '제목': '토익스피킹 나만의 꿀팁..', '글쓴이': 'sehan', '날짜' : '22.07.21', '조회수': '3만'},
        { '번호': '89', '제목': '정보보안기사 꿀팁입니다', '글쓴이': 'kyojun', '날짜' : '22.07.21', '조회수': '2만'},
        { '번호': '88', '제목': '한능검 꿀팁 드려요', '글쓴이': 'aeri', '날짜' : '22.07.21', '조회수': '5,444'},
        { '번호': '87', '제목': '오픽 세 번 만의 AL 달성 후기', '글쓴이': 'jonghwan', '날짜' : '22.07.21', '조회수': '1,799'},
      ]     
  }
  }
}
</script>

<style>
.common{
  margin-bottom: 1.8rem;
  border-color: #e4dada;
  max-width: 70rem; 
}
.pencil{
  text-align: right;
}
.paging{
  text-align: center;
}
</style>