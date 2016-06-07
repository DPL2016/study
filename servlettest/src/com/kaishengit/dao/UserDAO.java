package com.kaishengit.dao;

public class UserDAO {
    public  Long count(){
        return 11l;
    }
    public Object findOne(Integer id){
        if(id.equals(1)){
            return new Object();
        }else {
            return null;
        }
    }
}
