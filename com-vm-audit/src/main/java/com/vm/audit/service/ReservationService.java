package com.vm.audit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vm.audit.domain.Reservation;
import com.vm.audit.domain.ReservationDao;

@Service
public class ReservationService {

/*	@Autowired
	private ReservationRepository resRepository;*/

	  @Autowired
	  private ReservationDao reservationDao;
	
	public List<Reservation> getAllReservations() {
		//return resRepository.findAll();
		return reservationDao.getAll();
	}
	
	public Reservation findReservationById(Long resId) {
		//return resRepository.findOne(resId);
		return reservationDao.getById(resId);
	}

	public void addReservation(Reservation reservation) {
		//resRepository.saveAndFlush(reservation);
		reservationDao.save(reservation);
	}

	public void deleteReservation(Reservation reservation) {
		//resRepository.delete(id);
		reservationDao.delete(reservation);
	}

	public void updateReservation(Reservation reservation) {
		reservationDao.update(reservation);
		//resRepository.save(reservation);
	}

}
