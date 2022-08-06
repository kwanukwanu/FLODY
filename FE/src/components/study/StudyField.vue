<template>
  <h2>field</h2>
  <!-- <div id="fi" @click="action_coords($event)"> -->
  <div id="fi">
    <!-- <img id="flower" src="@/assets/flower7_1.png" class="w-10" style="height: 100px; cursor: grab;" @mousedown="mouseDown()"/> -->
    <img id="flower" src="@/assets/flower7_1.png" class="w-10" style="height: 100px; cursor: grab;" @mousedown="startDrag($event)"/>
    <!-- <img id="flower" src="@/assets/flower7_1.png" class="w-10" style="height: 100px; cursor: grab;" :style="{left:xPosition, top:yPosition}"/> -->
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
    startDrag(event){
      /*
      드래그를 할때
      posX 에는 그림에대한 x 위치를,
      posy 에는 그림에 대한 y 위치를 받아온다
      */
      
      const bg = document.getElementById('fi');
      const flower = document.getElementById('flower');
      let coordBg = bg.getBoundingClientRect();
      let coordFl = flower.getBoundingClientRect();

      console.log(coordFl);
      console.log((coordFl.top + (coordFl.height / 2)) - coordBg.top);
      console.log((coordFl.left + (coordFl.width / 2)) - coordBg.left);

      let x1 = event.clientX; 
      let y1 = event.clientY; 
      let x2 = event.offsetX; 
      let y2 = event.offsetY; 
      let x3 = event.screenX; 
      let y3 = event.screenY; 
      console.log("flower : clientX: " + x1 + ", clientY: " + y1);
      console.log("flower : offsetX: " + x2 + ", offsetY: " + y2);
      console.log("flower : screenX: " + x3 + ", screenY: " + y3); 

      // posX = getLeft(obj) - e_obj.clientX;
      // posY = getTop(obj) - e_obj.clientY;

      // document.onmousemove = moveDrag;
      // document.onmouseup = stopDrag;
      // if(e_obj.preventDefault)e_obj.preventDefault();
    },
    action_coords(event) { 
      let x1 = event.clientX; 
      let y1 = event.clientY; 
      let x2 = event.offsetX; 
      let y2 = event.offsetY; 
      let x3 = event.screenX; 
      let y3 = event.screenY; 
      console.log("clientX: " + x1 + ", clientY: " + y1);
      console.log("offsetX: " + x2 + ", offsetY: " + y2);
      console.log("screenX: " + x3 + ", screenY: " + y3); 
    },
  },
  setup() {
    function mouseDown(e) {
      console.log(e)
      window.addEventListener('mousemove', mouseMove)
      window.addEventListener('mouseup', mouseUp)
    }

    function mouseMove() {
    }

    function mouseUp(e) {
        console.log(e)
        window.removeEventListener('mousemove', mouseMove)
        window.removeEventListener('mouseup', mouseUp)
    }

    return { mouseDown, mouseMove, mouseUp }

  }
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