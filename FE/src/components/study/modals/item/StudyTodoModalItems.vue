<template>
    <b-card style="min-height: 12rem; max-width: 30rem; background-color: #f8f3f3">
        <b-container ref="form">
            <b-row style="margin-bottom: 10px;">
                <b-col cols="10" style="padding: 0; margin-left: 10px;">
                    <b-form-input id="todo_content" placeholder="내용 입력..." aria-placeholder="할 일..." required
                        style="border: none;"></b-form-input>
                </b-col>
                <b-col id="study_lookup_button_space" style="padding: 0; margin-left: 6px;">
                    <div style="text-align:center">
                        <b-button size="sm" id="study_lookup-button" text style="color: #453535; background-color: #E1D3D2; border: none; 
              vertical-align:-webkit-baseline-middle;" @click="todosInsert()">
                            <svg width="20" height="20" fill="none" xmlns="http://www.w3.org/2000/svg"
                                style="color:red;">
                                <path
                                    d="M10 6.667v6.666M6.667 10h6.666m5 0a8.333 8.333 0 1 1-16.666 0 8.333 8.333 0 0 1 16.666 0Z"
                                    stroke="#444" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
                            </svg>
                        </b-button>
                    </div>
                </b-col>
            </b-row>
            <div id="todosField" style="height:50px; overflow-y: scroll;">

            </div>
            <br />
            <b-button text @click="submit" style="color: #453535; background-color: #e1d3d2; border: none">등록
            </b-button>
        </b-container>
    </b-card>
</template>

<script>
export default {
    methods: {
        todosInsert() {
            let todo_content = document.getElementById('todo_content');
            let todos_field = document.getElementById('todosField');
            console.log(todo_content.value);
            console.log(todos_field);
            if (todo_content.value !== '') {
                const item = document.createElement('div')
                // text
                const text = document.createElement('span');
                // 제거하기 버튼
                const deleteButton = document.createElement('a');
                // <span id="delete" class="material-icons" style="vertical-align: sub; cursor: pointer;">delete</span>
                deleteButton.innerHTML = `
                                <svg id="delete" width="20" height="20" fill="none" xmlns="http://www.w3.org/2000/svg" style="vertical-align: sub; cursor: pointer;">
                                  <path d="M6.667 10h6.666m5 0a8.333 8.333 0 1 1-16.666 0 8.333 8.333 0 0 1 16.666 0Z" stroke="#444"
                                    stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
                                </svg>
                              `;

                text.textContent = todo_content.value
                todo_content.value = ''

                item.appendChild(text)
                item.appendChild(deleteButton)
                todos_field.appendChild(item)

                deleteButton.addEventListener('click', (event) => {
                    todos_field.removeChild(event.currentTarget.parentNode)
                })
                todo_content.value = ''
            }
        },
    }
}
</script>

<style>
</style>