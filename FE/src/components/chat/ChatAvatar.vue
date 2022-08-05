<template>
  <img class="avatar" :src="src" style="width: 70px; height: 70px;"/>
</template>

<script>
export default {
  props: { src: { type: String, default: '' } }
}
</script>