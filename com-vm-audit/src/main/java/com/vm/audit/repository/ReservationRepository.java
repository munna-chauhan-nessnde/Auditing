package com.vm.audit.repository;

import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.vm.audit.domain.Reservation;

@Repository
@RestResource
public interface ReservationRepository/* extends JpaRepository<Reservation, Long> */{

}
