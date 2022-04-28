package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    private FruitTransactionDao fruitTransactionDao;

    public PurchaseOperationHandler(FruitTransactionDao fruitTransactionDao) {
        this.fruitTransactionDao = fruitTransactionDao;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        FruitTransaction fruitTransactionFromDb = fruitTransactionDao.get(transaction.getFruit());
        fruitTransactionFromDb.setQuantity(fruitTransactionFromDb.getQuantity()
                - transaction.getQuantity());
        fruitTransactionDao.update(fruitTransactionFromDb);
    }
}
