package com.redis.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @program: demo
 * @description:
 * @author: Mr.Chen
 * @create: 2018-05-05 23:18
 **/
public class JedisDemo1 {

    @Test
    /**
     * 单实例的测试
     */
    public void demo1(){
        // 1、设置IP地址和端口
        Jedis jedis = new Jedis("127.0.0.1",6379);

        // 2、保存数据
        jedis.set("name","Test");

        // 3、获取数据
        String name = jedis.get("name");
        System.out.println("name:" + name);

        // 4、释放资源
        jedis.close();

        /**
         * 注：如果使用的是Linux系统，需要设置6379端口打开，并重启Linux防火墙
         *  基本命令：
         *  1、进入编辑模式
         *      vim /etc/sysconfig/iptables
         *  2、添加端口访问控制（添加如下）
         *      -A INPUT -m state NEW -m tcp --dport 6379 -j ACCEPT
         *  3、保存退出
         *  4、重启Linux防火墙
         *      service iptables restart
         */

    }

    @Test
    /**
     * 连接池方式连接
     */
    public void demo2(){
        // 获得连接池的配置对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

        //设置最大连接数
        jedisPoolConfig.setMaxTotal(30);

        //设置最大空闲连接数
        jedisPoolConfig.setMaxIdle(10);

        //获得连接池
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,"127.0.0.1",6379);

        //获得核心对象
        Jedis jedis = null;
        try {
            //通过连接池获得连接
            jedis = jedisPool.getResource();

            //设置数据
            jedis.set("name","test");

            //获取数据
            String name = jedis.get("name");
            System.out.println("name: " + name);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            //释放资源
            if (jedis != null){
                jedis.close();
            }
            if (jedisPool != null){
                jedisPool.close();
            }
        }
    }

}
