package listutils;

import java.util.List;

public class PageResult<T> {
    private List<T> content;      // 当前页数据
    private int pageNumber;       // 当前页码
    private int pageSize;         // 每页大小
    private int totalPages;       // 总页数
    private long totalItems;      // 总记录数（过滤后的数量）

    public PageResult(List<T> content, int pageNumber, int pageSize, long totalItems) {
        this.content = content;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalItems = totalItems;
        this.totalPages = (int) Math.ceil((double) totalItems / pageSize);
    }

    // Getter 方法
    public List<T> getContent() {
        return content;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public long getTotalItems() {
        return totalItems;
    }
}