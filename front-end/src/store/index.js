import Vue from "vue"
import Vuex from "vuex"
import axios from "axios"

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    userInfo: null,
    isLogin: false,
    isLoginError: false
  },
  mutations: {
    loginSuccess(state, payload) {
      state.isLogin = true
      state.isLoginError = false
      state.userInfo = payload
    },
    loginError(state) {
      state.isLogin = false
      state.isLoginError = true
    }
  },
  actions: {
    login({ dispatch }, loginObj) {
      axios
        .post("https://prod.reflix.club/app/sign-in", loginObj)
        .then((res) => {
          let token = res.data.result.jwt
          localStorage.setItem("X-ACCESS-TOKEN", token)
          dispatch("getUserInfo")
        })
        .catch((err) => {
          alert(err.response.data.message)
        })
    },
    getUserInfo({ commit }) {
      let token = localStorage.getItem("X-ACCESS-TOKEN")
      if (token) {
        let config = {
          headers: {
            "X-ACCESS-TOKEN": token
          }
        }
        axios
          .get("https://prod.reflix.club/app/accounts/auth", config)
          .then((response) => {
            let userInfo = response.data.result
            commit("loginSuccess", userInfo)
          })
          .catch((err) => {
            alert(err.response.data.message)
          })
      }
    },
    signUp({ dispatch }, signUpObj) {
      axios
        .post("https://prod.reflix.club/app/sign-up", signUpObj)
        .then((res) => {
          let token = res.data.result.jwt
          localStorage.setItem("X-ACCESS-TOKEN", token)
          dispatch("getUserInfo")
        })
        .catch((err) => {
          alert(err.response.data.message)
        })
    }
  },
  modules: {}
})
