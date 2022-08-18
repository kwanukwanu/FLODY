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
            size="sm" @click="gotoPage('/club')"><svg width="24" height="24" fill="none"
              xmlns="http://www.w3.org/2000/svg">
              <path d="M12 5v14m-7-7h14" stroke="#444" stroke-width="2" stroke-linecap="round"
                stroke-linejoin="round" />
            </svg></b-button>
        </b-col>
      </b-row>
      <hr style="margin: 5px;" />
      <group-nav-items v-for="group in myGroupItem" :key="group" v-bind="group">

      </group-nav-items>

    </b-container>
  </b-card>
</template>

<script>
import GroupNavItems from "./items/GroupNavItems.vue";
import { computed } from "vue";
import { useStore } from "vuex";

export default {
  components: { GroupNavItems },
  setup() {
    const store = useStore();
    const myGroupItem = computed(() => store.state.groupStore.myGroupItem);

    return { store, myGroupItem };
  },
  data() {
    return {
      group_items: [
        {
          name: '정처기 뿌셔',
          goal: '정보처리기사',
          date: '2022-08-16',
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
          goal: 'OPIC',
          date: '2022-08-13',
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
  mounted() {
    this.store.dispatch("groupStore/set_my_group_item");
    console.log("------------------------");
    console.log(this.myGroupItem);
  }
}
</script>

<style>
#move {
  margin-bottom: 3px;
}
</style>