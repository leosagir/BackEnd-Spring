package staff.administration;

import staff.production.Merchendiser;
import staff.production.SalesManager;

public class SalesChief {
    private SalesManager manager;
    private Merchendiser merchendiser;

    public void setManager(SalesManager manager) {
        this.manager = manager;
    }

    public void setMerchendiser(Merchendiser merchendiser) {
        this.merchendiser = merchendiser;
    }
    public void giveOrders(){
        manager.work();
        merchendiser.work();
    }
}

