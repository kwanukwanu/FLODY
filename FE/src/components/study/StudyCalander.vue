<template>
  <div>Study calandar</div>
  <v-calendar :attributes='attributes'></v-calendar>
  <div>calendar end</div>
</template>

<script>
export default {
  data() {
    //todo : description(할 일), isComplete(완료여부), dates(날짜), color(색상표시)
    // weekday : 요일, 1(일),2(월),3(화),4(수),5(목),6(금),7(토)
    const todos = [
      {
        description: 'Take Noah to basketball practice.',
        isComplete: false,
        dates: { months:7, days: 18},
        color: 'red',
      },
      {
        description: 'Take Noah to basketball practice.',
        isComplete: true,
        dates: { weekdays: 5 },
        color: 'blue',
      },
    ];
    return {
      incId: todos.length,
      todos,
    };
  },
  computed: {
    attributes() {
      return [
        // Attributes for todos
        ...this.todos.map(todo => ({
          dates: todo.dates,
          dot: {
            color: todo.color,
            class: todo.isComplete ? 'opacity-75' : '',
          },
          popover: {
            label: todo.description,
            visibility: 'focus'
          },
          customData: todo,
        })),
      ];
    },
  },
};
</script>

<style></style>
