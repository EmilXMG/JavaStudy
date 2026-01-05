package listutils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Alice", 25, 3000),
                new User("Bob", 30, 5000),
                new User("Charlie", 20, 4000),
                new User("David", 30, 6000)
        );

        // 1. 多条件查询（年龄 > 25 AND 薪资 < 6000）
        Predicate<User> ageFilter = user -> user.getAge() > 25;
        Predicate<User> salaryFilter = user -> user.getSalary() < 6000;
        List<Predicate<User>> predicates = Arrays.asList(ageFilter, salaryFilter);

        // 2. 多字段排序（先按年龄降序，再按薪资升序）
        List<SortCriteria<User>> sortCriteria = Arrays.asList(
                SortCriteria.of(User::getAge, SortDirection.DESC),
                SortCriteria.of(User::getSalary, SortDirection.ASC)
        );

        // 3. 执行分页查询（第1页，每页2条）
        PageResult<User> result = ListPaginationUtils.paginate(
                users,
                predicates,
                CombinationMode.AND,
                sortCriteria,
                1,
                2
        );

        // 输出结果
        System.out.println("Total Items: " + result.getTotalItems()); // 2 (符合条件的Bob和David)
        result.getContent().forEach(user ->
                System.out.println(user.getName() + " - Age: " + user.getAge() + ", Salary: " + user.getSalary())
        );
        // Bob - Age: 30, Salary: 5000
        // David - Age: 30, Salary: 6000 (薪资不符合条件会被过滤掉？）
    }
}

// 实体类
class User {
    private String name;
    private int age;
    private int salary;

    public User(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // Getter 方法（必须存在）
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }
}