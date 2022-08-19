<template>
    <b-row style="text-align: left; margin-bottom: 10px;">
        <details>
            <summary style="font-weight: bold; margin-top: 7px;">
                {{ groName }}
                <!-- <b-button size="sm" variant="link" @click="gotoPage('/group')">
                    <svg width="24" height="24" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path
                            d="m12 16 4-4m0 0-4-4m4 4H8m-.2 9h8.4c1.68 0 2.52 0 3.162-.327a3 3 0 0 0 1.311-1.311C21 18.72 21 17.88 21 16.2V7.8c0-1.68 0-2.52-.327-3.162a3 3 0 0 0-1.311-1.311C18.72 3 17.88 3 16.2 3H7.8c-1.68 0-2.52 0-3.162.327a3 3 0 0 0-1.311 1.311C3 5.28 3 6.12 3 7.8v8.4c0 1.68 0 2.52.327 3.162a3 3 0 0 0 1.311 1.311C5.28 21 6.12 21 7.8 21Z"
                            stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
                    </svg>
                </b-button> -->
                <router-link :to="{ name: 'group', params: { name: 'name' } }">
                    <svg id="move" width="18" height="18" fill="none" xmlns="http://www.w3.org/2000/svg"
                        style="margin-left:8px; margin-bottom:4px" @click="gotoPage()">
                        <path
                            d="m9 12 3-3m0 0L9 6m3 3H6m-.15 6.75h6.3c1.26 0 1.89 0 2.371-.245.424-.216.768-.56.984-.984.245-.48.245-1.11.245-2.371v-6.3c0-1.26 0-1.89-.245-2.371a2.25 2.25 0 0 0-.984-.984c-.48-.245-1.11-.245-2.371-.245h-6.3c-1.26 0-1.89 0-2.371.245a2.25 2.25 0 0 0-.984.984c-.245.48-.245 1.11-.245 2.371v6.3c0 1.26 0 1.89.245 2.371.216.424.56.768.984.984.48.245 1.11.245 2.371.245Z"
                            stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
                    </svg>
                </router-link>
            </summary>

            <ul style="list-style: none;">
                <group-items v-for="item in memberList" :key="item" v-bind="item"></group-items>
            </ul>
        </details>
    </b-row>
</template>

<script>
import { useStore } from "vuex";

import GroupItems from "@/components/layout/items/GroupItems.vue";
export default {
    components: {
        GroupItems,
    },
    props: {
        groNo: Number,
        groName: String,
        memberList: Array,
    },
    data() {
        return {
        }
    },
    setup() {
        const store = useStore();
        return { store };
    },
    methods: {
        gotoPage() {
            const data = {
                groNo: this.groNo,
                name: this.groName,
                memberList: this.memberList,
            };
            console.log(data);
            this.store.dispatch("groupStore/selectGroups", data);
            // this.$router.push(link);
        },
    },
}
</script>

<style>
</style>