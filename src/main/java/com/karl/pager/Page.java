package com.karl.pager;

/**
 * 模块描述: 【分页参数】
 *
 * @Author: Mr. YuBang.Xu
 * @Date: 2022/5/31$ 11:23$
 * @since: 1.8.0
 * @version: 1.0.0
 */
public class Page<T> implements IPaginable<T> {
    /**
     * 默认页条数
     */
    public static final int DEFAULT_PAGE_SIZE = 10;

    /**
     * 页数
     */
    public static final int PAGE_COUNT = 10;

    /**
     * 页码
     */
    private int pageNo = 1;

    /**
     * 每页条数
     */
    private int pageSize = DEFAULT_PAGE_SIZE;

    /**
     * 总条数
     */
    private int totalCount = 0;

    /**
     * 总页数
     */
    private int totalPage = 0;

    /**
     * 查询时间戳
     */
    private long timestamp = 0;

    /**
     * 是否全量更新
     */
    private boolean full = false;

    @Override
    public int getPageNo() {
        return pageNo;
    }

    @Override
    public boolean isFirstPage() {
        return pageNo <= 1;
    }

    @Override
    public boolean isLastPage() {
        return pageNo >= totalPage;
    }

    @Override
    public int getNextPage() {
        return isLastPage() ? pageNo : (pageNo + 1);
    }

    @Override
    public int getPrePage() {
        return isFirstPage() ? pageNo : (pageNo - 1);
    }

    @Override
    public int getBeginIndex() {
        return pageNo > 0 ? (pageSize * (pageNo - 1)) : 0;
    }

    @Override
    public int getEndIndex() {
        return pageNo > 0 ? Math.min(pageNo * pageSize, totalCount) : 0;
    }

    @Override
    public int getBeginPage() {
        return pageNo > 0 ? (PAGE_COUNT * ((pageNo - 1) / PAGE_COUNT) + 1) : 0;
    }

    @Override
    public int getEndPage() {
        return pageNo > 0 ? Math.max(PAGE_COUNT * ((pageNo - 1) / PAGE_COUNT + 1), getTotalPage()) : 0;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    @Override
    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        int totalPage = totalCount % pageSize != 0 ? totalCount / pageSize + 1 : totalCount / pageSize;
        this.setTotalPage(totalPage);
    }

    @Override
    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }
}
