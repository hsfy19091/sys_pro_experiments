<template>
  <ul>
    <li>
      <span @click="a">单向绑定</span>
    </li>
    <li>
      <span @click="b">双向绑定</span>
    </li>
  </ul>
</template>

<script>
export default {
    methods:{
        a(){
            this.$router.push("/Example01")
        },
        b(){
            this.$router.push("/Example02")
        }
    }
};
</script>
<style scoped>
li {
  vertical-align: top;
  margin: 10px;
  display: inline-block;
  border: 1px solid red;
  width: 200px;
}
</style>
