<template>
  <div style="margin-bottom: 10px">
    <b-row>
      <b-col cols="1" style="padding: 4px; text-align: right">
        <b-avatar :src="pics" variant="info" size="26px"></b-avatar>
      </b-col>
      <b-col>
        <b-row>
          <b-col cols="2">
            <div style="text-align: left">
              <a style="padding: 0px; font-weight: bold; text-decoration: none">
                {{ userId }}</a>
            </div>
          </b-col>
        </b-row>
        <b-row>
          <b-col cols="10">
            <div style="text-align: left; padding: 0px">{{ contents }}</div>
          </b-col>
          <b-col cols="2">
            <!-- <div style="text-align:right" data-v-5213e8a5 class="comment_tool">
              <a data-v-5213e8a5 id="commentItem58677667" href="#" role="button" title="더보기"
                class="comment_tool_button">
                <svg data-v-5213e8a5 aria-label="더보기" class="svg-icon ico-post-more-979797" width="20" height="20"
                  fill="none" xmlns="http://www.w3.org/2000/svg">
                  <path
                    d="M10 10.833a.833.833 0 1 0 0-1.666.833.833 0 0 0 0 1.666ZM10 5a.833.833 0 1 0 0-1.667A.833.833 0 0 0 10 5ZM10 16.667A.833.833 0 1 0 10 15a.833.833 0 0 0 0 1.667Z"
                    stroke="#444" stroke-opacity=".7" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
                  <use data-v-5213e8a5 xlink:href="#ico-post-more-979797" aria-hidden="false"></use>
                </svg>
              </a>
              <div data-v-5213e8a5 id="commentItem58677667" role="menu" class="LayerMore">
                <ul class="layer_list">
                  <li class="layer_item">
                    <a href="#" role="button" class="layer_button" v-b-modal.modal-6>신고</a>
                  </li>
                </ul>
              </div>
            </div> -->
            <div style="text-align: right;">
            <a style="text-align: right; cursor: pointer;">
        <a v-b-modal.modal-6>신고</a>
      </a></div>
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
            <a href="" style="
                color: #9f9f9f;
                text-align: left;
                font-weight: bold;
                text-decoration: none;
              ">답글 쓰기</a>
          </b-col>
        </b-row>
      </b-col>
    </b-row>
  </div>
  <!-- <board-comments-list-item-child /> -->

  <!-- axios 를 사용하면 가능해질 것! -->
  <board-comments-list-item-child v-for="item in child" :key="item" v-bind="item"></board-comments-list-item-child>

  <b-modal hide-footer id="modal-6" centered title="신고하기" style="text-align: center">
    <b-card style="height: 23rem; max-width: 30rem; background-color: #f8f3f3">
      <b-container ref="form">
        <b-row style="margin-bottom: 10px">
          <b-col>
            <b-form-textarea id="content" placeholder="신고 내용" rows="10" max-rows="15" required style="border: none">
            </b-form-textarea>
          </b-col>
        </b-row>
        <br />
        <b-button text @click="submit" style="color: #453535; background-color: #e1d3d2; border: none">제출</b-button>
      </b-container>
    </b-card>
  </b-modal>
</template>


<script>
import BoardCommentsListItemChild from "./BoardCommentsListItemChild.vue";
export default {
  components: { BoardCommentsListItemChild },
  data() {
    return {
      children: null,
      pics: "https://placekitten.com/300/250",
    };
  },
  props: {
    profile: String,
    userId: String,
    contents: String,
    date: String,
    time: String,
    child: Array,
  },
  mounted() {
    this.pics = this.profile;
    console.log(this.child);
  },
};
</script>


<style>
/* 
.CommentBox .comment_list .comment_tool {
    position: absolute;
    top: 12px;
    right: 0;
}
.CommentBox .comment_list .comment_tool .comment_tool_button {
    display: block;
    width: 16px;
    height: 16px;
    text-align: right;
}
.CommentBox a {
    color: inherit;
}
.LayerMore .layer_button {
    display: block;
    text-align: left;
    min-width: 100px;
    height: 36px;
    padding: 0 15px;
    box-sizing: border-box;
    font-size: 13px;
    line-height: 37px;
    white-space: nowrap;
    color: #000;
}
.LayerMore {
    overflow-y: auto;
    position: absolute;
    top: auto;
    z-index: 1;
    max-height: 416px;
    padding: 10px 0;
    border: 1px solid rgba(0,0,0,.06);
    border-radius: 6px;
    box-shadow: 0 1px 12px 0 rgb(0 0 0 / 6%);
    background-color: #fff;
    box-sizing: border-box;
    color: #000;
}
.CommentBox .comment_list .comment_tool .LayerMore {
    left: auto;
    right: 0;
    margin-top: 7px;
}
.layout_content {
    width: 860px;
    margin: 0 auto;
    background-color: var(--skinColor);
    font-size: 13px;
}
.CommentBox .comment_list .comment_tool .svg-icon {
    width: 3px;
    height: 15px;
    color: var(--skinCommentWriterText);
    vertical-align: top;
}
.svg-icon {
    pointer-events: none;
}
svg:not(:root) {
    overflow: hidden;
}
dl, ol, ul {
    list-style: none;
}
li {
    display: list-item;
    text-align: -webkit-match-parent;
}
a:-webkit-any-link {
    cursor: pointer;
}
ul{
    display:block;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    padding-inline-start: 40px;
} */
</style>