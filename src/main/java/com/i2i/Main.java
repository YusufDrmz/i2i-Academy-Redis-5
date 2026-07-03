package com.i2i;

import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;

public class Main {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        try (Jedis jedis = new Jedis("localhost", 6379)) {
            System.out.println("Redis'e bağlanıldı.");

            // 10.000 Person ekle
            for (int i = 1; i <= 10000; i++) {
                Person person = new Person(i, "Person_" + i, 20 + (i % 50));
                String json = mapper.writeValueAsString(person);
                jedis.set("person:" + i, json);
            }
            System.out.println("10.000 kişi eklendi.");

            // 10.000 Person oku ve birkaçını yazdır
            for (int i = 1; i <= 10000; i++) {
                String json = jedis.get("person:" + i);
                Person person = mapper.readValue(json, Person.class);
                if (i <= 5) {
                    System.out.println(person);
                }
            }
            System.out.println("10.000 kişi okundu.");
        }
    }
}