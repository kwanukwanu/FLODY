<template>
    <b-row>
        <b-col cols="8">
            <b-card-text class="test_name">{{subject}}</b-card-text>
        </b-col>
        <b-col cols="4">
            <b-card-text class="howmuchleft" style="color:#BC6464; font-weight: bold;">D-{{mod}}</b-card-text>
        </b-col>
    </b-row>
</template>

<script>
export default {
    props:{
        subject : String,
        mod : Number,
    },
}
</script>

<style>

</style>