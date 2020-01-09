// Give the service worker access to Firebase Messaging.
// Note that you can only use Firebase Messaging here, other Firebase libraries
// are not available in the service worker.
importScripts('https://www.gstatic.com/firebasejs/7.6.1/firebase-app.js');
importScripts('https://www.gstatic.com/firebasejs/7.6.1/firebase-messaging.js');

// Initialize the Firebase app in the service worker by passing in the
// messagingSenderId.
firebase.initializeApp({
  apiKey: 'AIzaSyCteH_YyLh1nq4KjCCeC00evSvo3nfl7jQ',
  projectId: 'vue-fcm-6ff39',
  messagingSenderId: '902231810000',
  appId: '1:902231810000:web:4c8725619f7c3e55f7a3d5'
})

// Retrieve an instance of Firebase Messaging so that it can handle background
// messages.
const messaging = firebase.messaging()

// 백그라운드 상태에서 받은 알림 처리
messaging.setBackgroundMessageHandler((payload) => {
  console.log('[firebase-messaging-sw.js] Received background message ', payload)
  // Customize notification here
  const notificationTitle = 'Background Message Title'
  const notificationOptions = {
    body: 'Background Message body.',
    icon: '/firebase-logo.png'
  }

  return self.registration.showNotification(notificationTitle,
    notificationOptions)
})
