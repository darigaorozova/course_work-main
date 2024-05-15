public class Admin {
    private TourPackageManager manager;
    private static final String ADMIN_PASSWORD = "admin123";

    public Admin(TourPackageManager manager) {
        this.manager = manager;
    }

    public boolean authenticateAdmin(String password) {
        return password.equals(ADMIN_PASSWORD);
    }

    public void addTourPackage(String type, String transport, String meals, int days) {
        manager.addPackage(new TourPackage(type, transport, meals, days));
    }
}
