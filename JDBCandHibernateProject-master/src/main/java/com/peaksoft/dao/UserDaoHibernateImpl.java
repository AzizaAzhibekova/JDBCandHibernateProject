package com.peaksoft.dao;



import com.peaksoft.model.User;
<<<<<<< HEAD

import java.util.List;

=======
import com.peaksoft.util.Util;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.util.List;



>>>>>>> 9aba5b7 (Initial commit)
public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        String sql= "CREATE TABLE IF NOT EXISTS users " +
                "(id BIGSERIAL PRIMARY KEY, " +
                "name VARCHAR(255)," +
                 "last_name VARCHAR(255), " +
                "age INT2);";
        Session session= Util.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.createSQLQuery(sql).executeUpdate();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }finally {
            session.close();
        }

    }





    @Override
    public void dropUsersTable() {
        Session session = Util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        String sql = "DROP TABLE IF EXISTS users";

        Query query = session.createSQLQuery(sql).addEntity(User.class);

        transaction.commit();
        session.close();

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User();
        Session session = Util.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            user.setName(name);
            user.setLastName(lastName);
            user.setAge(age);
            session.save(user);
            session.getTransaction().commit();
        } catch (HibernateException h) {
            h.printStackTrace();
        } finally {
            session.close();
        }
    }








    @Override
    public void removeUserById(long id) {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        User e = (User) session.get(User.class, id);
        session.delete(e);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted " + e);
    }




    @Override
    public List<User> getAllUsers() {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
       List<User> users = session.createQuery("FROM User").list();
       session.getTransaction().commit();
        session.close();
        return users;
    }
    @Override
    public void cleanUsersTable() {
       Session session =Util.getSessionFactory().openSession();
        session.beginTransaction();
        session.createSQLQuery("TRUNCATE TABLE users").executeUpdate();
        session.getTransaction().commit();

    }
}
