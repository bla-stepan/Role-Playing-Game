public class Trader implements Seller {

    @Override
    public String sell(Goods goods, int quantity, int gold) {
        int cost;
        String result = "";
        switch (goods) {
            case ZELIE:
                cost = 10;
                if (payCatch(cost, quantity, gold)) {
                    gold = -cost * quantity;
                    System.out.println(String.format("продано %d единиц %s остаток золота - %d", quantity, goods, gold));
                    result = "Z";
                } else {
                    System.out.println(String.format("недостаточно средств для покупки %d единиц %s", quantity, goods));
                    result = "";
                }
                return result;
            case MECH:
                cost = 10;
                if (payCatch(cost, quantity, gold)) {
                    gold = -cost * quantity;
                    System.out.println(String.format("продано %d единиц %s остаток золота - %d", quantity, goods, gold));
                    result = "M";
                } else {
                    System.out.println(String.format("недостаточно средств для покупки %d единиц %s", quantity, goods));
                    result = "";
                }
                return result;
            case SHLEM:
                cost = 10;
                if (payCatch(cost, quantity, gold)) {
                    gold = -cost * quantity;
                    System.out.println(String.format("продано %d единиц %s остаток золота - %d", quantity, goods, gold));
                    result = "S";
                } else {
                    System.out.println(String.format("недостаточно средств для покупки %d единиц %s", quantity, goods));
                    result = "";
                }
                return result;
            default:
                System.out.println("Такого товара нет в наличии");
        }
        return result;
    }

    public boolean payCatch(int cost, int pay, int quantity) {
        if (quantity > 0) {
            if (cost * quantity <= pay) return true;
            else return false;
        } else {
            System.out.println(String.format("Указано не верное количество %d", quantity));
            return false;
        }
    }


    public enum Goods {
        ZELIE, MECH, SHLEM
    }
}
