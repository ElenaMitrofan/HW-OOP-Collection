package Transport;

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
    public String toString() {
        return "Спонсор: " + name +
                ", сумма поддержки: " + amountOfSponsorship;
    }
}
