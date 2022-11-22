package com.mvatanasov.danodastane.dao;

import com.mvatanasov.danodastane.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Repository
public class RoleRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Boolean deleteRoles(){
        try {
            Query q = entityManager.createNativeQuery("DELETE FROM Roles");
             q.executeUpdate();
             return true;
        } catch (Exception e) {
            System.out.println("An error occurred in RoleRepo while deleting roles");
            return false;
        }
    }

    @Transactional
    public Integer save(Role r) {
        Integer temp = 0;
        try {
            Query q = entityManager.createNativeQuery("INSERT INTO Roles(RoleName) VALUES(?)").setParameter(1, r.getRoleName());
            temp = q.executeUpdate();
            return temp;
        } catch (Exception e) {
            System.out.println("Violation of UNIQUE KEY constraint \'UK_Roles\'.");
            return temp;
        }

    }



}
