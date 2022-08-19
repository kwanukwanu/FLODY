<template>
  <!-- <b-row>
    <b-col>
      <b-row>
<h4 style="font-weight:bold">{{selectGroups.name}}</h4>
      </b-row>
      <b-row>
<h5>{{selectGroups.name}}</h5>
      </b-row>
    </b-col>
    <b-col>
      <h1 style="color:red; font-weight:600; text-align: right;">D-3</h1>
    </b-col>
    </b-row> -->
    <b-row>
      
    </b-row>
</template>

<script>
import {computed} from "vue";
import {useStore} from "vuex";

export default {
  
  data(){
    return{
    }
  },
  setup(){
    const store = useStore();
    const selectGroups = computed(()=>store.state.groupStore.selectGroups);

    return {store, selectGroups};
  },
  mounted(){
    console.log("name : ");
    console.log(this.selectGroups.name);
  }
}
</script>

<style>

</style>