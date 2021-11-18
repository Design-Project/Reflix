<template>
  <div class="post">
    <div class="post-header">
      <div class="profile2"></div>
      <span class="profile-name">{{username}}</span>
    </div>
    <div class="post-body2"></div>
    <div class="post-content">
      <img src="https://emojigraph.org/media/twitter/brown-heart_1f90e.png" class="recommand"/>
      <p>721 Likes</p>
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
    </div>
    <p></p>
</div> 
</template>

<script>

export default {
  name: 'Post',
  data(){
    return{
      username : 'cjy3082',
      movietitle : '#샹치와_텐_링즈의_전설',
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
  margin-right: 10px;
}
.post {
  width: 100%;
}
.profile2 {
  background-image: url("https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA2MDRfMTgz%2FMDAxNjIyNzk5Mjk5OTU0.fNSZUVt6aBliSh-mMS6B_1NrFs9ViZK57OvaoSb87Lwg.iz2R_UvdoDBp03Ecj6nv5htS5oXDNgClmADga9zg5Y4g.JPEG.asdwe1%2Fa_5430354892_a0613d1089f993ee7a07ef1f6355e2f73beceb28.jpg&type=sc960_832");
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
  padding: 10px;
}
.post-body2 {
  background-image: url("https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTA5MDFfMTcg%2FMDAxNjMwNDg1Mzk3NDQx.k4_DAnw6v8NJgGL7nTt3IqnY1m94LO1zizQZf_xJm1Eg.rUT0vzcWvoNIEE_78SiGFbVhr4NQt5liFPml-jcwaN0g.JPEG.haimin91%2FIMG_3788.JPG&type=sc960_832");
  height: 550px;
  background-position: center;
  background-size: cover;
  margin-bottom: 15px;
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