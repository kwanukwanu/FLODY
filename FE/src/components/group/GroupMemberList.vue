<template>
    <b-card class="wrap-vertical">
        <div id="tab">
            <ul style="padding: 0px 0px 0px 0px; margin:0px 0px 0px 0px">
                <group-member-list-item v-for="item in selectGroup.memberList" :key="item" v-bind="item">
                </group-member-list-item>
            </ul>
        </div>
    </b-card>
</template>

<script>
import { computed } from "vue";
import { useStore } from "vuex";
import GroupMemberListItem from "./items/GroupMemberListItem.vue";

export default {
  components: {
    GroupMemberListItem,
  },
  setup() {
    const store = useStore();
    const memberList = computed(() => store.state.groupStore.groupMember);
    const selectGroup = computed(() => store.state.groupStore.selectGroups);
    return { store, memberList, selectGroup };
  },
  mounted() {
    console.log("groupInfo");
    console.log(this.selectGroup);
  }
}
</script>

<style>
</style>