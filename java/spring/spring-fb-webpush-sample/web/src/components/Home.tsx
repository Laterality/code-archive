import firebase from "firebase/app";
import React, { useState } from "react";

export default function Home(): React.FunctionComponentElement<void> {
  const [token, setToken] = useState<string | null>(null);
  const [receivedMessage, setReceivedMessage] = useState<string>('');
  const msg = firebase.messaging();

  msg.onMessage((arg) => {
    console.log("Push received", arg);
    setReceivedMessage(receivedMessage + `${arg.notification.body}\n`);
  });

  function sendPush() {
    const body = new FormData();
    body.append("to", token ?? "");
    fetch(`http://localhost:8080/send`, {
      method: "POST",
      body,
    });
  }

  return (
    <>
      {!token && (
        <div>
          <button
            onClick={() =>
              msg.getToken().then((token) => {
                setToken(token);
              })
            }
          >
            Obtain token
          </button>
        </div>
      )}
      {token && (
        <div>
          <strong>Token: {token}</strong>
        </div>
      )}
      {token && <button onClick={sendPush}>Send push</button>}
      <textarea cols="30" rows="10" value={receivedMessage} contentEditable={false}></textarea>
    </>
  );
}
