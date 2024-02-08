package com.psa.flights_reservation_app_5.utilities;
// Java Program to Illustrate Creation Of
// Service Interface

// Interface
public interface EmailService {

    // Method
    // To send a simple email
    String sendSimpleMail(EmailDetails details);

    // Method
    // To send an email with attachment
    String sendMailWithAttachment(EmailDetails details);
}
