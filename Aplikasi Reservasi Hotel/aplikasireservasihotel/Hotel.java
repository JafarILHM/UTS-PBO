package aplikasireservasihotel;

class Hotel {
    private Room[] rooms;
    private Customer[] customers;
    private int roomCount;
    private int customerCount;
    private static final int MAX_ROOMS = 10; 
    private static final int MAX_CUSTOMERS = 10;

    public Hotel() {
        rooms = new Room[MAX_ROOMS];
        customers = new Customer[MAX_CUSTOMERS];
        roomCount = 0;
        customerCount = 0;
        initializeRooms();
        initializeCustomers();
    }

    private void initializeRooms() {
        addRoom(new Room(101, "Suite", 150.0, true));
        addRoom(new Room(102, "Deluxe", 100.0, true));
        addRoom(new Room(103, "Suite", 150.0, true));
        addRoom(new Room(104, "Deluxe", 100.0, true));
        addRoom(new Room(105, "Suite", 150.0, true));
        addRoom(new Room(106, "Deluxe", 100.0, true));
        addRoom(new Room(107, "Suite", 150.0, true));
        addRoom(new Room(108, "Deluxe", 100.0, true));
        addRoom(new Room(109, "Suite", 150.0, true));
        addRoom(new Room(110, "Deluxe", 100.0, true));
    }

    private void initializeCustomers() {
        Customer c1 = new Customer("Jafar", "12345");
        c1.setBookedRoom(findRoomByNumber(101), 3, "10/10/2024");
        findRoomByNumber(101).setAvailable(false);
        addCustomer(c1);

        Customer c2 = new Customer("Raffi", "67890");
        c2.setBookedRoom(findRoomByNumber(102), 2, "09/10/2024");
        findRoomByNumber(102).setAvailable(false);
        addCustomer(c2);

        Customer c3 = new Customer("Akbar", "54321");
        c3.setBookedRoom(findRoomByNumber(103), 1, "08/10/2024");
        findRoomByNumber(103).setAvailable(false);
        addCustomer(c3);

        Customer c4 = new Customer("Naufal", "09876");
        c4.setBookedRoom(findRoomByNumber(104), 4, "07/10/2024");
        findRoomByNumber(104).setAvailable(false);
        addCustomer(c4);
    }

    public void addCustomer(Customer customer) {
        if (customerCount < MAX_CUSTOMERS) {
            customers[customerCount++] = customer;
        } else {
            System.out.println("Cannot add more customers. Maximum limit reached.");
        }
    }

    public void removeCustomer(Customer customer) {
        for (int i = 0; i < customerCount; i++) {
            if (customers[i] == customer) {
                for (int j = i; j < customerCount - 1; j++) {
                    customers[j] = customers[j + 1];
                }
                customers[--customerCount] = null;
                return;
            }
        }
    }

    public Customer findCustomerByName(String name) {
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getName().equalsIgnoreCase(name)) {
                return customers[i];
            }
        }
        return null;
    }

    public Customer findCustomerById(int customerId) {
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getCustomerId() == customerId) {
                return customers[i];
            }
        }
        return null;
    }

    public Room[] getAvailableRooms() {
        int availableCount = 0;
        for (int i = 0; i < roomCount; i++) {
            if (rooms[i].isAvailable()) {
                availableCount++;
            }
        }
        Room[] availableRooms = new Room[availableCount];
        int index = 0;
        for (int i = 0; i < roomCount; i++) {
            if (rooms[i].isAvailable()) {
                availableRooms[index++] = rooms[i];
            }
        }
        return availableRooms;
    }

    public Room findRoomByNumber(int roomNumber) {
        for (int i = 0; i < roomCount; i++) {
            if (rooms[i].getRoomNumber() == roomNumber) {
                return rooms[i];
            }
        }
        return null;
    }

    public Room[] getAllRooms() {
        Room[] allRooms = new Room[roomCount];
        System.arraycopy(rooms, 0, allRooms, 0, roomCount);
        return allRooms;
    }

    public void addRoom(Room room) {
        if (roomCount < MAX_ROOMS) {
            rooms[roomCount++] = room;
        } else {
            System.out.println("Cannot add more rooms. Maximum limit reached.");
        }
    }

    public void removeRoom(Room room) {
        for (int i = 0; i < roomCount; i++) {
            if (rooms[i] == room) {
                for (int j = i; j < roomCount - 1; j++) {
                    rooms[j] = rooms[j + 1];
                }
                rooms[--roomCount] = null;
                return;
            }
        }
    }

    public Customer[] getAllCustomers() {
        Customer[] allCustomers = new Customer[customerCount];
        System.arraycopy(customers, 0, allCustomers, 0, customerCount);
        return allCustomers;
    }
}
