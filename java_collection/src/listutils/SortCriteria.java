package listutils;

import java.util.Comparator;
import java.util.function.Function;

public interface SortCriteria<T> {
    Comparator<T> toComparator();

    // 创建基于方法引用的排序条件
    static <T, U extends Comparable<? super U>> SortCriteria<T> of(
            Function<T, U> fieldExtractor,
            SortDirection direction
    ) {
        return () -> {
            Comparator<T> comparator = Comparator.comparing(fieldExtractor);
            return direction == SortDirection.DESC ? comparator.reversed() : comparator;
        };
    }

    // 创建嵌套字段排序条件（如 user -> user.getAddress().getCity()）
    static <T, U extends Comparable<? super U>> SortCriteria<T> nested(
            Function<T, ? extends U> fieldExtractor,
            SortDirection direction
    ) {
        return of(fieldExtractor, direction);
    }

    // 创建自定义比较器
    static <T> SortCriteria<T> custom(Comparator<T> comparator) {
        return () -> comparator;
    }

    // 组合多个排序条件
    default SortCriteria<T> then(SortCriteria<T> other) {
        return () -> this.toComparator().thenComparing(other.toComparator());
    }
}