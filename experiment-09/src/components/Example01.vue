<template>
  <div>
    {{user.name}}<br/>
    <span v-if="user.role == 'admin'">user is :{{user.role}}</span>
    <div v-for="(item,i) in courses" :key="i">
      课程名称:{{item.name}}<br/>
      插入时间:{{timeFormat(item.insertTime)}}<br/>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      user: { name: "hsfy", role: "admin" },
      courses: [
        { id: 1, name: "系统程序设计", insertTime: "2019-05-20T11:11:11" },
        { id: 2, name: "安卓", insertTime: "2019-05-21T11:12:12" },
        { id: 3, name: "软件质量保证与测试", insertTime: "2019-05-22T11:13:13" },
        { id: 4, name: "软件项目管理", insertTime: "2019-05-23T11:14:14" }
      ]
    };
  },
  computed:{  
    timeFormat(){
      return data=> data.replace("T"," ")
    }
  }
};
</script>

<style>
</style>
