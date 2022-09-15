package cinema;


import cinema.dto.Cinema;
import cinema.dto.Purchase;
import cinema.dto.Seat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedList;
import java.util.List;

@Configuration
public class Config {

    @Bean
    public Cinema allSeats(){
        Cinema cn = new Cinema();
        cn.setTotal_columns(9);
        cn.setTotal_rows(9);

        for (int i = 1; i < 10; i++){
            for (int j = 1; j < 10; j++){
                cn.addSeat(new Seat(i, j, i <= 4 ? 10: 8, true));
            }
        }
        return cn;
    }

    @Bean
    public List<Purchase> allPurchases(){
        return new LinkedList<>();
    }
}
