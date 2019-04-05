package com.xiaoleilei.singletondcl;

/**
 * Created by Administrator 2019/4/5 0005 23:02
 */
public class SingletonIns {

    private SingletonIns(){
        super();
    }

    private static class InstanceHolder{
        public static SingletonIns instance = new SingletonIns();
    }

    public SingletonIns getInstance() {
        return InstanceHolder.instance;
    }
}
