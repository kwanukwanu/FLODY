<template>
    <b-modal hide-footer id="modal-3" centered title="새 게시물 만들기" style="text-align: center">
        <newspid-header-modal-new-board></newspid-header-modal-new-board>
    </b-modal>

    <b-modal hide-header hide-footer title="채팅창" centered id="chatting2" size="lg" style="text-align: center;">
        <newspid-header-modal-chat></newspid-header-modal-chat>
    </b-modal>

</template>

<script>
import NewspidHeaderModalNewBoard from '@/components/newspid/modal/items/header/NewspidHeaderModalNewBoard.vue'
import NewspidHeaderModalChat from '@/components/newspid/modal/items/header/NewspidHeaderModalChat.vue';
export default {
    components:{
        NewspidHeaderModalNewBoard,
        NewspidHeaderModalChat,
    }
}
</script>

<style>

</style>