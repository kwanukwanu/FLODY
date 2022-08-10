<template>
  <!-- <h2>field</h2> -->
  <b-card style="width:60rem; border-color: #a48282; margin-top:30px; margin-left: 7px;">
  <div id="fi" > 
    <study-field-items
    id="flower"
    v-for="(item,index) in flowers"
    :key="item.index = index"
    v-bind="item"
    >
    </study-field-items>
    <!-- <img id="flower" src="@/assets/flower7_1.png" class="w-10" style="height: 100px; cursor: grab; position: relative; left: 0px; top: 0px;" @mousedown="startDrag($event)"/> -->
  </div>
</b-card>
<!-- 
  <div id="outerContainer">
    <div id="container">
      <div id="item">

      </div>
    </div>
  </div> -->



</template>

<script>
import StudyFieldItems from "@/components/study/items/StudyFieldItems.vue";

export default {
  components:{
    StudyFieldItems,
  },
  data(){
    return{
      flowerElements : null,
      index:-1,
      pos:{
        posX:0,
        posY:0,
      },
      flowers:[
        {
          pos:{
            posX:0,
            posY:0,
          }
        },
        {
          pos:{
            posX:0,
            posY:0,
          }
        },
        {
          pos:{
            posX:0,
            posY:0,
          }
        },
      ],
    }
  },
  methods: {
    // startDrag(event){
    //   /*
    //   드래그를 할때
    //   posX 에는 그림에대한 x 위치를,
    //   posy 에는 그림에 대한 y 위치를 받아온다
    //   */
      
    //   const bg = document.getElementById('fi');
    //   const flower = document.getElementById('flower');
    //   let coordBg = bg.getBoundingClientRect();
    //   let coordFl = flower.getBoundingClientRect();

    //   console.log(coordFl);
    //   console.log((coordFl.top + (coordFl.height / 2)) - coordBg.top);
    //   console.log((coordFl.left + (coordFl.width / 2)) - coordBg.left);

    //   let x1 = event.clientX; 
    //   let y1 = event.clientY; 
    //   let x2 = event.offsetX; 
    //   let y2 = event.offsetY; 
    //   let x3 = event.screenX; 
    //   let y3 = event.screenY; 
    //   console.log("flower : clientX: " + x1 + ", clientY: " + y1);
    //   console.log("flower : offsetX: " + x2 + ", offsetY: " + y2);
    //   console.log("flower : screenX: " + x3 + ", screenY: " + y3); 

    //   // posX = getLeft(obj) - e_obj.clientX;
    //   // posY = getTop(obj) - e_obj.clientY;

    //   // document.onmousemove = moveDrag;
    //   // document.onmouseup = stopDrag;
    //   // if(e_obj.preventDefault)e_obj.preventDefault();
    // },
  },
  setup() {
    function mouseDown(item,e) {
      window.addEventListener('mousemove', mouseMove)
      
      // const bg = document.getElementById('fi');
      // bg.addEventListener('mouseup', mouseUp)
      // console.log(bg)
      console.log(item.index);
      this.index = item.index;
      console.log("left : " + e.clientX + " top : " + e.clientY);
    }

    function mouseMove(e) {

      console.log("0");
      if(this.index==-1)
      {
        window.removeEventListener('mousemove', mouseMove)
        return;
      }

      console.log("1");
      const bg = document.getElementById('fi');
      let coordBg = bg.getBoundingClientRect();
      let coordFl = this.flowerElements[this.index].getBoundingClientRect();

      console.log("2");
      this.posX = e.clientX - coordBg.left - (coordFl.width / 2);
      this.posY = e.clientY - coordBg.top - (coordFl.height / 2);
      console.log("posx : " + this.posX + ", posY : " + this.posY);

      this.flowerElements[this.index].style.left = this.posX + "px";
      this.flowerElements[this.index].style.top = this.posY + "px";

      /*
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
        */
    }

    function mouseUp() {
      this.index = -1;
      window.removeEventListener('mousemove', mouseMove)
    }


    return { mouseDown, mouseMove, mouseUp, }

  },
  mounted() {
    this.flowerElements = document.getElementsByName('flower');
    // const ele = document.getElementById('flower');
    // console.log(ele);
    // this.posX = ele.style.left;
    // this.posY = ele.style.top;
    // console.log("posx : " + this.posX + ", posY : " + this.posY)




    var dragItem = document.querySelector("#flower");
    var container = document.querySelector("#fi");

    var active = false;
    var currentX;
    var currentY;
    var initialX;
    var initialY;
    var xOffset = 0;
    var yOffset = 0;

    container.addEventListener("touchstart", dragStart, false);
    container.addEventListener("touchend", dragEnd, false);
    container.addEventListener("touchmove", drag, false);

    container.addEventListener("mousedown", dragStart, false);
    container.addEventListener("mouseup", dragEnd, false);
    container.addEventListener("mousemove", drag, false);

    function dragStart(e) {
      if (e.type === "touchstart") {
        initialX = e.touches[0].clientX - xOffset;
        initialY = e.touches[0].clientY - yOffset;
      } else {
        initialX = e.clientX - xOffset;
        initialY = e.clientY - yOffset;
      }

      if (e.target === dragItem) {
        active = true;
      }
    }

    function dragEnd() {
      initialX = currentX;
      initialY = currentY;

      active = false;
    }

    function drag(e) {
      if (active) {
      
        e.preventDefault();
      
        if (e.type === "touchmove") {
          currentX = e.touches[0].clientX - initialX;
          currentY = e.touches[0].clientY - initialY;
        } else {
          currentX = e.clientX - initialX;
          currentY = e.clientY - initialY;
        }

        xOffset = currentX;
        yOffset = currentY;

        setTranslate(currentX, currentY, dragItem);
      }
    }

    function setTranslate(xPos, yPos, el) {
      el.style.transform = "translate3d(" + xPos + "px, " + yPos + "px, 0)";
    }






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


#container {
      width: 100%;
      height: 400px;
      background-color: #333;
      display: flex;
      align-items: center;
      justify-content: center;
      overflow: hidden;
      border-radius: 7px;
      touch-action: none;
    }
    #item {
      width: 100px;
      height: 100px;
      background-color: rgb(245, 230, 99);
      border: 10px solid rgba(136, 136, 136, .5);
      border-radius: 50%;
      touch-action: none;
      user-select: none;
    }
    #item:active {
      background-color: rgba(168, 218, 220, 1.00);
    }
    #item:hover {
      cursor: pointer;
      border-width: 20px;
    }
</style>