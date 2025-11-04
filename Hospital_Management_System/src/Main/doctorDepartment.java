package Main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class doctorDepartment {
    private static Scanner sc = new Scanner(System.in);

    public static void general() {
        int ch = 0, aid, pid, n;

        do {
            try {
                System.out.print("\n\n\tGENERAL DEPARTMENT");
                repository.viewAppointments("general");

                System.out.print("\n\n1. Consult Patient");
                System.out.print("\n2. Exit");
                System.out.print("\nEnter An Option: ");
                n = sc.nextInt();

                if (n == 2) return;

                System.out.print("\n\n\tEnter Appointment ID: ");
                aid = sc.nextInt();

                if (!repository.general.containsKey(aid)) {
                    System.out.print("\n\nINVALID APPOINTMENT ID!");
                    continue;
                }

                pid = repository.general.get(aid);
                repository.viewPatientById(pid);

                System.out.print("\n\tCONSULTATION STATUS");
                System.out.print("\n1. Revisit");
                System.out.print("\n2. Completed");
                System.out.print("\n3. Go Back");
                System.out.print("\n\nChoose An Option: ");
                ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        break;
                    case 2:
                        repository.general.remove(aid);
                        System.out.print("\nAppointment Completed");
                        ch = 3;
                        break;
                    case 3:
                        break;
                    default:
                        System.out.print("\n\nINVALID INPUT!");
                        break;
                }
            } catch (InputMismatchException ime) {
                System.out.println("\nInvalid Input. Please Enter Numeric Values.");
                sc.nextLine(); 
            } catch (Exception e) {
                System.out.println("\nAn Unexpected Error Occurred: " + e.getMessage());
            }
        } while (ch != 3);
    }

    public static void pediatrician() {
        int ch = 0, aid, pid, n = 0;

        do {
            try {
                System.out.print("\n\n\tPEDIATRICIAN DEPARTMENT");
                repository.viewAppointments("pediatrician");

                System.out.print("\n\n1. Consult Patient");
                System.out.print("\n2. Exit");
                System.out.print("\nEnter An Option: ");
                n = sc.nextInt();

                if (n == 2) return;

                System.out.print("\n\n\tEnter Appointment ID: ");
                aid = sc.nextInt();

                if (!repository.pediatrician.containsKey(aid)) {
                    System.out.print("\n\nINVALID APPOINTMENT ID!");
                    continue;
                }

                pid = repository.pediatrician.get(aid);
                repository.viewPatientById(pid);

                System.out.print("\n\tCONSULTATION STATUS");
                System.out.print("\n1. Revisit");
                System.out.print("\n2. Completed");
                System.out.print("\n3. Go Back");
                System.out.print("\n\nChoose An Option: ");
                ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        break;
                    case 2:
                        repository.pediatrician.remove(aid);
                        System.out.print("\nAppointment Completed");
                        ch = 3;
                        break;
                    case 3:
                        break;
                    default:
                        System.out.print("\n\nINVALID INPUT!");
                        break;
                }
            } catch (InputMismatchException ime) {
                System.out.println("\nInvalid Input. Please Enter Numeric Values.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("\nAn Unexpected Error Occurred: " + e.getMessage());
            }
        } while (ch != 3);
    }

    public static void surgeon() {
        int ch = 0, aid, pid, n = 0;

        do {
            try {
                System.out.print("\n\n\tSURGEON DEPARTMENT");
                repository.viewAppointments("surgeon");

                System.out.print("\n\n1. Consult Patient");
                System.out.print("\n2. Exit");
                System.out.print("\nEnter An Option: ");
                n = sc.nextInt();

                if (n == 2) return;

                System.out.print("\n\n\tEnter Appointment ID: ");
                aid = sc.nextInt();

                if (!repository.surgeon.containsKey(aid)) {
                    System.out.print("\n\nINVALID APPOINTMENT ID!");
                    continue;
                }

                pid = repository.surgeon.get(aid);
                repository.viewPatientById(pid);

                System.out.print("\n\tCONSULTATION STATUS");
                System.out.print("\n1. Revisit");
                System.out.print("\n2. Completed");
                System.out.print("\n3. Go Back");
                System.out.print("\n\nChoose An Option: ");
                ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        break;
                    case 2:
                        repository.surgeon.remove(aid);
                        System.out.print("\nAppointment Completed");
                        ch = 3;
                        break;
                    case 3:
                        break;
                    default:
                        System.out.print("\n\nINVALID INPUT!");
                        break;
                }
            } catch (InputMismatchException ime) {
                System.out.println("\nInvalid Input. Please Enter Numeric Values.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("\nAn Unexpected Error Occurred: " + e.getMessage());
            }
        } while (ch != 3);
    }
}
