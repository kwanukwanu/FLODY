<template>
    <b-row>
        <b-col cols="8">
            <b-card-text class="test_name" @click="deleteGoal()">{{ title }}</b-card-text>
        </b-col>
        <b-col cols="4">
            <b-card-text class="howmuchleft" style="color:#BC6464; font-weight: bold;">D-{{ dateSet }}</b-card-text>
        </b-col>
    </b-row>
</template>

<script>
import { useStore } from "vuex";
import { delete_goal } from "@/api/goal";

export default {
    props: {
        title: String,
        dueDate: String,
        ugNo: Number,
    },
    setup() {
        const store = useStore();
        return { store };
    },
    mounted() {
        console.log(this.title + " , " + this.dueDate);
    },
    computed: {
        dateSet() {
            const now = new Date();
            const future = new Date(this.dueDate);
            const subtime = future - now;
            const res = subtime / 1000 / 60 / 60 / 24;
            if (res % 1 != 0)
                return (res - res % 1) + 1;
            else return res;
        }
    },
    methods: {
        deleteGoal() {
            // let result = confirm("Do you want to delete this goal?");
            // if(result == true) {
            //   alert("삭제");
            // }
            this.$swal.fire({
                title: '정말로 그렇게 하시겠습니까?',
                text: "다시 되돌릴 수 없습니다. 신중하세요.",
                icon: 'error',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: '삭제',
                cancelButtonText: '취소'
            }).then((result) => {
                if (result.isConfirmed) {
                    console.log(this.ugNo);
                    delete_goal(
                        this.ugNo,
                        (response) => {
                            if (response.data.msg === "SUCCESS") {
                                this.$swal.fire(
                                    '승인이 완료되었습니다.',
                                    '화끈하시네요~!',
                                    'success'
                                );
                                this.getPlans();
                            }
                        },
                        (error) => {
                            console.log(error);
                        }
                    )
                }
            })
        },
        async getPlans() {
            // 여기서 axios를 통해 목표를 받아온다.
            await this.store.dispatch("memberStore/setgoals");
        },
    }
}
</script>

<style>
</style>