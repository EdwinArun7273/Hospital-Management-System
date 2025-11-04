package Main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class bed {
    static int ward = 20;
    static int general = 20;
    static int vip = 20;
    static int pward = 0, pgeneral = 0, pvip = 0;
    static int category;

    public static void alloc() {
        Scanner sc = new Scanner(System.in);
        Patient p = new Patient();

        System.out.print("\n\n\tBED ALLOCATION");
        System.out.print("\n\nSPACES AVAILABLE");
        System.out.print("\n\n1. Ward: " + (ward - pward) + " Bed Spaces");
        System.out.print("\n2. General Rooms: " + (general - pgeneral) + " Rooms");
        System.out.print("\n3. VIP Rooms: " + (vip - pvip) + " Rooms");
        System.out.print("\n\nSELECT A ROOM");
        System.out.print("\n\n1. Ward");
        System.out.print("\n2. General Rooms");
        System.out.print("\n3. VIP Rooms");
        System.out.print("\n4. Go Back");

        do {
            try {
                System.out.print("\n\nEnter Category: ");
                category = sc.nextInt();

                if (category == 4) break;

                System.out.print("Enter Patient ID: ");
                int pid = sc.nextInt();

                if (!repository.patientList.containsKey(pid)) {
                    System.out.println("No Patient Found With ID: " + pid);
                    continue;
                }

                switch (category) {
                    case 1:
                        if (pward < ward) {
                            pward += 1;
                            p.setCategory(pid, "Ward");
                            p.setIsAdmit(pid, true);
                            System.out.println("Bed In Ward Allocated Successfully");
                            category = 4;
                        } else {
                            System.out.println("Bed Not Available");
                        }
                        break;

                    case 2:
                        if (pgeneral < general) {
                            pgeneral += 1;
                            p.setCategory(pid, "General Room");
                            p.setIsAdmit(pid, true);
                            System.out.println("General Room Allocated Successfully");
                            category = 4;
                        } else {
                            System.out.println("General Room Not Available");
                        }
                        break;

                    case 3:
                        if (pvip < vip) {
                            pvip += 1;
                            p.setCategory(pid, "VIP Room");
                            p.setIsAdmit(pid, true);
                            System.out.println("VIP Room Allocated Successfully");
                            category = 4;
                        } else {
                            System.out.println("VIP Room Not Available");
                        }
                        break;

                    default:
                        System.out.println("Invalid Choice");
                        break;
                }
            } catch (InputMismatchException ime) {
                System.out.println("Invalid Input. Please Enter Numeric Values.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("An Unexpected Error Occurred: " + e.getMessage());
            }
        } while (category != 4);
    }

    public static void deAlloc(int paId) {
        try {
            if (!repository.patientList.containsKey(paId)) {
                System.out.println("No Patient Found With ID: " + paId);
                return;
            }

            Patient p2 = new Patient();
            String cat = p2.getCategory(paId);

            if (cat == null) {
                System.out.println("Patient Category Not Found.");
                return;
            }

            switch (cat) {
                case "Ward":
                    pward -= 1;
                    p2.setIsAdmit(paId, false);
                    break;

                case "General Room":
                    pgeneral -= 1;
                    p2.setIsAdmit(paId, false);
                    break;

                case "VIP Room":
                    pvip -= 1;
                    p2.setIsAdmit(paId, false);
                    break;

                default:
                    System.out.println("Unknown Category: " + cat);
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error During Deallocation: " + e.getMessage());
        }
    }
}
