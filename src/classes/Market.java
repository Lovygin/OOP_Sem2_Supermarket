package classes;

import interfaces.iMarketBehaviour;
import interfaces.iQueueBehaviour;
import interfaces.iActorBehaviour;
import interfaces.iReturnOrder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Market implements iMarketBehaviour, iQueueBehaviour, iReturnOrder {
    private List<iActorBehaviour> queue;

    /**
     * @apiNote создает очередь обслуживания в магазине при его "открытии"
     */
    public Market() {
        this.queue = new ArrayList<iActorBehaviour>();
    }

    /**
     * @apiNote метод выводит информацию о том, что клиент пришел в магазин
     * и добавляет его в очередь на обслуживание
     * @param actor
     */
    @Override
    public void acceptToMarket(iActorBehaviour actor) {
        System.out.println("buyer " + actor.getActor().getName() + " пришел в магазин ");
        takeInQueue(actor);
    }

    /**
     * @apiNote метод добавляет клиента в очередь на обслуживание.
     * Выводит информацию о добавлении клиента в очередь
     * @param actor
     */
    @Override
    public void takeInQueue(iActorBehaviour actor) {
        this.queue.add(actor);
        System.out.println("buyer " + actor.getActor().getName() + " добавлен в очередь ");
    }

    /**
     * @apiNote Вывод информации о вышедшем из магазина покупателе
     * @param actor
     */
    @Override
    public void releaseFromMarket(iActorBehaviour actor) {
        System.out.println("buyer " + actor.getActor().getName() + " ушел из магазина ");
        //queue.remove(actor);
    }

    /**
     * @apiNote Создает список обслуженных клиентов, список участников в акции.
     * Перебирает покупателей находящихся в очереди на обслуживание.
     * Если клиенту нужно вернуть товар, то проводится возврат товара.
     * Если клиент хочет приобрести товар, то метод проверят, участвует ли клиент в акциях.
     * Если да, то проверяется, не превышает ли количество участников максимальное число участников в акции.
     * Если все условия соблюдены, то проводится акция, клиент получает товар по сниженной цене, об этом выводится информация.
     * Если условия не соблюдены, клиенту предлагается приобрести товар за полную стоимость (логика не дописана).
     * Если клиент в акции не участвует, то проводится покупка, получение товара, выход из очереди обслуживания и выход из магазина.
     * Информация обо всех операциях выводится на экран.
     */
    @Override
    public void update() {
        List<Actor> releaseActors = new ArrayList<>();
        HashSet<Integer> participantsOfAction = new HashSet<>();
        for (iActorBehaviour actor : queue) {
            if (!actor.getActor().isReturnOrder) {
                if (actor.getActor().getIsPromotionClient()) {
                    participantsOfAction.add(actor.getActor().getIdPromotionBuyer());
                    if (participantsOfAction.size() <= actor.getMaxNumberOfParticipants()) {
                        takeOrder(actor);
                        giveOrderForAction(actor);
                    } else {
                        System.out.println("Клиенту " + actor.getActor().getName() + " в проведении акции отказано." +
                                " Желаете приобрести товар за полную стоимость?...");
                    }
                } else {
                    takeOrder(actor);
                    giveOrder(actor);
                }
            } else {
                productOfferedForReview(actor);
            }
            releaseFromQueue(actor, releaseActors);
            if (releaseActors.contains(actor.getActor())) {
                releaseFromMarket(actor.getActor());
            }
        }
        if (releaseActors.containsAll(queue)) {
            queue.clear();
        }
    }

    /**
     * @apiNote метод делает возможным получение/оплату товара, если заказ был сделан.
     * Выводит информацию о получении заказа клиентом.
     * @param actor
     */
    @Override
    public void giveOrder(iActorBehaviour actor) {
        if (actor.getActor().isMakeOrder) {
            actor.setTakeOrder(true);
            System.out.println("buyer " + actor.getActor().getName() + " получил свой заказ ");
        }
    }

    /**
     * @apiNote Возвращает информацию о завершении обслуживания текущего клиента
     * и об его выходе из очереди обслуживаемых клиентов.
     * @param actor курируемый клиент
     * @param releaseActors - список обслуженных клиентов
     */
    @Override
    public void releaseFromQueue(iActorBehaviour actor, List<Actor> releaseActors) {
        if (actor.getActor().isTakeOrder) {
            releaseActors.add(actor.getActor());
            System.out.println("buyer " + actor.getActor().getName() + " ушел из очереди ");
        } else if (actor.getActor().isReturnOrder) {
            releaseActors.add(actor.getActor());
            System.out.println("client " + actor.getActor().getName() + " ушел из очереди ");
        }

    }

    /**
     * @apiNote Выводит информацию о завершении выбора товара и готовности клиента получить товар.
     * @param actor
     */
    @Override
    public void takeOrder(iActorBehaviour actor) {
        if (!actor.getActor().isMakeOrder) {
            actor.setMakeOrder(true);
            System.out.println("buyer " + actor.getActor().getName() + " сделал заказ ");
        }
    }

    /**
     * @apiNote выводит информацию об успешно проведенной акции для покупателя, участвующего в ней.
     * @param actor
     */
    @Override
    public void giveOrderForAction(iActorBehaviour actor) {
        if (actor.getActor().isMakeOrder) {
            actor.setTakeOrder(true);
            System.out.println("buyer " + actor.getActor().getName() + " получил свой заказ по сниженной цене ");
        }
    }

    /**
     * @apiNote выводит информацию об успешно проведенном возврате товара для курируемого клиента.
     * @param actor
     */
    @Override
    public void productOfferedForReview(iActorBehaviour actor) {
        System.out.println("client " + actor.getActor().getName() + " сдал товар");

    }
}
