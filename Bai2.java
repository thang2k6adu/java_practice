abstract class BaseCharacter {
    protected String name;
    protected int hp;
    protected int baseDamage;

    public BaseCharacter(String name, int hp, int baseDamage) {
        this.name = name;
        this.hp = hp;
        this.baseDamage = baseDamage;
    }

    public abstract void attack();
}

class Warrior extends BaseCharacter {
    public Warrior(String name, int hp, int baseDamage) {
        super(name, hp, baseDamage);
    }

    @Override
    public void attack() {
        System.out.println(name + " dùng vũ khí cận chiến tấn công! Sát thương: " + baseDamage);
    }
}

class Archer extends BaseCharacter {
    public Archer(String name, int hp, int baseDamage) {
        super(name, hp, baseDamage);
    }

    @Override
    public void attack() {
        System.out.println(name + " bắn mũi tên từ xa! Sát thương: " + baseDamage);
        longRangeAttack();
    }

    private void longRangeAttack() {
        System.out.println(name + " thực hiện tấn công tầm xa bổ sung!");
    }
}

class Mage extends BaseCharacter {
    public Mage(String name, int hp, int baseDamage) {
        super(name, hp, baseDamage);
    }

    @Override
    public void attack() {
        System.out.println(name + " thi triển phép thuật! Sát thương: " + baseDamage);
        castSpell();
    }

    private void castSpell() {
        System.out.println(name + " sử dụng kỹ năng phép thuật bổ sung!");
    }
}

class ArcaneArcher extends BaseCharacter {
    public ArcaneArcher(String name, int hp, int baseDamage) {
        super(name, hp, baseDamage);
    }

    @Override
    public void attack() {
        System.out.println(name + " bắn mũi tên phép tấn công! Sát thương: " + baseDamage);
        longRangeAttack();
        castSpell();
    }

    private void longRangeAttack() {
        System.out.println(name + " thực hiện tấn công tầm xa bổ sung!");
    }

    private void castSpell() {
        System.out.println(name + " sử dụng phép thuật bổ sung!");
    }
}

public class SimpleRPG {
    public static void main(String[] args) {
        BaseCharacter[] characters = new BaseCharacter[] {
            new Warrior("Leon", 100, 15),
            new Archer("Robin", 80, 12),
            new Mage("Merlin", 70, 20),
            new ArcaneArcher("Luna", 75, 14)
        };

        for (BaseCharacter character : characters) {
            character.attack();
            System.out.println("---");
        }
    }
}
