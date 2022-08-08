<template>
  <b-container>
      <b-row>
        <b-col>
          <div style="text-align:center;">
            <b-avatar variant="info" src="https://placekitten.com/300/300" size="85px"></b-avatar>
          </div>
        </b-col>
      </b-row>
      <br>
      <b-row>
        <b-col style="margin-bottom:12px;">
          @Brown_Cat님의 팔로우를 취소하시겠어요?
        </b-col>
      </b-row>
      <hr />
      <b-row @click="Modify" style="cursor: pointer; color: red; font-weight: bold;">
        <div style="text-align:center;">팔로우 취소</div>
      </b-row>
      <hr />
      <b-row @click="Cancel" style="text-align:center; cursor: pointer;" data-bs-dismiss="modal" aria-label="Close">
        <div style="text-align:center;" >취소</div>
      </b-row>
    </b-container>
</template>

<script>
export default {

}
</script>

<style>

</style>