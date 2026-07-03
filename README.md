# Redis Homework

A simple Java application that connects to a local Redis instance via Docker
and inserts/retrieves 10,000 Person objects using Jedis client.

## Technologies
- Java 21, Maven, Jedis
- Redis + RedisInsight (Docker)

## Run
Start the containers first:
docker run -d --name redis -p 6379:6379 redis:latest
docker run -d --name redisinsight -p 5540:5540 redis/redisinsight:latest
Then run `Main.java` in IntelliJ.
