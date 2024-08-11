import staff.administration.Director;
import staff.administration.ProductionChief;
import staff.administration.SalesChief;
import staff.production.MachineOperator;
import staff.production.Merchendiser;
import staff.production.SalesManager;
import staff.production.StoreKeeper;

public class Main {
    public static void main(String[] args) {
        MachineOperator machineOperator = new MachineOperator();
        StoreKeeper storeKeeper = new StoreKeeper();
        SalesManager salesManager = new SalesManager();
        Merchendiser merchendiser = new Merchendiser();

        ProductionChief productionChief = new ProductionChief();
        productionChief.setOperator(machineOperator);
        productionChief.setStoreKeeper(storeKeeper);

        SalesChief salesChief = new SalesChief();
        salesChief.setManager(salesManager);
        salesChief.setMerchendiser(merchendiser);

        Director director = new Director();
        director.setProductionChief(productionChief);
        director.setSalesChief(salesChief);


        director.manageCompany();
    }
}
