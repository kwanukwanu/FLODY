<template>
  <div> Study calandar</div>
    <calendar></calendar>
    <DatePicker></DatePicker>
  <div>calendar end</div>
</template>

<script>
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