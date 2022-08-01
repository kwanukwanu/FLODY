<template>  
  <div>
    <!-- <v-for="(item, index) in items" :key="index"></v-for> -->
    <newspid-detail></newspid-detail>
  </div>

</template>

<script>
import NewspidDetail from './NewspidDetail.vue'
export default {
  data() {
    return {
      listnum:5,
    }
  },
  components: { NewspidDetail },

}
</script>

<style>

</style>