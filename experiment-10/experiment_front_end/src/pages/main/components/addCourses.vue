<template>
  <div>
    <el-input placeholder="请输入课程名" v-model="course.name"></el-input>
    <br>
    <el-input placeholder="请输入教师id" v-model="course.teacher.id"></el-input>
    <br>
    <el-button @click="submit">提交</el-button>
  </div>
</template>
<script>
export default {
  data() {
    return {
      course: { name: "", teacher: { id: "" } }
    };
  },
  methods: {
    submit() {
        if(this.course.name == ""||this.course.teacher.id == ""){
            this.$message({ type: "error", message: "请检查信息是否完整" });
        return;
        }
      this.$axios.post("/api/admin/addCourse", this.course).then(res => {
        console.log(res.data);
      });
    }
  }
};
</script>
