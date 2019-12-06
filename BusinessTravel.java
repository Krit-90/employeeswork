package humanresources;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public final class BusinessTravel {
    private final String city;
    private final int compensation;
    private final String description;
    private LocalDate dayOfStart;
    // how to right add LocalDate
    private LocalDate dayOfEnd;

    public BusinessTravel() {
        this.city = null;
        this.dayOfStart = LocalDate.now();
        this.dayOfEnd = dayOfStart.plusDays(1);
        this.compensation = 0;
        this.description = null;
    }

    public BusinessTravel(String city, int daysCount, int compensation, String description) {
        this.city = city;
        this.dayOfStart = LocalDate.now();
        this.dayOfEnd = dayOfStart.plusDays(daysCount);
        this.compensation = compensation;
        this.description = description;
    }

    public int getDaysCount() {
        int daysCount = dayOfStart.until(dayOfEnd).getDays();
        return daysCount;
    }

    public LocalDate getDayOfStart() {
        return dayOfStart;
    }

    public void setDayOfStart(LocalDate dayOfStart) {
        this.dayOfStart = dayOfStart;
    }

    public LocalDate getDayOfEnd() {
        return dayOfEnd;
    }

    public void setDayOfEnd(LocalDate dayOfEnd) {
        this.dayOfEnd = dayOfEnd;
    }

    public String toString() {
        StringBuilder buffer = new StringBuilder();
        if (city != null) {
            buffer.append("city ='").append(city).append('\'');
        }
        if (getDaysCount() != 0) {
            buffer.append(", daysCount ='").append(getDaysCount()).append('\'');
        }
        if (compensation != 0) {
            buffer.append("<(").append(compensation).append(")>").append('\'');
        }
        if (description != null) {
            buffer.append(", description =").append(description).append('}');
        }
        return buffer.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BusinessTravel)) {
            return false;
        }
        BusinessTravel that = (BusinessTravel) o;
        return getDaysCount() == that.getDaysCount() &&
                compensation == that.compensation &&
                Objects.equals(city, that.city) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, getDaysCount(), compensation, description);
    }
}
