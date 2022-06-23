public class Trader implements Seller{

    public void sell(String goods, Units player) {
        int gold = player.getGold();
        int cost;
        //String result = "";
        switch (goods) {
            case "зелье"://улучшает здоровье
                cost = 10;
                if (payCatch(cost, gold)) {
                    player.setGold(player.getGold() - cost);
                    player.setHealth(player.getHealth() + 100);
                    System.out.println(String.format("продано %s богатырь прокачен (ЗДОРОВЬЕ: %d, остаток золота: %d)", goods, player.getHealth(), player.getGold()));
                } else {
                    System.out.println(String.format("недостаточно средств для покупки %s", goods));
                }
                break;
            case "меч"://улучшает силу удара
                cost = 20;
                if (payCatch(cost, gold)) {
                    player.setGold(player.getGold() - cost);
                    player.setDexterity(player.getDexterity() + 15);
                    System.out.println(String.format("продано %s богатырь прокачен (ЛОВКОСТЬ: %d, остаток золота: %d)", goods, player.getDexterity(), player.getGold()));
                    //result = "M";
                } else {
                    System.out.println(String.format("недостаточно средств для покупки %s", goods));
                }
                break;
            case "щит":
                cost = 30;
                if (payCatch(cost, gold)) {
                    player.setGold(player.getGold() - cost);
                    player.setExperience(player.getExperience() + 25);
                    System.out.println(String.format("продано %s богатырь прокачен (ОПЫТ: %d, остаток золота: %d)", goods, player.getExperience(), player.getGold()));
                } else {
                    System.out.println(String.format("недостаточно средств для покупки %s", goods));
                }
                break;
            default:
                System.out.println("К сожалению у нат нет какого товара.");

        }
    }

    public boolean payCatch(int cost, int pay) {
        if (cost <= pay) return true;
        else return false;
    }
}
