package day3_day4.q5;

public class UserRegistration {
    public void registerUser(String username, String userCountry) throws InvalidCountryException {
        if (!"India".equalsIgnoreCase(userCountry)) {
            throw new InvalidCountryException("User Outside India cannot be registered");
        } else {
            System.out.println("User registration done successfully");
        }
    }

    public static void main(String[] args) {
        UserRegistration registration = new UserRegistration();
        try {
            registration.registerUser("John Doe", "USA");
        } catch (InvalidCountryException e) {
            System.out.println(e.getMessage());
        }

        try {
            registration.registerUser("Amit Kumar", "India");
        } catch (InvalidCountryException e) {
            System.out.println(e.getMessage());
        }
    }
}
