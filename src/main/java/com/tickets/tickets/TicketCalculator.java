package com.tickets.tickets;

public class TicketCalculator {
    public static double calculateAdultTicket(double basePrice, double taxPercentage){
        double taxAmount = (taxPercentage / 100) * basePrice;
        return basePrice + taxAmount;
    }

    public static double calculateChildTicket(double basePrice, double taxPercentage){
        double discountAmount = (TicketConstants.CHILD_DISCOUNT_PERCENTAGE / 100) * basePrice;
        double totalBeforeTax = basePrice - discountAmount;
        double taxAmount = (taxPercentage / 100) * totalBeforeTax;
        return totalBeforeTax + taxAmount;
    }

    public static double calculateLuggagePrice(int quantity,double basePrice, double taxPercentage){
        double subtotal = quantity * basePrice;
        double totalBeforeTax = (TicketConstants.LUGGAGE_DISCOUNT_PERCENTAGE / 100) * subtotal;
        double taxAmount = (taxPercentage / 100) * totalBeforeTax;
        return totalBeforeTax + taxAmount;
    }
}
