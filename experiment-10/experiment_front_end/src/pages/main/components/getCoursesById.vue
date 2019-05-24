<template>
  <div>
    <el-row>
      <el-col :lg="6" :offset="4">
        <span>请输入课程id:</span>
      </el-col>
      <el-col :lg="8">
        <el-input v-model="courseId"></el-input>
      </el-col>
      <el-button plain @click="getCourseById">获取</el-button>
      <br>
      <br>
      <br>
      <el-col :lg="12" v-if="course!={}">
        课程名:
        <br>任课教师:
        <br>插入时间:
        <br>
      </el-col>
      <el-col :lg="12" v-if="course!={}">
        {{course.name}}
        <br>
        {{courseTeacherName}}
        <br>
        {{course.insertTime}}
      </el-col>
    </el-row>
  </div>
</template>
<script>
export default {
  data() {
    return {
      courseId: "",
      course: { name: "", teacher: { name: "" }, insertTime: "" }
    };
  },
  computed: {
    courseTeacherName() {
      return this.course.teacher == null ? "暂无" : this.course.teacher.name;
    }
  },
  methods: {
    getCourseById() {
      if (this.courseId == "") {
        this.$message({ type: "error", message: "请输入id" });
        return;
      }
      this.$axios
        .get("/api/getCourseByCourseId", {
          params: { courseId: this.courseId }
        })
        .then(res => {
          console.log(res.data);
          if (res.data == "") {
            this.$message({ type: "error", message: "没有相关课程" });
          } else {
            this.course = res.data;
          }
        });
    }
  },
  created() {}
};
</script>
<style>
</style>
