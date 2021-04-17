// Give the service worker access to Firebase Messaging.
// Note that you can only use Firebase Messaging here. Other Firebase libraries
// are not available in the service worker.
importScripts('https://www.gstatic.com/firebasejs/8.3.1/firebase-app.js');
importScripts('https://www.gstatic.com/firebasejs/8.3.1/firebase-messaging.js');

// Initialize the Firebase app in the service worker by passing in
// your app's Firebase config object.
// https://firebase.google.com/docs/web/setup#config-object
firebase.initializeApp({
    apiKey: "AIzaSyBMcrD2iLG2kB_OAp4S-tjVfJOH4RbMjzE",
    authDomain: "test-push-app-5adb2.firebaseapp.com",
    projectId: "test-push-app-5adb2",
    storageBucket: "test-push-app-5adb2.appspot.com",
    messagingSenderId: "485081917445",
    appId: "1:485081917445:web:f6d1f71ee76b7349b2546c"
  });

// Retrieve an instance of Firebase Messaging so that it can handle background
// messages.
const messaging = firebase.messaging();