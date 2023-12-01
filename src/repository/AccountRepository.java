package repository;
/*
@date 28.11.2023
@author Sergey Bugaienko
*/

import model.Account;
import model.Operation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class AccountRepository {
    private final AtomicInteger currentAccountId = new AtomicInteger(1);

    private final Map<Integer, List<Account>> accounts; // Map<userId, List<Account>>
    private final Map<Integer, List<Operation>> accountOperations; // Map<accountId, List<Operation>>

    public AccountRepository() {
        this.accounts = new HashMap<>();
        this.accountOperations = new HashMap<>();
    }
}
