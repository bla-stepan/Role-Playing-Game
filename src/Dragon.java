public class Dragon extends Units{

    public Dragon(String name, int health, int dexterity, int experience, int power, int gold, int level) {
        super(name, health, dexterity, experience, power, gold, level);
//        System.out.println(String.format(
//                "Дракон уровня - %d по имени %s с параметрами (здоровье: %d, ловкость: %d, опыт: %d, сила: %d, наличка: %d) готов к атаке!",
//                level, name, health, dexterity, experience, power, gold));
    }
}
