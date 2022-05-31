/**
 *
 */
package com.karl.pager;

/**
 * 模块描述: 【分页接口】
 *
 * @Author: Mr. YuBang.Xu
 * @Date: 2022/5/31$ 11:29$
 * @since: 1.8.0
 * @version: 1.0.0
 */
public interface IPaginable<T> {

    /**
     * 总记录数
     *
     * @return
     */
    int getTotalCount();

    /**
     * 总页数
     *
     * @return
     */
    int getTotalPage();

    /**
     * 每页记录数
     *
     * @return
     */
    int getPageSize();

    /**
     * 当前页号
     *
     * @return
     */
    int getPageNo();

    /**
     * 是否第一页
     *
     * @return
     */
    boolean isFirstPage();

    /**
     * 是否最后一页
     *
     * @return
     */
    boolean isLastPage();

    /**
     * 返回下页页码
     *
     * @return
     */
    int getNextPage();

    /**
     * 返回上页页码
     *
     * @return
     */
    int getPrePage();

    /**
     * 取得当前页显示的项的起始序号
     *
     * @return
     */
    int getBeginIndex();

    /**
     * 取得当前页显示的末项序号
     *
     * @return
     */
    int getEndIndex();

    /**
     * 获取开始页
     *
     * @return
     */
    int getBeginPage();

    /**
     * 获取结束页
     *
     * @return
     */
    int getEndPage();
}
