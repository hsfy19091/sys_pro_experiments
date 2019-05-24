<template>
  <div>
    <el-table :data="courses" style="width: 100%">
      <el-table-column prop="name" label="课程名称"></el-table-column>
      <el-table-column prop="teacher.name" label="任课教师" :formatter="teacherFormatter"></el-table-column>
      <el-table-column prop="insertTime" label="插入时间" :formatter="dateTimeFormatter"></el-table-column>
    </el-table>
  </div>
</template>
<script>
export default {
  data() {
    return {
      courses: []
    };
  },
  methods: {
    //格式化文本显示
    teacherFormatter(row) {
      if (row.teacher  == null) {
        return "暂无";
      } else return row.teacher.name;
    },
    dateTimeFormatter(row){
        return row.insertTime.replace("T"," ")
    }
  },
  created() {
    this.$axios.get("/api/getCourses").then(res => {
      this.courses = res.data;
    });
  }
};
</script>
<style>
</style>
