package cinema.dto;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cinema {
    private int total_rows;
    private int total_columns;

    private List<Seat> available_seats;

    public Cinema() {
         this.available_seats = new ArrayList<>();
    }

    public void addSeat(Seat seat){
        this.available_seats.add(seat);
    }

    public int getTotal_rows() {
        return total_rows;
    }

    public void setTotal_rows(int total_rows) {
        this.total_rows = total_rows;
    }

    public int getTotal_columns() {
        return total_columns;
    }

    public void setTotal_columns(int total_columns) {
        this.total_columns = total_columns;
    }

    public List<Seat> getAvailable_seats() {
        return available_seats;
    }

    public void setAvailable_seats(List<Seat> available_seats) {
        this.available_seats = available_seats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cinema cinema = (Cinema) o;
        return total_rows == cinema.total_rows && total_columns == cinema.total_columns && Objects.equals(available_seats, cinema.available_seats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(total_rows, total_columns, available_seats);
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "total_rows=" + total_rows +
                ", total_columns=" + total_columns +
                ", available_seats=" + available_seats +
                '}';
    }
}
