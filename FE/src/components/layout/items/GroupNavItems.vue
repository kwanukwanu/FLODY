<template>
    <b-row style="text-align: left;">
        <details>
            <summary style="font-weight: bold; margin-top: 7px;">
                {{ name }}
                <router-link :to="{ name: 'group' }"><svg id="move" width="18" height="18" fill="none"
                        xmlns="http://www.w3.org/2000/svg">
                        <path
                            d="m9 12 3-3m0 0L9 6m3 3H6m-.15 6.75h6.3c1.26 0 1.89 0 2.371-.245.424-.216.768-.56.984-.984.245-.48.245-1.11.245-2.371v-6.3c0-1.26 0-1.89-.245-2.371a2.25 2.25 0 0 0-.984-.984c-.48-.245-1.11-.245-2.371-.245h-6.3c-1.26 0-1.89 0-2.371.245a2.25 2.25 0 0 0-.984.984c-.245.48-.245 1.11-.245 2.371v6.3c0 1.26 0 1.89.245 2.371.216.424.56.768.984.984.48.245 1.11.245 2.371.245Z"
                            stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
                    </svg></router-link>
            </summary>

            <ul>
                <group-items v-for="item in groups" :key="item" v-bind="item"></group-items>
            </ul>
        </details>
    </b-row>
</template>

<script>
import GroupItems from "@/components/layout/items/GroupItems.vue";
export default {
    components:{
        GroupItems,
    },
    props: {
        name: String,
        groups: Array,
    },
    data() {
        return {
        }
    },
    mounted(){
        console.log(this.groups);
    }
}
</script>

<style>
</style>