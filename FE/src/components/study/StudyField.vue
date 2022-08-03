<template>
  <h2>field</h2>
  <div id="fi">
    <img src="@/assets/flower.png" class="w-10" style="height: 100px; cursor: grab;" @mousedown="startDrag()"/>
  </div>
</template>

<script>
export default {
    data(){
        return{
            pos:{
                posX:0,
                posY:0,
            },
        }
    },
    methods: {
    startDrag(){
        /*
        드래그를 할때
        posX 에는 그림에대한 x 위치를,
        posy 에는 그림에 대한 y 위치를 받아온다
        */


        // posX = getLeft(obj) - e_obj.clientX;
        // posY = getTop(obj) - e_obj.clientY;

        // document.onmousemove = moveDrag;
        // document.onmouseup = stopDrag;
        // if(e_obj.preventDefault)e_obj.preventDefault();
        }
    },
}

</script>

<style>
#fi {
    background-image: url("@/assets/field.png");
    background-repeat: no-repeat;
    width: 900px;
    height: 400px;
}
</style>