package interfaces;
/*
@date 28.11.2023
@author Sergey Bugaienko
*/

import model.*;

import java.util.List;
import java.util.Optional;

public interface IR_CurrencyRepo {
    Currency getCurrencyByCode(String curCode); //SERG
    List<Currency> getAllCurrencies();
    Rate getCurrencyRate(String curCode);
    Rate getCurrencyRate(Currency currency);

    List<Rate> getRateHistory(String curCode);
    List<Rate> getRateHistory(Currency currency);

    void addRateToHistory(String curCode, Rate rate);
    void addRateToHistory(Currency currency, Rate rate);


}
