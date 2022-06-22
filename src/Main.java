import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {//Realm
    private static BufferedReader br;
    private static Units player = null;
    private static Battle battle=null;

    public static void main(String[] args) {
        //инициируем чтение BufferedReader
        br = new BufferedReader(new InputStreamReader(System.in));
        //инициируем класс для боя
        battle = new Battle();
        //просим ввести имя игрока
        System.out.println("Введите имя игрока:");
        try {
            command(br.readLine());//обвернуть в метод комманд ошибка
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //в этом методе реализуем рекурсию в метод будет передаваться буферридер
    private static void command(String str) throws IOException {
        //Если это первый запуск, то мы должны создать игрока, именем будет служить первая введенная строка из консоли
        if (player == null) {
            player = new Player(str, 100, 10, 0, 10, 0, 1);
            String.format("Спасти наш мир от драконов и леших вызвался богатырь %s!", player.getName());
            //отдельным методом выводим меню
            printMenu();
        }
        //варианты команд
        switch (br.readLine()) {
            case "1": {
                System.out.println("торговец еще не приехал");
                //player.sell();
                command(br.readLine());
            }
            break;
            case "2": {
                commitFight();//ошибка
            }
            break;
            case "3": {
                System.exit(1);
            }
            break;
            case "да": {
                command("2");
            }
            break;
            case "нет": {
                printMenu();
                command(br.readLine());
            }
        }
        //снова ждем команды от пользователя
        command(br.readLine());
    }

    interface Callback {
        void Lost();

        void Win();
    }

    //метод реализации боевой логики
    private static void commitFight() {
        //запускаем объект и вызываем метод битвы
        //Units monster = creatMonster();
        battle.fight(player, creatMonster(), new Callback() {
            @Override
            public void Lost() {
                System.out.println(String.format("Увы, богатырь %s пал на поле брани смертью храбрых.", player.getName()));
                System.exit(0);
            }

            @Override
            public void Win() {
                System.out.println(String.format("%s победил! Параметры %s - здоровье: %d, ловкость: %d, опыт: %d, сила: %d, наличка: %d, уровень: %d",
                        player.getName(), player.getName(), player.getHealth(), player.getDexterity(), player.getExperience(),
                        player.getPower(), player.getGold(), player.getLevel()));
                System.out.println(String.format("Желает ли богатырь %s продолжить вершить подвиги? (да/нет)", player.getName()));
                try {
                    command(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static Units creatMonster() {
        //рандомим появление монстра
        if (Math.random() * 10 % 2 == 0) return new Goblin("Чудо Юдо поганое", 100, 5, 1, 10, 50, 1);
        else return new Dragon("Змей Горыныч", 100, 10, 1, 15, 100, 1);

    }

    //меню
    private static void printMenu() {
        System.out.println("Куда вы хотите пойти?");
        System.out.println("1. К торговцу.");
        System.out.println("2. В темный лес.");
        System.out.println("3. Да ну Вас! Пойду на печи полежу.");
    }


}
