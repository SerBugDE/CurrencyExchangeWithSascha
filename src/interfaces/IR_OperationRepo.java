package interfaces;
/*
@date 28.11.2023
@author Sergey Bugaienko
*/

import model.Currency;
import model.Operation;
import model.TypeOperation;
import model.User;

import java.util.List;

public interface IR_OperationRepo {

    Operation createOperation(User user, TypeOperation typeOperation, double amountSell, Currency currencySell, double rateSell);

    void saveOperation(Operation operation);

    List<Operation> getUserOperations(User user);



}
