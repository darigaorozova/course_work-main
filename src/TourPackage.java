public class TourPackage {
    private String type;
    private String transport;
    private String meals;
    private int days;

    public TourPackage(String type, String transport, String meals, int days) {
        this.type = type;
        this.transport = transport;
        this.meals = meals;
        this.days = days;
    }

    public String getType() {
        return type;
    }

    public String getTransport() {
        return transport;
    }

    public String getMeals() {
        return meals;
    }

    public int getDays() {
        return days;
    }

    @Override
    public String toString() {
        return "Type: " + type + ", Transport: " + transport + ", Meals: " + meals + ", Days: " + days;
    }
}
