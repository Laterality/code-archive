import Vue from 'vue'
import App from './App.vue'
import router from './router'

import firebase from 'firebase/app'
import 'firebase/messaging'

const firebaseConfig = {
  apiKey: 'AIzaSyCteH_YyLh1nq4KjCCeC00evSvo3nfl7jQ',
  authDomain: 'vue-fcm-6ff39.firebaseapp.com',
  databaseURL: 'https://vue-fcm-6ff39.firebaseio.com',
  projectId: 'vue-fcm-6ff39',
  storageBucket: 'vue-fcm-6ff39.appspot.com',
  messagingSenderId: '902231810000',
  appId: '1:902231810000:web:4c8725619f7c3e55f7a3d5'
}

firebase.initializeApp(firebaseConfig)

const messaging = firebase.messaging()

messaging.usePublicVapidKey('BHtTUZeVoHuJQc40ao2g41EQ6VY_w4D53hb7PGU6UA-8m12tO5OnNmZXsi_TbqjmdpWLYnPTi37zBHYo8QfHVOM')

// 알림 수신을 위한 사용자 권한 요청
Notification.requestPermission()
  .then((permission) => {
    console.log('permission ', permission)
    if (permission !== 'granted') {
      alert('알림을 허용해주세요')
    }
  })

// TODO: Send token to server for send notification
messaging.getToken()
  .then(console.log)

messaging.onMessage(payload => {
  console.log(payload)
  alert(payload.data.message)
})

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
