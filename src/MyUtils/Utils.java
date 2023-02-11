package MyUtils;

import java.util.Collection;
import java.util.Scanner;

/**
 *
 * @author giahu
 */
public class Utils {

    Scanner sc = new Scanner(System.in);
    DateMatcher dateMatcher = new DateMatcher();

    public String checkString() {
        boolean check = true;
        String string;

        do {
            string = sc.nextLine();

            if (string.length() == 0) {
                System.out.println("Input cannot be empty!");
            } else {
                check = false;
            }
        } while (check);

        return string;
    }

    public String checkString(String str) {
        boolean check = true;
        String string;

        do {
            System.out.println("------------");
            System.out.print("Enter " + str + ": ");
            string = sc.nextLine();

            if (string.length() == 0) {
                System.out.println(str + " cannot be empty!");
            } else {
                check = false;
            }
        } while (check);

        return string;
    }

    public String checkString(String str, String msg, String pattern) {
        boolean check = true;
        String string;

        do {
            System.out.println("------------");
            System.out.print("Enter " + str + ": ");
            string = sc.nextLine();

            if (string.length() == 0) {
                System.out.println(str + " cannot be empty!");
            } else if (!string.matches(pattern)) {
                System.out.println(msg);
            } else {
                check = false;
            }
        } while (check);

        return string;
    }

    public int checkInt() {
        int number;

        do {
            try {
                number = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception ex) {
                System.out.println("Please re-enter NUMBER.");
            }
        } while (true);

        return number;
    }

    public int checkInt(String str) {
        int number;

        do {
            System.out.println("------------");
            System.out.print("Enter " + str + ": ");
            try {
                number = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception ex) {
                System.out.println("You entered the wrong " + str + " format.\n"
                        + "Please re-enter NUMBER.");
            }
        } while (true);

        return number;
    }

    public int checkInt(String str, String msg, int min) {
        boolean check = true;
        int number = 0;

        do {
            System.out.println("------------");
            System.out.print("Enter " + str + ": ");
            try {
                number = Integer.parseInt(sc.nextLine());
                if (number < min) {
                    System.out.println(msg);
                } else {
                    check = false;
                }
            } catch (Exception ex) {
                System.out.println("You entered the wrong " + str + " format.\n"
                        + "Please re-enter NUMBER.");
            }
        } while (check);

        return number;
    }

    public int checkInt(String str, String msg, int min, int max) {
        boolean check = true;
        int number = 0;

        do {
            System.out.println("------------");
            System.out.print("Enter " + str + ": ");
            try {
                number = Integer.parseInt(sc.nextLine());
                if (number < min || number > max) {
                    System.out.println(msg);
                } else {
                    check = false;
                }
            } catch (Exception ex) {
                System.out.println("You entered the wrong " + str + " format.\n"
                        + "Please re-enter NUMBER.");
            }
        } while (check);

        return number;
    }

    public float checkFloat() {
        float number;

        do {
            try {
                number = Float.parseFloat(sc.nextLine());
                break;
            } catch (Exception ex) {
                System.out.println("Please re-enter NUMBER.");
            }
        } while (true);

        return number;
    }

    public float checkFloat(String str) {
        float number;

        do {
            System.out.println("------------");
            System.out.print("Enter " + str + ": ");
            try {
                number = Float.parseFloat(sc.nextLine());
                break;
            } catch (Exception ex) {
                System.out.println("You entered the wrong " + str + " format.\n"
                        + "Please re-enter NUMBER.");
            }
        } while (true);

        return number;
    }

    public float checkFloat(String str, String msg, float min) {
        boolean check = true;
        float number = 0f;

        do {
            System.out.println("------------");
            System.out.print("Enter " + str + ": ");
            try {
                number = Float.parseFloat(sc.nextLine());
                if (number < min) {
                    System.out.println(msg);
                } else {
                    check = false;
                }
            } catch (Exception ex) {
                System.out.println("You entered the wrong " + str + " format.\n"
                        + "Please re-enter NUMBER.");
            }
        } while (check);

        return number;
    }

