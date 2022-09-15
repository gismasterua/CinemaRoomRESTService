package cinema.dto;

import java.util.Objects;

public class Statistic implements DTOWrapper{

    private int current_income;
    private int number_of_available_seats;
    private int number_of_purchased_tickets;

    public Statistic(){}

    public Statistic(int current_income, int number_of_available_seats, int number_of_purchased_tickets) {
        this.current_income = current_income;
        this.number_of_available_seats = number_of_available_seats;
        this.number_of_purchased_tickets = number_of_purchased_tickets;
    }

    public int getCurrent_income() {
        return current_income;
    }

    public void setCurrent_income(int current_income) {
        this.current_income = current_income;
    }

    public void addCurrent_income(int income){
        this.current_income += income;
    }

    public int getNumber_of_available_seats() {
        return number_of_available_seats;
    }

    public void setNumber_of_available_seats(int number_of_available_seats) {
        this.number_of_available_seats = number_of_available_seats;
    }

    public void incrementAvailableSeat(){
        this.number_of_available_seats++;
    }

    public int getNumber_of_purchased_tickets() {
        return number_of_purchased_tickets;
    }

    public void setNumber_of_purchased_tickets(int number_of_purchased_tickets) {
        this.number_of_purchased_tickets = number_of_purchased_tickets;
    }

    public void incrementPurchasedTickets(){
        this.number_of_purchased_tickets++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statistic statistic = (Statistic) o;
        return current_income == statistic.current_income && number_of_available_seats == statistic.number_of_available_seats && number_of_purchased_tickets == statistic.number_of_purchased_tickets;
    }

    @Override
    public int hashCode() {
        return Objects.hash(current_income, number_of_available_seats, number_of_purchased_tickets);
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "current_income=" + current_income +
                ", number_of_available_seats=" + number_of_available_seats +
                ", number_of_purchased_tickets=" + number_of_purchased_tickets +
                '}';
    }
}
