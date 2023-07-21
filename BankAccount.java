import java.util.*;
public class BankAccount {

    String name;
    String userName;
    String password;
    String accountNo;
    float balance = 100000f;
    int transactions = 0;
    String transactionHistory = "";

    public void register() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Your Name - ");
        this.name = sc.nextLine();
        System.out.print("Enter Your Username - ");
        this.userName = sc.nextLine();
        System.out.print("Enter Your Password - ");
        this.password = sc.nextLine();
        System.out.print("Enter Your Account Number - ");
        this.accountNo = sc.nextLine();
        System.out.println("Registration completed..kindly login");
    }

    public boolean login() {
        boolean isLogin = false;
        Scanner sc = new Scanner(System.in);
        while (!isLogin) {
            System.out.print("\nEnter Your Username - ");
            String Username = sc.nextLine();
            if (Username.equals(userName)) {
                while (!isLogin) {
                    System.out.print("Enter Your Password - ");
                    String Password = sc.nextLine();
                    if (Password.equals(password)) {
                        System.out.print("Login successful!!");
                        isLogin = true;
                    } else {
                        System.out.println("Incorrect Password");
                    }
                }
            } else {
                System.out.println("Username not found");
            }
        }
        return isLogin;
    }

    public void withdraw() {

        System.out.print("Enter amount to withdraw - ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try {

            if (balance >= amount) {
                transactions++;
                balance -= amount;
                System.out.println("Withdraw Successfully");
                System.out.println("\n********  WELCOME TO SBI ATM SYSTEM  ********");
                String str = amount + " Rs Withdrawed\n";
                transactionHistory = transactionHistory.concat(str);

            } else {
                System.out.println("Insufficient Balance");
                System.out.println("\n********  WELCOME TO SBI ATM SYSTEM  ********");
            }

        } catch (Exception e) {
        }
    }

    public void deposit() {

        System.out.print("Enter amount to deposit - ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();

        try {
            if (amount <= 100000f) {
                transactions++;
                balance += amount;
                System.out.println("Successfully Deposited");
                System.out.println("\n********  WELCOME TO SBI ATM SYSTEM  ********");
                String str = amount + " Rs deposited\n";
                transactionHistory = transactionHistory.concat(str);
            } else {
                System.out.println("Sorry...Limit is 100000.00");
                System.out.println("\n********  WELCOME TO SBI ATM SYSTEM  ********");
            }

        } catch (Exception e) {
        }
    }

    public void transfer() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Receipent's Name - ");
        String receipent = sc.nextLine();
        System.out.print("Enter amount to transfer - ");
        float amount = sc.nextFloat();

        try {
            if (balance >= amount) {
                if (amount <= 50000f) {
                    transactions++;
                    balance -= amount;
                    System.out.println("Successfully Transfered to " + receipent);
                    System.out.println("\n********  WELCOME TO SBI ATM SYSTEM  ********");
                    String str = amount + " Rs transfered to " + receipent + "\n";
                    transactionHistory = transactionHistory.concat(str);
                } else {
                    System.out.println("Sorry...Limit is 50000.00");
                    System.out.println("\n********  WELCOME TO SBI ATM SYSTEM  ********");
                }
            } else {
                System.out.println("Insufficient Balance");
                System.out.println("\n******* WELCOME TO SBI ATM SYSTEM *******");
            }
        } catch (Exception e) {
        }
    }

    public void checkBalance() {
        System.out.println("\nTotal Balance is: 1" + balance + " Rs");
        System.out.println("\n********  WELCOME TO SBI ATM SYSTEM  ********");
    }

    public void transHistory() {
        if (transactions == 0) {
            System.out.println("\nEmpty");
            System.out.println("\n********  WELCOME TO SBI ATM SYSTEM  ********");
        } else {
            System.out.println("\n" + transactionHistory);
            System.out.println("\n********  WELCOME TO SBI ATM SYSTEM  ********");
        }
    }
}

class AtmInterface {

    public static int takeIntegerInput(int limit) {
        int input = 0;
        boolean flag = false;

        while (!flag) {
            try {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;

                if (flag && input > limit || input < 1) {
                    System.out.println("Choose the number between 1 to " + limit);
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("Enter only integer value");
                flag = false;
            }
        }
        ;
        return input;
    }

    public static void main(String[] args) {

        System.out.println("\n******* WELCOME TO SBI ATM SYSTEM *******");
        System.out.println("*               1.Register              *");
        System.out.println("*               2.Exit                  *");
        System.out.println("*****************************************");
        System.out.print("Enter Your Choice - ");
        int choice = takeIntegerInput(2);

        if (choice == 1) {
            BankAccount b = new BankAccount();
            b.register();
            while (true) {
                System.out.println("\n1.Login \n2.Exit");
                System.out.print("Enter Your Choice - ");
                int ch = takeIntegerInput(2);
                if (ch == 1) {
                    if (b.login()) {
                        System.out.println("\n\n********* WELCOME BACK " + b.name + " **********");
                        boolean isFinished = false;
                        while (!isFinished) {
                            System.out.println("*           1. Withdraw                     *");
                            System.out.println("*           2. Deposit                      *");
                            System.out.println("*           3. Transfer                     *");
                            System.out.println("*           4. Check Balance                *");
                            System.out.println("*           5. Transaction History          *");
                            System.out.println("*           6. Exit                         *");
                            System.out.println("*********************************************");
                            System.out.print("\nEnter Your Choice - ");

                            int c = takeIntegerInput(6);
                            switch (c) {
                                case 1:
                                    b.withdraw();
                                    break;
                                case 2:
                                    b.deposit();
                                    break;
                                case 3:
                                    b.transfer();
                                    break;
                                case 4:
                                    b.checkBalance();
                                    break;
                                case 5:
                                    b.transHistory();
                                    break;
                                case 6:
                                    isFinished = true;
                                    break;
                            }
                        }
                    }
                } else {
                    System.exit(0);
                }
            }
        } else {
            System.exit(0);
        }
    }
}