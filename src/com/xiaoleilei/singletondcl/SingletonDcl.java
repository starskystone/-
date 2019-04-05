package com.xiaoleilei.singletondcl;

/**
 * 懒汉式-双重检查
 */
public class SingletonDcl {
    private volatile static SingletonDcl instance;     //加volatile关键字解决不安全的情况
    private SingletonDcl(){
        super();
    }

    public static SingletonDcl getInstance() {
        if(instance == null){
            synchronized (SingletonDcl.class){
                if(instance == null){
                    instance = new SingletonDcl();
                }
            }
        }
        return instance;
    }
}
