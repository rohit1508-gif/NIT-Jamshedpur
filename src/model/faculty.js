const mongoose = require('mongoose')
const facultySchema = new mongoose.Schema({
    image:{type:String,required:true},
    name:{type:String,required:true},
    des:{type:String,required:true},
    branch:{type:String,required:true},
    link:{type:String,required:true}
},{ collection: 'faculties'})
const Faculty = mongoose.model('Faculty',facultySchema)
module.exports=Faculty
