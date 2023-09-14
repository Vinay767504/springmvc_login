package com.skss.web.springmvc_login.dao.imp1;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.skss.web.springmvc_login.model.UserModel;

@Repository
public class UserDaoImp1 {

	EntityManagerFactory emf=Persistence.createEntityManagerFactory("login");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	
	public UserModel getUser(int id) {
		
		return em.find(UserModel.class, id);
	}
	
	public String updateUser(UserModel userModel) {
		
		et.begin();
		em.merge(userModel);
		et.commit();
		return userModel.getName()+" is updated";
	}
	
	public String deleteUser(int id) {
		
		UserModel user=em.find(UserModel.class,id);
		et.begin();
		em.remove(user);
		et.commit();
		return "Deleted";
		
	}
	
	public String saveUser(UserModel userModel) {
		et.begin();
		em.persist(userModel);
		et.commit();	
		
		return userModel.getName()+"Saved Successfully";
	}
	
	public ArrayList<UserModel>getAllUsers(){
		
		Query q=em.createQuery("select u from UserModel u");
		return (ArrayList<UserModel>) q.getResultList();
		
	}
}
