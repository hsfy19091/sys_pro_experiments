<template>
  <div>
    <div v-for="(i,item) in homeworks" :key="item">
      作业名称:{{i.homework.title}}<br>
      截止时间:{{i.homework.deadLineTime}}
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      homeworks: []
    };
  },
  created() {
    this.$axios.get("/api/getHomeWorks").then(res => {
      this.homeworks = res.data;
    });
  }
};
</script>
<style>
</style>

