public abstract class Units implements Fighter {
    private String name;//имя персонажа
    private int health, dexterity, experience, power, gold, level;//здоровье, ловкость, опыт, сила, золото

    //конструктор юнита вариант 1
    public Units(String name, int health, int dexterity, int experience, int power, int gold, int level) {
        this.name = name;//имя
        this.health = health;//здоровье
        this.dexterity = dexterity;//ловкость
        this.experience = experience;//опыт
        this.power = power;//сила
        this.gold = gold;//золото
        this.level = level;//уровень
    }

    //переопределенный метод ведения боя
    @Override
    public int attack() {
        //условие силы
        if (dexterity * (3+level) > getRandomValue()) {
            if (Math.random()*10 % 2 == 0) {
                return power * 2;
            } else return power;
        //}else return power;
        } else return 0;
    }

    //метод случайного числа
    private  int getRandomValue(){
        return (int) (Math.random() * 100);
    }

    //геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getLevel() {
        return level;
    }

    public Units setLevel(int level) {
        this.level = level;
        return this;
    }

    //переопределяем метод печати имени и здоровья юнита
    @Override
    public String toString() {
        return String.format("%s здоровье:%d", name, health);
    }
}
