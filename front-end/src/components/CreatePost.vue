<template>
  <div>
    <b-row class="mt-5">
      <b-col></b-col>
      <b-col cols="9">
        <b-input-group prepend="Movie Name" class="mt-3">
          <b-form-input
            v-model="CreatePostReq.movieNameByClient"
          ></b-form-input>
        </b-input-group>
      </b-col>
      <b-col cols="2"></b-col>
    </b-row>
    <b-row class="mt-5">
      <b-col></b-col>
      <b-col cols="10">
        <b-form-textarea
          id="textarea"
          v-model="CreatePostReq.contents"
          placeholder="Contents"
          rows="5"
          max-rows="6"
        ></b-form-textarea>
      </b-col>
      <b-col></b-col>
    </b-row>
    <b-row class="mt-5">
      <b-col></b-col>
      <b-col>
        <div cols="10">
          <b-form-select
            v-model="CreatePostReq.rating"
            :options="options"
          ></b-form-select>
        </div>
      </b-col>
      <b-col></b-col>
    </b-row>
    <b-row class="mt-5">
      <b-col></b-col>
      <b-col>
        <div cols="10">
          <b-button
            variant="danger"
            style="margin-right: 20px"
            @click="createMovie(CreatePostReq)"
            >작성</b-button
          >
          <b-button variant="success">홈으로</b-button>
        </div>
      </b-col>
      <b-col></b-col>
    </b-row>
  </div>
</template>

<script>
import axios from "axios"
export default {
  methods: {
    createMovie(value) {
      let token = localStorage.getItem("X-ACCESS-TOKEN")
      axios
        .post("/app/movies/posts", value, {
          headers: {
            "X-ACCESS-TOKEN": token
          }
        })
        .then(() => {
          this.$router.push({
            name: "Main"
          })
        })
        .catch((err) => {
          alert(err.response.data.message)
        })
    }
  },
  data() {
    return {
      CreatePostReq: {
        movieNameByClient: "",
        contents: "",
        rating: null
      },
      options: [
        { value: null, text: "영화의 평점을 선택해주세요." },
        { value: 5, text: "5점" },
        { value: 4, text: "4점" },
        { value: 3, text: "3점" },
        { value: 2, text: "2점" },
        { value: 1, text: "1점" }
      ]
    }
  }
}
</script>

<style></style>
