package classes;

public class SpecialClient extends Actor {
    private int idVip;

    @Override
    String getName() {
        return super.name;
    }

    @Override
    void setName(String name) {
        super.name = name;
    }

    /**
     *
     * @param name
     * @param idVip индивидуальный номер
     * @param isReturnOrder флаг возвращения товара
     * @apiNote Конструктор специального клиента.
     */
    public SpecialClient(String name, int idVip, boolean isReturnOrder) {
        super(name, isReturnOrder);
        this.idVip = idVip;
    }

    /**
     *
     * @return флаг сделан ли заказ?
     */
    public boolean isMakeOrder(){
        return super.isMakeOrder;
    }

    /**
     *
     * @return флаг - будет ли покупатель возвращать товары
     */
    @Override
    public boolean isReturnOrder() {
        return super.isReturnOrder;
    }

    /**
     *
     * @return флаг - принят ли заказ
     */
    public boolean isTakeOrder(){
        return super.isTakeOrder;

    }
    public void setMakeOrder(boolean isMakeOrder){
        super.isMakeOrder = isMakeOrder;
    }

    public void setTakeOrder(boolean isTakeOrder){
        super.isTakeOrder = isTakeOrder;
    }
    public void setReturnOrder(boolean isReturnOrder){
        super.isReturnOrder = isReturnOrder;
    }
    public boolean getReturnOrder() {
        return super.isReturnOrder();
    }

    public Actor getActor(){
        return this; // ссылка на самого себя
    }
}
