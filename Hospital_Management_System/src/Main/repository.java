package Main;

import java.util.HashMap;

public class repository {
    int pid;
    String pname;
    int age;
    String category;
    boolean isAdmit;

    static HashMap<Integer, Patient> patientList = new HashMap<>();
    static HashMap<Integer, Integer> general = new HashMap<>();
    static HashMap<Integer, Integer> surgeon = new HashMap<>();
    static HashMap<Integer, Integer> pediatrician = new HashMap<>();
    static HashMap<Integer, Integer> selectedDept = null;
    static int idCounter = 10000;

    public static void save(Patient patient) {
        try {
            idCounter += 1;
            patientList.put(idCounter, patient);
        } catch (Exception e) {
            System.out.println("\nError Saving Patient: " + capitalizeWords(e.getMessage()));
        }
    }

    public static void viewAppointments(String dept) {
        try {
            selectedDept = null;
            System.out.printf("%-20s %-15s %-15s%n", "\nAppointment No", "Patient ID", "Patient Name");

            switch (dept.toLowerCase()) {
                case "general":
                    selectedDept = general;
                    break;
                case "surgeon":
                    selectedDept = surgeon;
                    break;
                case "pediatrician":
                    selectedDept = pediatrician;
                    break;
                default:
                    System.out.println("Invalid Department Name.");
                    return;
            }

            if (selectedDept == null || selectedDept.isEmpty()) {
                System.out.println("No Appointments.");
                return;
            }

            for (int token : selectedDept.keySet()) {
                int pid = selectedDept.get(token);
                Patient p1 = patientList.get(pid);
                if (p1 != null) {
                    System.out.printf("%-20s %-15s %-15s%n", token, pid, capitalizeWords(p1.pname));
                } else {
                    System.out.println("Patient Record Missing For ID: " + pid);
                }
            }
        } catch (Exception e) {
            System.out.println("\nError Viewing Appointments: " + capitalizeWords(e.getMessage()));
        }
    }

    public static void patientBillUpdate(int id, Double amt) {
        try {
            Patient pa = patientList.get(id);
            if (pa != null) {
                pa.bill += amt;
            } else {
                System.out.println("Invalid Patient ID. Cannot Update Bill.");
            }
        } catch (Exception e) {
            System.out.println("\nError Updating Bill: " + capitalizeWords(e.getMessage()));
        }
    }

    public static void viewPatientById(int patientId) {
        try {
            if (patientList.containsKey(patientId)) {
                Patient p1 = patientList.get(patientId);
                String admitStatus = p1.isAdmit ? "Admitted" : "Not Admitted";
                System.out.printf("%-15s %-20s %-15s %-20s %-20s%n",
                        "Patient ID", "Patient Name", "Patient Age", "Admit Status", "Room Details");
                System.out.printf("%-15s %-20s %-15s %-20s %-20s%n",
                        patientId, capitalizeWords(p1.pname), p1.age, admitStatus, capitalizeWords(p1.category));
            } else {
                System.out.println("No Patient Found With ID: " + patientId);
            }
        } catch (Exception e) {
            System.out.println("\nError Viewing Patient: " + capitalizeWords(e.getMessage()));
        }
    }

    public int getPid() {
        return pid;
    }

    public String getPname() {
        return pname;
    }

    public int getAge() {
        return age;
    }

    public String getCategory(int pid) {
        try {
            Patient pa = patientList.get(pid);
            return pa != null ? pa.category : "Not Available";
        } catch (Exception e) {
            System.out.println("\nError Retrieving Category: " + capitalizeWords(e.getMessage()));
            return "Not Available";
        }
    }

    public void setCategory(int pid, String c) {
        try {
            Patient pa = patientList.get(pid);
            if (pa != null) {
                pa.category = c;
            } else {
                System.out.println("Invalid Patient ID. Cannot Set Category.");
            }
        } catch (Exception e) {
            System.out.println("\nError Setting Category: " + capitalizeWords(e.getMessage()));
        }
    }

    public void setIsAdmit(int pid, boolean b) {
        try {
            Patient pa = patientList.get(pid);
            if (pa != null) {
                pa.isAdmit = b;
            } else {
                System.out.println("Invalid Patient ID. Cannot Update Admit Status.");
            }
        } catch (Exception e) {
            System.out.println("\nError Updating Admit Status: " + capitalizeWords(e.getMessage()));
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
