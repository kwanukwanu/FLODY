<template>
    <b-card>
        <b-tabs pills card vertical>
            <b-tab title="프로필 편집" active>
                <b-row style="margin-bottom:18px;">
                    <b-col cols="3" style="text-align: right; font-weight: bold;">
                        <b-avatar variant="info" :src="userInfo.profile" size="40px"></b-avatar>
                    </b-col>
                    <b-col cols="9">
                        <b-row>
                            <div style="margin-left:1px; font-size:large;">{{userInfo.email}}</div>
                        </b-row>
                        <b-row style="color:#064635; font-size: small;">
                            <a> 프로필 사진 바꾸기(불가)
                            </a>
                        </b-row>
                    </b-col>
                </b-row>

                <b-row style="margin-bottom:18px;">
                    <b-col cols="3" style="text-align: right; font-weight: bold;">
                        이름
                    </b-col>
                    <b-col cols="9">
                        <b-form-input id="content" v-model="userInfo.name" placeholder="이름" style="width:500px;">
                        </b-form-input>
                    </b-col>
                </b-row>

                <b-row style="margin-bottom:18px;">
                    <b-col cols="3" style="text-align: right; font-weight: bold;">
                        사용자 이름
                    </b-col>
                    <b-col cols="9">
                        <b-form-input id="content" v-model="userInfo.nickname" placeholder="사용자 이름" style="width:500px;">
                        </b-form-input>
                    </b-col>
                </b-row>

                <b-row style="margin-bottom:18px;">
                    <b-col cols="3" style="text-align: right; font-weight: bold;">
                        소개
                    </b-col>
                    <b-col cols="9">
                        <b-form-textarea id="content" v-model="introduction" placeholder="소개" style="width:500px;">
                        </b-form-textarea>
                    </b-col>
                </b-row>

                <b-row style="margin-bottom:18px;">
                    <b-col cols="3" style="text-align: right; font-weight: bold;">
                        주소
                    </b-col>
                    <b-col cols="9">
                        <b-form-input id="content" v-model="userInfo.address" placeholder="주소" style="width:500px;">
                        </b-form-input>
                    </b-col>
                </b-row>

                <b-row style="margin-bottom:18px;">
                    <b-col cols="3" style="text-align: right; font-weight: bold;">
                        전화번호
                    </b-col>
                    <b-col cols="9">
                        <b-form-input id="content" v-model="userInfo.phone" placeholder="전화번호" style="width:500px;">
                        </b-form-input>
                    </b-col>
                </b-row>

                <b-row>
                    <b-col cols="3"></b-col>
                    <b-col cols="9">
                        <b-button text @click="submit" style="color: white; background-color: #83A39A; border: none;">제출
                        </b-button>
                    </b-col>
                </b-row>
            </b-tab>

            <b-tab title="비밀번호 변경">
                <b-row style="margin-bottom:28px;">
                    <b-col cols="3" style="text-align: right; font-weight: bold;">
                        <b-avatar variant="info" src="https://placekitten.com/300/200" size="40px"></b-avatar>
                    </b-col>
                    <b-col cols="9">
                        <span style="margin-left:1px; font-size: x-large;">chlwogus</span>
                    </b-col>
                </b-row>

                <b-row style="margin-bottom:18px;">
                    <b-col cols="3" style="text-align: right; font-weight: bold;">
                        이전 비밀번호
                    </b-col>
                    <b-col cols="9">
                        <b-form-input id="content" placeholder="" style="width:500px;">
                        </b-form-input>
                    </b-col>
                </b-row>

                <b-row style="margin-bottom:18px;">
                    <b-col cols="3" style="text-align: right; font-weight: bold;">
                        새 비밀번호
                    </b-col>
                    <b-col cols="9">
                        <b-form-input id="content" placeholder="" style="width:500px;">
                        </b-form-input>
                    </b-col>
                </b-row>


                <b-row style="margin-bottom:18px;">
                    <b-col cols="3" style="text-align: right; font-weight: bold;">
                        새 비밀번호 확인
                    </b-col>
                    <b-col cols="9">
                        <b-form-input id="content" placeholder="" style="width:500px;">
                        </b-form-input>
                    </b-col>
                </b-row>
                <b-row>
                    <b-col cols="3"></b-col>
                    <b-col cols="9">
                        <b-button text @click="submit" style="color: white; background-color: #83A39A; border: none;">
                            비밀번호 변경
                        </b-button>
                    </b-col>
                </b-row>
            </b-tab>
        </b-tabs>
    </b-card>
</template>

<script>
import {useStore} from "vuex";

export default {
    data(){
        return {
            userInfo:{
                address:"",
                profile : "",
                name: "이름",
                nickname: "사용자 이름",
                introduction: "자기소개입니다",
            },
        }
    },
    setup(){
        const store = useStore();
        return {store};
    },
    mounted(){
        this.userInfo = this.store.state.memberStore.userInfo;
        console.log(this.userInfo);
    }
}
</script>

<style>
.nav-pills .nav-link.active, .nav-pills .show>.nav-link {
    color: BLACK;
    background-color: var(--bs-nav-pills-link-active-black);
    font-weight: bold;
}
.nav-link {
    display: block;
    padding: var(--bs-nav-link-padding-y) var(--bs-nav-link-padding-x);
    font-size: var(--bs-nav-link-font-size);
    font-weight: var(--bs-nav-link-font-weight);
    color: black;
    text-decoration: none;
}
.card-header {
    padding: var(--bs-card-cap-padding-y) var(--bs-card-cap-padding-x);
    margin-bottom: 0;
    color: var(--bs-card-cap-color);
    background-color: white;
    border-bottom: var(--bs-card-border-width) solid var(--bs-card-border-color);
}
</style>