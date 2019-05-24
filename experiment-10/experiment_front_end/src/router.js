import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/getCourses',
      name: 'getCourses',
      component: () =>import("./pages/main/components/getCourses")
    },{
      path: '/',
      name: 'index',
      component: () =>import("./pages/main/components/index")
    },{
      path: '/getCoursesById',
      name: 'getCoursesById',
      component: () =>import("./pages/main/components/getCoursesById")
    },{
      path: '/addCourses',
      name: 'addCourses',
      component: () =>import("./pages/main/components/addCourses")
    }
    // {
    //   path: '/about',
    //   name: 'about',
    //   // route level code-splitting
    //   // this generates a separate chunk (about.[hash].js) for this route
    //   // which is lazy-loaded when the route is visited.
    //   component: () => import(/* webpackChunkName: "about" */ './views/About.vue')
    // }
  ]
})
