package classes;

import interfaces.iActorBehaviour;
public abstract class Actor implements iActorBehaviour {
    protected String name;
    protected boolean isTakeOrder;
    protected boolean isMakeOrder;
    protected boolean isPromotionClient;

    public Actor(String name) {
        this.name = name;
    }

    @Override
    public boolean isReturnOrder() {
        return isReturnOrder;
    }

    protected boolean isReturnOrder;

    abstract String getName();
    abstract void setName(String name);

    public Actor(String name, boolean isReturnOrder) {
        this.name = name;
        this.isReturnOrder = isReturnOrder;
    }

    @Override
    public boolean getIsPromotionClient() {
        return isPromotionClient;
    }

    @Override
    public Integer getIdPromotionBuyer() {
        return getIdPromotionBuyer();
    }
    @Override
    public int getMaxNumberOfParticipants(){
        return getMaxNumberOfParticipants();
    }
}
