module.exports = function (rel, href) {
  var nodeInfo = {
    links: [{ rel: rel, href: href }]
  };
  return nodeInfo;
}