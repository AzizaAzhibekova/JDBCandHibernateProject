package com.peaksoft;



import com.peaksoft.dao.UserDao;
import com.peaksoft.dao.UserDaoHibernateImpl;
import com.peaksoft.service.UserService;
import com.peaksoft.service.UserServiceImpl;

public class App {
    public static void main(String[] args) {
        UserDao u = new UserDaoHibernateImpl();
        u.createUsersTable();

        u.saveUser("Hanna", "Herman", (byte) 24);
        u.saveUser("Saya", "Beghard", (byte) 22);


    }
}
