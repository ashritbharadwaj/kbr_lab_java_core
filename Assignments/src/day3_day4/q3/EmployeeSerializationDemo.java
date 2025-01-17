package day3_day4.q3;

import java.io.*;

public class EmployeeSerializationDemo {
    public static void main(String[] args) {
        Address address = new Address("123 Main St", "Bengaluru", "Karnataka", "560001");
        Employee employee = new Employee(1, "John Doe", address, 50000.0);

        // Serialize the Employee object
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employee.ser"))) {
            oos.writeObject(employee);
            System.out.println("Employee object serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize the Employee object
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employee.ser"))) {
            Employee deserializedEmployee = (Employee) ois.readObject();
            System.out.println("Employee object deserialized successfully.");
            deserializedEmployee.display();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
