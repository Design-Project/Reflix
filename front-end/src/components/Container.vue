<template>
  <div>
    <b-container>
      <b-row class="text-center">
        <b-col cols="4" v-for="movie in movieRank" v-bind:key="movie.rank">
          <b-col><MovieInfo v-bind:movie="movie" /></b-col>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import MovieInfo from "./MovieInfo.vue"
import axios from "axios"

export default {
  data() {
    return {
      movieRank: null
    }
  },
  components: {
    MovieInfo
  },
  created: function () {
    axios
      .get("/app/movies/ranking")
      .then((res) => {
        this.movieRank = res.data.result
      })
      .catch((err) => {
        alert(err.response.data.message)
      })
  }
}
</script>
