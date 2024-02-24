package classes;

import java.util.HashSet;

public class PromotionClient extends  Actor {
    private String nameOfPromotion; // Название акции
    private boolean isPromotionClient = true;
    private Integer idPromotionBuyer;
    private  static int maxNumberOfParticipants = 3; //Максимальное количество участников акции
    //private HashSet<Integer> participants; // Список участников акции

    public boolean isPromotionClient() {
        return isPromotionClient;
    }

    public boolean getIsPromotionClient() {
        return isPromotionClient;
    }

    public void setPromotionClient(boolean promotionClient) {
        isPromotionClient = promotionClient;
    }


    public PromotionClient(String name, Integer idPromotionBuyer) {
        super(name);
        this.idPromotionBuyer = idPromotionBuyer;
        super.isReturnOrder = false;
    }
    public PromotionClient(String name, int idPromotionBuyer, boolean isReturnOrder) {
        super(name, isReturnOrder);
        this.idPromotionBuyer = idPromotionBuyer;
    }

    public Integer getIdPromotionBuyer() {
        return idPromotionBuyer;
    }

    public void setIdPromotionBuyer(Integer idPromotionBuyer) {
        this.idPromotionBuyer = idPromotionBuyer;
    }

    public void setNameOfPromotion(String nameOfPromotion) {
        this.nameOfPromotion = nameOfPromotion;
    }

    public int getMaxNumberOfParticipants() {
        return maxNumberOfParticipants;
    }


    public void setMaxNumberOfParticipants(int maxNumberOfParticipants) {
        PromotionClient.maxNumberOfParticipants = maxNumberOfParticipants;
    }

    @Override
    String getName() {
        return super.name;
    }

    @Override
    void setName(String name) {
        super.name = name;
    }


    public boolean isMakeOrder(){
        return super.isMakeOrder;
    }

    @Override
    public boolean isReturnOrder() {
        return super.isReturnOrder;
    }

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
