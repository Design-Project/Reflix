<template>
<div>
 
  <div class="row mb-3">
  <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">ID</label>
  <div class="col-sm-10">
    <input type="email" class="form-control form-control-lg" id="colFormLabelLg" placeholder="아이디 입력">
  </div>
  </div>
  <div class="row mb-3">
  <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">PASSWORD</label>
  <div class="col-sm-10">
    <input type="email" class="form-control form-control-lg" id="colFormLabelLg" placeholder="비밀번호 입력">
  </div>
  </div>
  <div class="mb-3 form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1">
    <label class="form-check-label" for="exampleCheck1">아이디 저장하기</label>
  </div>
  <div class="d-grid gap-2 col-6 mx-auto">
  <button class="btn btn-primary" type="button">로그인</button>
</div>
</div>
</template>

<script>
export default {

}
</script>

<style>
.login{
  margin-top: 100px;
}

</style>