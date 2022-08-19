<template>
    <b-container>
        <!-- 본인 게시물이라면 신고 안 보이도록 해야 함 -->
        <b-row @click="Delete" style="text-align:center; cursor: pointer; color: red; font-weight: 600;"
            data-bs-dismiss="modal" aria-label="Close">
            <div style="text-align:center;" v-b-modal.modal-7>신고</div>
        </b-row>
        <hr />
        <b-row @click="Delete" style="text-align:center; cursor: pointer; color: red; font-weight: 600;">
            <div style="text-align:center;">삭제</div>
        </b-row>
        <hr />
        <b-row @click="Modify" style="cursor: pointer;">
            <div style="text-align:center;">수정</div>
        </b-row>
        <hr />
        <b-row @click="Cancel" style="text-align:center; cursor: pointer;" data-bs-dismiss="modal" aria-label="Close">
            <div style="text-align:center;">취소</div>
        </b-row>
    </b-container>
</template>

<script>
export default {
    
}
</script>

<style>

</style>