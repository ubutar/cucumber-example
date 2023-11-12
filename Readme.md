#### Have docker installed
  - Alternatively, have Selenium Hub with at least one chrome node running.
#### Execute these, line by line, *from elevated prompt*:
`docker network create grid`\
`docker run -d -p 4442-4444:4442-4444 --net grid --name selenium-hub selenium/hub`\
`docker run -d --net grid --name chrome-node -e SE_EVENT_BUS_HOST=selenium-hub --shm-size="2g" -e SE_EVENT_BUS_PUBLISH_PORT=4442 -e SE_EVENT_BUS_SUBSCRIBE_PORT=4443 -e SE_NODE_MAX_SESSIONS=2 selenium/node-chrome`

or any other grid, hub and node names, if by chance those already exist

#### Run
by calling maven's `clean install` from project root

#### Configuration
Check `fake-news-tests` module, `src/test/java/resources` for features and configs.\
By default, solution assumes `localhost` as hub host, it can be changed from command line:\
`clean install -Dremote.driver.url=http://<host>:<port>`

#### Reports
`fake-news-tests` : `target/cucumber-reports`

### About
1. SpringBoot + Cucumber + Junit5 + Selenium 4
2. Works in parallel if enough concurrency available on Hub
3. Some tests should fail occasionally (by design)