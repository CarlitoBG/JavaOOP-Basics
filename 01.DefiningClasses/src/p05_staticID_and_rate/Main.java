package p05_staticID_and_rate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    private static HashMap<Integer, BankAccount> bankAccounts = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command = reader.readLine();

        while (!"End".equals(command)) {
            String[] line = command.split("\\s+");

            switch (line[0]) {
                case "Create":
                    createBankAccount();
                    break;
                case "Deposit":
                    depositSum(Integer.valueOf(line[1]), Double.valueOf(line[2]));
                    break;
                case "SetInterest":
                    setInterestRate(Double.valueOf(line[1]));
                    break;
                case "GetInterest":
                    getInterestRate(Integer.valueOf(line[1]), Integer.valueOf(line[2]));
                    break;
            }

            command = reader.readLine();
        }
    }

    private static void createBankAccount() {
        BankAccount account = new BankAccount();
        bankAccounts.put(account.getId(), account);
        System.out.println(String.format("Account %s created", account));
    }

    private static void depositSum(Integer id, Double amount) {
        if (bankAccounts.containsKey(id)){
            bankAccounts.get(id).deposit(amount);
            System.out.printf("Deposited %.0f to ID%d%n", amount, id);
        }else {
            System.out.println("Account does not exist");
        }
    }

    private static void getInterestRate(Integer id, Integer years) {
        if (bankAccounts.containsKey(id)){
            System.out.printf("%.2f%n", bankAccounts.get(id).getInterest(years));
        }else {
            System.out.println("Account does not exist");
        }
    }

    private static void setInterestRate(Double interest) {
        BankAccount.setInterest(interest);
    }
}