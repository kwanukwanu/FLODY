<template>
    <div style="height:297px;">
        <b-row>
            <b-col cols="2" style="padding: 4px;">
                <div class="avatar">
                    <b-avatar variant="info" src="https://placekitten.com/300/300" size="50px"></b-avatar>
                </div>
            </b-col>
            <b-col>
                <b-row>
                    <div style="text-align: left; padding: 0px; font-weight: bold;">Brown_Cat</div>
                </b-row>
                <b-row>
                    <div style="text-align: left; padding: 0px;">공부를 놓지 않는다. 취한다.</div>
                </b-row>
                <b-row>
                    <b-col>
                        <a v-for="tag in tags" :key="tag" style="text-align: left; padding: 0px; color: #255D4E">
                            #{{ tag }}</a>
                    </b-col>
                </b-row>
                <b-row style="margin-bottom: 5px;">
                    <div style="text-align: left; padding: 0px; color: gray; font-size: small;">15시간전</div>
                </b-row>
            </b-col>
        </b-row>
        <b-row>
            <newspid-item v-for="(item) in items" :key="item" v-bind="item">
            </newspid-item>
        </b-row>
    </div>
</template>

<script>
import NewspidItem from "@/components/newspid/items/NewspidItem.vue"

import { computed } from "vue";
import { useStore } from "vuex";

export default {
    components: {
        NewspidItem,
    },
    data() {
        return {
            tags: ["영국", "런던", "스터디"],
            Myname: "Brown_Cat",

        }
    },
    setup() {
        const store = useStore();
        const items = computed(() => store.state.newspidStore.comments);
        return { store, items };
    }
}
</script>

<style>
</style>