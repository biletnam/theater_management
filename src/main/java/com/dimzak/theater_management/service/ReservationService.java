package com.dimzak.theater_management.service;

import com.dimzak.theater_management.model.Projection;
import com.dimzak.theater_management.model.Reservation;
import com.dimzak.theater_management.model.Theater;

import java.util.List;

/**
 * @author Dimitris Zakas
 */
public interface ReservationService {

    List<Projection> displayProjections();

    List<Theater> getAllTheaters();

    List<Reservation> getAllReservations();

    boolean bookSeat(int reservation_id);

    boolean reserveTheaterForMovie(Reservation reservation);
}
