package view;
/*
@date 28.11.2023
@author Sergey Bugaienko
*/

import model.Account;
import model.Currency;
import model.User;
import service.CurrencyService;
import service.ExchangeService;
import service.UserService;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Menu {

    private final UserService userService;
    private final CurrencyService currencyService;
    private final ExchangeService exchangeService;

    private final static Scanner SCANNER = new Scanner(System.in);
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");


    public Menu(UserService userService, CurrencyService currencyService) {
        this.userService = userService;
        this.currencyService = currencyService;
        this.exchangeService = new ExchangeService(userService, currencyService);
    }


    public void run(){
       showMenu();
    }

    private void showMenu() {
        while (true) {
            PrintMenuOptions.printShowMenu();

            int choice = SCANNER.nextInt();
            SCANNER.nextLine();
            if (choice == 0) {
                System.out.println("До свидания");
                break;
            }
            showSubMenu(choice);

        }
    }

    private void showSubMenu(int choice) {
        switch (choice) {
            case 1:
                showCurrencyMenu();
                break;
            case 2:
                showUsersMenu();
                break;
            case 3:
                //TODO admin menu
                //showAdminMenu();
                break;
            default:
                System.out.println("Ваш выбор не корректен");
        }
    }

    private void showCurrencyMenu() {
        while (true) {
            PrintMenuOptions.printShowCurrencyMenu();
            int choice = SCANNER.nextInt();
            SCANNER.nextLine();
            if (choice == 0) break;
            choiceCurrencyMenuProcessing(choice);
        }
    }

    private void showUsersMenu() {
        while (true) {
            PrintMenuOptions.printShowUsersMenu();
            int choice = SCANNER.nextInt();
            SCANNER.nextLine();
            if (choice == 0) break;
            choiceUserMenuProcessing(choice);
        }
    }

    public void choiceCurrencyMenuProcessing(int choice) {
        switch (choice) {
            case 1:
                // TODO menuCurrencyList();

                waitRead();
                break;
            case 2:
                //TODO menuCurrencyRatesList();

                waitRead();
                break;
            case 3:
                //TODO menuExchange();

                waitRead();
                break;
            case 4:
                //TODO menuRatesHistory();

                waitRead();
                break;
            case 5:
                //TODO menuDepositAccount();

                waitRead();
                break;
            case 6:
                //TODO menuDebitAccount();

                waitRead();
                break;

            case 0:

                break;
            default:
                System.out.println("Не верный ввод\n");
                waitRead();
        }
    }


    private void choiceUserMenuProcessing(int choice) {
        switch (choice) {
            case 1:
                //TODO menuUserAuthorisation(); //Sasha

                waitRead();
                break;
            case 2:
                //TODO menuUserRegistration(); //Serg

                waitRead();
                break;
            case 3:
                //TODO showUsersAccounts(); //Sacha

                waitRead();
                break;
            case 4:
                //TODO menuAddAccount(); //Sasha

                waitRead();
                break;
            case 5:
                menuDeleteAccount(); //Serg

                waitRead();
                break;
            case 6:
                //TODO menuUserHistory(); //Sasha
                waitRead();
                break;
            case 0:

                break;
            default:
                System.out.println("Не верный ввод\n");
                waitRead();
        }
    }

    private void menuDeleteAccount() {
        System.out.println("Удалить счет");
        User activeUser = userService.getActiveUser();
        if (activeUser == null) {
            System.out.println("Авторизуйтесь в системе");
            return;
        }

        List<Account> userAccounts = currencyService.getUserAccounts(activeUser);
        if (userAccounts.isEmpty()) {
            System.out.println("У вас нет активных счетов");
            return;
        }

        Currency currency = getCurrencyByInputCode();
        if (currency == null) {
            System.out.println("У вас нет счета в такой валюте");
            return;
        }

        Optional<Account> accountOptional = currencyService.getAccountByCurrency(activeUser, currency);
        Account account = null;
        if (accountOptional.isEmpty()) {
            System.out.println("У вас нет счета в такой валюте");
            return;
        } else {
            account = accountOptional.get();
        }


    }

    private Currency getCurrencyByInputCode() {
        System.out.println("Введите код валюты?");
        String inputCur = SCANNER.nextLine().trim().toUpperCase();
        return currencyService.getCurrencyByCode(inputCur.trim().toUpperCase());
    }
    private void waitRead() {
        System.out.println("\nДля продолжения нажмите Enter ...");
        SCANNER.nextLine();
    }




}
