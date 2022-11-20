package com.mvatanasov.danodastane.dao;

import com.mvatanasov.danodastane.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class UserRepository  {
    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    public void insertWithEntityManager(User user) {
        this.entityManager.persist(user);
    }
    @Transactional
    public void insertUser(User user){
        if(user.getRole()==null){
            entityManager.createNativeQuery(
                    "INSERT INTO Users(Username, Password, FirstName, LastName, RoleID)" +
                            " VALUES (?,cast(? as varbinary(max)),?,?,?)"
            )
                    .setParameter(1,user.getUsername())
                    .setParameter(2,user.getPassword())
                    .setParameter(3,user.getFirstName())
                    .setParameter(4,user.getLastName())
                    .setParameter(5,1).executeUpdate();
            System.out.println(user.getUsername());
        }else{
            entityManager.createNativeQuery(
                            "INSERT INTO Users(Username, Password, FirstName, LastName, RoleID)" +
                                    " VALUES (?,cast(? as varbinary(max)),?,?,?)"
                    )
                    .setParameter(1,user.getUsername())
                    .setParameter(2,user.getPassword())
                    .setParameter(3,user.getFirstName())
                    .setParameter(4,user.getLastName())
                    .setParameter(5,user.getRole().getId()).executeUpdate();
            System.out.println(user.getFirstName());
        }
    }
}

