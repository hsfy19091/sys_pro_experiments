<template>
  <div id="app">
    <el-container>
      <el-header>
        Header
        <el-button plain @click="logout" style="float:right;margin-top:10px;">退出</el-button>
      </el-header>
      <el-container>
        <el-aside width="200px">
          <el-button plain size="medium" @click="getHomeworks">获取全部作业</el-button>
          <el-button plain size="medium" @click="getCourses">获取全部课程</el-button>
          <el-button plain size="medium" @click="getCoursesById">获取指定课程</el-button>
          <el-button plain size="medium" @click="addCourse">添加课程</el-button>
        </el-aside>
        <el-main>
          <router-view/>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>
<script>
export default {
  data() {
    return {};
  },
  created() {
    if (this.$store.state.userInfo.token == "") {
      window.location.href = "./login.html";
    }
  },
  methods: {
    getHomeworks() {
      this.$router.push("/");
    },
    getCourses() {
      this.$router.push("/getCourses");
    },
    getCoursesById() {
      this.$router.push("/getCoursesById");
    },
    addCourse() {
      this.$router.push("/addCourses");
    },
    logout() {
      this.$store.commit("logout");
      window.location.href = "./login.html";
    }
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
}
.el-header,
.el-footer {
  background-color: #b3c0d1;
  color: #333;
  text-align: center;
  line-height: 60px;
}

.el-aside {
  background-color: #d3dce6;
  color: #333;
  text-align: center;
  line-height: 70px;
}

.el-main {
  background-color: #e9eef3;
  color: #333;
  text-align: center;
}

body > .el-container {
  margin-bottom: 40px;
}

.el-container:nth-child(5) .el-aside,
.el-container:nth-child(6) .el-aside {
  line-height: 260px;
}

.el-container:nth-child(7) .el-aside {
  line-height: 320px;
}
</style>
