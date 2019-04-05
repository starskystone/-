package com.xiaoleilei;

public class Singleton {
    private Singleton instance;
    private Singleton(){
        super();
    }

    public Singleton getInstance() {
        if(instance == null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
