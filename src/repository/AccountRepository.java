package repository;
/*
@date 28.11.2023
@author Sergey Bugaienko
*/

import interfaces.IR_AccountRepo;
import model.*;
import model.Currency;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

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
        Account account = new Account(currentAccountId.getAndIncrement(), currency, user);
        accounts.merge(user.getId(), new ArrayList<>(List.of(account)), (oldList, newList) -> {
            oldList.addAll(newList);
            return oldList;
        });
        return account;
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

        if (!account.getCurrency().equals(operation.getCurrency())) return false;

        double balance = account.getBalance();

        if (operation.getType() == TypeOperation.BUY || operation.getType() == TypeOperation.DEPOSIT) {
            balance += operation.getAmount();
        } else {
            balance -= operation.getAmount();
        }

        if (balance < 0) return false;

        account.setBalance(balance);

        accountOperations.merge(account.getId(), new ArrayList<>(List.of(operation)),
                (oldList, newList) -> {
                    oldList.addAll(newList);
                    return oldList;
                });

        return true;
    }

    /**
     * История операция по счету
     * @param account
     * @return List<Operation>  for Account
     */
    @Override
    public List<Operation> getHistory(Account account) {
        return accountOperations.getOrDefault(account.getId(), new ArrayList<>());

//        if (accountOperations.containsKey(account.getId())){
////            return accountOperations.get(account.getId()).stream().toList();
//            return new ArrayList<>(accountOperations.get(account.getId()));
//        } else {
//            return null;
//        }
    }

    @Override
    public boolean deleteAccount(User user, Account account){
        return accounts.getOrDefault(user.getId(), new ArrayList<>()).remove(account);
    }

}
