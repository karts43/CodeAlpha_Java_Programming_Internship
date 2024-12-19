import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

class TravelItinerary {
    private String destination;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Activity> activities;
    private double budget;
    private Map<String, Double> expenses;
    private WeatherInfo weatherInfo;

    public TravelItinerary(String destination, LocalDate startDate, LocalDate endDate, double budget) {
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
        this.activities = new ArrayList<>();
        this.expenses = new HashMap<>();
        this.weatherInfo = new WeatherInfo();
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
        updateExpenses(activity.getCost());
    }

    private void updateExpenses(double cost) {
        double currentTotal = expenses.getOrDefault("activities", 0.0);
        expenses.put("activities", currentTotal + cost);
    }

    public double getRemainingBudget() {
        double totalExpenses = expenses.values().stream().mapToDouble(Double::doubleValue).sum();
        return budget - totalExpenses;
    }

    public String generateItineraryReport() {
        StringBuilder report = new StringBuilder();
        report.append("\n=== Travel Itinerary for ").append(destination).append(" ===\n");
        report.append("Duration: ").append(startDate).append(" to ").append(endDate).append("\n");
        report.append("Weather Forecast: ").append(weatherInfo.getForecast(destination)).append("\n\n");
        
        report.append("Activities:\n");
        activities.forEach(activity -> {
            report.append("- ").append(activity.getName())
                  .append(" (").append(activity.getDate()).append(")")
                  .append(" - $").append(String.format("%.2f", activity.getCost()))
                  .append("\n   Location: ").append(activity.getLocation())
                  .append("\n");
        });
        
        report.append("\nBudget Summary:\n");
        report.append("Total Budget: $").append(String.format("%.2f", budget)).append("\n");
        report.append("Remaining Budget: $").append(String.format("%.2f", getRemainingBudget())).append("\n");
        
        return report.toString();
    }
}

class Activity {
    private String name;
    private LocalDate date;
    private double cost;
    private String location;

    public Activity(String name, LocalDate date, double cost, String location) {
        this.name = name;
        this.date = date;
        this.cost = cost;
        this.location = location;
    }

    public String getName() { return name; }
    public LocalDate getDate() { return date; }
    public double getCost() { return cost; }
    public String getLocation() { return location; }
}

class WeatherInfo {
    public String getForecast(String location) {
        // Simulated weather API integration
        return "Sunny, 75°F";
    }
}

public class TravelPlannerDemo {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void main(String[] args) {
        System.out.println("Welcome to Travel Itinerary Planner!");
        TravelItinerary itinerary = createItinerary();
        
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    addActivity(itinerary);
                    break;
                case 2:
                    System.out.println(itinerary.generateItineraryReport());
                    break;
                case 3:
                    System.out.println("Remaining budget: $" + 
                        String.format("%.2f", itinerary.getRemainingBudget()));
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for using Travel Itinerary Planner!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static TravelItinerary createItinerary() {
        System.out.println("\n=== Create New Itinerary ===");
        System.out.print("Enter destination: ");
        String destination = scanner.nextLine();
        
        LocalDate startDate = getDateInput("Enter start date (YYYY-MM-DD): ");
        LocalDate endDate = getDateInput("Enter end date (YYYY-MM-DD): ");
        
        while (endDate.isBefore(startDate)) {
            System.out.println("End date must be after start date!");
            endDate = getDateInput("Enter end date (YYYY-MM-DD): ");
        }
        
        double budget = getDoubleInput("Enter total budget: $");
        
        return new TravelItinerary(destination, startDate, endDate, budget);
    }

    private static void addActivity(TravelItinerary itinerary) {
        System.out.println("\n=== Add New Activity ===");
        System.out.print("Enter activity name: ");
        String name = scanner.nextLine();
        
        LocalDate date = getDateInput("Enter activity date (YYYY-MM-DD): ");
        
        double cost = getDoubleInput("Enter activity cost: $");
        
        System.out.print("Enter activity location: ");
        String location = scanner.nextLine();
        
        Activity activity = new Activity(name, date, cost, location);
        itinerary.addActivity(activity);
        System.out.println("Activity added successfully!");
    }

    private static void displayMenu() {
        System.out.println("\n=== Menu ===");
        System.out.println("1. Add Activity");
        System.out.println("2. View Itinerary");
        System.out.println("3. Check Remaining Budget");
        System.out.println("4. Exit");
    }

    private static LocalDate getDateInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String dateStr = scanner.nextLine();
                return LocalDate.parse(dateStr, dateFormatter);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use YYYY-MM-DD format.");
            }
        }
    }

    private static double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Please enter a valid number.");
            }
        }
    }

    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}