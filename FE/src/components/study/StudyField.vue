<template>
  <h2>field</h2>
  <div id="fi" >
    <img id="flower" src="@/assets/flower7_1.png" class="w-10" style="height: 100px; cursor: grab; position: relative; left: 0px; top: 0px;" @mousedown="mouseDown()" @mousemove="mouseMove($event)" />
    <!-- <img id="flower" src="@/assets/flower7_1.png" class="w-10" style="height: 100px; cursor: grab; position: relative; left: 0px; top: 0px;" @mousedown="startDrag($event)"/> -->
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
  },
  setup() {
    function mouseDown() {
      // window.addEventListener('mousemove', mouseMove)
      const bg = document.getElementById('fi');
      bg.addEventListener('mouseup', mouseUp);
      // bg.addEventListener('mouseup', (e) => {
      //   console.log(e)
      //   console.log("left : " + e.clientX + " top : " + e.clientY);

      //   const bg = document.getElementById('fi');
      //   const flower = document.getElementById('flower');
      //   let coordBg = bg.getBoundingClientRect();
      //   let coordFl = flower.getBoundingClientRect();

      //   this.posX = e.clientX - coordBg.left - (coordFl.width / 2);
      //   this.posY = e.clientY - coordBg.top - (coordFl.height / 2);
      //   console.log("posx : " + this.posX + ", posY : " + this.posY)

      //   flower.style.left = this.posX + "px";
      //   flower.style.top = this.posY + "px";
      //   console.log(flower)
      //   // console.log("flower    left : " + flower.style.left + " top : " + flower.style.top);

      //   // window.removeEventListener('mousemove', mouseMove)
      //   bg.removeEventListener('mouseup', mouseUp)
      // });
      console.log(bg)
    }

    function mouseMove() {
      // console.log("left : " + e.clientX + " top : " + e.clientY);
    }

    function mouseUp(e) {
        console.log(e)
        console.log("left : " + e.clientX + " top : " + e.clientY);

        const bg = document.getElementById('fi');
        const flower = document.getElementById('flower');
        let coordBg = bg.getBoundingClientRect();
        let coordFl = flower.getBoundingClientRect();

        this.posX = e.clientX - coordBg.left - (coordFl.width / 2);
        this.posY = e.clientY - coordBg.top - (coordFl.height / 2);
        console.log("posx : " + this.posX + ", posY : " + this.posY)

        flower.style.left = this.posX + "px";
        flower.style.top = this.posY + "px";
        console.log(flower)
        // console.log("flower    left : " + flower.style.left + " top : " + flower.style.top);

        // window.removeEventListener('mousemove', mouseMove)
        bg.removeEventListener('mouseup', mouseUp)
    }

    return { mouseDown, mouseMove, mouseUp }

  },
  mounted() {
    const ele = document.getElementById('flower');
    console.log(ele);
    this.posX = ele.style.left;
    this.posY = ele.style.top;
    console.log("posx : " + this.posX + ", posY : " + this.posY)
  },
  updated() {

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