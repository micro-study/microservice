package com.hz.base.page;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Json标注本来应该直接加载{@link Page}类上，但修改工作量太大，这里添加新的类，对其包装
 *
 * @author yulewei on 2016/9/18
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class Page4Json<E> {
    private Page<E> pageObj;
    public static <E> Page4Json<E> of(Page<E> pageObj) {
        return new Page4Json<E>(pageObj);
    }
    private Page4Json(Page<E> pageObj) {
        this.pageObj = pageObj;
    }
    @JsonProperty("list")
    public List<E> getResult() {
        return new ArrayList<E>(pageObj.getResult());
    }
    /**
     * 总数量
     */
    @JsonProperty("totalItems")
    public long getTotalItems() {
        return pageObj.getTotal();
    }
    /**
     * 总页数
     */
    @JsonProperty("totalPages")
    public int getTotalPages() {
        return pageObj.getPages();
    }
    /**
     * 当前页码
     */
    @JsonProperty("pageNum")
    public int getPageNum() {
        return pageObj.getPageNum();
    }
    /**
     * 每页数量
     */
    @JsonProperty("pageSize")
    public int getPageSize() {
        return pageObj.getPageSize();
    }
}