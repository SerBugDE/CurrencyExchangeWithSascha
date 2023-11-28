package service;
/*
@date 28.11.2023
@author Sergey Bugaienko
*/

public class ExchangeService {

    private final UserService userService;
    private final CurrencyService currencyService;


    public ExchangeService(UserService userService, CurrencyService currencyService) {
        this.userService = userService;
        this.currencyService = currencyService;
    }
}
