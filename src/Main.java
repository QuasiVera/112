import Units.*;

public class Main {
    /*   Создать иерархию классов для персонажей
     *  Крестьянин	Разбойник*	Снайпер*	Колдун*
        копейщик*	арбалетчик	монах
     */
    public static void main(String[] args) {
        Hero hero1 = new Sniper("Vasily");
        Hero hero2 = new Spearman("Gregory");
        Hero hero3 = new Witcher("Stephen");
        Hero hero4 = new Bandit("Midori");
        hero4.attack(hero3);
        System.out.println(hero1.toString());
        System.out.println(hero2.toString());
        System.out.println(hero3.toString());
        System.out.println(hero4.toString());

    }
}