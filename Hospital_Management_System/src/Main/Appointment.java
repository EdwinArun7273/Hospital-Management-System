package Main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Appointment {

    static int generalCount = 0;
    static int surgeonCount = 0;
    static int pediatricianCount = 0;
    static Scanner s = new Scanner(System.in);

    public static void addtoList() {
        try {
            System.out.print("\n\nEnter Patient ID: ");
            int id = s.nextInt();

            if (!repository.patientList.containsKey(id)) {
                System.out.println("No Patient Found With ID: " + id + ". Appointment Cannot Be Created.");
                return;
            }

            repository.viewPatientById(id);

            System.out.print("\n\nAVAILABLE DEPARTMENTS FOR CONSULTATION");
            System.out.print("\n\n1.General\n2.Surgeon\n3.Pediatrician\n4.Go Back");
            System.out.print("\n\nChoose A Consulting Department: ");
            int ch = s.nextInt();

            int token = 0;
            switch (ch) {
                case 1:
                    if (repository.general.size() >= 20) {
                        System.out.println("General Department Appointments Are Full For Today.");
                        break;
                    }
                    token = ++generalCount;
                    repository.general.put(token, id);
                    System.out.println("General Appointment Token: " + token);
                    repository.patientBillUpdate(id, 350.00);
                    break;

                case 2:
                    if (repository.surgeon.size() >= 20) {
                        System.out.println("Surgeon Department Appointments Are Full For Today.");
                        break;
                    }
                    token = ++surgeonCount;
                    repository.surgeon.put(token, id);
                    System.out.println("Surgeon Appointment Token: " + token);
                    repository.patientBillUpdate(id, 400.00);
                    break;

                case 3:
                    if (repository.pediatrician.size() >= 20) {
                        System.out.println("Pediatrician Department Appointments Are Full For Today.");
                        break;
                    }
                    token = ++pediatricianCount;
                    repository.pediatrician.put(token, id);
                    System.out.println("Pediatrician Appointment Token: " + token);
                    repository.patientBillUpdate(id, 250.00);
                    break;

                case 4:
                    break;

                default:
                    System.out.println("INVALID OPTION");
                    break;
            }
        } catch (InputMismatchException ime) {
            System.out.println("\nInvalid Input. Please Enter Numeric Values Only.");
            s.nextLine();
        } catch (Exception e) {
            System.out.println("\nAn Unexpected Error Occurred: " + e.getMessage());
        }
    }
}
