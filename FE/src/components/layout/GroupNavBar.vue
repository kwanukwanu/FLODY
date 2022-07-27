<template>
  <div style="margin-top:12px;"></div>
  <b-card style="max-width: 20rem; max-height: 45rem; background-color: #f8f3f3; min-height:100%;" class="mb-2">
    <b-container>
      <b-row>
        <b-col style="text-align: left; padding: 6px 12px;">
          <b-card-text style="font-weight: bold; color: #786666">현재 스터디 목록</b-card-text>
        </b-col>
        <b-col cols="2">
          <b-button class="plus_button" variant="link" style="color:brown; text-decoration: none; font-weight: 600;"
            @click="gotoPage('/club')">+</b-button>
        </b-col>
      </b-row>
      <hr style="margin: 5px;" />
      <b-row style="text-align: left;">
        <details>
          <summary style="font-weight: bold; margin-top: 7px;">
            정처기 뿌셔
            <b-button @click="gotoPage('/group')">이동</b-button>
          </summary>
          <ul>
            <li style="text-align: left;">
              <b-avatar size="30px" src="https://placekitten.com/300/300" style="margin: 0px 5px 5px 0px;"></b-avatar>
              Super_Mario
            </li>
            <li style="text-align: left;">
              <b-avatar size="30px" src="https://placekitten.com/300/200" style="margin: 0px 5px 5px 0px;"></b-avatar>
              Bat_Man
            </li>
            <li style="text-align: left;">
              <b-avatar size="30px" src="https://placekitten.com/300/100" style="margin: 0px 5px 5px 0px;"></b-avatar>
              Cinderella
            </li>
          </ul>
        </details>
      </b-row>
      <b-row style="text-align: left;">
        <details>
          <summary style="font-weight: bold;">
            오픽 유잼
            <b-button @click="gotoPage('/group')">이동</b-button>
          </summary>
          <ul>
            <li style="text-align: left;">
              <b-avatar size="30px" src="https://placekitten.com/300/250" style="margin: 0px 5px 5px 0px;"></b-avatar>
              Drunken_Tiger
            </li>
            <li style="text-align: left;">
              <b-avatar size="30px" src="https://placekitten.com/300/240" style="margin: 0px 5px 5px 0px;"></b-avatar>
              girl_girls
            </li>
            <li style="text-align: left;">
              <b-avatar size="30px" src="https://placekitten.com/300/150" style="margin: 0px 5px 5px 0px;"></b-avatar>
              Oh_My_Boy
            </li>
            <li style="text-align: left;">
              <b-avatar size="30px" src="https://placekitten.com/300/230" style="margin: 0px 5px 5px 0px;"></b-avatar>
              pussy_cat
            </li>
            <li style="text-align: left;">
              <b-avatar size="30px" src="https://placekitten.com/300/170" style="margin: 0px 5px 5px 0px;"></b-avatar>
              ronaldo
            </li>
            <li style="text-align: left;">
              <b-avatar size="30px" src="https://placekitten.com/300/180" style="margin: 0px 5px 5px 0px;"></b-avatar>
              messi_god
            </li>
            <li style="text-align: left;">
              <b-avatar size="30px" src="https://placekitten.com/300/190" style="margin: 0px 5px 5px 0px;"></b-avatar>
              heungmini
            </li>
          </ul>
        </details>
      </b-row>
    </b-container>
  </b-card>

</template>

<script>
export default {
  methods: {
    gotoPage(link) {
      console.log(link);
      this.$router.push(link);
    },
  },
}
</script>

<style>
</style>