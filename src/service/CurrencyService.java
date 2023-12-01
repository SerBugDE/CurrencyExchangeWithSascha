package service;
/*
@date 28.11.2023
@author Sergey Bugaienko
*/

import model.Account;
import model.Currency;
import model.User;
import repository.AccountRepository;
import repository.CurrencyRepository;
import repository.OperationRepository;

import java.util.List;
import java.util.Optional;

public class CurrencyService {
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

    public Optional<Account> getAccountByCurrency(User user, Currency currency) {
        return accountRepo.
    }

}
