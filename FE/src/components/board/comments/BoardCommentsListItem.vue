<template>
  <div style="margin-bottom: 10px">
    <b-row>
      <b-col cols="1" style="padding: 4px; text-align: right">
        <!-- <img  variant="info" style="width: 20px; height:20px"/> -->
      </b-col>
      <b-col>
        <b-row>
          <b-col>
            <div style="text-align: left">
              <a style="padding: 0px; font-weight: bold; text-decoration: none">
                {{ userId }}
              </a>
            </div>
          </b-col>
        </b-row>
        <b-row>
          <b-col>
            <div style="text-align: left; padding: 0px">{{ contents }}</div>
          </b-col>
          <b-col>
            <div style="text-align: right">
              <a>신고</a>
            </div>
          </b-col>
        </b-row>
        <b-row>
          <b-col cols="1">
            <div style="color: #9f9f9f">{{ date }}</div>
          </b-col>
          <b-col cols="1">
            <div style="color: #9f9f9f">{{ time }}</div>
          </b-col>
          <b-col cols="2">
            <a 
              href=""
              style="
                color: #9f9f9f;
                text-align: left;
                font-weight: bold;
                text-decoration: none;
              "
              >답글 쓰기</a
            >
          </b-col>
        </b-row>
      </b-col>
    </b-row>
  </div>

  <board-comments-list-item-child
    v-for="childitem in child"
    :key="childitem"
    v-bind="childitem"
  ></board-comments-list-item-child>
</template>

<script>
import BoardCommentsListItemChild from "./BoardCommentsListItemChild.vue";
export default {
  components: { BoardCommentsListItemChild },
  data() {
    return {
      children: null,
    };
  },
  props: {
    index: Number,
    profile: String,
    userId: String,
    contents: String,
    date: String,
    time: String,
    child: Object,
  },
};
</script>

<style></style>
