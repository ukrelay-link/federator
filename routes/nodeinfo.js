var express = require('express');
var router = express.Router();

router.get('/2.1', function(req, res, next) {
    var nodeInfo = {
        "version": "2.1",
        "software": { 
            "name": "federator",
            "version": "v0.0.1",
            "repository":"https://github.com/tba"
        },
        "protocols": [ "activitypub" ],
        "services": { "inbound":[], "outbound":[] },
        "openRegistrations": true,
        "usage": {
            "users": {
                "total":0,
                "activeMonth":0,
                "activeHalfyear":0
            }
        },
        "metadata": {}
    };

    res.setHeader('Content-Type', 'application/json');
    res.send(JSON.stringify(nodeInfo));
});

module.exports = router;