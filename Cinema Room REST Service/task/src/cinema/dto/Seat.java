package cinema.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

public class Seat implements DTOWrapper{

    private int row;
    private int column;

    private int price;

    private boolean available;

    public Seat(){

    }
    public Seat(int row, int column,  int price) {
        this.row = row;
        this.column = column;
        this.price = price;
    }

    public Seat(int row, int column,  int price, boolean available) {
        this(row, column, price);
        this.available = available;
    }

    @JsonIgnore
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return row == seat.row && column == seat.column && price == seat.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column, price);
    }

    @Override
    public String toString() {
        return "Seat{" +
                "row=" + row +
                ", column=" + column +
                ", price=" + price +
                '}';
    }
}
