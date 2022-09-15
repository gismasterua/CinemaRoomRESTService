package cinema.dto;

import java.util.Objects;

public class ReturnTicket implements DTOWrapper{

    private Seat returned_ticket;

    public ReturnTicket() {
    }

    public ReturnTicket(Seat returned_ticket) {
        this.returned_ticket = returned_ticket;
    }

    public Seat getReturned_ticket() {
        return returned_ticket;
    }

    public void setReturned_ticket(Seat returned_ticket) {
        this.returned_ticket = returned_ticket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReturnTicket that = (ReturnTicket) o;
        return Objects.equals(returned_ticket, that.returned_ticket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(returned_ticket);
    }

    @Override
    public String toString() {
        return "ReturnTicket{" +
                "returned_ticket=" + returned_ticket +
                '}';
    }
}

