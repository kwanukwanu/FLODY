<template>
  <div> Study calandar</div>
    <calendar></calendar>
    <DatePicker v-model="date"></DatePicker>
  <div>calendar end</div>
</template>

<script>
import 'v-calendar/dist/style.css';
import { Calendar, DatePicker } from 'v-calendar';
export default {
  components: {
      Calendar,
      DatePicker,
    },
    data() {
      return {
        date: new Date(),
      };
    },
}
</script>

<style>

</style>