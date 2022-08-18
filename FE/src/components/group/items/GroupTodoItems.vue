<template>
    <li>
        <div class="checkbox">
            <input type="checkbox" name="packersOff" :id="index" :checked="isComplete" @click="logingCheckbox()"
                style="margin-right: 7px" />
            <label :for="index" class="strikethrough">{{ title }}</label>
        </div>
    </li>
</template>

<script>
import { computed } from "vue";
import { useStore } from "vuex";

import { modify_group_schedule } from "@/api/group";


export default {
    props: {
        index: Number,
        gsNo: Number,
        title: String,
        detail: String,
        startDate: String,
        endDate: String,
        done: Boolean,
    },
    data() {
        return {

        }
    },
    mounted() {
        // console.log(this.index + " , " + this.description);
    },
    setup() {
        const store = useStore();
        const selectGroup = computed(() => store.state.groupStore.selectGroups);
        const selectDate = computed(() => store.state.groupStore.selectedDate);
        return { store, selectGroup, selectDate };
    },
    methods: {
        async logingCheckbox() {
            console.log(this.title);
            console.log(this.startDate);
            console.log(this.endDate);
            console.log(this.done);
            const data = {
                title: this.title,
                detail: this.detail,
                startDate: this.startDate,
                endDate: this.endDate,
                done: !this.done,
            };
            console.log("data");
            console.log(data);
            const data2 = {
                groNo: this.selectGroup.groNo,
                selectedDate: this.selectDate,
            };
            console.log("data2");
            console.log(data2);
            await modify_group_schedule(
                this.gsNo, data,
                (response) => {
                    console.log(response);
                    if (response.data.msg === "SUCCESS") {
                        console.log("수정 완료!");
                        this.store.dispatch("groupStore/set_todo_list", data2);
                    }
                },
                (error) => {
                    console.log(error);
                }
            );
        }
    }
}
</script>

<style>
</style>