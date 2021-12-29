<template>
  <div>
    <b-row>
      <b-col></b-col>
      <b-col cols="10">
        <b-input-group prepend="Movie Name" class="mt-3">
          <b-form-input v-model="movieName"></b-form-input>
          <b-input-group-append>
            <b-button variant="outline-danger" @click="getMovieInfo(movieName)"
              >Button</b-button
            >
          </b-input-group-append>
        </b-input-group>
      </b-col>
      <b-col></b-col>
    </b-row>
    <b-row v-if="movieInfo" class="mt-3">
      <b-col>
        <div>
          <MovieInfo v-bind:movie="movieInfo" :key="movieInfo.title" /></div
      ></b-col>
    </b-row>
  </div>
</template>

<script>
import axios from "axios"
import MovieInfo from "./MovieInfo.vue"
export default {
  name: "MovieSearch",
  methods: {
    getMovieInfo(title) {
      axios
        .get(`/app/movies/name/${title}`)
        .then((res) => {
          this.movieInfo = res.data.result
        })
        .catch((err) => {
          alert(err.response.data.message)
        })
    }
  },
  components: {
    MovieInfo
  },
  data() {
    return {
      movieName: "",
      movieInfo: null
    }
  }
}
</script>

<style></style>
