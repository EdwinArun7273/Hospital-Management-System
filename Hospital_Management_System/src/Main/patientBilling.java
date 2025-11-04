package Main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class patientBilling {
    static double wardP = 1000;
    static double generalP = 5000;
    static double vipP = 10000;
    static Scanner sc = new Scanner(System.in);

    public static void getBill() {
        try {
            System.out.print("\n\n\tBilling Department");
            System.out.print("\nEnter Patient ID: ");
            int pid = sc.nextInt();

            if (!repository.patientList.containsKey(pid)) {
                System.out.println("\nInvalid Patient ID. No Record Found.");
                return;
            }

            Patient pa = repository.patientList.get(pid);
            Patient p3 = new Patient();
            String categ = p3.getCategory(pid);
            int days = 0;
            double rfee = 0;
            double ratePerDay = 0;
            double consultFee = pa.bill;

            if (!categ.equals("Not Available")) {
                switch (categ) {
                    case "Ward":
                        System.out.print("\n\nPatient Was Admitted In Ward");
                        System.out.print("\nNumber Of Days Admitted: ");
                        days = sc.nextInt();
                        if (days <= 0) {
                            System.out.println("\nInvalid Number Of Days.");
                            return;
                        }
                        ratePerDay = wardP;
                        rfee = days * ratePerDay;
                        bed.deAlloc(pid);
                        break;

                    case "General Room":
                        System.out.print("\n\nPatient Was Admitted In General Room");
                        System.out.print("\nNumber Of Days Admitted: ");
                        days = sc.nextInt();
                        if (days <= 0) {
                            System.out.println("\nInvalid Number Of Days.");
                            return;
                        }
                        ratePerDay = generalP;
                        rfee = days * ratePerDay;
                        bed.deAlloc(pid);
                        break;

                    case "VIP Room":
                        System.out.print("\n\nPatient Was Admitted In VIP Room");
                        System.out.print("\nNumber Of Days Admitted: ");
                        days = sc.nextInt();
                        if (days <= 0) {
                            System.out.println("\nInvalid Number Of Days.");
                            return;
                        }
                        ratePerDay = vipP;
                        rfee = days * ratePerDay;
                        bed.deAlloc(pid);
                        break;

                    default:
                        System.out.println("\nUnknown Category. Billing Cannot Be Processed.");
                        return;
                }

                pa.bill += rfee;
            }

            // Display bill in table format
            System.out.println("\n\n\tFinal Bill Summary");
            System.out.println("------------------------------------------------------------");
            System.out.printf("%-25s : %s%n", "Patient ID", pid);
            System.out.printf("%-25s : %s%n", "Patient Name", capitalizeWords(pa.pname));
            System.out.printf("%-25s : %s%n", "Room Category", capitalizeWords(categ));
            System.out.printf("%-25s : ₹%.2f%n", "Consultation Charges", consultFee);

            if (!categ.equals("Not Available")) {
                System.out.printf("%-25s : %d%n", "Days Admitted", days);
                System.out.printf("%-25s : ₹%.2f%n", "Rate Per Day", ratePerDay);
                System.out.printf("%-25s : ₹%.2f%n", "Room Charges", rfee);
            }

            System.out.printf("%-25s : ₹%.2f%n", "Total Bill Amount", pa.bill);
            System.out.println("------------------------------------------------------------");

            pa.bill = 0.0;

        } catch (InputMismatchException ime) {
            System.out.println("\nInvalid Input. Please Enter Numeric Values.");
            sc.nextLine(); // Clear buffer
        } catch (Exception e) {
            System.out.println("\nError Processing Bill: " + e.getMessage());
        }
    }

    // Helper method to capitalize each word
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
