const refreshList = () => {
    fetch('/articles')
    .then(res => res.json())
    .then(json => {
        const list = document.querySelector('.list-group');
        list.innerHTML = '';
        let innerHTML = '';
        for (const article of json) {
            innerHTML += `<li class="list-group-item">[${article.author.name}]: ${article.contents}</li>`;
        }
        list.innerHTML = innerHTML;
    });
}

document.querySelector('.btn-save').addEventListener('click', () => {
    const nameElm = document.querySelector('input[name=authorName]');
    const contentsElm = document.querySelector('input[name=contents]');

    fetch('/articles', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json; charset=utf-8'
        },
        body: JSON.stringify({
            authorName: nameElm.value,
            contents: contentsElm.value,
        }),
    })
    .then(res => refreshList());
});

refreshList();