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
            <b-col
                style="margin-bottom:12px; font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Helvetica, Arial, sans-serif;">
                <div style="font-size: 22px; margin-bottom: 8px;">팔로워를 삭제하시겠어요?</div>
                <span style="font-size: 14px; color: #8E8E8E;">super_girl님은 회원님의 팔로워 리스트에서 삭제된<br>사실을 알 수
                    없습니다</span>
            </b-col>
        </b-row>
        <hr />
        <b-row style="cursor: pointer; color: red; font-weight: bold;">
            <div style="text-align:center;">팔로우 취소</div>
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