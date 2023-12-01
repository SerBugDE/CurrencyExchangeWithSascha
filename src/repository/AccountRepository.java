package repository;
/*
@date 28.11.2023
@author Sergey Bugaienko
*/

import model.Account;
import model.Currency;
import model.Operation;
import model.User;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class AccountRepository {
    private final AtomicInteger currentAccountId = new AtomicInteger(1);

    private final Map<Integer, List<Account>> accounts; // Map<userId, List<Account>>
    private final Map<Integer, List<Operation>> accountOperations; // Map<accountId, List<Operation>>

    public AccountRepository() {
        this.accounts = new HashMap<>();
        this.accountOperations = new HashMap<>();
    }

    public List<Account> getAllUsersAccounts(User user){
        return accounts.getOrDefault(user.getId(), new ArrayList<>());
    }

    public Optional<Account> getUserAccountByCurrency(User user, Currency currency){
        return accounts.getOrDefault(user.getId(), new ArrayList<>()).stream()
                .filter(a -> a.getCurrency().equals(currency)).findFirst();
    }

    public boolean deleteAccount(User user, Account account){
        return accounts.getOrDefault(user.getId(), new ArrayList<>()).remove(account);
    }

}
