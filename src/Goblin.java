public class Goblin extends Units{
    public Goblin(String name, int health, int dexterity, int experience, int power, int gold, int level) {
        super(name, health, dexterity, experience, power, gold, level);
        System.out.println(String.format(
                "Гоблин уровня - %d по имени %s с параметрами (здоровье: %d, ловкость: %d, опыт: %d, сила: %d, наличка: %d) к бою готов!",
                level, name, health, dexterity, experience, power, gold));

    }
}
