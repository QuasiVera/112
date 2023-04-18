import Units.*;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    /*   Создать иерархию классов для персонажей
     *  Крестьянин*	Разбойник*	Снайпер*	Колдун*
        копейщик*	арбалетчик*	монах*
     */
    public static void main(String[] args) {
        ArrayList<Hero> team1 = new ArrayList<>();
        ArrayList<Hero> team2 = new ArrayList<>();



        int teamSize = 10;

        for (int i = 0; i < teamSize; i++) {                // написать метод
            switch (new Random().nextInt(1,5)){
                case 1:
                    team1.add(new Sniper("Vasily"));
                    break;
                case 2:
                    team1.add(new Witcher("Stephen"));
                    break;
                case 3:
                    team1.add(new Spearman("Sergey"));
                    break;
                case 4:
                    team1.add(new Peasant("Fedor"));
                    break;
            }
        }

        for (int i = 0; i < teamSize; i++) {
            switch (new Random().nextInt(1,5)){
                case 1:
                    team2.add(new Sniper("Vasily"));
                    break;
                case 2:
                    team2.add(new Witcher("Stephen"));
                    break;
                case 3:
                    team2.add(new Spearman("Sergey"));
                    break;
                case 4:
                    team2.add(new Peasant("Fedor"));
                    break;
            }
        }

        team1.forEach(unit-> System.out.println(unit.getInfo()));
        System.out.println("-------");
        team2.forEach(unit-> System.out.println(unit.getInfo()));

//
//        Hero hero1 = new Sniper("Vasily");
//        Hero hero2 = new Spearman("Gregory");
//        Hero hero3 = new Witcher("Stephen");
//        Hero hero4 = new Bandit("Midori");


//        System.out.println(hero1.toString());
//        System.out.println(hero2.toString());
//        System.out.println(hero3.toString());
//        System.out.println(hero4.toString());



    }
}