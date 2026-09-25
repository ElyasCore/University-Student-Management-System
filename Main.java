import java.util.Scanner;
public class Main {
    public static String[] addStudent(Scanner in, String[] names) {
        in.nextLine();
        for (int i = 0; i < names.length; i++) {
            System.out.print("Enter student " + (i + 1) + " name: ");
            names[i] = in.nextLine();
        }
        return names;
    }
    public static int[] addAge(Scanner in, int[] ages) {
        for (int i = 0; i < ages.length; i++) {
            System.out.print("Enter student " + (i + 1) + " age: ");
            ages[i] = in.nextInt();
            if (ages[i] > 30 || ages[i] < 18) {
                while (ages[i] > 30 || ages[i] < 18) {
                    System.out.print("Invalid age, choose between 18-30: ");
                    ages[i] = in.nextInt();
                }
            }
        }
        return ages;
    }
    public static String[] addMajor(Scanner in, String[] majors) {
        in.nextLine();
        for (int i = 0; i < majors.length; i++) {
                System.out.print("Enter student " + (i + 1) + " major: ");
                majors[i] = in.nextLine();
            }
        return majors;
    }
    public static int[][] addGrade(Scanner in, int [][] grades) {
                for(int i = 0; i < grades.length; i++){
                    System.out.println();
                    System.out.println("Enter student " + (i+1) + " Grades: ");
                    for(int j = 0; j < 3; j++){
                        System.out.print("Grade #" +(j+1) + " : ");
                        grades[i][j] = in.nextInt();
                        if(grades[i][j] > 100 || grades[i][j] < 0){
                            while(grades[i][j] > 100 || grades[i][j] < 0) {
                                System.out.print("Invalid grade, enter a grade between 0-100: ");
                                grades[i][j] = in.nextInt();
                            }
                        }
                    }
                }
                return grades;
    }
    public static void showStudents(String[] savedNames, int[] savedAges, String[] savedMajors, int[][] savedGrades) {
        System.out.println("===== Students =====");
        for (int i = 0; i < savedGrades.length; i++) {
            System.out.println("Student #" + (i + 1));
            System.out.println("Name: " + savedNames[i]);
            System.out.println("Age: " + savedAges[i]);
            System.out.println("Major: " + savedMajors[i]);
            System.out.println("Grades: ");
            for(int j = 0; j < savedGrades[i].length; j++){
                System.out.println("Grade " + (j+1) + " : " + savedGrades[i][j]);
            }
            System.out.println();
        }
    }
    public static void searchStudent(Scanner in, String[] savedNames, int[] savedAges, String[] savedMajors){
        System.out.print("Enter student name: ");
        boolean notFound = true;
        in.nextLine();
        String search = in.nextLine();
        for(int i = 0; i < savedNames.length; i++){
            if(search.equalsIgnoreCase(savedNames[i])) {
                System.out.println("Student #" + (i + 1));
                System.out.println("Name: " + savedNames[i]);
                System.out.println("Age: " + savedAges[i]);
                System.out.println("Major: " + savedMajors[i]);
                notFound = false;
                break;
            }
        }
        if(notFound) {
            System.out.println("Student not found.");
        }
    }
    public static double calculateAverage(Scanner in, int[][] savedGrades, String[] savedNames){
        int sum = 0;
        System.out.print("Enter student number: ");
        int studentNum = in.nextInt();
        if(studentNum > savedNames.length || studentNum <= 0){
            while(studentNum > savedNames.length || studentNum <= 0){
                System.out.print("Invalid value, choose a student from 1-5: ");
                studentNum = in.nextInt();
            }
        }
        System.out.print("Student [" + savedNames[studentNum-1] + "] average: ");
        for(int i = 0; i < savedGrades[studentNum - 1].length; i++){
            sum += savedGrades[studentNum-1][i];
        }
        return (double) sum / savedGrades[studentNum - 1].length;
    }
    public static void checkGrade(double avg) {
        System.out.print("Grade: ");
        if(avg >= 90){
            System.out.println("A");
        }else if(avg >= 80){
            System.out.println("B");
        }else if(avg >= 70){
            System.out.println("C");
        }else if(avg >= 60){
            System.out.println("D");
        }else{
            System.out.println("F");
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice;
        boolean checkAdding = false;
        String[] names = new String[5];
        int[] ages = new int[names.length];
        String[] majors = new String[names.length];
        int[][] grades = new int[5][3];

        String[] savedNames = null;
        int[] savedAges = null;
        String[] savedMajors = null;
        int[][] savedGrades = null;
        double avg = 0;

        while (true) {
            System.out.println("===== University Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Show All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Calculate Student Average");
            System.out.println("5. Exit");

            System.out.print("Select your choice: ");
            choice = in.nextInt();
            if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) {
                System.out.println();
                System.out.println("Faild, try again by using one of the options");
                System.out.println();
                System.out.println();
            }
            switch (choice) {
                case 1:
                    savedNames = addStudent(in, names);
                    savedAges = addAge(in, ages);
                    savedMajors = addMajor(in, majors);
                    savedGrades = addGrade(in,grades);
                    checkAdding = true;
                    break;
                case 2:
                    if (checkAdding) {
                        showStudents(savedNames,savedAges,savedMajors,savedGrades);
                    } else {
                        System.out.println();
                        System.out.println("No students were added, add a student and try again.");
                        System.out.println();
                    }
                    break;
                case 3:
                    if (checkAdding) {
                        searchStudent(in,savedNames,savedAges,savedMajors);
                    } else {
                        System.out.println();
                        System.out.println("No students were added, add a student and try again.");
                        System.out.println();
                    }
                    break;
                case 4:
                    if (checkAdding) {
                        avg = calculateAverage(in,savedGrades,savedNames);
                        System.out.println(avg);
                        checkGrade(avg);
                    } else {
                        System.out.println();
                        System.out.println("No students were added, add a student and try again.");
                        System.out.println();
                    }
                    break;
            }
            if (choice == 5) {
                break;
            }
        }
    }
}