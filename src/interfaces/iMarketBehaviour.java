package interfaces;

import classes.Actor;

import java.util.List;

public interface iMarketBehaviour {
    void acceptToMarket(iActorBehaviour actor);
    void releaseFromMarket(iActorBehaviour actor);
    void update();

    void giveOrderForAction(iActorBehaviour actor);
}
