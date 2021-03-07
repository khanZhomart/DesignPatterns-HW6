import subtask1.Database;
import subtask2.factories.Factory;
import subtask2.factories.GuitarFactory;
import subtask2.factories.PianoFactory;
import subtask3.User;

import java.util.Scanner;

public class Main {
    static final Scanner scan = new Scanner(System.in);

    static void showSingleton() {
        Database postgres1 = Database.getInstance();
        postgres1.query("SELECT * FROM employee");

        Database postgres2 = Database.getInstance();
        postgres2.query("SELECT * FROM project");
    }

    static void showFactory() {
        System.out.println("Instruments: " +
                            "\n1. Piano" +
                            "\n2. Guitar" +
                            "\n0. Back");
        int choice = scan.nextInt();

        Factory factory = null;

        switch(choice) {
            case 0:
                return;

            case 1:
                factory = new PianoFactory();
                break;

            case 2:
                factory = new GuitarFactory();
                break;

            default:
                System.out.println("Invalid answer, try again.");
                showFactory();
        }

        factory.playSound();
    }

    static void showBuilder() {
        User user = new User.UserBuilder("Zhomartkhan", "Talgatuly")
                .setUsername("jomajoma")
                .setGender("male")
                .setPassword("12345abcdef")
                .setTelno("+8 (777) 212 12 21")
                .build();

        System.out.println(user.toString());
    }

    static void run() {
        while (true) {
            System.out.println("\n1. Singleton (requires database connection)" +
                    "\n2. Factory" +
                    "\n3. Builder" +
                    "\n0. Exit");

            int choice = scan.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Bye-bye!");
                    System.exit(0);

                case 1:
                    showSingleton();
                    break;

                case 2:
                    showFactory();
                    break;

                case 3:
                    showBuilder();
                    break;

                default:
                    System.out.println("Invalid answer, try again.");
                    run();
            }
        }
    }

    public static void main(String[] args) {
        run();
        scan.close();
    }
}
