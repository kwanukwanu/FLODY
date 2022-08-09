<template>
  <!-- <h2>flower</h2> -->
  <!-- <img src="@/assets/flower1_1.png" class="w-25" style="height: 240px; width: 200px; border: solid 3px; border-radius: 100%; border-color: green;"/>
  <img src="@/assets/flower2_1.png" class="w-25" style="height: 240px; width: 200px; border: solid 3px; border-radius: 100%; border-color: green;"/>
  <img src="@/assets/flower3_1.png" class="w-25" style="height: 240px; width: 200px; border: solid 3px; border-radius: 100%; border-color: green;"/>
  <img src="@/assets/flower4_1.png" class="w-25" style="height: 240px; width: 200px; border: solid 3px; border-radius: 100%; border-color: green;"/>
  <img src="@/assets/flower5_1.png" class="w-25" style="height: 240px; width: 200px; border: solid 3px; border-radius: 100%; border-color: green;"/>
  <img src="@/assets/flower6_1.png" class="w-25" style="height: 240px; width: 200px; border: solid 3px; border-radius: 100%; border-color: green;"/> -->
  <b-card style="max-width:70rem; border-color: #a48282;">
    <b-row>
      <b-col cols="6" style="text-align:center">
        <img src="@/assets/flower6_1.png" class="w-25" style="height: 240px; width: 200px;" />
        <b-progress max='50' class="w-25" style="margin-top: 20px; margin-left: 170px; margin-bottom: 20px;">
          <b-progress-bar variant="success" value="30"></b-progress-bar>
        </b-progress>
      </b-col>
      <b-col cols="6">
        <h8>
          <div class="ment">lv1. 씨앗이 꽃을 피우는 날을 꿈꾸며 화이팅!<br /></div>
          <div class="ment">lv2. 벌써 싹이 돋았네요! 잘 하고 계십니다!<br /></div>
          <div class="ment">lv3. 싹이 무럭무럭 자라났네요!<br /></div>
          <div class="ment">lv4. 잎사귀가 돋아났습니다!<br /></div>
          <div class="ment">lv5. 꽃봉오리가 생겼네요! <br /></div>
          <div class="ment">lv6. 발화 임박! 조금만 더 힘내세요!<br /></div>
        </h8>
        <h7>
          <div class="ment">lv7. 발화 성공! 🎉 하지만 방심은 금물 아시죠? 😄<br /></div>
        </h7>
      </b-col>
    </b-row>
  </b-card>
  <br />
</template>

<script>
export default {

}
</script>

<style>
.ment{
  margin-bottom: 17px;
}
/* html, body {
  width: 100%;  
  height: 100%;
  background: #FF7777;
  -webkit-font-smoothing: antialiased;
  display: flex;
  justify-content: center;
  align-items: center;
} */

h7 div {
  position: relative;
  top: 2px;
  animation: bounce .4s ease infinite alternate;
  font-family: 'san-serif';
  font-size: 17px;
  color: #447467;
  /* text-shadow: 0 1px 0 #CCC,
               0 2px 0 #CCC,
               0 3px 0 #CCC,
               0 4px 0 #CCC,
               0 5px 0 #CCC,
               0 6px 0 transparent,
               0 7px 0 transparent,
               0 8px 0 transparent,
               0 9px 0 transparent,
               0 10px 10px rgba(0, 0, 0, .4); */
}

h1 div:nth-child(2) { animation-delay: .1s; }
h1 div:nth-child(3) { animation-delay: .2s; }
h1 div:nth-child(4) { animation-delay: .3s; }
h1 div:nth-child(5) { animation-delay: .4s; }
h1 div:nth-child(6) { animation-delay: .5s; }
h1 div:nth-child(7) { animation-delay: .6s; }

@keyframes bounce {
  100% {
    top: -2px;
    /* text-shadow: 0 1px 0 #CCC,
                 0 2px 0 #CCC,
                 0 3px 0 #CCC,
                 0 4px 0 #CCC,
                 0 5px 0 #CCC,
                 0 6px 0 #CCC,
                 0 7px 0 #CCC,
                 0 8px 0 #CCC,
                 0 9px 0 #CCC,
                 0 50px 25px rgba(0, 0, 0, .2); */
  }
}

h8{
  color:#E0D2D2;
}
</style>