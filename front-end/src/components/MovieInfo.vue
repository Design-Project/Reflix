<template>
  <div>
    <div class="post-header">
      <div class="profile"></div>
      <span class="profile-name" v-if="movieRank">🔥{{ movieRank }}위</span>
    </div>
    <div class="post-body" style="text-align: center">
      <img style="max-width: 350px" :src="movieImage" />
    </div>
    <div class="post-content" style="text-align: center">
      <div v-if="movieRating !== 0">
        <img
          src="https://emojigraph.org/media/twitter/brown-heart_1f90e.png"
          class="recommand"
        />
        <p>{{ movieRating }}</p>
      </div>
      <p @click="onClickRedirect()" class="hashtag" style="cursor: pointer">
        {{ movieTitle }}
      </p>
      <div align-v="center">
        <p>{{ movieSubTitle }}</p>
        <!-- <div class="star-ratings">
          <div
            class="star-ratings-fill space-x-2 text-lg"
            :style="{ width: ratingToPercent + '%' }"
          >
            <span>★</span><span>★</span><span>★</span><span>★</span
            ><span>★</span>
          </div>
          <div class="star-ratings-base space-x-2 text-lg">
            <span>★</span><span>★</span><span>★</span><span>★</span
            ><span>★</span>
          </div>
        </div> -->
      </div>
      <p></p>
    </div>
  </div>
</template>

<script>
export default {
  name: "Post",
  props: ["movie"],
  methods: {
    onClickRedirect: function () {
      window.open(`${this.movieLink}`, "_blank")
    }
  },
  data() {
    return {
      username: "ihjez_00",
      movieTitle: this.movie.title,
      movieImage: this.movie.image,
      movieActor: this.movie.actor,
      movieDirector: this.movie.director,
      movieRank: this.movie.rank,
      movieSubTitle: this.movie.subtitle,
      movieRating: this.movie.userRating,
      movieLink: this.movie.link
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
}
.profile {
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
  color: cornflowerblue;
}
.post-header {
  height: 30px;
  margin-bottom: 15px;
}
.post-body {
  width: 100%;
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
