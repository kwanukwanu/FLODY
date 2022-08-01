<template>
  <div id="app">
    <b-container>
        <router-view />
    </b-container>
    <footer-bar />
  </div>
</template>

<script>

import FooterBar from "@/components/layout/FooterNavBar.vue";

export default{
  name:"App",
  components:{
    FooterBar,
  },
}
</script>


<style>
/* #app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}

#app {
	font-family: basic-scans, sans-serif;
  color : #666565;
	font-size: 1em;
	line-height: 1.6;
	margin: 0;
	min-height: 100%;
	position: relative;
	padding-bottom: 120px;
} */
html,
body {
	height: 100%;
}

a {
	text-decoration: none;
}

a:hover {
	text-decoration: none;
	font-weight: bold;
	color: chartreuse;
}

a.router-link-exact-active {
	color: #064635;
  font-weight: bold;
}

#app {
	font-family: basic-scans, sans-serif;
	font-size: 1em;
	line-height: 1.6;
	margin: 0;
	min-height: 100%;
	position: relative;
	padding-bottom: 133px;
}
</style>
