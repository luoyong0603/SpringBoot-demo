package com.example.demo;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StreamTest {

    @Autowired
    private UserService userService;


    @Test
    void contextLoads() {
        List<UserEntity> users = userService.list();
        //输出符合表达式的每一个对象
        users.stream().forEach(System.out::println);

        //返回一个符合表达式的集合的第一个对象
        Optional<UserEntity> first = users.stream().filter(p -> p.getAge() > 20).findFirst();
        System.out.println(first);

        //输出name:sex的map集合
        Map<String, String> collect = users.stream().collect(Collectors.toMap(UserEntity::getName, UserEntity::getSex));

        //转set集合
        Set<UserEntity> set = users.stream().filter(p -> p.getAge() > 20).collect(Collectors.toSet());

        //按年龄从小到大排序
        List<Integer> sortList1 = users.stream().sorted(Comparator.comparing(UserEntity::getAge)).map(UserEntity::getAge)
                .collect(Collectors.toList());
        //按年龄从大到小排序
        List<Integer> sortList2 = users.stream().sorted(Comparator.comparing(UserEntity::getAge).reversed())
                .map(UserEntity::getAge).collect(Collectors.toList());
        List<UserEntity> collect1 = users.stream().sorted(Comparator.comparing(UserEntity::getAge).reversed()).collect(Collectors.toList());

        //去重
        List<UserEntity> distinctList = users.stream().distinct().collect(Collectors.toList());
    }

    @Test
    void test() {
        List<String> strList = Arrays.asList("YangHang", "AnXiaoHei", "LiuPengFei");

        strList.forEach(System.out::println);
        //两种写法等价
        strList.forEach(x -> {
            System.out.println(x);
        });
    }

    //提取List对象中的id到新List中；
    @Test
    void test1() {
        List<UserEntity> users = userService.list();
        List<Integer> ids = users.stream().map(UserEntity::getId).collect(Collectors.toList());
        System.out.println(ids);
    }

    //提取符合条件的集合第一个对象。
    @Test
    void test2() {
        List<UserEntity> users = userService.list();

        Optional<UserEntity> user1 = users.stream().filter(p -> p.getAge() > 20 && p.getSex().equals("男")).findFirst();
        //等价上边这种写法
        Optional<UserEntity> user2 = users.stream().filter(p -> p.getAge() > 20)
                .filter(p -> p.getSex().equals("男"))
                .findFirst();
        System.out.println(user2);
    }

    @Test
    void test3() {
        List<String> strs = Arrays.asList("a", "b", "c");
        // 创建一个顺序流
        Stream<String> stream = strs.stream();
        // 创建一个并行流
        Stream<String> parallelStream = strs.parallelStream();

        String[] strings = new String[10];
        Stream<String> stream1 = Arrays.stream(strings);
    }

    //Stream静态方法
    @Test
    void test4() {

        //用于为给定元素创建顺序流
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5);
        stream1.forEach(System.out::print);//1,2,3,4,5
        //指定一个常量seed，生成从seed到常量f（由UnaryOperator返回的值得到）的流。

        //根据起始值seed(0)，每次生成一个指定递增值（n+1）的数，limit(5)用于截断流的长度，即只获取前5个元素。
        Stream.iterate(10, x -> x + 10).limit(5).forEach(System.out::print);//1020304050
        System.out.println();

        //合并两个流
        String[] strs = {"a","b","c"};
        Integer[] ints = {1,2,3};
        Stream concat = Stream.concat(Arrays.stream(strs), Arrays.stream(ints));
        concat.forEach(System.out::print);//abc123

        //流generate(Supplier s)返回无限顺序无序流，其中每个元素由提供的供应商生成。
        // 这适用于生成恒定流，随机元素流等。
        Stream.generate(new Random()::nextInt).limit(5).forEach(System.out::println);//1149006011  -703426624  774541719 942720678 1437848577

        System.out.println();

        //创建一个空的顺序流。
        Stream<String> empty = Stream.empty();
        empty.forEach(System.out::println);//无输出

        //构建流
        Stream.Builder<String> builder = Stream.builder();
        builder.add("a");
        builder.add("b");
        builder.add("c");
        builder.add("d");
        builder.add("e");
        builder.build().forEach(System.out::print); //abcde
    }


}
