package service;
/*
@date 28.11.2023
@author Sergey Bugaienko
*/

import interfaces.IS_ExchangeService;
import model.Currency;
import model.User;
import validators.exceptions.ExchangeDataError;

public class ExchangeService implements IS_ExchangeService {

    private final UserService userService;
    private final CurrencyService currencyService;


    public ExchangeService(UserService userService, CurrencyService currencyService) {
        this.userService = userService;
        this.currencyService = currencyService;
    }

    @Override
    public boolean exchangeCurrency(User user, Currency currencySell, Currency currencyBuy, double amount) throws ExchangeDataError {
        // Это сложная шляпа
        //TODO Sasha
    }

    @Override
    public boolean deposit(User user, Currency currency, double amount) {
        //TODO Serg
}
