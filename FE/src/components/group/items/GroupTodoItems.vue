<template>
    <li>
        <div class="checkbox">
            <input type="checkbox" name="packersOff" :id="index" :checked="isComplete" />
            <label :for="index" class="strikethrough">{{ description }}</label>
        </div>
    </li>
</template>

<script>
export default {
    props: {
        index: Number,
        dates: Object,
        description: String,
        isComplete: Boolean,
    },
    mounted() {
        // console.log(this.index + " , " + this.description);
    }
}
</script>

<style>
</style>