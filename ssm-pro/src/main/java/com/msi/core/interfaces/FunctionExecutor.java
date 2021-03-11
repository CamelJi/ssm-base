package com.msi.core.interfaces;

/**
 * 执行方法 函数式接口
 * @param <T>
 */
@FunctionalInterface
public interface FunctionExecutor<T> {
    T execute();
}
