package com.github.kop.plugin.otp;

import java.io.Serializable;

public interface OperationTableInterface {
    /**
     * 创建数据
     *
     * @param data 数据对象
     * @return id
     */
    <ID extends Serializable, T extends IdInterface<ID>> ID create(T data) throws ReflectiveOperationException;

    /**
     * 更新数据
     *
     * @param data 数据对象
     * @return 受影响行数
     */
    <ID extends Serializable, T extends IdInterface<ID>> int update(T data) throws ReflectiveOperationException;

    /**
     * 根据id查询实体
     *
     * @param id     id
     * @param target 操作的类
     * @return 数据对象
     */
    <ID extends Serializable, T extends IdInterface<ID>, O> O byId(ID id, Class<O> target) throws ReflectiveOperationException;

    /**
     * 根据id删除数据
     *
     * @param id     id
     * @param target 操作的类
     * @return 受影响行数
     */
    <ID extends Serializable> int delete(ID id, Class<?> target) throws ReflectiveOperationException;

}
