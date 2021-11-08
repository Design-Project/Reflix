<template>
  <form class="row g-3">
  <div class="row">
  <label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg">ID</label>
  <div class="col-sm-10">
    <input type="email" class="form-control form-control-lg" id="colFormLabelLg" placeholder="아이디 입력">
  </div>
  </div> 
  <div class="col-md-6">
    <label for="inputPassword4" class="form-label">PASSWORD</label>
    <input type="password" class="form-control" id="inputPassword4">
  </div>
  <div class="col-12">
    <div class="form-check">
      <input class="form-check-input" type="checkbox" id="gridCheck">
      <label class="form-check-label" for="gridCheck">
        Check me out
      </label>
    </div>
  </div>
  <div class="col-12">
    <button type="submit" class="btn btn-primary">Sign in</button>
  </div>
  </form>
</template>

<script>
export default {

}
</script>

<style>

</style>
