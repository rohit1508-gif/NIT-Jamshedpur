const express = require('express')
const router = new express.Router()
const Faculty = require('../model/faculty')
router.get('/faculties',async(req,res)=>{
    try{
       const faculty = await Faculty.find({})
       res.send(faculty)
    }
    catch(error){res.status(500).send(error)}
})
module.exports = router