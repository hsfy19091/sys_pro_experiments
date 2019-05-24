import Vue from 'vue'
import Vuex from 'vuex'
import createPersistedState from 'vuex-persistedstate'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    userInfo:{

    },
    token:""
  },
  mutations: {
    setToken(state,token){
      state.token = token
    },
    logout(state){
      state.userInfo = {}
      state.token = ""
    }
  },
  actions: {

  },
  plugins: [createPersistedState({ storage: window.sessionStorage })]
})
