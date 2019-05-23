<template>
  <div id="app">
    <myheader />
    <div id="main">
      <sidebar />
      <myarticle />
    </div>
    <myfooter />
  </div>
</template>
<script>
export default {
  components: {
    myheader: () => import("./components/Header"),
    sidebar: () => import("./components/Sidebar"),
    myfooter: () => import("./components/Footer"),
    myarticle: () => import("./components/Article")
  }
};
</script>

<style>
#main {
  margin: 5px 0px;
}
</style>
