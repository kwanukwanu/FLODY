<template>  
  <div>
    <!-- <v-for="(item, index) in items" :key="index"></v-for> -->
    <newspid-item></newspid-item>
  </div>

</template>

<script>
import NewspidItem from './items/NewspidItem.vue'
export default {
  data() {
    return {
      listnum:5,
    }
  },
  components: { NewspidItem },

}
</script>

<style>

</style>