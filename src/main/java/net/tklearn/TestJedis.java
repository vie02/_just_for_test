package net.tklearn;

import redis.clients.jedis.Jedis;

public class TestJedis {

    public static void main(String[] args) {
	// write your code here
        Jedis jedis = new Jedis("127.0.0.1");
        System.out.println("PING: " + jedis.ping());
        jedis.set("name", "tklearn.net");
        jedis.set("description", "a programming website");
        jedis.lpush("list", "Redis");
        jedis.lpush("list", "Mongodb");
        jedis.lpush("list", "Mysql");

        System.out.println("NAME: " + jedis.get("name"));
        System.out.println("DESC: " + jedis.get("description"));
        System.out.println("LIST: " + jedis.lrange("list", 0, 10));
    }
}
