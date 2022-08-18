<template>
    <li>
        <a>
            <b-avatar variant="info" :src="memberInfo.profile" size="70px" style="margin-bottom:5px;">
            </b-avatar>
            <!-- cursor: pointer;
                  v-b-modal.modal-14 -->
        </a><br />{{ email }}<a v-if="role == `OWNER`"> (owner) </a>
    </li>
</template>

<script>
//import { computed } from "vue";
//import { getUserInfo } from "@/api/member";
import { useStore } from "vuex";

export default {
    props: {
        email: String,
        gmNo: Number,
        profile: String,
        role: String,
    },
    data() {
        return {
            memberInfo: {
                email: this.email,
                nickname: "",
                profile: this.profile,
                role: this.role,
            }
        }
    },
    setup() {
        const store = useStore();
        return { store };
    },
    mount() {
        console.log("email : " + this.email);
    },

}
</script>

<style>
</style>