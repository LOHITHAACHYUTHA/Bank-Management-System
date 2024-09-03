import java.util.Scanner;

class BankManagement {
    private int accNo; // Account number
    private String name; // Account holder's name
    private String address; // Account holder's address
    private char accType; // Account type (saving or current)
    private float amount; // Account balance

    // Constructor to initialize account attributes
    public BankManagement() {
        accNo = 0;
        name = "";
        address = "";
        accType = '\0';
        amount = 0.0f;
    }

    // Method to check if the account slot is available
    public boolean checkAvailability() {
        return accNo == 0 && name.equals("") && address.equals("") && accType == '\0' && amount == 0.0f;
    }

    // Method to search for an account by account number
    public boolean searchAccount(int accountNumber) {
        return accNo == accountNumber;
    }

    // Method to create a new account
    public void newAccount(Scanner sc) {
        System.out.print("Enter your account number: ");
        accNo = sc.nextInt();
        sc.nextLine(); // Clear the buffer

        System.out.print("Enter your full name: ");
        name = sc.nextLine();

        System.out.print("Enter your address: ");
        address = sc.nextLine();

        System.out.print("What type of account do you want to open? Saving(s) or Current(c): ");
        accType = sc.next().charAt(0);

        System.out.print("Enter how much money you want to deposit: ");
        amount = sc.nextFloat();

        System.out.println("Account Created Successfully...");
    }

    // Method to deposit money into an account
    public void deposit(Scanner sc) {
        System.out.print("\nEnter amount to deposit: ");
        float depositAmount = sc.nextFloat();
        amount += depositAmount;
        System.out.println("Updated... New Amount = " + amount);
    }

    // Method to withdraw money from an account
    public void withdraw(Scanner sc) {
        System.out.print("\nEnter amount to withdraw: ");
        float withdrawAmount = sc.nextFloat();
        if (withdrawAmount <= amount) {
            amount -= withdrawAmount;
            System.out.println("\nAmount has been withdrawn.");
        } else {
            System.out.println("\nYou don't have enough amount in the bank.");
        }
        System.out.println("Remaining amount: " + amount);
    }

    // Method to display account details
    public void checkAccount() {
        System.out.println("\nYour name: " + name);
        System.out.println("Your address: " + address);
        System.out.println("Account type: " + accType);
        System.out.println("Amount: " + amount);
    }

    // Method to modify account information
    public void modifyAccount(Scanner sc) {
        System.out.println("\nAccount No.: " + accNo);

        sc.nextLine(); // Clear the buffer
        System.out.print("Modify Account Holder Name: ");
        name = sc.nextLine();

        System.out.print("Modify your address: ");
        address = sc.nextLine();

        System.out.print("Modify Type of Account: Saving (s) or Current (c): ");
        accType = sc.next().charAt(0);

        System.out.println("\nAccount is modified.");
    }

    // Method to delete an account
    public void deleteAccount() {
        accNo = 0;
        name = "";
        address = "";
        accType = '\0';
        amount = 0.0f;
        System.out.println("\nSuccessfully deleted.");
    }

    public static void main(String[] args) {
        BankManagement[] accounts = new BankManagement[5];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new BankManagement(); // Initialize each account object
        }

        Scanner sc = new Scanner(System.in);
        boolean check;
        int choice, accNum;

        while (true) {
            System.out.println("\n             =================              ");
            System.out.println("             |   Bank Menu   |              ");
            System.out.println("==========================================");
            System.out.println(" Enter 1 to create a new account.\n Enter 2 to Deposit.\n Enter 3 to Withdraw.");
            System.out.println(" Enter 4 to Check account.\n Enter 5 to Modify.\n Enter 6 to Delete.");
            System.out.println(" Enter 7 to show all accounts.\n Enter 8 to exit.");
            System.out.println("==========================================");
            System.out.print("Enter choice number: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: // Create a new account
                    check = false;
                    for (BankManagement account : accounts) {
                        if (account.checkAvailability()) {
                            check = true;
                            account.newAccount(sc);
                            System.out.println("Working.");
                            break;
                        }
                    }

                    if (!check)
                        System.out.println("Accounts exceeded.");
                    break;

                case 2: // Deposit money into an account
                    check = false;
                    System.out.print("Enter account number: ");
                    accNum = sc.nextInt();
                    for (BankManagement account : accounts) {
                        if (account.searchAccount(accNum)) {
                            check = true;
                            account.deposit(sc);
                            break;
                        }
                    }

                    if (!check)
                        System.out.println("No account found.");
                    break;

                case 3: // Withdraw money from an account
                    check = false;
                    System.out.print("Enter account number: ");
                    accNum = sc.nextInt();
                    for (BankManagement account : accounts) {
                        if (account.searchAccount(accNum)) {
                            check = true;
                            account.withdraw(sc);
                            break;
                        }
                    }

                    if (!check)
                        System.out.println("No account found.");
                    break;

                case 4: // Check account details
                    check = false;
                    System.out.print("Enter account number: ");
                    accNum = sc.nextInt();
                    for (BankManagement account : accounts) {
                        if (account.searchAccount(accNum)) {
                            check = true;
                            account.checkAccount();
                            break;
                        }
                    }

                    if (!check)
                        System.out.println("No account found.");
                    break;

                case 5: // Modify account information
                    check = false;
                    System.out.print("Enter account number: ");
                    accNum = sc.nextInt();
                    for (BankManagement account : accounts) {
                        if (account.searchAccount(accNum)) {
                            check = true;
                            account.modifyAccount(sc);
                            break;
                        }
                    }

                    if (!check)
                        System.out.println("No account found.");
                    break;

                case 6: // Delete an account
                    check = false;
                    System.out.print("Enter account number: ");
                    accNum = sc.nextInt();
                    for (BankManagement account : accounts) {
                        if (account.searchAccount(accNum)) {
                            check = true;
                            account.deleteAccount();
                            break;
                        }
                    }

                    if (!check)
                        System.out.println("No account found.");
                    break;

                case 7: // Show all accounts
                    check = false;
                    for (int i = 0; i < accounts.length; i++) {
                        if (!accounts[i].checkAvailability()) {
                            check = true;
                            System.out.println("\nAccount details of " + (i + 1) + ":");
                            accounts[i].checkAccount();
                            System.out.println("==========================================");
                        }
                    }

                    if (!check)
                        System.out.println("No account found.");
                    break;

                case 8: // Exit the program
                    System.out.println("Exiting program...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
