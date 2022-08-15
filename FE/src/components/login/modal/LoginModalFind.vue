<template>
    <b-container ref="form">
        <b-row>
            <login-modal-find-id v-if="idfind"></login-modal-find-id>
            <login-modal-find-pw></login-modal-find-pw>
        </b-row>
    </b-container>
</template>

<script>
import LoginModalFindId from "./LoginModalFindId.vue";
import LoginModalFindPw from "./LoginModalFindPw.vue";

export default {
    components: {
        LoginModalFindId,
        LoginModalFindPw,
    },
    data() {
        return {
        }
    },
    methods: {
        cancel() {
            this.pwfind = false;
            this.idfind = false;
            this.select = false;
        }
    },
    mounted() {
    },
}
</script>

<style>
</style>