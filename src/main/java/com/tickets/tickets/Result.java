package com.tickets.tickets;
import java.util.List;
import java.util.Objects;
public class Result {
    private List<Ticket> tickets;
    private double total;

    public Result(List<Ticket> tickets, double total) {
        this.tickets = tickets;
        this.total = total;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return Double.compare(result.total, total) == 0 &&
                Objects.equals(tickets, result.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tickets, total);
    }
}
