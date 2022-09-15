package cinema;

import cinema.dto.*;
import cinema.dto.Error;
import cinema.exceptions.TickedAlreadyPurchased;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
public class Controller {

    @Autowired
    Cinema allSeats;

    @Autowired
    List<Purchase> allPurchases;

    @GetMapping("/seats")
    public ResponseEntity<Cinema> getSeats(){
        return new ResponseEntity<>(allSeats, HttpStatus.OK);
    }

    @PostMapping("/return")
    public ResponseEntity<DTOWrapper> postReturn(@RequestBody Purchase returnPurchase){
        boolean foundState = false;
        ReturnTicket foundTicket = null;
        Purchase delRefenrce = null;

        for (Purchase purc: allPurchases) {
            if (returnPurchase.getToken().equals(purc.getToken())){

                for (Seat s: allSeats.getAvailable_seats()) {
                    if (s.getRow() == purc.getTicket().getRow() && s.getColumn() == purc.getTicket().getColumn()) {
                        s.setAvailable(true);
                    }
                }
                foundState = true;
                foundTicket = new ReturnTicket(purc.getTicket());
                delRefenrce = purc;
            }
        }

        if (foundState){
            allPurchases.remove(delRefenrce);
            return new ResponseEntity<>(foundTicket, HttpStatus.OK);
        }
        else {
            Error error = new Error("Wrong token!");
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/purchase")
    public ResponseEntity<DTOWrapper> postPurchase(@RequestBody Seat purchase){

        for (Seat s: allSeats.getAvailable_seats()) {
            if (s.getRow() == purchase.getRow() && s.getColumn() == purchase.getColumn()){
                if (s.isAvailable()){
                    s.setAvailable(false);
                    UUID uuid = UUID.randomUUID();
                    Purchase purchaseTransaction = new Purchase(uuid, s);
                    allPurchases.add(purchaseTransaction);
                    return new ResponseEntity<>(purchaseTransaction, HttpStatus.OK);
                }
                else {
                    Error error = new Error("The ticket has been already purchased!");
                    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
                }

            }
        }
        Error error = new Error("The number of a row or a column is out of bounds!");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/stats")
    public ResponseEntity<DTOWrapper> getStatistic(@RequestParam(required=false) String password){

        if (password == null){
            Error error = new Error("The password is wrong!");
            return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
        }
        if (password.equals("super_secret")){
            Statistic statistic = new Statistic();

            for (Seat s: allSeats.getAvailable_seats()) {
                if (s.isAvailable()){
                    statistic.incrementAvailableSeat();
                }
                else {
                    statistic.incrementPurchasedTickets();
                    statistic.addCurrent_income(s.getPrice());
                }
            }

            return new ResponseEntity<>(statistic, HttpStatus.OK);
        }

        Error error = new Error("The password is wrong!");
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);

    }
}
