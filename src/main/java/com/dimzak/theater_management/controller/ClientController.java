package com.dimzak.theater_management.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.logging.Logger;

/**
 * @author Dimitris Zakas
 */
@RequestScoped
@Named
public class ClientController {


    @Inject
    private transient Logger logger;



}
