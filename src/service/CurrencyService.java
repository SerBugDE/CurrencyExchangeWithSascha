package service;
/*
@date 28.11.2023
@author Sergey Bugaienko
*/

import interfaces.IS_CurrencyService;
import model.*;
import repository.AccountRepository;
import repository.CurrencyRepository;
import repository.OperationRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CurrencyService implements IS_CurrencyService {
    private final CurrencyRepository currencyRepo;
    private final AccountRepository accountRepo;

    private final OperationRepository operationRepo;

    public CurrencyService(CurrencyRepository currencyRepo, AccountRepository accountRepo, OperationRepository operationRepo) {
        this.currencyRepo = currencyRepo;
        this.accountRepo = accountRepo;
        this.operationRepo = operationRepo;
    }

    public List<Account> getUserAccounts(User user){
        return accountRepo.getAllUsersAccounts(user);
    }

    public Currency getCurrencyByCode(String curCode){
        return currencyRepo.getCurrencyByCode(curCode);
    }

    @Override
    public List<Currency> getAllCurrencies() {
        //Todo Sasha
    }

    @Override
    public Map<String, Rate> getRates() {
        //TODO думать. В репо нет метода
    }

    @Override
    public double getCurrencyRate(Currency currency) {
        return currencyRepo.getCurrencyRate(currency).getRate();
    }

    @Override
    public List<Rate> getRateHistory(Currency currency) {
        //TODO Sasha
    }

    @Override
    public Account createAccount(User user, Currency currency) {
        //TODO Реализовать проверку на существование аккаунта
        // Или проверка должна быть в методах, которые будут вызывать этот метод, например при обмене валюты или депозите
        return accountRepo.createAccount(user, currency);
    }

    public Optional<Account> getAccountByCurrency(User user, Currency currency) {
        return accountRepo.getUserAccountByCurrency(user, currency);
    }

    @Override
    public boolean changeBalanceAccount(Account account, Operation operation) {
        return accountRepo.applyOperation(account, operation);
    }

    @Override
    public Operation createOperation(User user, TypeOperation typeOperation, double amount, Currency currency, double rate) {
        return operationRepo.createOperation(user, typeOperation, amount, currency, rate);
    }

    @Override
    public boolean saveOperation(Operation operation) {
        //TODO поменять на void??
        operationRepo.saveOperation(operation);
        return true;

    }

    @Deprecated
    @Override
    public boolean saveHistory(Operation operation) {
        //TODO Не знаю зачем метод)
        return false;
    }

    @Deprecated
    @Override
    public boolean saveHistory(List<Operation> operations) {
        //TODO Не знаю зачем метод)
        return false;
    }

    @Override
    public List<Operation> getOperationsHistory(User user) {
        // TODO Sasha
    }

    public boolean deleteAccount(User user, Account account){
        return accountRepo.deleteAccount(user, account);
    }



}
