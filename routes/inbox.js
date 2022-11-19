var express = require('express');
var router = express.Router();

router.post('/', function(req, res, next) {

    // If signature is missing from header, reject
    var signature = req.get('signature');
    if (signature == null) {
        throw new Error('No signature')
    }

    res.setHeader('Content-Type', 'application/json');
    res.send(JSON.stringify("post received"));

});

module.exports = router;