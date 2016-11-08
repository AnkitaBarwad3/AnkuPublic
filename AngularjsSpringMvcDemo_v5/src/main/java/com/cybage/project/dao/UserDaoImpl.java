package com.cybage.project.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cybage.project.model.User;

/*
 * convenience annotation that adds the @Controller and @ResponseBody annotations
 * @see     org.springframework.web.bind.annotation.RestController
 */
@Repository
public class UserDaoImpl implements UserDao {

	/*
     * Marks a constructor, field, setter method or config method as to be autowired by Spring's dependency injection facilities.
     * @see      org.springframework.beans.factory.annotation.Autowired  
     */
	@Autowired
   SessionFactory sf;	
	
	@Override
	public void saveUser(User user) {
		sf.getCurrentSession().save(user);
		
	}

	@Override
	public List<User> findAllUser() {
		Criteria criteria = sf.getCurrentSession().createCriteria(User.class);
		criteria.addOrder(Order.asc("userName"));
		List<User>users =(List<User>)criteria.list();
	     
		
		return users;
		
	}

	@Override
	public User findBySSO(String name) {
	
	     Criteria criteria = sf.getCurrentSession().createCriteria(User.class);
	     criteria.add(Restrictions.eq("userName", name));
	        User user = (User)criteria.uniqueResult();
	        if(user!=null){
	            Hibernate.initialize(user.getAttachments());
	        }
	        return user;
	}

}
