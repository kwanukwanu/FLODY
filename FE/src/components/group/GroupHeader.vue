<template>
  <b-card>
    <b-row>
      <b-col>
        <b-row>
          <h4 style="font-weight:bold">{{ selectGroup.name }}</h4>
        </b-row>
        <b-row>
          <!-- <h5>({{ selectGroup.groNo }})</h5> -->
        </b-row>
      </b-col>
      <!-- <b-col>
                <h1 style="color:red; font-weight:600; text-align: right;">D-3</h1>
            </b-col> -->
    </b-row>
  </b-card>

</template>

<script>
import { computed } from "vue";
import { useStore } from "vuex";
export default {
  setup() {
    const store = useStore();
    const selectGroup = computed(() => store.state.groupStore.selectGroups);
    return { store, selectGroup };
  },
  mounted() {
    console.log("sel Group : ");
    console.log(this.selectGroup);
  }
}
</script>

<style>
</style>