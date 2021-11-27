<template>
  <div class="center">
    <img src="../assets/reflixlogo.png" />
    <form>
      <div class="mb-3">
        <label for="InputEmail" class="form-label">Email address</label>
        <input
          type="email"
          class="form-control"
          id="InputEmail"
          aria-describedby="emailHelp"
          v-model="signUpObj.email"
        />
        <div id="emailHelp" class="form-text">
          We'll never share your email with anyone else.
        </div>
      </div>
      <div class="mb-3">
        <label for="InputNickname" class="form-label">Nickname</label>
        <input
          type="text"
          class="form-control"
          id="InputId"
          v-model="signUpObj.nickname"
        />
      </div>
      <div class="mb-3">
        <label for="InputPassword1" class="form-label">Password</label>
        <input
          type="password"
          class="form-control"
          id="InputPassword1"
          v-model="signUpObj.password"
        />
      </div>
      <div class="mb-3">
        <label for="InputPassword2" class="form-label">Confirm Password</label>
        <input
          type="password"
          class="form-control"
          id="InputPassword2"
          v-model="confirmPassword"
        />
        <div class="form-text" v-if="!sameChk()">
          비밀번호가 일치하지 않습니다.
        </div>
        <div class="form-text" v-else>비밀번호가 일치합니다.</div>
      </div>
      <div class="mb-3 form-check">
        <input type="checkbox" class="form-check-input" id="exampleCheck1" />
        <label class="form-check-label" for="exampleCheck1">Check me out</label>
      </div>
      <button type="Submit" class="btn btn-danger" @click="signUp(signUpObj)">
        회원가입
      </button>
    </form>
  </div>
</template>

<script>
import { mapActions } from "vuex"
export default {
  name: "Register",
  data() {
    return {
      signUpObj: {
        email: "",
        password: "",
        nickname: "",
        phoneNumber: ""
      },
      confirmPassword: "",
      isSamePwd: true
    }
  },
  created: function () {
    this.isSamePwd = true
  },
  methods: {
    methods: {
      ...mapActions(["signUp"])
    },
    sameChk() {
      if (this.signUpObj.password == this.confirmPassword) return true
      else {
        return false
      }
    }
  }
}
</script>

<style>
.center {
  width: 600px;
  padding-top: 50px;
  margin: 0 auto;
}
.logo {
  width: 200px;
  padding-top: 50px;
  padding-bottom: 50px;
  margin: 0 auto;
}
</style>
