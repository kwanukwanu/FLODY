<template>
  <div>Study calandar</div>
  <DatePicker
    v-model="dates"
    :value="null"
    color="red"
    style="background-color: #fafafa"
  ></DatePicker>
  <div>calendar end</div>
</template>

<script>
import "v-calendar/dist/style.css";
import { DatePicker } from "v-calendar";
export default {
  components: {
    DatePicker,
  },
  data() {
    return {
      dates: [
        { start: new Date(2022, 7, 1), end: new Date(2022, 7, 5) },
        { start: new Date(2022, 7, 10), end: new Date(2022, 7, 15) },
      ],
      range: {
        start: new Date(2022, 0, 1),
        end: new Date(2022, 0, 5),
      },
    };
  },
};
</script>

<style></style>
