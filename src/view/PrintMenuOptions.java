package view;
/*
@date 01.12.2023
@author Sergey Bugaienko
*/

public class PrintMenuOptions {

    public static void printShowMenu(){
        System.out.println("Добро пожаловать в обмен валют");
        System.out.println("=========== v 1.0 ===========");
        System.out.println("1. Обмен валют");
        System.out.println("2. Меню пользователей");
        System.out.println("3. Меню администратора");
        System.out.println("0. Выход");
        System.out.println("\nСделайте выбор:");
    }

    public static void printShowCurrencyMenu(){
        System.out.println("Currency Menu");
        System.out.println("1. Список валют");
        System.out.println("2. Текущие курсы");
        System.out.println("3. Обмен валют");
        System.out.println("4. История курсов");
        System.out.println("5. Пополнить счет");
        System.out.println("6. Снять со счета");
        System.out.println("0. Вернуться в предыдущее меню");
        System.out.println("\nСделайте выбор:");
    }

    public static void printShowUsersMenu(){
        System.out.println("Users Menu");
        System.out.println("1. Авторизоваться");
        System.out.println("2. Регистрация пользователя");
        System.out.println("3. Список счетов пользователя");
        System.out.println("4. Добавить счет");
        System.out.println("5. Удалить счет");
        System.out.println("6. История всех операций");
        System.out.println("7. История операций по валюте");
        System.out.println("0. Вернуться в предыдущее меню");
        System.out.println("\nСделайте выбор:");
    }
}
