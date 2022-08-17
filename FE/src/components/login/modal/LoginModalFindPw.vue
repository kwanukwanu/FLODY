<template>
    <b-card>
        <!-- <h1>비밀번호 찾기</h1> -->
        <b-container>
            <b-row class="justify-content-md-center">
                <b-card style="height: 27rem; max-width: 40rem; background-color: #F8F3F3;">
                    <b-container ref="form">
                        <br>
                        <b-row>
                            <b-col>
                                <b-form-input placeholder="이메일 주소" required style="border: none;"
                                    @keyup="emailChecking()">
                                </b-form-input>
                            </b-col>
                        </b-row>
                        <br>
                        <b-row>
                            <b-col>
                                <b-form-input placeholder="성명" style="border: none;"></b-form-input>
                            </b-col>
                        </b-row>
                        <br>
                        <b-row>
                            <b-col>
                                <b-form-input type="password" placeholder="비밀번호" style="border: none;"
                                    @keyup="pwChecking"></b-form-input>
                            </b-col>
                        </b-row>
                        <br>
                        <b-row>
                            <b-col>
                                <b-form-input type="password" placeholder="비밀번호 확인" style="border: none;">
                                </b-form-input>
                            </b-col>
                        </b-row>
                        <br>
                        <b-row>
                            <b-col>
                                <b-form-input placeholder="휴대폰 번호" style="border: none;" @keyup="getMask(user.phone)">
                                </b-form-input>
                            </b-col>
                        </b-row>
                        <br>
                        <b-col>
                            <div class="button">
                                <b-button text @click="submit"
                                    style="color: #453535; background-color: #E1D3D2; border: none;">회원가입
                                </b-button>
                            </div>
                            <div class="button">
                                <b-button text @click="back"
                                    style="color: #453535; background-color: #E1D3D2; border: none;"> 취소
                                </b-button>
                            </div>
                        </b-col>
                    </b-container>
                </b-card>
            </b-row>
        </b-container>
    </b-card>
</template>

<script>
export default {

}
</script>

<style>
.btn-close{
  box-shadow: none !important;
  outline: none !important;
}
</style>