package repository;
/*
@date 28.11.2023
@author Sergey Bugaienko
*/

import model.Currency;
import model.Rate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrencyRepository {

    private final Map<String, Rate> rates; // codeCurrency
    private final Map<String, Currency> currencyMap; // codeCur Currency
    private final Map<String, List<Rate>> historyRates; // codeCur, List<Rate>

    public CurrencyRepository() {
        this.rates = new HashMap<>();
        this.currencyMap = new HashMap<>();
        this.historyRates = new HashMap<>();
        initTestData();
    }

    private void initTestData() {
        List<Currency> currencies = List.of(
                new Currency("EUR", "Euro"),
                new Currency("USD", "Dollar USA"),
                new Currency("GBP", "UK pound sterling"),
                new Currency("PLN", "Polish zloty"),
                new Currency("CZK", "Czech krone")
        );

        for (Currency currency : currencies) {
            currencyMap.put(currency.getCode(), currency);
        }

        Rate rateEUR = new Rate(1.0);
        Rate rateUSD = new Rate(0.93689147);
        Rate rateGBP = new Rate(1.1604073);
        Rate ratePLN = new Rate(0.21496);
        Rate rateCZK = new Rate(0.0406557);

        rates.put("EUR", rateEUR);
        rates.put("USD", rateUSD);
        rates.put("GBP", rateGBP);
        rates.put("PLN", ratePLN);
        rates.put("CZK", rateCZK);

        //TODO раскомментировать после добавления реализации метода
//        addRateToHistory("EUR", rateEUR);
//        addRateToHistory("USD", rateUSD);
//        addRateToHistory("GBP", rateGBP);
//        addRateToHistory("PLN", ratePLN);
//        addRateToHistory("CZK", rateCZK);

    }
}
