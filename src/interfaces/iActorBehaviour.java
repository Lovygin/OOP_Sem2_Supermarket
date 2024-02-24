package interfaces;

import classes.Actor;

public interface iActorBehaviour {
    public boolean isTakeOrder();
    public boolean isMakeOrder();
    public boolean isReturnOrder();
    public void setTakeOrder(boolean val);
    public void setMakeOrder(boolean val);
    public void setReturnOrder(boolean val);
    public Actor getActor();

    boolean getIsPromotionClient();
    Integer getIdPromotionBuyer();
    int getMaxNumberOfParticipants();
}
