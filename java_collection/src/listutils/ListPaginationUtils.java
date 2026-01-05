package listutils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListPaginationUtils {

    /**
     * 通用分页查询（支持多条件、多字段排序）
     *
     * @param sourceList   原始数据列表
     * @param predicates   条件列表（可空）
     * @param combineMode  条件组合方式（AND/OR）
     * @param sortCriteria 排序条件列表（可空）
     * @param pageNumber   页码（从1开始）
     * @param pageSize     每页大小
     * @return 分页结果（包含数据和元信息）
     */
    public static <T> PageResult<T> paginate(
            List<T> sourceList,
            List<Predicate<T>> predicates,
            CombinationMode combineMode,
            List<SortCriteria<T>> sortCriteria,
            int pageNumber,
            int pageSize
    ) {
        // 处理空列表
        if (sourceList == null || sourceList.isEmpty()) {
            return emptyResult(pageNumber, pageSize);
        }

        // 参数校验
        validateParams(pageNumber, pageSize);

        // 1. 合并条件
        Predicate<T> combinedPredicate = combinePredicates(predicates, combineMode);

        // 2. 过滤数据
        List<T> filteredList = sourceList.stream()
                .filter(combinedPredicate)
                .collect(Collectors.toList());

        // 3. 排序数据
        sortData(filteredList, sortCriteria);

        // 4. 执行分页
        return executePagination(filteredList, pageNumber, pageSize);
    }

    //-------------- 私有方法 --------------
    private static <T> PageResult<T> emptyResult(int pageNumber, int pageSize) {
        return new PageResult<>(Collections.emptyList(), pageNumber, pageSize, 0);
    }

    private static void validateParams(int pageNumber, int pageSize) {
        if (pageNumber < 1 || pageSize < 1) {
            throw new IllegalArgumentException("Page number and size must be >= 1");
        }
    }

    private static <T> Predicate<T> combinePredicates(
            List<Predicate<T>> predicates,
            CombinationMode combineMode
    ) {
        if (predicates == null || predicates.isEmpty()) {
            return x -> true; // 无条件时不过滤
        }

        Predicate<T> base = predicates.get(0);
        for (int i = 1; i < predicates.size(); i++) {
            base = (combineMode == CombinationMode.AND) ?
                    base.and(predicates.get(i)) :
                    base.or(predicates.get(i));
        }
        return base;
    }

    private static <T> void sortData(List<T> data, List<SortCriteria<T>> sortCriteria) {
        if (sortCriteria == null || sortCriteria.isEmpty()) return;

        Comparator<T> comparator = sortCriteria.stream()
                .map(SortCriteria::toComparator)
                .reduce(Comparator::thenComparing)
                .orElse((a, b) -> 0);

        data.sort(comparator);
    }

    private static <T> PageResult<T> executePagination(List<T> data, int pageNumber, int pageSize) {
        int totalItems = data.size();
        if (totalItems == 0) {
            return new PageResult<>(Collections.emptyList(), pageNumber, pageSize, 0);
        }

        int fromIndex = (pageNumber - 1) * pageSize;
        if (fromIndex >= totalItems) {
            return new PageResult<>(Collections.emptyList(), pageNumber, pageSize, totalItems);
        }

        int toIndex = Math.min(fromIndex + pageSize, totalItems);
        List<T> pageContent = new ArrayList<>(data.subList(fromIndex, toIndex));

        return new PageResult<>(pageContent, pageNumber, pageSize, totalItems);
    }
}