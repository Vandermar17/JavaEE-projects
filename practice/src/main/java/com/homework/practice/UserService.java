package com.homework.practice;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final EntityManager entityManager;

    @Transactional
    public UserEntity createUser(String firstName, String lastName, String email) {
        UserEntity user = new UserEntity();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        return entityManager.merge(user);
    }


    public UserEntity findByEmail(String email){
        return entityManager.createNamedQuery(UserEntity.FIND_BY_EMAIL,UserEntity.class)
                .setParameter("email",email).getSingleResult();
    }

    public List<UserEntity> findAll(){
        return entityManager.createNamedQuery(UserEntity.FIND_ALL,UserEntity.class).getResultList();
    }

    public List<UserEntity> findByLastName(String lastName){
        return entityManager.createNamedQuery(UserEntity.FIND_BY_LASTNAME,UserEntity.class)
                .setParameter("lastName",lastName).
                        getResultList();
    }

    public List<UserEntity> findByWord(String word){
        return entityManager.createNamedQuery(UserEntity.FIND_BY_WORD,UserEntity.class)
                .setParameter("word",word)
                .getResultList();
    }

}
