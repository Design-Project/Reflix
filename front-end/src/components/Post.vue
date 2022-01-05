<template>
  <div class="post">
    <div class="post-header">
      <div class="profile1"></div>
      <span class="profile-name">{{ postData.accountNickName }}</span>
    </div>
    <div
      class="post-body"
      v-bind:style="{ backgroundImage: `url(` + this.postData.imageUrl + `)` }"
    ></div>
    <div class="post-content">
      <img
        src="https://emojigraph.org/media/twitter/brown-heart_1f90e.png"
        class="recommand"
      />
      <p>{{ postData.likeCount }} Likes</p>
      <div>{{ postData.content }}</div>
      <p class="hashtag">{{ postData.movieTitle }}</p>
      <div>
        <p>{{ postData.accountNickName }}님의 평점 : {{ postData.rating }}</p>
        <div class="star-ratings">
          <div
            class="star-ratings-fill space-x-2 text-lg"
            v-if="postData.rating == 0"
          >
            <span>☆</span><span>☆</span><span>☆</span><span>☆</span
            ><span>☆</span>
          </div>
          <div
            class="star-ratings-fill space-x-2 text-lg"
            v-if="postData.rating == 1"
          >
            <span>★</span><span>☆</span><span>☆</span><span>☆</span
            ><span>☆</span>
          </div>
          <div
            class="star-ratings-fill space-x-2 text-lg"
            v-if="postData.rating == 2"
          >
            <span>★</span><span>★</span><span>☆</span><span>☆</span
            ><span>☆</span>
          </div>
          <div
            class="star-ratings-fill space-x-2 text-lg"
            v-if="postData.rating == 3"
          >
            <span>★</span><span>★</span><span>★</span><span>☆</span
            ><span>☆</span>
          </div>
          <div
            class="star-ratings-fill space-x-2 text-lg"
            v-if="postData.rating == 4"
          >
            <span>★</span><span>★</span><span>★</span><span>★</span
            ><span>☆</span>
          </div>
          <div
            class="star-ratings-fill space-x-2 text-lg"
            v-if="postData.rating == 5"
          >
            <span>★</span><span>★</span><span>★</span><span>★</span
            ><span>★</span>
          </div>
        </div>
      </div>
      <div class="d-flex justify-content-between align-items-center">
        <span
          v-if="!replyShow"
          @click="replyShowFunc()"
          style="cursor: pointer"
        >
          댓글보기
        </span>
        <span v-if="replyShow" @click="replyShowFunc()" style="cursor: pointer">
          댓글닫기
        </span>
        <span
          v-if="!createReplyShow"
          @click="setReply()"
          style="cursor: pointer; margin-right: 10px"
          >댓글작성</span
        >
        <span
          v-if="createReplyShow"
          @click="setReply()"
          style="cursor: pointer; margin-right: 10px"
          >작성취소</span
        >
      </div>
      <div v-if="createReplyShow">
        <b-form-textarea
          id="textarea"
          v-model="postReply.contents"
          placeholder="댓글을 작성해주세요..."
          rows="2"
          max-rows="6"
        ></b-form-textarea>

        <div class="d-flex justify-content-between align-items-center">
          <b-button
            squared
            variant="outline-success"
            size="sm"
            @click="rollback()"
            >초기화</b-button
          >
          <b-button
            squared
            variant="outline-danger"
            size="sm"
            @click="createReply()"
            >작성</b-button
          >
        </div>
      </div>

      <div v-if="replyShow">
        <Reply v-bind:replyValue="replyValue" :key="replyValue" />
      </div>
      <p></p>
    </div>
  </div>
</template>

<script>
import Reply from "./Reply.vue"
import axios from "axios"
export default {
  name: "Post",
  props: ["postDataValue"],
  components: {
    Reply
  },
  methods: {
    replyShowFunc() {
      this.replyShow = !this.replyShow
    },
    setReply() {
      this.postReply.contents = ""
      this.createReplyShow = !this.createReplyShow
    },
    createReply() {
      let token = localStorage.getItem("X-ACCESS-TOKEN")
      axios
        .post(
          `/app/movies/posts/${this.postData.postId}/replies`,
          this.postReply,
          {
            headers: {
              "X-ACCESS-TOKEN": token
            }
          }
        )
        .then(() => {
          this.getReply()
          this.postReply.contents = ""
          this.createReplyShow = !this.createReplyShow
        })
        .catch((err) => {
          alert(err.response.data.message)
        })
    },
    rollback() {
      this.postReply.contents = ""
    },
    getReply() {
      axios
        .get(`/app/movies/posts/${this.postDataValue.postId}/replies`)
        .then((res) => {
          this.replyValue = res.data.result
        })
        .catch((err) => {
          alert(err.response.data.message)
        })
    }
  },
  created() {
    this.replyShow = false
    this.createReplyShow = false
    this.postData = this.postDataValue
    this.getReply()
  },
  data() {
    return {
      reply: "",
      replyValue: null,
      replyShow: false,
      createReplyShow: false,
      postReply: {
        contents: ""
      },
      postData: {
        postId: null,
        imageUrl: "",
        movieTitle: "",
        content: "",
        rating: null,
        accountNickname: "",
        likeCount: null
      }
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
  background-image: url("https://d2u3dcdbebyaiu.cloudfront.net/uploads/atch_img/436/8142f53e51d2ec31bc0fa4bec241a919_crop.jpeg");
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
