package com.github.kop.plugin.otp;

import org.apache.ibatis.session.SqlSession;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class CrudTemplate implements OperationTableInterface {


    /**
     * mybatis中向数据库执行插入的方法
     */
    protected final String createMethodName;
    /**
     * mybatis中向数据库执行更新的方法
     */
    protected final String updateByIdMethodName;
    /**
     * mybatis中向数据库执行根据id查询的方法
     */
    protected final String byIdMethodName;
    /**
     * mybatis中向数据库执行根据id删除的方法
     */
    protected final String deleteByIdMethodName;

    protected final SqlSession sqlSession;

    protected Map<Class<?>, Class<?>> tMappingMapperClass = new HashMap<>(64);

    public CrudTemplate(String createMethodName, String updateByIdMethodName, String byIdMethodName, String deleteByIdMethodName, SqlSession sqlSession) {
        this.createMethodName = createMethodName;
        this.updateByIdMethodName = updateByIdMethodName;
        this.byIdMethodName = byIdMethodName;
        this.deleteByIdMethodName = deleteByIdMethodName;
        this.sqlSession = sqlSession;
    }

    public <T extends IdInterface<?>> void put(Class<T> data, Class<?> mapper) {
        tMappingMapperClass.put(data, mapper);
    }

    public <T extends IdInterface<?>> Class<?> get(T data) {
        return tMappingMapperClass.get(data.getClass());
    }

    public Class<?> get(Class<?> clazz) {
        return tMappingMapperClass.get(clazz);
    }

    @Override
    public <ID extends Serializable, T extends IdInterface<ID>> ID create(T data) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> mapperClazz = get(data);
        Object mapperObj = Proxy.newProxyInstance(mapperClazz.getClassLoader(),
                new Class[]{mapperClazz},
                new MapperTarget(sqlSession.getMapper(mapperClazz))
        );

        for (Method method : mapperClazz.getMethods()) {
            if (method.getName().equals(createMethodName)) {
                Object invoke = method.invoke(mapperObj, data);
                if (invoke != null) {
                    return data.getId();
                }
            }
        }


        return null;
    }

    @Override
    public <ID extends Serializable, T extends IdInterface<ID>> int update(T data) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> mapperClazz = get(data);
        Object mapperObj = Proxy.newProxyInstance(mapperClazz.getClassLoader(),
                new Class[]{mapperClazz},
                new MapperTarget(sqlSession.getMapper(mapperClazz))
        );

        for (Method method : mapperClazz.getMethods()) {
            if (method.getName().equals(updateByIdMethodName)) {
                Object invoke = method.invoke(mapperObj, data);
                if (invoke != null) {
                    if (invoke instanceof Integer) {
                        return (int) invoke;
                    }
                }
            }
        }

        return -1;
    }

    @Override
    public <ID extends Serializable, T extends IdInterface<ID>, O> O byId(ID id, Class<O> target) throws ReflectiveOperationException {
        Class<?> mapperClazz = get(target);
        Object mapperObj = Proxy.newProxyInstance(mapperClazz.getClassLoader(),
                new Class[]{mapperClazz},
                new MapperTarget(sqlSession.getMapper(mapperClazz))
        );
        for (Method method : mapperClazz.getMethods()) {
            if (method.getName().equals(byIdMethodName)) {
                Object invoke = method.invoke(mapperObj, id);
                if (invoke != null) {
                    return (O) invoke;
                }
            }
        }


        return null;
    }

    @Override
    public <ID extends Serializable> int delete(ID id, Class<?> target) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Class<?> mapperClazz = get(target);
        Object mapperObj = Proxy.newProxyInstance(mapperClazz.getClassLoader(),
                new Class[]{mapperClazz},
                new MapperTarget(sqlSession.getMapper(mapperClazz))
        );

        for (Method method : mapperClazz.getMethods()) {
            if (method.getName().equals(deleteByIdMethodName)) {
                Object invoke = method.invoke(mapperObj, id);
                if (invoke != null) {
                    if (invoke instanceof Integer) {
                        return (int) invoke;
                    }
                }
            }
        }
        return -1;
    }

    /**
     * 用于承载Mapper代理类的
     */
    private class MapperTarget implements InvocationHandler {
        private final Object target;

        public MapperTarget(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return method.invoke(target, args);
        }
    }
}
