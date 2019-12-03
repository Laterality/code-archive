const consoleElm = document.querySelector('#console');
const evtSource = new EventSource('/subscribe', {withCredentials: true});
evtSource.onmessage = evt => {
    const item = document.createElement('li');
    item.innerText = JSON.parse(evt.data).message;
    consoleElm.appendChild(item);
}
document.querySelector('.btn-send')
.addEventListener('click', (evt) => {
    const inputElm = document.querySelector('#message-input');
    const message = inputElm.value;
    inputElm.value = '';
    fetch('/send', {
        method: 'POST',
        body: JSON.stringify({ message })
    })
    .then(res => {
        console.log('Message sent: ', res)
    })
})