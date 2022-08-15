<template>
    <b-container fluid="sm">
        <b-list-group style="overflow-y: scroll; height:240px">
            <b-list-group-item>
                <div class="person">
                    <b-row>
                        <b-col cols="2">
                            <b-avatar variant="info" src="https://placekitten.com/300/202" size="44px"></b-avatar>
                        </b-col>
                        <b-col cols="7">
                            <b-row class="nickname">super_girl</b-row>
                            <b-row class="realname">김미료</b-row>
                        </b-col>
                        <!-- 팔로잉 누르면 모달 생성 -->
                        <b-col cols="3" style="text-align:right" data-bs-dismiss="modal" aria-label="Close">
                            <b-button size="sm"
                                style="color:black; background-color:white; font-size: 14px; padding:5px 9px;"
                                v-b-modal.modal-12>팔로잉</b-button>
                        </b-col>
                    </b-row>
                </div>
            </b-list-group-item>
            <b-list-group-item>
                <div class="person">
                    <b-row>
                        <b-col cols="2">
                            <b-avatar variant="info" src="https://placekitten.com/300/203" size="44px"></b-avatar>
                        </b-col>
                        <b-col cols="7">
                            <b-row class="nickname">bat_man </b-row>
                            <b-row class="realname">최재현</b-row>
                        </b-col>
                        <b-col cols="3" style="text-align:right" data-bs-dismiss="modal" aria-label="Close">
                            <b-button size="sm"
                                style="color:black; background-color:white; font-size: 14px; padding:5px 9px;"
                                v-b-modal.modal-12>팔로잉
                            </b-button>
                        </b-col>
                    </b-row>
                </div>
            </b-list-group-item>
            <b-list-group-item>
                <div class="person">
                    <b-row>
                        <b-col cols="2">
                            <b-avatar variant="info" src="https://placekitten.com/300/204" size="44px"></b-avatar>
                        </b-col>
                        <b-col cols="7">
                            <b-row class="nickname">pussycat </b-row>
                            <b-row class="realname">신영제</b-row>
                        </b-col>
                        <b-col cols="3" style="text-align:right" data-bs-dismiss="modal" aria-label="Close">
                            <b-button size="sm"
                                style="color:black; background-color:white; font-size: 14px; padding:5px 9px;"
                                v-b-modal.modal-12>팔로잉
                            </b-button>
                        </b-col>
                    </b-row>
                </div>
            </b-list-group-item>
            <b-list-group-item>
                <div class="person">
                    <b-row>
                        <b-col cols="2">
                            <b-avatar variant="info" src="https://placekitten.com/300/205" size="44px"></b-avatar>
                        </b-col>
                        <b-col cols="7">
                            <b-row class="nickname">keeper_yang </b-row>
                            <b-row class="realname">양한빈</b-row>
                        </b-col>
                        <b-col cols="3" style="text-align:right" data-bs-dismiss="modal" aria-label="Close">
                            <b-button size="sm"
                                style="color:black; background-color:white; font-size: 14px; padding:5px 9px;"
                                v-b-modal.modal-12>팔로잉
                            </b-button>
                        </b-col>
                    </b-row>
                </div>
            </b-list-group-item>
            <b-list-group-item>
                <div class="person">
                    <b-row>
                        <b-col cols="2">
                            <b-avatar variant="info" src="https://placekitten.com/300/206" size="44px"></b-avatar>
                        </b-col>
                        <b-col cols="7">
                            <b-row class="nickname">puppy_jisung </b-row>
                            <b-row class="realname">박지성</b-row>
                        </b-col>
                        <b-col cols="3" style="text-align:right" data-bs-dismiss="modal" aria-label="Close">
                            <b-button size="sm"
                                style="color:black; background-color:white; font-size: 14px; padding:5px 9px;"
                                v-b-modal.modal-12>팔로잉
                            </b-button>
                        </b-col>
                    </b-row>
                </div>
            </b-list-group-item>
            <b-list-group-item>
                <div class="person">
                    <b-row>
                        <b-col cols="2">
                            <b-avatar variant="info" src="https://placekitten.com/300/207" size="44px"></b-avatar>
                        </b-col>
                        <b-col cols="7">
                            <b-row class="nickname">nalgangdo </b-row>
                            <b-row class="realname">날강두</b-row>
                        </b-col>
                        <b-col cols="3" style="text-align:right" data-bs-dismiss="modal" aria-label="Close">
                            <b-button size="sm"
                                style="color:black; background-color:white; font-size: 14px; padding:5px 9px;"
                                v-b-modal.modal-12>팔로잉
                            </b-button>
                        </b-col>
                    </b-row>
                </div>
            </b-list-group-item>
            <b-list-group-item>
                <div class="person">
                    <b-row>
                        <b-col cols="2">
                            <b-avatar variant="info" src="https://placekitten.com/300/208" size="44px"></b-avatar>
                        </b-col>
                        <b-col cols="7">
                            <b-row class="nickname">kevin_d </b-row>
                            <b-row class="realname">김덕배</b-row>
                        </b-col>
                        <b-col cols="3" style="text-align:right" data-bs-dismiss="modal" aria-label="Close">
                            <b-button size="sm"
                                style="color:black; background-color:white; font-size: 14px; padding:5px 9px;"
                                v-b-modal.modal-12>팔로잉
                            </b-button>
                        </b-col>
                    </b-row>
                </div>
            </b-list-group-item>
            <b-list-group-item>
                <div class="person">
                    <b-row>
                        <b-col cols="2">
                            <b-avatar variant="info" src="https://placekitten.com/300/300" size="44px"></b-avatar>
                        </b-col>
                        <b-col cols="7">
                            <b-row class="nickname">kimmich </b-row>
                            <b-row class="realname">김미희</b-row>
                        </b-col>
                        <b-col cols="3" style="text-align:right" data-bs-dismiss="modal" aria-label="Close">
                            <b-button size="sm"
                                style="color:black; background-color:white; font-size: 14px; padding:5px 9px;"
                                v-b-modal.modal-12>팔로잉
                            </b-button>
                        </b-col>
                    </b-row>
                </div>
            </b-list-group-item>
        </b-list-group>
    </b-container>
</template>

<script>
export default {

}
</script>

<style>
</style>