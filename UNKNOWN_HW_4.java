class Character {
    protected String Name;
    protected Integer HP;
    protected Integer MaxHP;
    public Character(String Name, Integer HP){
        this.Name = Name;
        this.HP = HP;
        this.MaxHP = HP;
        if (HP <= 0) {
            throw new CustomException("Здоровье указано в отрицательную сторону или указан ноль!");
        }
        if (Name.equals("")) {
            throw new CustomException("Не указанно имя персонажа!");
        }
    }

    public void Attack() {
        int DamageToInflict = 3 + (int) (Math.random() * ((17 - 3) + 1));
        System.out.println(this.Name + " ударил и нанёс кулаком " + DamageToInflict + " единиц урона.");
    }
    public void HelloText() {
        System.out.println("Привет, я " + Name + " - обычный человек.");
    }
    public void IssueDamage(Integer Damage) {
        this.HP -= Damage;
        if (this.HP<0) {
            System.out.println(this.Name + " получил " + Damage + " единиц урона и умер!");
            this.HP = -1000;
        } else {
            System.out.println(this.Name + " получил " + Damage + " единиц урона. Текущее здоровье: " + this.HP + " единиц.");
        }
    }
    public void Regenerate() {
        if (this.HP != -1000) {
            if (!this.HP.equals(this.MaxHP)) {
                int RandInt = 15 + (int) (Math.random() * ((30 - 15) + 1));
                this.HP += RandInt;
                if (this.HP > this.MaxHP) {
                    int A = this.HP - this.MaxHP;
                    int B = RandInt - A;
                    this.HP = this.MaxHP;
                    System.out.println(this.Name + " восстановил здоровье на " + B + " единиц. Здоровье уже полное.");
                } else {
                    System.out.println(this.Name + " восстановил здоровье на " + RandInt + " единиц. Текущее здоровье: " + this.HP + " единиц.");
                }
            } else {
                System.out.println("У " + this.Name + " полное здоровье восстановление здоровья не требуется.");
            }
        } else {
            System.out.println(this.Name + " уже умер и его не воскресить.");
        }
    }
    public static class CustomException extends RuntimeException{
        public CustomException(String ExceptionMessage) {
            super(ExceptionMessage);
        }
    }
}

class Wizard extends Character {
    protected Integer Mana;
    protected Integer MaxMana;
    protected String Name;
    public Wizard(String Name, Integer HP, Integer mana) {
        super(Name, HP);
        this.Name = Name;
        this.Mana = mana;
        this.MaxMana = mana;
        if (Mana < 0) {
            throw new CustomException("Мана указана в отрицательную сторону!");
        }
    }
    public void Attack() {
        if (this.Mana > 0) {
            int RandIntManaWaste = 3 + (int) (Math.random() * ((7 - 3) + 1));
            if (this.Mana >= RandIntManaWaste) {
                int DamageToInflict = RandIntManaWaste * 7;
                System.out.println(this.Name + " использовал магию и нанёс " + DamageToInflict + " единиц урона. Осталось " + this.Mana + " единиц маны.");
                this.Mana -= RandIntManaWaste;
            } else {
                int A = this.Mana - RandIntManaWaste;
                int B = RandIntManaWaste - A;
                int DamageToInflict = B * 7;
                System.out.println(this.Name + " использовал магию и нанёс " + DamageToInflict + " единиц урона. Маны не осталось.");
                this.Mana -= B;
            }
        } else {
            System.out.println("У " + this.Name + " нет маны для атаки.");
        }
    }
    public void HelloText() {
        System.out.println("Привет, я " + Name + " - маг.");
    }

}

class Archer extends Character{
    protected Integer Arrows;
    protected String Name;
    public Archer(String Name, Integer HP, Integer arrows) {
        super(Name, HP);
        this.Name = Name;
        this.Arrows = arrows;
        if (Arrows < 0) {
            throw new CustomException("Количество стрел указано в отрицательную сторону!");
        }
    }
    public void Attack() {
        if (this.Arrows>0) {
            this.Arrows -= 1;
            int DamageToInflict = 15 + (int) (Math.random() * ((27 - 15) + 1));
            System.out.println(this.Name + " выстрелили стрелой и нанёс " + DamageToInflict + " единиц урона. Осталось стрел: " + this.Arrows);
        } else {
            System.out.println("У " + this.Name + " нет стрел для выстрела.");
        }
    }
    public void HelloText() {
        System.out.println("Привет, я " + Name + " - лучник.");
    }
}

class TesterCharacter extends Character{
    protected String Name;
    public TesterCharacter(String Name, Integer HP) {
        super(Name, HP);
        this.Name = Name;
        if(!Name.equalsIgnoreCase("Test")){
            throw new TesterCharacterException(Name);
        }
    }
    public void HelloText() {
        System.out.println("Привет, я " + this.Name + " - тестовый персонаж.");
    }
    public static class TesterCharacterException extends RuntimeException{
        public TesterCharacterException(String Name){
            super("Невозможно создать тестового персонажа с именем: " + Name);
        }
    }
}

