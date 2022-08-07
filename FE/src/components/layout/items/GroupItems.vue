<template>
    <li style="text-align: left;">
        <b-avatar size="30px" :src="src" style="margin: 0px 5px 5px 0px;">
        </b-avatar>
        {{ id }}
    </li>
</template>

<script>
export default {
    props: {
        id: String,
        src: String,
    },
    mounted() {
        console.log(this.id + " , " + this.src);
    }
}
</script>

<style>
</style>