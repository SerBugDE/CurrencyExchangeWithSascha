package repository;
/*
@date 28.11.2023
@author Sergey Bugaienko
*/

import interfaces.IR_CurrencyRepo;
import model.Currency;
import model.Rate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrencyRepository implements IR_CurrencyRepo {

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
        addRateToHistory("EUR", rateEUR);
        addRateToHistory("USD", rateUSD);
        addRateToHistory("GBP", rateGBP);
        addRateToHistory("PLN", ratePLN);
        addRateToHistory("CZK", rateCZK);

    }

    public Currency getCurrencyByCode(String curCode) {
        return currencyMap.getOrDefault(curCode, null);
    }

    @Override
    public List<Currency> getAllCurrencies() {
        return currencyMap.values().stream().toList();
        //TODO Sasha flatMat
    }

    @Override
    public Rate getCurrencyRate(String curCode) {
       return rates.get(curCode);
    }

    @Override
    public Rate getCurrencyRate(Currency currency) {
        return getCurrencyRate(currency.getCode());
    }

    @Override
    public List<Rate> getRateHistory(String curCode) {
        return historyRates.getOrDefault(curCode, new ArrayList<>());
    }

    @Override
    public List<Rate> getRateHistory(Currency currency) {
        return getRateHistory(currency.getCode());
    }

    @Override
    public void addRateToHistory(String curCode, Rate rate) {

        historyRates.merge(curCode, new ArrayList<>(List.of(rate)), (oldList, newList) -> {
            oldList.addAll(newList);
            return oldList;
        });
    }

    @Override
    public void addRateToHistory(Currency currency, Rate rate) {
        addRateToHistory(currency.getCode(), rate);
    }
}
