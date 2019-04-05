package com.xiaoleilei.singletondcl;

/**
 * 饿汉模式
 */
public class SingletonHun {
    private static SingletonHun instance;
    private SingletonHun(){
        super();
    }

    public static SingletonHun getInstance() {
        return instance;
    }
}
