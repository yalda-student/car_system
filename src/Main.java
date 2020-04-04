import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int commandNumbers = scanner.nextInt();
        String[] inputCommands = new String[commandNumbers];

        ManageAccounts manageAccounts = new ManageAccounts(commandNumbers);

        for (int i = 0; i < commandNumbers; i++) {
            inputCommands[i] = new Scanner(System.in).nextLine();
        }

        for (int i = 0; i < commandNumbers; i++) {

            String commandStr = inputCommands[i], method;
            String[] command = commandStr.split("\\s");
            method = command[0];

            switch (method) {

                case "1":
                    manageAccounts.addAccounts(command[1], command[2], Integer.parseInt(command[3]));
                    break;

                case "2":
                    String mostDebtor = manageAccounts.findDebtor();
                    if (mostDebtor != null)
                        System.out.println(mostDebtor);
                    else System.out.println(-1);
                    break;

                case "3":
                    String mostCreditor = manageAccounts.findCreditor();
                    if (mostCreditor != null)
                        System.out.println(mostCreditor);
                    else System.out.println(-1);
                    break;

                case "4":
                    int debtorCounter = manageAccounts.countDebtors(command[1]);
                    System.out.println(debtorCounter);
                    break;

                case "5":
                    int creditorCounter = manageAccounts.countCreditors(command[1]);
                    System.out.println(creditorCounter);
                    break;

                case "6":
                    int moneyGetBack = manageAccounts.getMoney(command[1], command[2]);
                    System.out.printf("%.2f\n", (float) moneyGetBack);
                    break;
            }
        }
    }
}
