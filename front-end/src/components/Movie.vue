<template>
<div>
<div class="card mb-3">
    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
  <ol class="carousel-indicators">
    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
  </ol>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="https://movie-phinf.pstatic.net/20210820_122/1629448997924YXUCv_JPEG/movie_image.jpg" class="d-block w-100" alt="영화포스터">
    </div>
    <div class="carousel-item">
      <img src="https://movie-phinf.pstatic.net/20210617_11/1623893571534zX1vl_JPEG/movie_image.jpg?type=m665_443_2" class="d-block w-100" alt="스틸컷">
    </div>
    <div class="carousel-item">
      <img src="https://movie-phinf.pstatic.net/20210617_33/1623893764803wD8Oz_JPEG/movie_image.jpg?type=m665_443_2" class="d-block w-100" alt="스틸컷">
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
  
  <div class="card-body">
    <h5 class="card-title">모가디슈</h5>
    
    <div class="progress">
    <div class="progress-bar bg-danger" role="progressbar" style="width: 86.9%" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100">★8.69</div>
    </div>

    <div class="accordion" id="accordionExample">
  <div class="card">
    <div class="card-header" id="headingOne">
      <h2 class="mb-0">
        <button class="btn btn-link btn-block text-left" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
          장르
        </button>
      </h2>
    </div>

    <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
        <div class="card-body">
        액션, 드라마
      </div>
    </div>
  </div>
  <div class="card">
    <div class="card-header" id="headingTwo">
      <h2 class="mb-0">
        <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
          출연진
        </button>
      </h2>
    </div>
    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
      <div class="card-body">
        김윤석, 조인성, 허준호, 구교환, 김소진, 정만식 ...
      </div>
    </div>
  </div>
  <div class="card">
    <div class="card-header" id="headingThree">
      <h2 class="mb-0">
        <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
          줄거리
        </button>
      </h2>
    </div>
    <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
      <div class="card-body">
        내전으로 고립된 낯선 도시, 모가디슈
지금부터 우리의 목표는 오로지 생존이다!
 
 대한민국이 UN가입을 위해 동분서주하던 시기
 1991년 소말리아의 수도 모가디슈에서는 일촉즉발의 내전이 일어난다.
 통신마저 끊긴 그 곳에 고립된 대한민국 대사관의 직원과 가족들은
 총알과 포탄이 빗발치는 가운데, 살아남기 위해 하루하루를 버텨낸다.
 그러던 어느 날 밤, 북한 대사관의 일행들이 도움을 요청하며 문을 두드리는데…
 
 목표는 하나, 모가디슈에서 탈출해야 한다!
      </div>
    </div>
  </div>
</div>


    <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
  </div> 
</div>

</div>

</template>

<script>
export default {
  name: "Movie",
}
</script>

<style>

</style>