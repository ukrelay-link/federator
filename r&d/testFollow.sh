#!/bin/sh
curl -X POST \
     -H "Content-Type: application/json" \
     -H "signature: xxxx" \
     https://ukrelay.link/inbox \
     -d '{"@context":"https://www.w3.org/ns/activitystreams","id":"https://localhost/ffffffff-ffff-ffff-ffff-ffffffffffff","type":"Follow","actor":https://localhost/users/lee","object":"https://www.w3.org/ns/activitystreams#Public"}'
