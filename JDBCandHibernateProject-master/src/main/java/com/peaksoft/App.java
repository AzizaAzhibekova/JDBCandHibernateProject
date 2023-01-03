package com.peaksoft;


import com.peaksoft.dao.UserDao;
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
    }
}
