package staff.administration;

public class Director {
    private SalesChief salesChief;
    private ProductionChief productionChief;

    public void setSalesChief(SalesChief salesChief) {
        this.salesChief = salesChief;
    }

    public void setProductionChief(ProductionChief productionChief) {
        this.productionChief = productionChief;
    }

    public void manageCompany(){
        salesChief.giveOrders();
        productionChief.giveOrders();
    }
}
