<template>
  <div>
    <div v-if="postDatas">
      <div>
        <div
          v-for="postDataValue in postDatas"
          v-bind:key="postDataValue.postId"
        >
          <Post v-bind:postDataValue="postDataValue" />
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import Post from "./Post.vue"
import axios from "axios"
export default {
  components: {
    Post
  },
  data() {
    return {
      postDatas: null
    }
  },
  created() {
    axios
      .get("https://prod.reflix.club/app/movies/posts")
      .then((res) => {
        this.postDatas = res.data.result
      })
      .catch((err) => {
        alert(err.response.data.message)
      })
  }
}
</script>
