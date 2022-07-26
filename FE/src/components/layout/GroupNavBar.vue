<template>
  <div> 스터디 그룹 </div>
  <b-card style="max-width: 32rem; max-height: 45rem; background-color: #f8f3f3" class="mb-2">
      <b-container>
        <b-row>
          <b-col style="text-align: left; padding: 6px 12px;">
            <b-card-text style="font-weight: bold;">현재 스터디 목록</b-card-text>
          </b-col>
          <b-col cols="2">
            <b-button variant="link" style="text-decoration: none; font-weight: 100;">+</b-button>
          </b-col>
        </b-row>
        <hr style="margin: 5px;"/>
        <b-row style="text-align: left;">
          <details>
            <summary style="font-weight: bold;">정처기 뿌셔</summary>
            <ul>
              <li style="text-align: left;"><b-avatar src="https://placekitten.com/300/300" style="margin: 0px 5px 5px 0px;"></b-avatar>Super_Mario</li>
              <li style="text-align: left;"><b-avatar src="https://placekitten.com/300/200" style="margin: 0px 5px 5px 0px;"></b-avatar>Bat_Man</li>
              <li style="text-align: left;"><b-avatar src="https://placekitten.com/300/100" style="margin: 0px 5px 5px 0px;"></b-avatar>Cinderella</li>
            </ul>
          </details>
        </b-row>
        <b-row style="text-align: left;">
          <details>
            <summary style="font-weight: bold;">오픽 유잼</summary>
            <ul>
              <li style="text-align: left;"><b-avatar src="https://placekitten.com/300/250" style="margin: 0px 5px 5px 0px;"></b-avatar>Drunken_Tiger</li>
              <li style="text-align: left;"><b-avatar src="https://placekitten.com/300/240" style="margin: 0px 5px 5px 0px;"></b-avatar>girl_girls</li>
              <li style="text-align: left;"><b-avatar src="https://placekitten.com/300/150" style="margin: 0px 5px 5px 0px;"></b-avatar>Oh_My_Boy</li>
            </ul>
          </details>
        </b-row>
      </b-container>
    </b-card>
</template>

<script>
export default {

}
</script>

<style>

</style>