<template>
    <b-modal hide-footer id="modal-3" centered title="새 게시물 만들기" style="text-align: center">
        <newspid-header-modal-new-board></newspid-header-modal-new-board>
    </b-modal>

    <b-modal hide-header hide-footer title="채팅창" centered id="chatting2" size="lg" style="text-align: center;">
        <newspid-header-modal-chat></newspid-header-modal-chat>
    </b-modal>

    <b-modal hide-footer id="modal-10" centered title="팔로워" style="text-align: center;">
        <newspid-header-modals-followers></newspid-header-modals-followers>
    </b-modal>

    <b-modal hide-footer id="modal-11" centered title="팔로우" style="text-align: center;">
        <newspid-header-modal-follow></newspid-header-modal-follow>
    </b-modal>

    <b-modal hide-footer hide-title hide-header no-stacking centered id="modal-12" size="md"
        style="text-align: center;">
        <newspid-header-modal-follow-set></newspid-header-modal-follow-set>
    </b-modal>

    <b-modal hide-footer hide-title hide-header no-stacking centered id="modal-13" style="text-align: center;">
        <newspid-header-modal-follower-set></newspid-header-modal-follower-set>
    </b-modal>

</template>

<script>

import NewspidHeaderModalNewBoard from '@/components/newspid/modal/items/header/NewspidHeaderModalNewBoard.vue'
import NewspidHeaderModalChat from '@/components/newspid/modal/items/header/NewspidHeaderModalChat.vue';
import NewspidHeaderModalFollow from "./items/header/NewspidHeaderModalFollow.vue";
import NewspidHeaderModalsFollowers from "./items/header/NewspidHeaderModalsFollowers.vue";
import NewspidHeaderModalFollowSet from "./items/header/NewspidHeaderModalFollowSet.vue";
import NewspidHeaderModalFollowerSet from "./items/header/NewspidHeaderModalFollowerSet.vue";

export default {
    components: {
        NewspidHeaderModalNewBoard,
        NewspidHeaderModalChat,
        NewspidHeaderModalFollow,
        NewspidHeaderModalsFollowers,
        NewspidHeaderModalFollowSet,
        NewspidHeaderModalFollowerSet,
    }
}
</script>

<style>
</style>