    public float checkFloat(String str, String msg, float min, float max) {
        boolean check = true;
        float number = 0f;

        do {
            System.out.println("------------");
            System.out.print("Enter " + str + ": ");
            try {
                number = Float.parseFloat(sc.nextLine());
                if (number < min || number > max) {
                    System.out.println(msg);
                } else {
                    check = false;
                }
            } catch (Exception ex) {
                System.out.println("You entered the wrong " + str + " format.\n"
                        + "Please re-enter NUMBER.");
            }
        } while (check);

        return number;
    }

    public String checkDate() {
        boolean check = true;
        String string;

        do {
            string = sc.nextLine();

            if (string.length() == 0) {
                System.out.println("Input cannot be empty!");
            } else if (!dateMatcher.matches(string)) {
                System.out.println("Date has dd/mm/yyyy format!");
            } else {
                check = false;
            }
        } while (check);

        return string;
    }

    public String checkDate(String str) {
        boolean check = true;
        String string;

        do {
            System.out.println("------------");
            System.out.print("Enter " + str + ": ");
            string = sc.nextLine();

            if (string.length() == 0) {
                System.out.println(str + " cannot be empty!");
            } else if (!dateMatcher.matches(string)) {
                System.out.println("Date has dd/mm/yyyy format!");
            } else {
                check = false;
            }
        } while (check);

        return string;
    }

    public String checkDate(String str, String msg) {
        boolean check = true;
        String string;

        do {
            System.out.println("------------");
            System.out.print("Enter " + str + ": ");
            string = sc.nextLine();

            if (string.length() == 0) {
                System.out.println(str + " cannot be empty!");
            } else if (!dateMatcher.matches(string)) {
                System.out.println(msg);
            } else {
                check = false;
            }
        } while (check);

        return string;
    }

    public String checkBlank() {
        boolean check = true;
        String string;

        string = sc.nextLine();

        return string;
    }

    public String checkBlank(String str, String msg, String pattern) {
        boolean check = true;
        String string = "";

        do {
            System.out.println("------------");
            System.out.print("Enter " + str + ": ");
            string = sc.nextLine();

            if (string.length() != 0 && !string.matches(pattern)) {
                System.out.println(msg);
            } else {
                check = false;
            }
        } while (check);

        return string;
    }

    public int checkBlank(String str, String msg, int min, int max) {
        boolean check = true;
        int number = 0;
        String string;

        do {
            System.out.println("------------");
            System.out.print("Enter " + str + ": ");
            string = sc.nextLine();
            if (string.length() == 0) {
                return -1;
            } else {
                try {
                    number = Integer.parseInt(string);

                    if (number < min || number > max) {
                        System.out.println(msg);
                    } else {
                        check = false;
                    }
                } catch (Exception ex) {
                    System.out.println("You entered the wrong " + str + " format.\n"
                            + "Please re-enter NUMBER.");
                }
            }
        } while (check);

        return number;
    }

    public float checkBlank(String str, String msg, float min, float max) {
        boolean check = true;
        float number = 0f;
        String string;

        do {
            System.out.println("------------");
            System.out.print("Enter " + str + ": ");
            string = sc.nextLine();
            if (string.length() == 0) {
                return -1;
            } else {
                try {
                    number = Float.parseFloat(string);

                    if (number < min || number > max) {
                        System.out.println(msg);
                    } else {
                        check = false;
                    }
                } catch (Exception ex) {
                    System.out.println("You entered the wrong " + str + " format.\n"
                            + "Please re-enter NUMBER.");
                }
            }
        } while (check);

        return number;
    }

    public String checkBlank(String str, String msg) {
        boolean check = true;
        String string = "";

        do {
            System.out.println("------------");
            System.out.print("Enter " + str + ": ");
            string = sc.nextLine();

            if (string.length() != 0 && !dateMatcher.matches(string)) {
                System.out.println(msg);
            } else {
                check = false;
            }
        } while (check);

        return string;
    }

    public String showMenu(String[] options) {
        System.out.println("\n---------MENU----------\n");
        for (int i = 0; options.length > i; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        return checkString("Your choice");
    }

    public <E> void printList(Collection<E> list) {
        for (E x : list) {
            System.out.println("------------");
            System.out.println(x);
        }
        System.out.println("---------------------------------");
    }
}
