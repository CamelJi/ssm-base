package com.msi.core.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author zyh
 * @Date 2020/12/30
 * @Description TODO
 */
public class PageVO<T> implements Serializable {
    private List<T> list;

    private Long size;

    private Long total;

    private Long current;

    public PageVO(Long c, Long s, Long t) {
        this.current = c;
        this.size = s;
        this.total = t;
    }

    public PageVO(List<T> list, Long size, Long total, Long current) {
        this.list = list;
        this.size = size;
        this.total = total;
        this.current = current;
    }

    public List<T> getList() {
        return list;
    }

    public PageVO<T> setList(List<T> list) {
        this.list = list;
        return this;
    }

    public Long getSize() {
        return size;
    }

    public PageVO<T> setSize(Long size) {
        this.size = size;
        return this;
    }

    public Long getTotal() {
        return total;
    }

    public PageVO<T> setTotal(Long total) {
        this.total = total;
        return this;
    }

    public Long getCurrent() {
        return current;
    }

    public PageVO<T> setCurrent(Long current) {
        this.current = current;
        return this;
    }

    @Override
    public String toString() {
        return "PageVO{" +
                "list=" + list +
                ", size=" + size +
                ", total=" + total +
                ", current=" + current +
                '}';
    }
}
