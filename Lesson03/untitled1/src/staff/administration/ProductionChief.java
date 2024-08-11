package staff.administration;

import staff.production.MachineOperator;
import staff.production.StoreKeeper;

public class ProductionChief {
    private MachineOperator operator;
    private StoreKeeper storeKeeper;

    public void setOperator(MachineOperator operator) {
        this.operator = operator;
    }

    public void setStoreKeeper(StoreKeeper storeKeeper) {
        this.storeKeeper = storeKeeper;
    }
    public void giveOrders(){
        operator.work();
        storeKeeper.work();
    }
}
