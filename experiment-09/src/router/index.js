import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/Example01',
      name: 'Example01',
      component: () => import("../components/Example01.vue")
    },
    {
      path: '/Example02',
      name: 'Example02',
      component: () => import("../components/Example02.vue")
    }
  ]
})
