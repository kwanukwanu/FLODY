<template>
    <li>
        <div class="checkbox">
            <input type="checkbox" name="packersOff" :id="index" :checked="isComplete" @click="logingCheckbox()" style="margin-right: 7px"/>
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
    data() {
        return {

        }
    },
    mounted() {
        // console.log(this.index + " , " + this.description);
    },
    methods: {
        logingCheckbox() {
            console.log(this.description);
            console.log(this.isComplete);
        }
    }
}
</script>

<style>
</style>