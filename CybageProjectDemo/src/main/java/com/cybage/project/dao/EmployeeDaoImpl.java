package com.cybage.project.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.cybage.project.model.Employee;
 
 
 
@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao<Integer, Employee> implements EmployeeDao {
 
    static final Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);
     
    public Employee findById(int id) {
    	Employee employee = getByKey(id);
        if(employee!=null){
            Hibernate.initialize(employee.getEmployeeProfiles());
        }
        return employee;
    } 

	@Override
	public void save(Employee employee) {
		 persist(employee);		
	}

	@Override
	public void deleteById(int id) {
	    Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("id", id));
        Employee employee = (Employee)crit.uniqueResult();
        delete(employee);
		
	}

	@Override
	public List<Employee> findAllEmployees() {
		 Criteria criteria = createEntityCriteria().addOrder(Order.asc("name"));
	        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
	        List<Employee> employees = (List<Employee>) criteria.list();
	        return employees;
	}
 
}