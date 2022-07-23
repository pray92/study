
const express = require('express');

const app = express();

app.get('/', (req, res) => {
    res.send('Hello World for docker!');
});

app.listen(8080, () => console.log('Server is running!'));