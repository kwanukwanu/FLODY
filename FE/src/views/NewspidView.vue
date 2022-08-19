<template>
  <newspid-header />
  <newspid-detail v-for="item in newspids" :key="item" v-bind="item" />
</template>

<script>
import { computed } from "vue";
import { useStore } from "vuex";

import NewspidHeader from '@/components/newspid/NewspidHeader.vue'
import NewspidDetail from '@/components/newspid/NewspidDetail.vue'
export default {
  components: { NewspidHeader, NewspidDetail },
  setup() {
    const store = useStore();
    const newspids = computed(() => store.state.newspidStore.newspids);
    return { store, newspids };
  },
  mounted() {
  }
}
</script>

<style>
</style>