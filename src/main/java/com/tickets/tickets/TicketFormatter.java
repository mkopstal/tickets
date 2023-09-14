package com.tickets.tickets;

public class TicketFormatter {
    public static String formatAdultTicketString(double price,double basePrice, double taxPercentage) {
        return String.format("Adult (%.0f EUR + %.0f%%) = %.2f EUR",
                basePrice, taxPercentage, price);
    }

    public static String formatChildTicketString(double price,double basePrice, double taxPercentage) {
        return String.format("Child (%.0f EUR  x %.0f%% + %.0f%%) = %.2f EUR",
                basePrice, TicketConstants.CHILD_DISCOUNT_PERCENTAGE, taxPercentage, price);
    }

    public static String formatLuggagePriceString(int bagCount, double price,double basePrice, double taxPercentage) {
        return TicketCountFormatter.formatBagCount(bagCount) + String.format("%.0f EUR  x %.0f%% + %.0f%%) = %.2f EUR",
                basePrice, TicketConstants.LUGGAGE_DISCOUNT_PERCENTAGE, taxPercentage, price);
    }
}
