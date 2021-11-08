<template>
<div class = "center">
<form>
  <div class="mb-3">
    <label for="InputEmail" class="form-label">Email address</label>
    <input type="email" class="form-control" id="InputEmail" aria-describedby="emailHelp" v-model="email">
    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
  </div>
  <div class="mb-3">
    <label for="InputNickname" class="form-label">Nickname</label>
    <input type="text" class="form-control" id="InputId" v-model="nickname">
  </div>
  <div class="mb-3">
    <label for="InputPassword1" class="form-label">Password</label>
    <input type="password" class="form-control" id="InputPassword1" v-model="password1">
  </div>
  <div class="mb-3">
    <label for="InputPassword2" class="form-label">Confirm Password</label>
    <input type="password" class="form-control" id="InputPassword2" v-model="password2">
    <div id="emailHelp" class="form-text" v-if="passward2!=password1">비밀번호가 일치하지 않습니다.</div>
  </div>
  <div class="mb-3 form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1">
    <label class="form-check-label" for="exampleCheck1">Check me out</label>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>
</template>

<script>
export default {
    name: 'Register',
    data(){
        return {
            backEmail : null,
            email : null,
            passward1 : null,
            password2 : null,
            nickname : null,
            PasswordSame : false,
        }
    },
}
</script>

<style>
.center{
  width: 600px;
  padding-top: 50px;
  margin: 0 auto;
}
</style>