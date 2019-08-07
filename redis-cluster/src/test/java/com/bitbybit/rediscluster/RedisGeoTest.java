package com.bitbybit.rediscluster;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisGeoTest {

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void geoAdd() {

        List<RedisGeoCommands.GeoLocation> geoLocations = new ArrayList<>();
        // songlanpu
        Point point = new Point(116.305473D,40.160284D);
        geoLocations.add(new RedisGeoCommands.GeoLocation("songlanpu", point));

        //qinghexincheng
        Point point1 = new Point(116.3537D,40.03434D);
        geoLocations.add(new RedisGeoCommands.GeoLocation("qinghexincheng", point1));

        //shigezhuang
        Point point2 = new Point(116.293466D,40.110932D);
        geoLocations.add(new RedisGeoCommands.GeoLocation("shigezhuang", point2));

        // mentouxincunnanqu
        Point point3 = new Point(116.215971D,39.973949D);
        geoLocations.add(new RedisGeoCommands.GeoLocation("mentouxincunnanqu", point3));

        //beiwujiayuan
        Point point4 = new Point(116.25763D,39.985005D);
        geoLocations.add(new RedisGeoCommands.GeoLocation("beiwujiayuan", point4));

        //saoziying
        Point point5 = new Point(116.290151D,40.013621D);
        geoLocations.add(new RedisGeoCommands.GeoLocation("saoziying", point5));

        redisTemplate.opsForGeo().add("beijing", geoLocations);
    }

    @Test
    public void geoPos() {
        try {
            List<Point> position = redisTemplate.opsForGeo().position("beijing", "songlanpu", "qinghexincheng", "shigezhuang", "mentouxincunnanqu",
                    "beiwujiayuan", "saoziying");
            for (Point point : position) {
                System.out.println(point.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void geoRadius() {
        try {
            //haizhichuangtou
            Circle circle = new Circle(116.314322D, 39.988198D, 100000D);
            RedisGeoCommands.GeoRadiusCommandArgs geoRadiusCommandArgs = RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs();
            geoRadiusCommandArgs.includeDistance();
            geoRadiusCommandArgs.includeCoordinates();
            geoRadiusCommandArgs.sortDescending();
            GeoResults beijing = redisTemplate.opsForGeo().radius("beijing", circle, geoRadiusCommandArgs);
            Iterator iterator = beijing.iterator();
            while (iterator.hasNext()) {
                GeoResult next = (GeoResult) iterator.next();
                System.out.println(next.getContent() + "====" + next.getDistance());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
