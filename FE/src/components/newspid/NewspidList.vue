<template>
  <div>
    <!-- header -->
    <b-row rows="2">
      <newspid-list-header></newspid-list-header>
    </b-row>
    <hr style="margin: 5px;">
    <!-- body -->
    <b-row rows="8">
      <newspid-list-body></newspid-list-body>
    </b-row>
    <hr style="margin: 5px;">
    <!-- footer -->
    <b-row rows="2">
      <newspid-list-footer></newspid-list-footer>
    </b-row>
  </div>

</template>

<script>
import NewspidListHeader from "@/components/newspid/lists/NewspidListHeader.vue";
import NewspidListBody from "@/components/newspid/lists/NewspidListBody.vue";
import NewspidListFooter from "@/components/newspid/lists/NewspidListFooter.vue";

export default {
  components:{ 
    NewspidListHeader, 
    NewspidListBody, 
    NewspidListFooter},
  data() {
    return {
      listnum:5,
    }
  },

}
</script>

<style>

</style>