<template>
    <li>
        <div class="checkbox">
            <input type="checkbox" name="packersOff" :id="index" :checked="isCompleted" />
            <label :for="index" class="strikethrough">&nbsp;{{ description }}</label>
        </div>
    </li>
</template>

<script>
export default {
    props: {
        index: Number,
        description: String,
        isCompleted: Boolean,
    }
}
</script>

<style>
</style>