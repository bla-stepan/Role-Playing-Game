import java.io.BufferedReader;
import java.io.IOException;

public class Realm {
    //В этом классе у нас будут переменные, которые мы выносим на уровне класса, чтобы к ним был доступ из других методов:
    //создаем объект класса для чтения строк из консоли
    private static BufferedReader br;
    //сохраняем игрока на протяжении всей игры
    private static Units player = null;
    //класс для битны не создаем каждый раз а переиспользуем его - т.е. тоже сохраняем на период игры
    private static Battle battle = null;



    //в этом методе реализуем рекурсию
    private static void command(String str) throws IOException {
        //Если это первый запуск, то мы должны создать игрока, именем будет служить первая введенная строка из консоли
        if (player == null) {
            player = new Player(str, 100, 10, 0, 10, 0,1);

        }
    }

    public class FightCallback {

        public void fightWin(){}

        public  void fightLost(){}

    }

    //метод колбэк
}
