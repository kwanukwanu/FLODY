<template>
  <div style="margin-top:12px;"></div>
  <b-card style="max-width: 20rem; max-height: 45rem; background-color: #f8f3f3; min-height:1090px;" class="mb-2">
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
      <group-nav-items v-for="group in group_items" :key="group" v-bind="group">

      </group-nav-items>

      <!--       
      <b-row style="text-align: left;">
        <details>
          <summary style="font-weight: bold; margin-top: 7px;">
            정처기 뿌셔
            <router-link :to="{ name: 'group' }"><svg id="move" width="18" height="18" fill="none"
                xmlns="http://www.w3.org/2000/svg">
                <path
                  d="m9 12 3-3m0 0L9 6m3 3H6m-.15 6.75h6.3c1.26 0 1.89 0 2.371-.245.424-.216.768-.56.984-.984.245-.48.245-1.11.245-2.371v-6.3c0-1.26 0-1.89-.245-2.371a2.25 2.25 0 0 0-.984-.984c-.48-.245-1.11-.245-2.371-.245h-6.3c-1.26 0-1.89 0-2.371.245a2.25 2.25 0 0 0-.984.984c-.245.48-.245 1.11-.245 2.371v6.3c0 1.26 0 1.89.245 2.371.216.424.56.768.984.984.48.245 1.11.245 2.371.245Z"
                  stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
              </svg></router-link>
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
          <summary style="font-weight: bold;">오픽 유잼
           -->


      <!-- <b-button variant="link" @click="gotoPage('/group')">
              <svg width="24" height="24" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path
                  d="m12 16 4-4m0 0-4-4m4 4H8m-.2 9h8.4c1.68 0 2.52 0 3.162-.327a3 3 0 0 0 1.311-1.311C21 18.72 21 17.88 21 16.2V7.8c0-1.68 0-2.52-.327-3.162a3 3 0 0 0-1.311-1.311C18.72 3 17.88 3 16.2 3H7.8c-1.68 0-2.52 0-3.162.327a3 3 0 0 0-1.311 1.311C3 5.28 3 6.12 3 7.8v8.4c0 1.68 0 2.52.327 3.162a3 3 0 0 0 1.311 1.311C5.28 21 6.12 21 7.8 21Z"
                  stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
              </svg>
            </b-button> -->


      <!-- 
            <router-link :to="{ name: 'group' }"><svg id="move" width="18" height="18" fill="none"
                xmlns="http://www.w3.org/2000/svg">
                <path
                  d="m9 12 3-3m0 0L9 6m3 3H6m-.15 6.75h6.3c1.26 0 1.89 0 2.371-.245.424-.216.768-.56.984-.984.245-.48.245-1.11.245-2.371v-6.3c0-1.26 0-1.89-.245-2.371a2.25 2.25 0 0 0-.984-.984c-.48-.245-1.11-.245-2.371-.245h-6.3c-1.26 0-1.89 0-2.371.245a2.25 2.25 0 0 0-.984.984c-.245.48-.245 1.11-.245 2.371v6.3c0 1.26 0 1.89.245 2.371.216.424.56.768.984.984.48.245 1.11.245 2.371.245Z"
                  stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
              </svg></router-link>
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
      </b-row> -->

    </b-container>
  </b-card>
</template>

<script>
import GroupNavItems from "./items/GroupNavItems.vue";
export default {
  components: { GroupNavItems },
  data() {
    return {
      group_items: [
        {
          name: '정처기 뿌셔',
          groups: [
            {
              id: 'Super_Mario',
              src: 'https://placekitten.com/300/300',
            },
            {
              id: 'Bat_Man',
              src: 'https://placekitten.com/300/200',
            },
            {
              id: 'Cinderella',
              src: 'https://placekitten.com/300/100',
            }
          ]
        },
        {
          name: '오픽 유잼',
          groups: [
            {
              id: 'Drunken_Tiger',
              src: "https://placekitten.com/300/250",
            },
            {
              id: 'girl_girls',
              src: "https://placekitten.com/300/240",
            },
            {
              id: 'Oh_My_Boy',
              src: "https://placekitten.com/300/150",
            },
            {
              id: 'pussy_cat',
              src: "https://placekitten.com/300/230",
            },
            {
              id: 'ronaldo',
              src: "https://placekitten.com/300/170"
            },
            {
              id: 'messi_god',
              src: "https://placekitten.com/300/180",
            },
            {
              id: 'heungmini',
              src: "https://placekitten.com/300/190",
            },
          ]
        }
      ]
    }
  },
  methods: {
    gotoPage(link) {
      this.$router.push(link);
    },
  },
  mounted(){
    
  }
}
</script>

<style>
#move {
  margin-bottom: 3px;
}
</style>