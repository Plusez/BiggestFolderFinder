import com.skillbox.airport.Airport;
import java.util.Date;

import static com.skillbox.airport.Flight.Type.DEPARTURE;

public class Main {

    public static void main(String[] args) {

        Date departureTime = new Date();
        Date beforeTwoHoursTime = new Date(departureTime.getTime() - 7200000);

        System.out.println("departureTime - " + departureTime);
        System.out.println("beforeTwoHoursTime - " + beforeTwoHoursTime);

        for (int i = 0; i < Airport.getInstance().getTerminals().size(); i++) {
            System.out.println("Terminal - " + i);

            Airport.getInstance().getTerminals().stream()
                    .flatMap(t -> t.getFlights().stream())
                    .filter(f -> f.getType().equals(DEPARTURE))
                    .filter(f -> f.getDate().before(departureTime))
                    .filter(f -> f.getDate().after(beforeTwoHoursTime))
                    .forEach(f -> System.out.println(f.getDate() + " + " +  f.getAircraft()));

        }
    }
}
