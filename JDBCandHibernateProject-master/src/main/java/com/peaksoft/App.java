package com.peaksoft;


import com.peaksoft.dao.UserDao;
<<<<<<< HEAD
import com.peaksoft.dao.UserDaoJdbcImpl;
import com.peaksoft.service.UserService;
import com.peaksoft.service.UserServiceImpl;

public class App
{
    public static void main( String[] args )
    {
        UserService u=new UserServiceImpl();

        u.saveUser("Hanna","Herman", (byte) 24);
        u.saveUser("Saya","Beghard", (byte) 22);

        // реализуйте алгоритм здесь
=======
import com.peaksoft.dao.UserDaoHibernateImpl;
import com.peaksoft.dao.UserDaoJdbcImpl;
import com.peaksoft.model.User;
import com.peaksoft.service.UserService;
import com.peaksoft.service.UserServiceImpl;
import com.peaksoft.util.Util;
import org.hibernate.*;

public class App {
    public static void main( String[] args ) {
        UserDao u=new UserDaoHibernateImpl();
        u.createUsersTable();
        u.saveUser("Aylin","Aslanova", (byte) 21);



>>>>>>> 9aba5b7 (Initial commit)
    }
}
