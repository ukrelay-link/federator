var express = require('express');
var router = express.Router();

router.get('/', function(req, res, next) {
  var instances = [{name:'one.one.one'}, {name:'two.two.two'}];
  var host = 'localhost';
  var baseurl = 'http://localhost:3000';
  var note = 'An instance defined note goes here';

  res.render('index', { title: 'Federator', host: host, baseurl: baseurl, note: note, instances: instances });
});

module.exports = router;
