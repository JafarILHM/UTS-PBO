package aplikasireservasihotel;

class Admin {
    private static final String ADMIN_PASSWORD = "admin123";

    public boolean authenticate(String name, String password) {
        return name.equalsIgnoreCase("admin") && password.equals(ADMIN_PASSWORD);
    }
}
