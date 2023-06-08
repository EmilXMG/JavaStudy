package org.emil.builtin_functions;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * @Author: emil
 * @Date: 2023/5/9 10:31
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class PredicateDemo {

    public static void main(String[] args) {
        Predicate<String> predicate = s -> s.length() > 2;
        System.out.println(predicate.test("j"));
        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();

        Predicate<Boolean> nonNull = Objects::nonNull;

        Predicate<Boolean> isNull = Objects::isNull;
    }
}
