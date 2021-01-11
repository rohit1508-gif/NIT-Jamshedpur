const express  = require('express')
require('./src/db/mongoose')
const facultyrouter = require('./src/router/faculty.js')
const app = express()
const port = process.env.PORT 
app.use(express.json())
app.use(facultyrouter)
app.listen(port,()=>{
    console.log('Server setup in Port ' + port)
})

