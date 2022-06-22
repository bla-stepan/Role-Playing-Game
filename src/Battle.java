public class Battle {
    //Метод, который вызывается при начале боя, сюда мы передаем ссылки на нашего героя и монстра, который встал у него на пути
    public void fight(Units player, Units monster, Realm.FightCallback fightCallback) {//надо добавить еще какой-то объект
        //ходы будут идти в отдельном потоке (с помощью интерфейчас runnadle)
        Runnable runnable = () -> {
            int turn = 1;//номер хода
            boolean isFightEnded = false;//проверка на окончание боя
            while (!isFightEnded) {
                //печатаем номер ходы
                System.out.println("=====ход -" + turn + "=====");
                //логика смены нападающей стороны
                if (turn++ % 2 != 0) {
                    isFightEnded = makeHit(player, monster, fightCallback);
                } else {
                    isFightEnded = makeHit(monster, player, fightCallback);
                }

                //чтобы бой не проходил за секунду, немного поспим
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        //запускаем новый поток
        Thread thread = new Thread(runnable);
        thread.start();
    }

    //метод для совершения удара
    private boolean makeHit(Units defender, Units attacker, Realm.FightCallback fightCallback){
        //получаем силу удара
        int hit = attacker.attack();
        //получаем здоровье обороняющегося
        int defenderHealth = defender.getHealth();
        if(hit!=0){
            //пишем ход атакующего
            System.out.println(String.format("%s нанес удар в %d единиц.", attacker.getName(), hit));
            //пишем ход обороняющегося
            System.out.println(String.format("У %s осталось %d единиц здоровья.", defender.getName(), defenderHealth));
        }else {
            System.out.println(String.format("%s промахнулся!", attacker.getName()));
        }
        //проверяем
        if(defenderHealth<=0 && defender instanceof Player){
            System.out.println(String.format("Богатырь %s пал в бою!", defender.getName()));
            //тут надо дописать метод колбэк
            fightCallback.fightLost();
            return true;
        }else if (defenderHealth<=0){
            String.format("%s был повержен! %s получает %d опыта и %d золота!", defender.getName(), defender.getExperience(), defender.getGold());
            attacker.setExperience(attacker.getExperience()+defender.getExperience());
            attacker.setGold(attacker.getGold()+defender.getGold());
            //тут пишем метод колбэк
            fightCallback.fightWin();
            return true;
        }else {
            //если защищающийся не повержен, то мы устанавливаем ему новый уровень здоровья
            defender.setHealth(defenderHealth);
            return false;
        }
    }
}
