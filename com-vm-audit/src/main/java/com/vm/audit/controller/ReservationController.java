package com.vm.audit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vm.audit.domain.Reservation;
import com.vm.audit.service.ReservationService;

@RestController
@RequestMapping(value = "/reservation")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	@GetMapping
	public List<Reservation> getAllReservation(){
		return reservationService.getAllReservations();
	}

	@GetMapping("/{resId}")
	public Reservation getCource(@PathVariable Long resId){
		return reservationService.findReservationById(resId);
	}

	@PostMapping
	public void addReservation(@RequestBody Reservation reservation){
		reservationService.addReservation(reservation);
	}
	@PutMapping
	public void updateReservation(@RequestBody Reservation reservation){
		reservationService.updateReservation(reservation);
	}

	@DeleteMapping
	public void deleteReservation(@PathVariable Reservation reservation){
		reservationService.deleteReservation(reservation);
	}
}
