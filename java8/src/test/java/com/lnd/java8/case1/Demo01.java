package com.lnd.java8.case1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Stream;

/**
 * @Author lnd
 * @Description 函数式接口
 *      1、Consumer
 *          1.2、BiConsumer
 *      2、Supplier
 *      3、Function
 *      4、Predicate
 * @Date 2022/8/21 20:36
 */
@SpringBootTest
public class Demo01 {

    List<Integer> integers = Arrays.asList(1,2,3,4,5,6,7,7,8,9);

    /**
     *
     */
    @Test
    public void test01() {
        Stream<Integer> stream = Stream.iterate(2, i -> i * 2);
        stream.limit(10).forEach(System.out::println);
    }

    @Test
    public void test02() {
        Stream<Double> stream = Stream.generate(Math::random);
        stream.limit(10).forEach(System.out::println);
    }

    @Test
    public void test03() {
        Stream<Integer> stream = integers.stream();
        stream.filter((e) -> {
            return e % 2 == 0;
        }).forEach(System.out::println);
    }

    @Test
    public void test04() {
        Stream<Integer> stream = integers.stream();
        stream.filter((e) -> {
            return e % 2 == 0;
        }).forEach(System.out::println);
    }

    /**
     *
     */
    @Test
    public void test05() {
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(str -> filterChar(str)).forEach(System.out::println);
        list.stream().flatMap(str -> filterChar(str)).forEach(System.out::println);
    }

    private Stream<Character> filterChar(String str) {
        ArrayList<Character> list = new ArrayList<>();
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            list.add(aChar);
        }
        return list.stream();
    }

    /**
     *
     */
    @Test
    public void test06() {
        /*
            10 + 1 = 11
            11 + 3 = 14
            14 + 5 = 19
        */
        List<Integer> list = Arrays.asList(1, 3, 5);
        Integer reduce = list.stream().reduce(10, (a, b) -> a + b);
        Optional<Integer> reduce2 = list.stream().reduce((a, b) -> a + b);  //对于Integer类型而言，identity默认为0
        System.out.println(reduce);
        System.out.println(reduce2.get());
    }


    /**
     *
     */
    @Test
    public void test07() {

    }
}
