import Units.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    /*   Создать иерархию классов для персонажей
     *  Крестьянин*	Разбойник*	Снайпер*	Колдун*
        копейщик*	арбалетчик*	монах*
     */
    public static ArrayList<Hero> team1 = new ArrayList<>();
    public static ArrayList<Hero> team2 = new ArrayList<>();
    public static ArrayList<Hero> allTeam = new ArrayList<>();

    public static void main(String[] args) {


        int teamSize = 10;

        for (int i = 1; i < teamSize+1; i++) {                // написать метод
            switch (new Random().nextInt(1,5)){
                case 1:
                    team1.add(new Sniper(team1,getName(),1,i));
                    break;
                case 2:
                    team1.add(new Witcher(team1,getName(), 1,i));
                    break;
                case 3:
                    team1.add(new Spearman(team1,getName(), 1, i));
                    break;
                case 4:
                    team1.add(new Peasant(team1,getName(),1,i));
                    break;
            }
        }

        for (int i = 1; i < teamSize+1; i++) {
            switch (new Random().nextInt(1,5)){
                case 1:
                    team2.add(new Arbalester(team2,getName(), 10, i));
                    break;
                case 2:
                    team2.add(new Monk(team2, getName(), 10, i));
                    break;
                case 3:
                    team2.add(new Bandit(team2,getName(), 10, i));
                    break;
                case 4:
                    team2.add(new Peasant(team2,getName(), 10, i));
                    break;
            }
        }
        allTeam.addAll(team1);
        allTeam.addAll(team2);
        allTeam.sort(Hero::compareTo);

        Scanner in = new Scanner(System.in);
        while (true){

            View.view();
            in.nextLine();
            for (Hero hero : allTeam){
                if (team1.contains(hero)){
                    hero.step(team1,team2);
                }else hero.step(team2, team1);
            }

        }



//        System.out.println("-------команда 1");
//        team1.forEach(unit-> System.out.println(unit.getInfo()));
//        System.out.println("-------команда 2");
//        team2.forEach(unit-> System.out.println(unit.getInfo()));
//        System.out.println("---");
//        // all.sort(Hero::compareTo);
//        //all.forEach(unit->unit.step(team1,team2 ));
//        team1.forEach(unit->unit.step(team2,team1 ));
//        team2.forEach(unit->unit.step(team1,team2 ));
//        System.out.println("после атаки \n --------команда 1");
//        team1.forEach(unit-> System.out.println(unit.getInfo()));
//        System.out.println("------- команда 2");
//        team2.forEach(unit-> System.out.println(unit.getInfo()));
//
////        all.sort(new InitComparator());
////        System.out.println(all);


    }

    static String getName(){
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length)]);
    }

}