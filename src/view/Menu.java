package view;
/*
@date 28.11.2023
@author Sergey Bugaienko
*/

import service.CurrencyService;
import service.ExchangeService;
import service.UserService;

import java.time.format.DateTimeFormatter;
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
            System.out.println("Добро пожаловать в обмен валют");
            System.out.println("=========== v 1.0 ===========");
            System.out.println("1. Обмен валют");
            System.out.println("2. Меню пользователей");
            System.out.println("3. Меню администратора");
            System.out.println("0. Выход");
            System.out.println("\n Сделайте выбор:");
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
            System.out.println("Currency Menu");
            System.out.println("1. Список валют");
            System.out.println("2. Текущие курсы");
            System.out.println("3. Обмен валют");
            System.out.println("4. История курсов");
            System.out.println("5. Пополнить счет");
            System.out.println("6. Снять со счета");
            System.out.println("0. Вернуться в предыдущее меню");
            System.out.println("\n Сделайте выбор:");
            int choice = SCANNER.nextInt();
            SCANNER.nextLine();
            if (choice == 0) break;
            choiceCurrencyMenuProcessing(choice);
        }
    }

    private void showUsersMenu() {
        while (true) {
            System.out.println("Users Menu");
            System.out.println("1. Авторизоваться");
            System.out.println("2. Регистрация пользователя");
            System.out.println("3. Список счетов пользователя");
            System.out.println("4. Добавить счет");
            System.out.println("5. Удалить счет");
            System.out.println("6. История всех операций");
            System.out.println("7. История операций по валюте");
            System.out.println("0. Вернуться в предыдущее меню");
            System.out.println("\n Сделайте выбор:");
            int choice = SCANNER.nextInt();
            SCANNER.nextLine();
            if (choice == 0) break;
            choiceUserMenuProcessing(choice);
        }
    }

    private void choiceCurrencyMenuProcessing(int choice) {
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
                //TODO menuUserAuthorisation();

                waitRead();
                break;
            case 2:
                //TODO menuUserRegistration();

                waitRead();
                break;
            case 3:
                //TODO showUsersAccounts();

                waitRead();
                break;
            case 4:
                //TODO menuAddAccount();

                waitRead();
                break;
            case 5:
                //TODO menuDeleteAccount();

                waitRead();
                break;
            case 6:
                //TODO menuUserHistory();
                waitRead();
                break;
            case 0:

                break;
            default:
                System.out.println("Не верный ввод\n");
                waitRead();
        }
    }

    private void waitRead() {
        System.out.println("\nДля продолжения нажмите Enter ...");
        SCANNER.nextLine();
    }




}
