package service;
/*
@date 28.11.2023
@author Sergey Bugaienko
*/

import repository.AccountRepository;
import repository.CurrencyRepository;
import repository.OperationRepository;

public class CurrencyService {
    private final CurrencyRepository currencyRepo;
    private final AccountRepository accountRepo;

    private final OperationRepository operationRepo;

    public CurrencyService(CurrencyRepository currencyRepo, AccountRepository accountRepo, OperationRepository operationRepo) {
        this.currencyRepo = currencyRepo;
        this.accountRepo = accountRepo;
        this.operationRepo = operationRepo;
    }
}
