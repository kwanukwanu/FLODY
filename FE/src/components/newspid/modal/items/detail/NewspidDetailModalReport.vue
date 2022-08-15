<template>
    <b-card style="height: 23rem; max-width: 30rem; background-color: #f8f3f3">
        <b-container ref="form">
            <b-row style="margin-bottom: 10px">
                <b-col>
                    <b-form-textarea id="content" placeholder="신고 내용" rows="10" max-rows="15" required
                        style="border: none">
                    </b-form-textarea>
                </b-col>
            </b-row>
            <br />
            <b-button text @click="submit" style="color: #453535; background-color: #e1d3d2; border: none">제출</b-button>
        </b-container>
    </b-card>
</template>

<script>

export default {

}
</script>

<style>

</style>