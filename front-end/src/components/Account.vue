<template>
  <div>
    <div class="top">
      <a class="accountName">{{ 계정이름 }}님의 reflix</a>
    </div>

    <img src="../assets/reflixlogo.png" class="loginimage" />

    <div class="account">
      <img src="../assets/image.png" class="accimage" />
      <!-- 계정이미지 불러오기 -->
    </div>
    <h4 style="margin-left: 210px">{{ 계정이름 }}</h4>
    <!--계정이름 불러오기 -->

    <div>
      <p style="margin-left: 220px">{{ 나이 }} / {{ 성별 }}</p>
    </div>
    <div class="row">
      <div class="col-4"><a class="mypick">My Pick! </a></div>
      <div class="col-2"><h7 class="picktext">액션</h7></div>
      <div class="col-2"><h7 class="picktext">멜로</h7></div>
      <div class="col-2"><h7 class="picktext">판타지</h7></div>
    </div>

    <div>
      <div class="follow">
        <!-- 팔로우 버튼 생성 -->
        <div class="dropdown">
          <a
            class="btn btn-secondary dropdown-toggle"
            href="#"
            role="button"
            id="dropdownMenuLink"
            data-bs-toggle="dropdown"
            aria-expanded="false"
          >
            팔로우
          </a>

          <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
            <li><a class="dropdown-item" href="#">팔로우하기</a></li>
            <li><a class="dropdown-item" href="#">팔로우 취소</a></li>
            <li><a class="dropdown-item" href="#">차단하기</a></li>
          </ul>
        </div>
      </div>

      <div class="row">
        <p class="col-2" style="margin-left: 130px"><mark>팔로우 </mark></p>
        <p class="col-2"><mark>팔로잉 </mark></p>
        <p class="col-2"><mark>게시물 </mark></p>
      </div>
      <div class="row">
        <h4 class="col-2" style="margin-left: 135px">
          <mark>{{ follow }} </mark>
        </h4>
        <h4 class="col-2">
          <mark>{{ following }} </mark>
        </h4>
        <h4 class="col-2" style="margin-left: 10px">
          <mark> {{ postCount }} </mark>
        </h4>
      </div>

      <div class="rank">
        <h7 class="ranktext">{{ 계정이름 }}님의 평점 랭킹</h7>
      </div>

      <table class="table">
        <thead>
          <tr>
            <th scope="col">순위</th>
            <th scope="col">제목</th>
            <th scope="col">종류</th>
            <th scope="col">평점</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <th scope="row">1</th>
            <td>종이의집</td>
            <td>스페인드라마</td>
            <td>9.67 / 10.00</td>
          </tr>
          <tr>
            <th scope="row">2</th>
            <td>기생충</td>
            <td>한국영화</td>
            <td>9.55 / 10.00</td>
          </tr>
          <tr>
            <th scope="row">3</th>
            <td>귀멸의 칼날</td>
            <td>애니메이션</td>
            <td>9.42 / 10.00</td>
          </tr>
        </tbody>
      </table>

      <div class="bottom"></div>
    </div>
  </div>
</template>

<script>
import axios from "axios"
export default {
  name: "Accont",
  data() {
    return {
      계정이름: "",
      나이: "",
      성별: "",
      follow: 0,
      following: 0,
      postCount: 0
    }
  },
  methods: {
    getAccountInfo(nickname) {
      axios
        .get(`/app/accounts/auth/${nickname}`)
        .then((res) => {
          this.계정이름 = res.data.result.nickname
          this.나이 = res.data.result.age + "대"
          this.성별 = res.data.result.gender
          this.follow = res.data.result.follow
          this.following = res.data.result.following
          this.postCount = res.data.result.postCount
        })
        .catch((err) => {
          alert(err.response.data.message)
        })
    }
  },
  created: function () {
    this.getAccountInfo(this.$route.query.username)
  }
}
</script>

<style>
.loginimage {
  width: 30%;
  margin-left: 180px;
}
.picktext {
  background-color: pink;
  color: white;
  margin-left: 10px;
}

.mypick {
  color: red;
  margin-left: 80px;
  margin-bottom: 10px;
}

.bottom {
  background-color: red;
  margin-top: 20px;
  padding: 20px;
}
.rank {
  background-color: red;
  padding: 3px;
  border-radius: 20px;
  margin-left: 110px;
  margin-right: 130px;
  margin-top: 10px;
}
.ranktext {
  color: white;
  margin-left: 50px;
  padding: 5px;
}
.follow {
  margin-left: 200px;
}
.top {
  background-color: red;
  padding: 15px;
}
.accountName {
  color: white;
  padding: 10px;
  margin-left: 10px;
}
.accimage {
  width: 30%;
  margin-right: 450px;
  border-radius: 50px;
}
.account {
  margin-left: 200px;
  margin-top: 50px;
  width: 50%;
  margin-left: 210px;
  margin-top: 10px;
}
</style>
