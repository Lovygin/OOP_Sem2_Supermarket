import classes.*;
//import classes.TaxInspector;
//import interfaces.iActorBehaviour;


public class Main {
    public static void main(String[] args) {
        Market crossroads = new Market();
        Actor buyer1 = new OrdinaryClient("Alex", false);
        Actor buyer2 = new OrdinaryClient("Kathrine", false);
        Actor buyer3 = new SpecialClient("Vladimir Vladimirovich", 666, true);
        PromotionClient buyer6 = new PromotionClient("Mikhail Alexeyevich", 2, false);
        PromotionClient buyer7 = new PromotionClient("Irina Gennadievna", 3, false);
        PromotionClient buyer5 = new PromotionClient("Alexey Mikhailovich", 1, false);
        Actor buyer8 = new OrdinaryClient("Marina", false);
        TaxInspector buyer4 = new TaxInspector();

        buyer5.setMaxNumberOfParticipants(2);
        buyer5.setNameOfPromotion("Promotion for pensioners");

        crossroads.acceptToMarket(buyer1);
        crossroads.acceptToMarket(buyer2);
        crossroads.acceptToMarket(buyer3);

        crossroads.acceptToMarket(buyer4);
        crossroads.acceptToMarket(buyer5);
        crossroads.acceptToMarket(buyer6);
        crossroads.acceptToMarket(buyer7);
        crossroads.acceptToMarket(buyer8);


        crossroads.update();




    }
}