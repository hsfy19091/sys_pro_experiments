<template>
  <div id="app">
    <sidebar></sidebar>
    <router-view id="main"/>
  </div>
</template>

<script>
export default {
  name: "App",
  components: {
    sidebar: () => import("./components/Sidebar.vue")
  }
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
#main{
  vertical-align: top;
  margin: 10px;
  display: inline-block;
  border: 1px solid red;
  width: calc(100% - 250px);

}
</style>
