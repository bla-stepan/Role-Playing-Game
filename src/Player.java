public class Player extends Units{

    public Player(String name, int health, int dexterity, int experience, int power, int gold, int level) {
        super(name, health, dexterity, experience, power, gold, level);
        System.out.println(String.format(
                "Богатырь по имени %s с параметрами (здоровье: %d, ловкость: %d, опыт: %d, сила: %d, наличка: %d) к бою готов!",
                 name, health, dexterity, experience, power, gold));
    }

    public void playerUpgrade(String goods){

    }
}
