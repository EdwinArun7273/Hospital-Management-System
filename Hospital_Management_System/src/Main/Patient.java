package Main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Patient extends repository {

    int pid;
    String pname;
    int age;
    String category;
    boolean isAdmit;
    Double bill;

    Patient() {}

    public Patient(String pname, int age) {
        this.pname = pname;
        this.age = age;
        category = "Not Available";
        isAdmit = false;
        bill = 0.0;
    }

    public static void viewPatientDetails() {
        try {
            System.out.printf("%-15s %-20s %-15s %-20s %-20s%n", "\nPatient ID", "Patient Name", "Patient Age", "Admit Status", "Room Details");
            for (int ind : patientList.keySet()) {
                Patient p1 = patientList.get(ind);
                String admitStatus = p1.isAdmit ? "Admitted" : "Not Admitted";
                System.out.printf("%-15s %-20s %-15s %-20s %-20s%n", ind, capitalizeWords(p1.pname), p1.age, admitStatus, capitalizeWords(p1.category));
            }
        } catch (Exception e) {
            System.out.println("\nError Displaying Patient Details: " + capitalizeWords(e.getMessage()));
        }
    }

    public static void addPatient() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("\n\n\tAdd New Patient");
            System.out.print("\n\nEnter Name Of Patient: ");
            String name = sc.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("\nInvalid Input. Patient Name Cannot Be Empty.");
                return;
            }

            System.out.print("\nEnter Age Of Patient: ");
            int age = sc.nextInt();

            if (age <= 0 || age > 120) {
                System.out.println("\nInvalid Input. Please Enter A Valid Age Between 1 And 120.");
                return;
            }

            Patient patient = new Patient(name, age);
            save(patient);
            System.out.println("\nPatient Added Successfully.");
        } catch (InputMismatchException ime) {
            System.out.println("\nInvalid Input. Please Enter Correct Data Types.");
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("\nError Adding Patient: " + capitalizeWords(e.getMessage()));
        }
    }

    private static String capitalizeWords(String input) {
        if (input == null || input.isEmpty()) return input;
        String[] words = input.trim().split("\\s+");
        StringBuilder capitalized = new StringBuilder();
        for (String word : words) {
            if (word.length() > 0) {
                capitalized.append(Character.toUpperCase(word.charAt(0)))
                           .append(word.substring(1).toLowerCase())
                           .append(" ");
            }
        }
        return capitalized.toString().trim();
    }
}
