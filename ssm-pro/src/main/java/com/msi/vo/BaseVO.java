package com.msi.vo;

/**
 * @author zyh
 * @Date 2020/12/30
 * @Description TODO
 */
public class BaseVO {
    /**
     * 分页查询的当前页记录数量
     */
    private Integer size;
    /**
     * 分页查询的当前页码
     */
    private Integer current;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    @Override
    public String toString() {
        return "BaseVO{" +
                "size=" + size +
                ", current=" + current +
                '}';
    }
}
