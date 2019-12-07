package humanresources;

import java.time.LocalDate;

public interface BusinessTraveler {
    void addDescription(BusinessTravel businessTravel);

    BusinessTravel[] getBusinessTravels();

    boolean haveTravels();

    int travelPeriod(LocalDate start, LocalDate end);

}
