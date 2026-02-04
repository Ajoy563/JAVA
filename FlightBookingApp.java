import java.util.*;

public class FlightBookingApp {

    // Flight class
    static class Flight {
        private String flightNumber;
        private String origin;
        private String destination;
        private int totalSeats;
        private boolean[] seats; // true = booked

        public Flight(String flightNumber, String origin, String destination, int totalSeats) {
            this.flightNumber = flightNumber;
            this.origin = origin;
            this.destination = destination;
            this.totalSeats = totalSeats;
            this.seats = new boolean[totalSeats];
        }

        public String getFlightNumber() { return flightNumber; }
        public String getOrigin() { return origin; }
        public String getDestination() { return destination; }

        public boolean isSeatAvailable(int seatNo) {
            return seatNo >= 1 && seatNo <= totalSeats && !seats[seatNo - 1];
        }

        public boolean bookSeat(int seatNo) {
            if (isSeatAvailable(seatNo)) {
                seats[seatNo - 1] = true;
                return true;
            }
            return false;
        }

        public void displayAvailableSeats() {
            System.out.print("Available seats: ");
            for (int i = 0; i < seats.length; i++) {
                if (!seats[i]) System.out.print((i + 1) + " ");
            }
            System.out.println();
        }

        @Override
        public String toString() {
            return flightNumber + ": " + origin + " ➝ " + destination;
        }
    }

    // Passenger class
    static class Passenger {
        private String name;
        private int seatNo;
        private Flight flight;

        public Passenger(String name, int seatNo, Flight flight) {
            this.name = name;
            this.seatNo = seatNo;
            this.flight = flight;
        }

        @Override
        public String toString() {
            return "Passenger: " + name + "\nFlight: " + flight + "\nSeat No: " + seatNo;
        }
    }

    // BookingSystem class
    static class BookingSystem {
        private List<Flight> flights = new ArrayList<>();
        private List<Passenger> bookings = new ArrayList<>();

        public BookingSystem() {
            flights.add(new Flight("AI101", "Delhi", "Mumbai", 10));
            flights.add(new Flight("AI202", "Kolkata", "Bangalore", 10));
            flights.add(new Flight("AI303", "Chennai", "Goa", 8));
        }

        public void showFlights() {
            System.out.println("Available Flights:");
            for (int i = 0; i < flights.size(); i++) {
                System.out.println((i + 1) + ". " + flights.get(i));
            }
        }

        public Flight selectFlight(int index) {
            if (index >= 1 && index <= flights.size()) {
                return flights.get(index - 1);
            }
            return null;
        }

        public boolean makePayment(String name) {
            System.out.println("Processing payment for " + name + "...");
            try {
                Thread.sleep(1000); // simulate processing
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Payment successful!\n");
            return true;
        }

        public void bookFlight(String passengerName, int flightIndex, int seatNo) {
            Flight flight = selectFlight(flightIndex);
            if (flight == null) {
                System.out.println("Invalid flight selection.");
                return;
            }

            if (!flight.isSeatAvailable(seatNo)) {
                System.out.println("Seat not available.");
                return;
            }

            if (makePayment(passengerName)) {
                flight.bookSeat(seatNo);
                Passenger p = new Passenger(passengerName, seatNo, flight);
                bookings.add(p);
                System.out.println("Booking Confirmed!\n" + p + "\n");
            }
        }
    }

    // Main method
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookingSystem system = new BookingSystem();

        while (true) {
            System.out.println("\n--- Flight Booking System ---");
            System.out.println("1. View Flights");
            System.out.println("2. Book Flight");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    system.showFlights();
                    break;
                case 2:
                    system.showFlights();
                    System.out.print("Enter flight number (1/2/3): ");
                    int flightIndex = sc.nextInt();
                    sc.nextLine();

                    Flight selected = system.selectFlight(flightIndex);
                    if (selected == null) {
                        System.out.println("Invalid flight.");
                        break;
                    }

                    selected.displayAvailableSeats();
                    System.out.print("Enter seat number: ");
                    int seat = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter passenger name: ");
                    String name = sc.nextLine();

                    system.bookFlight(name, flightIndex, seat);
                    break;

                case 3:
                    System.out.println("Thank you for using Flight Booking System!");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}