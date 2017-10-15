package com.vm.audit.domain;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ReservationDao {

	  @Autowired
	  private SessionFactory sessionFactory;
	  
	  private Session getSession() {
	    return sessionFactory.getCurrentSession();
	  }

	  public void save(Reservation user) {
	    getSession().save(user);
	    return;
	  }
	  
	  public void delete(Reservation user) {
	    getSession().delete(user);
	    return;
	  }
	  
	  @SuppressWarnings("unchecked")
	  public List<Reservation> getAll() {
	    return getSession().createQuery("from Reservation").list();
	  }
	  
	  public Reservation getByName(String resName) {
	    return (Reservation) getSession().createQuery(
	        "from Reservation where resName = :resName")
	        .setParameter("resName", resName)
	        .uniqueResult();
	  }

	  public Reservation getById(long id) {
	    return (Reservation) getSession().load(Reservation.class, id);
	  }

	  public void update(Reservation user) {
	    getSession().update(user);
	    return;
	  }
}
