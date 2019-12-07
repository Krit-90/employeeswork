package humanresources;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class StaffEmployee extends Employee implements BusinessTraveler {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int DEFAULT_BONUS = 0;
    private static final int DEFAULT_COUNT_BUSINESS_TRAVEL = 0;
    private int bonus;
    private BusinessTravel[] businessTravels;
    private List businessTravelerInfo;

    private int countBusinessTravel;

    protected StaffEmployee(String name, String surname) {
        super(name, surname);
        this.bonus = DEFAULT_BONUS;
        this.businessTravels = new BusinessTravel[DEFAULT_CAPACITY];
        this.countBusinessTravel = DEFAULT_COUNT_BUSINESS_TRAVEL;
        this.businessTravelerInfo = new List();
    }

    public StaffEmployee(String name, String surname, JobTitlesEnum jobTitle, int salary) {
        super(name, surname, jobTitle, salary);
        this.bonus = DEFAULT_BONUS;
        this.businessTravels = new BusinessTravel[DEFAULT_CAPACITY];
        this.countBusinessTravel = DEFAULT_COUNT_BUSINESS_TRAVEL;
        this.businessTravelerInfo = new List();
    }

    protected StaffEmployee(String name, String surname, JobTitlesEnum jobTitle, int salary, BusinessTravel[] businessTravels) {
        super(name, surname, jobTitle, salary);
        this.businessTravels = businessTravels;
        this.businessTravelerInfo = new List();
        this.countBusinessTravel = businessTravels.length;
        for (BusinessTravel bt : businessTravels) {
            addDescription(bt);
        }
    }

    public int getCountBusinessTravel() {
        return countBusinessTravel;
    }

    @Override
    public void addDescription(BusinessTravel businessTravel) {
        if (countBusinessTravel < businessTravels.length) {
            businessTravels[countBusinessTravel++] = businessTravel;
        } else {
            BusinessTravel[] temp = new BusinessTravel[businessTravels.length * 2];
            System.arraycopy(businessTravels, 0, temp, 0, countBusinessTravel);
            businessTravels = temp;
        }
        businessTravelerInfo.add(businessTravel);
    }

    @Override
    public BusinessTravel[] getBusinessTravels() {
        return businessTravels;
    }

    @Override
    int getBonus() {
        return bonus;
    }

    @Override
    void setBonus(int bonus) {

    }

    public boolean haveTravels() {
        return countBusinessTravel > 0;
    }

    @Override
    public int travelPeriod(LocalDate start, LocalDate end) {
        int countDaysTravel = 0;
        for (BusinessTravel businessTravel : getBusinessTravels()) {
            if (haveTravels()) {
                if (comparePeriods(start, end, businessTravel)) {
                    if (start.isBefore(businessTravel.getDayOfStart())
                            && end.isAfter(businessTravel.getDayOfEnd())) {
                        countDaysTravel += start.until(businessTravel.getDayOfEnd()).getDays();
                    } else if (start.isBefore(businessTravel.getDayOfStart())
                            && end.isBefore(businessTravel.getDayOfEnd())) {
                        countDaysTravel += businessTravel.getDayOfStart().until(end).getDays();
                    } else if (start.isAfter(businessTravel.getDayOfStart())
                            && end.isBefore(businessTravel.getDayOfEnd())) {
                        countDaysTravel += start.until(end).getDays();
                    } else if (start.isBefore(businessTravel.getDayOfStart())
                            && end.isAfter(businessTravel.getDayOfEnd())) {
                        countDaysTravel += businessTravel.getDayOfStart()
                                .until(businessTravel.getDayOfEnd()).getDays();
                    }

                }
                if (isPeriodsContact(start, end, businessTravel)) {
                    countDaysTravel++;
                }
            }
        }
        return 0;
    }

    private boolean comparePeriods(LocalDate start, LocalDate end, BusinessTravel businessTravel) {
        return start.isBefore(businessTravel.getDayOfEnd())
                && end.isAfter(businessTravel.getDayOfStart());
    }

    private boolean isPeriodsContact(LocalDate start, LocalDate end, BusinessTravel businessTravel) {
        return start.isEqual(businessTravel.getDayOfEnd())
                || end.isEqual(businessTravel.getDayOfStart());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StaffEmployee{");
        if (getName() != null) {
            sb.append("name='").append(getName()).append('\'');
        }
        if (getSurname() != null) {
            sb.append(", surname='").append(getSurname()).append('\'');
        }
        if (getJobTitle() != JobTitlesEnum.NONE) {
            sb.append(", jobTitle='").append(getJobTitle()).append('\'');
        }
        if (getSalary() != 0 || getBonus() != 0) {
            sb.append(", salary=").append(getSalary()).append('}');
        }
        if (getBonus() != 0) {
            sb.append("bonus =").append(bonus);
        }
        sb.append(", businessTravelerInfo=").append(businessTravelerInfo).append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StaffEmployee)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        StaffEmployee that = (StaffEmployee) o;
        return getBonus() == that.getBonus() && businessTravels.length == that.businessTravels.length;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getBonus());
    }
}
