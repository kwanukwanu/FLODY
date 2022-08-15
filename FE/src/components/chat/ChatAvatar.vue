<template>
  <img class="avatar" :src="src" style="width: 24px; height: 24px; border-radius: 50%;"/>
</template>

<script>
export default {
  props: { src: { type: String, default: '' } },
}
</script>