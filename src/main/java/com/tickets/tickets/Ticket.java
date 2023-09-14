package com.tickets.tickets;
import java.util.Objects;

public class Ticket {
    private String ticketText;
    private double ticketPrice;

    public Ticket(String ticketText, double ticketPrice) {
        this.ticketText = ticketText;
        this.ticketPrice = ticketPrice;
    }

    public String getTicketText() {
        return ticketText;
    }

    public void setTicketText(String ticketText) {
        this.ticketText = ticketText;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Double.compare(ticket.ticketPrice, ticketPrice) == 0 &&
                Objects.equals(ticketText, ticket.ticketText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketText, ticketPrice);
    }
}
