package classes;

public class OrdinaryClient extends Actor {
    @Override
    String getName() {
        return super.name;
    }

    @Override
    void setName(String name) {
        super.name = name;
    }

    public OrdinaryClient(String name, boolean isReturnOrder) {
        super(name, isReturnOrder);
    }

    public boolean isMakeOrder() {
        return super.isMakeOrder;
    }

    @Override
    public boolean isReturnOrder() {
        return super.isReturnOrder;
    }

    public boolean isTakeOrder() {
        return super.isTakeOrder;

    }

    public void setMakeOrder(boolean isMakeOrder) {
        super.isMakeOrder = isMakeOrder;
    }

    public void setTakeOrder(boolean isTakeOrder) {
        super.isTakeOrder = isTakeOrder;
    }
    public void setReturnOrder(boolean isReturnOrder){
        super.isReturnOrder = isReturnOrder;
    }
    public boolean getReturnOrder() {
        return super.isReturnOrder();
    }


    public Actor getActor() {
        return this; // ссылка на самого себя
    }


}
