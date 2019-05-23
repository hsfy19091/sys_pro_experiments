<template>
  <div>
    <form>
      <input type="text" v-model="user.name">
      <br>
      <label>
        <input type="radio" v-model="user.sex" value="male">男
      </label>
      <br>
      <label>
        <input type="radio" v-model="user.sex" value="female">女
      </label>
      <br>
      <template v-for="(c, index) in courses">
        <label :key="`l${index}`">
          <input type="checkbox" v-model="user.courses" :value="{ id: c.id }" :key="index">
          {{ c.name }}
        </label>
        <br :key="`b${index}`">
      </template>
      <br>
      <br>
      <select v-model="user.title">
        <option v-for="(t, index) in titles" :key="index" :value="t.id">
          {{
          t.name
          }}
        </option>
      </select>
      <br>
      <button type="button">提交</button>{{user}}
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      user: { name: "", sex: "", courses: [], title: "" },
      courses: [
        { id: 1, name: "系统程序设计", insertTime: "2019-05-20T11:11:11" },
        { id: 2, name: "安卓", insertTime: "2019-05-21T11:12:12" },
        { id: 3, name: "软件质量与测试", insertTime: "2019-05-22T11:13:13" },
        { id: 4, name: "软件项目管理", insertTime: "2019-05-23T11:14:14" }
      ],
      titles: [
        { id: 1, name: "讲师" },
        { id: 2, name: "副教授" },
        { id: 3, name: "教授" }
      ]
    };
  }
};
</script>
<style>
</style>
