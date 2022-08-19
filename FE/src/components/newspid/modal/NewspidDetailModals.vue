<template>
<!-- Modal 4 : 뉴스피드 옵션 모달 -->
    <b-modal hide-footer hide-title hide-header  centered id="modal-4" size="sm" style="text-align: center;">
        <newspid-detail-modal-option></newspid-detail-modal-option>
    </b-modal>

<!-- Modal 5 : 팔로우 취소 모달 -->
    <b-modal hide-footer hide-title hide-header no-stacking centered id="modal-5" size="md" style="text-align: center;">
        <newspid-detail-modal-follow/>
    </b-modal>

<!-- Modal 7 : 뉴스피드 옵션 중 신고하기 모달 -->
    <b-modal hide-footer id="modal-7" centered no-stacking title="신고하기" style="text-align: center">
        <newspid-detail-modal-report></newspid-detail-modal-report>
    </b-modal>

</template>

<script>
import NewspidDetailModalOption from "@/components/newspid/modal/items/detail/NewspidDetailModalOption.vue";
import NewspidDetailModalReport from "@/components/newspid/modal/items/detail/NewspidDetailModalReport.vue";
import NewspidDetailModalFollow from '@/components/newspid/modal/items/detail/NewspidDetailModalFollow.vue';
export default {
    components:{
        NewspidDetailModalOption,
        NewspidDetailModalReport,
        NewspidDetailModalFollow,
    }
}
</script>

<style>

</style>