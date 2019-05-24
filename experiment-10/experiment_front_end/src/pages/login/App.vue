<template>
  <div id="app">
    <el-container>
      <el-header>选课管理系统</el-header>
      <el-container>
        <el-main>
          <span>请先登录</span>
          <el-row>
            <el-col :lg="8" :offset="8">
              <el-form ref="form" :model="userInfo" label-width="80px">
                <el-form-item label="用户名">
                  <el-input v-model="userInfo.name"></el-input>
                </el-form-item>
                <el-form-item label="密码">
                  <el-input v-model="userInfo.password" type="password"></el-input>
                </el-form-item>
                <el-form-item>
                  <el-button type="primary" @click="login">登录</el-button>
                  <el-button>取消</el-button>
                </el-form-item>
              </el-form>
            </el-col>
          </el-row>

        </el-main>
      </el-container>
    </el-container>
  </div>
</template>
<script>
export default {
  data() {
    return {
      userInfo: { name: "", password: "" }
    };
  },
  methods: {
    login() {
      this.$axios
        .post("/api/login", this.userInfo)
        .then(res => {
          this.$store.commit("setToken",res.data);
          this.$message({ type: "success", message: "登录成功" });
          window.location.href ="./index.html"
        })
        .catch(() => {
          this.$message({ type: "eror", message: "用户名或密码错误" });
        });
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
  color: #333;
  text-align: center;
  line-height: 60px;
}

.el-aside {
  background-color: #d3dce6;
  color: #333;
  text-align: center;
  line-height: 200px;
}

.el-main {
  color: #333;
  text-align: center;
  line-height: 160px;
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
