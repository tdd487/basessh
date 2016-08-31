package com.tdd;

import com.tdd.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by Administrator on 2016/8/31.
 */
public class test {
    //读取
    public static void load(){
        User user = session.load(User.class,new Integer(1));
        System.out.println(user.getName());
    }

    //插入数据库
    public static void insert(){
        User user = new User();
        user.setName("张三");

        session.save(user);
    }

    static SessionFactory sessionFactory;
    static Session session;
    static Transaction tx;
    private static void init(){
        sessionFactory = new Configuration().configure().buildSessionFactory();
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
    }

    private static void close(){
        tx.commit();
        session.close();
        sessionFactory.close();
    }

    public static void main(String args[]){
        init();
        load();
        close();
    }
}
