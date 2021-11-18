<template>
  <div class="mt-5">
    <img src="../assets/reflixlogo.png" class="loginimage" />
    <div class="row mb-3 p-4">
      <label
        for="colFormLabelLg"
        class="col-sm-2 col-form-label col-form-label-lg"
        >ID</label
      >
      <div class="col-sm-10">
        <input
          type="email"
          class="form-control form-control-lg"
          id="colFormLabelLg"
          v-model="loginObj.email"
          placeholder="이메일 입력"
        />
      </div>
    </div>
    <div class="row mb-3 p-4">
      <label
        for="colFormLabelLg"
        class="col-sm-2 col-form-label col-form-label-lg"
        >PASSWORD</label
      >
      <div class="col-sm-10">
        <input
          type="password"
          class="form-control form-control-lg"
          id="colFormLabelLg"
          v-model="loginObj.password"
          placeholder="비밀번호 입력"
        />
      </div>
    </div>
    <div class="mb-3 form-check">
      <input type="checkbox" class="form-check-input mx-2" id="exampleCheck1" />
      <label class="form-check-label" for="exampleCheck1"
        >아이디 저장하기</label
      >
    </div>
    <div class="d-grid gap-2 col-6 mx-auto mt-5">
      <button class="btn btn-danger" type="button" @click="login(loginObj)">
        로그인
      </button>
    </div>
  </div>
</template>

<script>
import { mapActions } from "vuex"
export default {
  data() {
    return {
      loginObj: {
        email: "",
        password: ""
      }
    }
  },
  methods: {
    ...mapActions(["login"])
  }
}
</script>

<style>
.login {
  margin-top: 100px;
}
.loginimage{
  margin-top: 10px;
  margin-left: 160px;
  width: 40%;
}
</style>
