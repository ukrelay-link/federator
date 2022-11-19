var config = require('../config');
var express = require('express');
var router = express.Router();

var nodeInfoFactory = require('../model/wellknown/nodeInfoFactory');

router.get('/nodeinfo', function(req, res, next) {
    var nodeInfo = nodeInfoFactory(
        'http://nodeinfo.diaspora.software/ns/schema/2.1',
        `${config.baseurl}/nodeinfo/2.1`);
    res.setHeader('Content-Type', 'application/json');
    res.send(JSON.stringify(nodeInfo));
});

module.exports = router;
