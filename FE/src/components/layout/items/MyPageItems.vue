<template>
    <b-row>
        <b-col cols="8">
            <b-card-text class="test_name">{{ name }}</b-card-text>
        </b-col>
        <b-col cols="4">
            <b-card-text class="howmuchleft" style="color:#BC6464; font-weight: bold;">D-{{ dateSet }}</b-card-text>
        </b-col>
    </b-row>
</template>

<script>
export default {
    props: {
        name: String,
        dueDate: String,
    },
    mounted() {
        console.log(this.name + " , " + this.dueDate);
    },
    computed: {
        dateSet() {
            const now = new Date();
            const future = new Date(this.dueDate);
            const subtime = future - now;
            const res = subtime / 1000 / 60 / 60 / 24;
            if (res % 1 != 0)
                return (res - res % 1) + 1;
            else return res;
        }
    }
}
</script>

<style>
</style>