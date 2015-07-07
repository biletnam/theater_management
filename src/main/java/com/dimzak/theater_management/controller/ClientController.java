package com.dimzak.theater_management.controller;

import com.dimzak.theater_management.model.Projection;
import com.dimzak.theater_management.service.ReservationService;
import com.dimzak.theater_management.util.DataAccess;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Dimitris Zakas
 */
@RequestScoped
@Named
public class ClientController {


    @Inject
    private transient Logger logger;

    @Inject
    @DataAccess
    private ReservationService reservationService;

    private List<Projection> projections;

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    private int reservationId;

    @PostConstruct
    public void init() {
        projections = reservationService.displayProjections();
    }

    public Logger getLogger() {
        return logger;
    }

    public boolean bookSeats() {
        Boolean res = reservationService.bookSeat(reservationId);
        String message = res? "Seat Booked!":"Could not book seat";
        logger.info(message);
        return true;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public ReservationService getReservationService() {
        return reservationService;
    }

    public void setReservationService(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    public List<Projection> getProjections() {
        return projections;
    }

    public void setProjections(List<Projection> projections) {
        this.projections = projections;
    }
}
