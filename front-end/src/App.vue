<template>
  <div>
    <div class="header">
      <div class="header-button-left">
        <div v-if="isLogin" @click="goToAuthAccountInfo()">
          Hello {{ userInfo.nickname }}
        </div>
      </div>
      <div class="header-button-right">
        <div v-if="!isLogin" @click="goToLogin()">login</div>
        <div v-else @click="logout">logout</div>
      </div>
      <img src="./assets/reflixlogo.png" class="logo" />
    </div>

    <div style="width: 100%"><router-view /></div>

    <div class="footer">
      <ul class="footer-button-plus">
        <!-- <input type="file" id="file" class="inputfile" /> -->
        <label @click="goPostCreate()" for="file" class="input-plus">+</label>
      </ul>
    </div>
  </div>
</template>

<script>
import { mapState, mapMutations } from "vuex"
export default {
  name: "App",
  components: {},
  computed: {
    ...mapState(["isLogin", "userInfo"])
  },
  methods: {
    ...mapMutations(["logout"]),
    goPostCreate() {
      this.$router.push({
        name: "CreatePost"
      })
    },
    goToLogin() {
      this.$router.push({
        name: "Login"
      })
    },
    goToAuthAccountInfo() {
      this.$router.push({
        name: "Account",
        query: { username: this.userInfo.nickname }
      })
    }
  }
}
</script>

<style>
body {
  margin: 0;
}
ul {
  padding: 5px;
  list-style-type: none;
}
.logo {
  width: 50px;
  margin: auto;
  display: block;
  position: absolute;
  left: 0;
  right: 0;
  top: 13px;
}
.header {
  width: 100%;
  height: 40px;
  background-color: white;
  padding-bottom: 8px;
  position: sticky;
  top: 0;
}
.header-button-left {
  color: skyblue;
  float: left;

  padding-left: 20px;
  cursor: pointer;
  margin-top: 10px;
}
.header-button-right {
  color: skyblue;
  float: right;
  width: 50px;
  cursor: pointer;
  margin-top: 10px;
  margin-right: 20px;
}
.footer {
  width: 100%;
  position: sticky;
  bottom: 0;
  padding-bottom: 10px;
  background-color: white;
}
.footer-button-plus {
  width: 80px;
  margin: auto;
  text-align: center;
  cursor: pointer;
  font-size: 24px;
  padding-top: 12px;
}
.sample-box {
  width: 100%;
  height: 600px;
  background-color: bisque;
}
.inputfile {
  display: none;
}
.input-plus {
  cursor: pointer;
}
#app {
  box-sizing: border-box;
  font-family: "consolas";
  margin-top: 60px;
  width: 100%;
  max-width: 460px;
  margin: auto;
  position: relative;
  border-right: 1px solid #eee;
  border-left: 1px solid #eee;
}
</style>
