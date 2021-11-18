<template>
  <div class="post">
    <div class="post-header">
      <div class="profile1"></div>
      <span class="profile-name">{{username}}</span>
    </div>
    <div class="post-body1"></div>
    <div class="post-content">
      <img src="https://emojigraph.org/media/twitter/brown-heart_1f90e.png" class="recommand"/>
      <p>153 Likes</p>
      <p class="hashtag">{{movietitle}}</p>
        <div>
        <p>{{username}}님의 평점 </p>
        <div class="star-ratings">
          <div class="star-ratings-fill space-x-2 text-lg" :style="{ width: ratingToPercent + '%' }">		
            <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
            </div>
            <div class="star-ratings-base space-x-2 text-lg">
		<span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
	</div>
          </div>
      </div>
      <p></p>
    </div>
</div> 
</template>

<script>

export default {
  name: 'Post',
  data(){
    return{
      username : 'ihjez_00',
      movietitle : '#극장판_짱구는_못말려:_격돌!_낙서왕국과_얼추_네_명의_용사들',
    }
  }
}
</script>

<style>
.star-ratings {
  color: #aaa9a9; 
  position: relative;
  unicode-bidi: bidi-override;
  width: max-content;
  -webkit-text-fill-color: transparent; /* Will override color (regardless of order) */
  -webkit-text-stroke-width: 1.3px;
  -webkit-text-stroke-color: #2b2a29;
}
 
.star-ratings-fill {
  color: #fff58c;
  padding: 0;
  position: absolute;
  z-index: 1;
  display: flex;
  top: 0;
  left: 0;
  overflow: hidden;
  -webkit-text-fill-color: gold;
}
 
.star-ratings-base {
  z-index: 0;
  padding: 0;
}
.recommand {
  width: 22px;
  height: 22px;
  border-radius: 10%;
  float: left;
  
}
.post {
  width: 100%;
}
.profile1 {
  background-image:url("https://d2u3dcdbebyaiu.cloudfront.net/uploads/atch_img/436/8142f53e51d2ec31bc0fa4bec241a919_crop.jpeg");
  width: 30px;
  height: 30px;
  background-size: 100%;
  border-radius: 50%;
  float: left;
}
.profile-name {
  display: block;
  float: left;
  padding-left: 10px;
  padding-top: 7px;
  font-size: 14px;
}
.hashtag {
  color :cornflowerblue;
}
.post-header {
  height: 30px;
  margin-bottom: 15px;
}
.post-body1 {
  background-image: url("https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA2MTZfMjQx%2FMDAxNjIzODM5MzA2NTU5.YRI7BhR5mTNKu3bhoPFYqjj5QToaXsqFuHTIFL76xA0g.TOv6VpIbWrIK4_UpuFh5akTkRCjElrdbXhpRZNMHORIg.JPEG.ckddyd4074%2Fmovie_image.jpg&type=sc960_832");
  height: 550px;
  margin-bottom: 15px;
  background-position: center;
  background-size: cover;
}
.post-content {
  padding-left: 15px;
  padding-right: 15px;
  font-size: 14px;
}
.date {
  font-size: 11px;
  color: grey;
  margin-top: -8px;
} 
</style>