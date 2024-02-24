package interfaces;

import classes.Actor;

import java.util.List;

public interface iQueueBehaviour {
    void takeInQueue(iActorBehaviour actor);
    void releaseFromQueue(iActorBehaviour actor, List<Actor> releaseActors);
    void takeOrder(iActorBehaviour actor);
    void giveOrder(iActorBehaviour actor);

}
