package Transport;

import java.util.Objects;

public class Sponsor {
    private final String name;
    private final int amountOfSponsorship;

    public Sponsor(String name, int amountOfSponsorship) {
        this.name = name;
        this.amountOfSponsorship = amountOfSponsorship;
    }

    public String getName() {
        return name;
    }

    public int getAmountOfSponsorship() {
        return amountOfSponsorship;
    }
    public void sponsorARace(){
        System.out.printf("Спонсор %s проспонсировал заезд на %d%n", name, amountOfSponsorship);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sponsor sponsor = (Sponsor) o;
        return amountOfSponsorship == sponsor.amountOfSponsorship && Objects.equals(name, sponsor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amountOfSponsorship);
    }

    @Override
    public String toString() {
        return "Спонсор: " + name +
                ", сумма поддержки: " + amountOfSponsorship;
    }
}
