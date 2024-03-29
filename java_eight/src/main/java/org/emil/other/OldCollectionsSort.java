package org.emil.other;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: 13419
 * @Date: 2023/5/8 17:16
 * @Version: v1.0.0
 * @Description: TODO
 **/
public class OldCollectionsSort {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });

        Collections.sort(names, (String a, String b) -> b.compareTo(b));

        Collections.sort(names, (a, b) -> b.compareTo(a));

        names.sort((a, b) -> b.compareTo(a));
    }
}
