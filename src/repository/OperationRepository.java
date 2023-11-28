package repository;
/*
@date 28.11.2023
@author Sergey Bugaienko
*/

import model.Operation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class OperationRepository {
    private final AtomicInteger currentOperationId = new AtomicInteger(1);

    private final List<Operation> operations;

    public OperationRepository() {
        this.operations = new ArrayList<>();
    }
}
