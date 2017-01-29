/**
 * Stome.com Co.,Ltd.
 * Copyright (c) 2004-2017, All Rights Reserved.
 */
package com.stome.workbanch.core.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.stome.workbanch.common.util.JsonUtil;

/** 
 * TODO [这里描述这个类的作用，必填]
 * 
 * @author Robin 
 * @date 2017-01-29 08:07:23 
 * @version $id: Test.java v1.0 
 */
public class Test {
    public static void main(String[] args) {
        User u = new User();
        u.setId(12);
        u.setName("aaa");
        u.setAge(5);
        u.setBirthday(new Date());

        User u2 = new User();
        u2.setId(122);
        u2.setName("aaa222");
        u2.setAge(25);
        u2.setBirthday(new Date());

        List<User> list = new ArrayList<User>();
        list.add(u);
        list.add(u2);

        System.out.println(JsonUtil.object2Json(u));

        //String json = "{\"id\":12,\"name\":\"aaa\",\"age\":5,\"birthday\":\"2017-01-29 08:13:48\"}";
        //User user = JsonUtil.json2Object(json, User.class);
        //System.out.println(user);

        //System.out.println(JsonUtil.object2Json(list));

        //String jsonList = "[{\"id\":12,\"name\":\"aaa\",\"age\":5,\"birthday\":\"2017-01-29T08:25:02\"},{\"id\":122,\"name\":\"aaa222\",\"age\":25,\"birthday\":\"2017-01-29T08:25:02\"}]";
        //List<User> list2 = JsonUtil.json2List(jsonList, new TypeReference<List<User>>() {
        //});
        //System.out.println(list2);

        //Map<String, User> map = new HashMap<String, User>();
        //map.put("a", u);
        //map.put("b", u2);

        //System.out.println(JsonUtil.object2Json(map));

        //String jsonmap = "{\"a\":{\"id\":12,\"name\":\"aaa\",\"age\":5,\"birthday\":\"2017-01-29T08:30:24\"},\"b\":{\"id\":122,\"name\":\"aaa222\",\"age\":25,\"birthday\":\"2017-01-29T08:30:24\"}}";

        //        Map<String, User> map = JsonUtil.json2Map(jsonmap, User.class);
        //        System.out.println(map);

        //        Map<String, Object> map = new HashMap<String, Object>();
        //        map.put("id", 123);
        //        map.put("name", "aaa");
        //        map.put("age", "43");
        //        map.put("birthday", "2017-01-29T08:30:24");
        //
        //        User us = JsonUtil.map2Object(map, User.class);
        //        System.out.println(us);

    }
}
