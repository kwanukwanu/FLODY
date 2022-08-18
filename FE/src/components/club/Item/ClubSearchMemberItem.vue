<template>
  <div class="person">
    <b-avatar variant="info" :src=profile size="20px"></b-avatar>
    {{email}}
  </div>
</template>

<script>
export default {
  props: {
    index: Number,
    gmNo: Number,
    email: String,
    profile: String,
    role: String,
  },
  data() {
    return {
    }
  },
  setup(){
  },
  mounted() {
  },
  methods: {
  }
};
</script>

<style></style>
