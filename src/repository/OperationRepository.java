package repository;
/*
@date 28.11.2023
@author Sergey Bugaienko
*/

import interfaces.IR_OperationRepo;
import model.Currency;
import model.Operation;
import model.TypeOperation;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class OperationRepository implements IR_OperationRepo {
    private final AtomicInteger currentOperationId = new AtomicInteger(1);

    private final List<Operation> operations;

    public OperationRepository() {
        this.operations = new ArrayList<>();
    }

    @Override
    public Operation createOperation(User user, TypeOperation typeOperation, double amount, Currency currency, double rate) {
        Operation operation = new Operation(
                currentOperationId.getAndIncrement(), user, typeOperation, amount, currency, rate);

        return operation;
    }

    @Override
    public void saveOperation(Operation operation) {
        operations.add(operation);
    }

    @Override
    public List<Operation> getUserOperations(User user) {
        return operations.stream()
                .filter(Objects::nonNull)
                .filter(operation -> operation.getUser().getId() == user.getId())
                .toList();
        //TODO Sasha
    }
}
