<template>
    <li style="text-align: left; margin-top: 8px;">
        <b-avatar size="30px" :src="src" style="margin: 0px 3px 0px 0px;">
        </b-avatar>
        {{ email }}
    </li>
</template>

<script>
export default {
    props: {
        email: String,
        src: String,
    },
}
</script>

<style>
li{
    margin-bottom: 9px;
}
</style>