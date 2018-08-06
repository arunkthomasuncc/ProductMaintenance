/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.data;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import project.business.UserPass;
import project.business.UserRole;

/**
 *
 * @author Arun
 */
public class UserDB {

    public static UserPass selectUser(String username, String password) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM UserPass u "
                + "WHERE u.username = :username and u.password = :password";
        TypedQuery<UserPass> q = em.createQuery(qString, UserPass.class);
        q.setParameter("username", username);
        q.setParameter("password", password);

        try {
            UserPass userpass = q.getSingleResult();
            return userpass;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public static boolean checkUserRole(int userId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM UserRole u "
                + "WHERE u.userPass.userId = :userId and (u.roleName = 'programmer' or u.roleName= 'customer service')";
        TypedQuery<UserRole> q = em.createQuery(qString, UserRole.class);
        //q.setParameter("userId", userId);
        q.setParameter("userId", userId);
        try {
            UserRole userRole = q.getSingleResult();
            if (userRole != null) {
                return true;
            } else {
                return false;
            }

        } catch (NoResultException e) {
            return false;
        } finally {
            em.close();
        }
    }
}
