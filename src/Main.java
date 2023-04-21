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
                    team1.add(new Sniper(team1,getName()));
                    break;
                case 2:
                    team1.add(new Witcher(team1,getName()));
                    break;
                case 3:
                    team1.add(new Spearman(team1,getName()));
                    break;
                case 4:
                    team1.add(new Peasant(team1,getName()));
                    break;
            }
        }

        for (int i = 0; i < teamSize; i++) {
            switch (new Random().nextInt(1,5)){
                case 1:
                    team2.add(new Arbalester(team2,getName()));
                    break;
                case 2:
                    team2.add(new Monk(team2, getName()));
                    break;
                case 3:
                    team2.add(new Bandit(team2,getName()));
                    break;
                case 4:
                    team2.add(new Peasant(team2,getName()));
                    break;
            }
        }


        //team1.forEach(unit-> System.out.println(unit.getInfo()));
        System.out.println("-------");
        team2.forEach(unit-> System.out.println(unit.getInfo()));
        //team2.forEach(unit->unit.step());
        team2.forEach(unit-> System.out.println(unit.getInfo()));
        team2.sort(Hero::compareTo);
        System.out.println(team2);


    }

    static String getName(){
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length)]);
    }

}