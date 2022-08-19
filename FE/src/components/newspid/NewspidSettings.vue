<template>
    <b-card>
        <b-tabs pills card vertical>
            <b-tab title="프로필 편집" active>
                <b-row style="margin-bottom:18px;">
                    <b-col cols="3" style="text-align: right; font-weight: bold;">
                        <b-avatar variant="info" :src="set_userInfo.profile" size="40px"></b-avatar>
                    </b-col>
                    <b-col cols="9">
                        <b-row>
                            <div style="margin-left:1px; font-size:large;">{{ set_userInfo.email }}</div>
                        </b-row>
                        <b-row style="color:#064635; font-size: small;">
                            <a> 프로필 사진 바꾸기
                            </a>
                        </b-row>
                    </b-col>
                </b-row>

                <b-row style="margin-bottom:18px;">
                    <b-col cols="3" style="text-align: right; font-weight: bold;">
                        이름
                    </b-col>
                    <b-col cols="9">
                        <b-form-input id="content" v-model="set_userInfo.name" placeholder="이름" style="width:500px;">
                        </b-form-input>
                    </b-col>
                </b-row>

                <b-row style="margin-bottom:18px;">
                    <b-col cols="3" style="text-align: right; font-weight: bold;">
                        사용자 이름
                    </b-col>
                    <b-col cols="9">
                        <b-form-input id="content" v-model="set_userInfo.nickname" placeholder="사용자 이름"
                            style="width:500px;">
                        </b-form-input>
                    </b-col>
                </b-row>

                <b-row style="margin-bottom:18px;">
                    <b-col cols="3" style="text-align: right; font-weight: bold;">
                        소개
                    </b-col>
                    <b-col cols="9">
                        <b-form-textarea id="content" v-model="set_userInfo.introduction" placeholder="소개"
                            style="width:500px;">
                        </b-form-textarea>
                    </b-col>
                </b-row>

                <b-row style="margin-bottom:18px;">
                    <b-col cols="3" style="text-align: right; font-weight: bold;">
                        주소
                    </b-col>
                    <b-col cols="9">
                        <b-form-input id="content" v-model="set_userInfo.address" placeholder="주소" style="width:500px;">
                        </b-form-input>
                    </b-col>
                </b-row>

                <b-row style="margin-bottom:18px;">
                    <b-col cols="3" style="text-align: right; font-weight: bold;">
                        전화번호
                    </b-col>
                    <b-col cols="9">
                        <b-form-input id="content" v-model="set_userInfo.phone" placeholder="전화번호" style="width:500px;">
                        </b-form-input>
                    </b-col>
                </b-row>

                <b-row>
                    <b-col cols="3"></b-col>
                    <b-col cols="9">
                        <b-button text @click="submit_profile()"
                            style="color: white; background-color: #83A39A; border: none;">제출
                        </b-button>
                    </b-col>
                </b-row>
            </b-tab>

            <b-tab title="비밀번호 변경">
                <b-row style="margin-bottom:28px;">
                    <b-col cols="3" style="text-align: right; font-weight: bold;">
                        <b-avatar variant="info" :src="userInfo.profile" size="40px"></b-avatar>
                    </b-col>
                    <b-col cols="9">
                        <span style="margin-left:1px; font-size: x-large;">{{ userInfo.email }}</span>
                    </b-col>
                </b-row>

                <b-row style="margin-bottom:18px;">
                    <b-col cols="3" style="text-align: right; font-weight: bold;">
                        이전 비밀번호
                    </b-col>
                    <b-col cols="9">
                        <b-form-input type="password" id="content" placeholder="" style="width:500px;"
                            v-model="set_password.currentPassword">
                        </b-form-input>
                    </b-col>
                </b-row>

                <b-row style="margin-bottom:18px;">
                    <b-col cols="3" style="text-align: right; font-weight: bold;">
                        새 비밀번호
                    </b-col>
                    <b-col cols="9">
                        <b-form-input type="password" id="content" placeholder="" style="width:500px;"
                            v-model="set_password.newPassword">
                        </b-form-input>
                    </b-col>
                </b-row>


                <b-row style="margin-bottom:18px;">
                    <b-col cols="3" style="text-align: right; font-weight: bold;">
                        새 비밀번호 확인
                    </b-col>
                    <b-col cols="9">
                        <b-form-input id="content" type="password" placeholder="" style="width:500px;"
                            v-model="set_password.checkNewPassword">
                        </b-form-input>
                    </b-col>
                </b-row>
                <b-row>
                    <b-col cols="3"></b-col>
                    <b-col cols="9">
                        <b-button text @click="submit_password()"
                            style="color: white; background-color: #83A39A; border: none;">
                            비밀번호 변경
                        </b-button>
                    </b-col>
                </b-row>
            </b-tab>
        </b-tabs>
    </b-card>
</template>

<script>

import { modifyMember, modifyPassword } from "@/api/member";
import { computed } from "vue";
import { useStore } from "vuex";

export default {
    data() {
        return {
            set_userInfo: {
                address: "",
                profile: "",
                name: "",
                nickname: "",
                introduction: "",
                phone: "",
            },
            set_password: {
                currentPassword: "",
                newPassword: "",
                checkNewPassword: "",
            }
        }
    },
    setup() {
        const store = useStore();
        const userInfo = computed(() => store.state.memberStore.userInfo);
        return { store, userInfo };
    },
    mounted() {
        this.set_userInfo.profile = this.userInfo.profile;
        this.set_userInfo.name = this.userInfo.name;
        this.set_userInfo.email = this.userInfo.email;
        this.set_userInfo.address = this.userInfo.address;
        this.set_userInfo.nickname = this.userInfo.nickname;
        this.set_userInfo.phone = this.userInfo.phone;
        this.set_userInfo.introduction = this.userInfo.introduction;
    },
    methods: {
        async submit_profile() {
            const url = "https://placekitten.com/300/" + ((Math.floor(Math.random() * (9 - 1)) + 1) * 100);
            this.set_userInfo.profile = url;
            console.log(this.set_userInfo);
            await modifyMember(
                this.set_userInfo,
                (response) => {
                    console.log(response);
                    if (response.data.msg === "SUCCESS") {
                        alert("변경되었습니다.");
                        this.store.dispatch("memberStore/getUserInfo", this.userInfo.email);
                        this.store.dispatch("newspidStore/set_profile", this.userInfo);
                    }
                    else {
                        alert("변경에 문제가 발생하였습니다.");
                    }
                },
                (error) => {
                    console.log(error);
                })
        },
        async submit_password() {
            console.log(this.set_password);
            await modifyPassword(
                this.set_password,
                (response) => {
                    console.log(response);
                    if (response.data.msg === "SUCCESS") {
                        alert("변경되었습니다.");
                    }
                    else {
                        alert("변경에 문제가 발생하였습니다.");
                    }
                },
                (error) => {
                    console.log(error);
                })
        },
    },
}
</script>

<style>
.nav-pills .nav-link.active,
.nav-pills .show>.nav-link {
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