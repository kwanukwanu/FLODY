<template>
    <!-- <h1>비밀번호 찾기</h1> -->
    <b-container>
        <b-row class="justify-content-md-center">
            <!-- <b-card style="height: 27rem; max-width: 40rem; background-color: #F8F3F3;">
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
                </b-card> -->
            <b-row style="padding:0px 0px">
                <b-col cols="9" style="padding:0px 0px"></b-col>
                <b-col cols="3" style="text-align:right; padding:0px 0px">
                    <b-button @click="Cancel" size="sm"
                        style="color: #A48282; background-color:white; border-color: white; padding: 0px 8px;"
                        data-bs-dismiss="modal" aria-label="Close"><svg width="24" height="24" fill="none"
                            xmlns="http://www.w3.org/2000/svg">
                            <path d="M18 6 6 18M6 6l12 12" stroke="#444" stroke-width="2" stroke-linecap="round"
                                stroke-linejoin="round" />
                        </svg></b-button>
                </b-col>
            </b-row>

            <b-row>
                <div style="text-align: center; margin-bottom:8px;">
                    <svg width="96" height="101" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path
                            d="M48 92.5c22.091 0 40-18.824 40-42.045S70.091 8.409 48 8.409 8 27.234 8 50.455C8 73.675 25.909 92.5 48 92.5Z"
                            stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
                        <path
                            d="M54.926 55.478c-.282-.89-.423-1.335-.416-1.699.008-.383.057-.584.224-.923.16-.324.586-.74 1.439-1.574C58.527 48.979 60 45.692 60 42.046c0-6.967-5.373-12.614-12-12.614s-12 5.647-12 12.613c0 3.648 1.473 6.934 3.827 9.237.853.834 1.28 1.25 1.439 1.574.167.34.216.54.224.923.007.364-.134.809-.416 1.699l-3.67 11.572c-.474 1.495-.711 2.242-.569 2.837a2.1 2.1 0 0 0 .864 1.26c.492.33 1.242.33 2.74.33H55.56c1.5 0 2.249 0 2.74-.33a2.1 2.1 0 0 0 .865-1.26c.142-.595-.095-1.342-.569-2.837l-3.67-11.572Z"
                            stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
                    </svg>
                </div>
            </b-row>
            <div style="font-weight:bold; font-size: 16px; margin-bottom: 7px;">로그인에 문제가 있나요?</div>
            <div style="font-size:14px; margin-bottom:18px">아래의 정보를 입력하시면 계정에 다시 액세스할 수 있는<br>링크를 보내드립니다.</div>
            <br><br />
            <b-row>
                <b-col>
                    <b-form-input placeholder="이메일 주소" required style="border-color: #B99B9A; margin-bottom: 12px;"
                        @keyup="emailChecking()">
                    </b-form-input>
                </b-col>
            </b-row>
            <b-row>
                <b-col>
                    <b-form-input placeholder="휴대폰 번호" style="border-color: #B99B9A; margin-bottom: 12px;"
                        @keyup="getMask(user.phone)">
                    </b-form-input>
                </b-col>
            </b-row>
            <br>
            <b-row>
                <b-col>
                    <b-form-input placeholder="성명" style="border-color: #B99B9A; margin-bottom: 20px;"></b-form-input>
                </b-col>
            </b-row>
            <br>
            <b-button size="sm" style="width:90%; background-color:#B5C8C3; border-color: #B5C8C3;">로그인 링크 보내기
            </b-button>
            <br>
        </b-row>
    </b-container>

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