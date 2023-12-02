package repository;
/*
@date 28.11.2023
@author Sergey Bugaienko
*/

import interfaces.IR_AccountRepo;
import model.Account;
import model.Currency;
import model.Operation;
import model.User;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class AccountRepository implements IR_AccountRepo {
    private final AtomicInteger currentAccountId = new AtomicInteger(1);

    private final Map<Integer, List<Account>> accounts; // Map<userId, List<Account>>
    private final Map<Integer, List<Operation>> accountOperations; // Map<accountId, List<Operation>>

    public AccountRepository() {
        this.accounts = new HashMap<>();
        this.accountOperations = new HashMap<>();
    }

    @Override
    public Account createAccount(User user, Currency currency) {
        return null;
        //TODO Sasha
    }

    @Override
    public List<Account> getAllUsersAccounts(User user){
        return accounts.getOrDefault(user.getId(), new ArrayList<>());
    }

    @Override
    public Optional<Account> getUserAccountByCurrency(User user, Currency currency){
        return accounts.getOrDefault(user.getId(), new ArrayList<>()).stream()
                .filter(a -> a.getCurrency().equals(currency)).findFirst();
    }

    @Override
    public boolean applyOperation(Account account, Operation operation) {
        //TODO Serg
        return false;
    }

    /**
     * История операция по счету
     * @param account
     * @return
     */
    @Override
    public List<Operation> getHistory(Account account) {
        if (accountOperations.containsKey(account.getId())){
            return accountOperations.get(account.getId()).stream().toList();
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteAccount(User user, Account account){
        return accounts.getOrDefault(user.getId(), new ArrayList<>()).remove(account);
    }

}
