package classes;

import interfaces.iActorBehaviour;

public class TaxInspector implements iActorBehaviour {
    private String name;
    private boolean isTakeOrder;
    private boolean isMakeOrder;
    private boolean isReturnOrder;

    /**
     * @ name (const) = Tax auditor for that class
     */
    public TaxInspector() {
        this.name = "Tax auditor / Inspector";
    }

    public boolean isMakeOrder() {
        return isMakeOrder;
    }

    @Override
    public boolean isReturnOrder() {
        return isReturnOrder;
    }

    public boolean isTakeOrder() {
        return isTakeOrder;

    }

    public void setMakeOrder(boolean isMakeOrder) {
        this.isMakeOrder = isMakeOrder;
    }

    public void setTakeOrder(boolean isTakeOrder) {
        this.isTakeOrder = isTakeOrder;
    }
    public void setReturnOrder(boolean isReturnOrder){
        this.isReturnOrder = isReturnOrder;
    }

    public boolean getReturnOrder() {
        return this.isReturnOrder();
    }


    @Override
    public Actor getActor() {
        return new OrdinaryClient("Secret client", false);
    }

    @Override
    public boolean getIsPromotionClient() {
        return false;
    }

    @Override
    public Integer getIdPromotionBuyer() {
        return null;
    }

    @Override
    public int getMaxNumberOfParticipants() {
        return 0;
    }
}
