package Units;

public abstract class Shooter extends Hero { // стрелки
    protected int arrows;
    protected int maxArrows;
    protected int accuracy;

    protected Shooter(String name, int health, int[] damage, int armor, int arrows, int accuracy) {
        super(name, health, damage, armor);
        this.arrows = arrows;
        this.maxArrows = arrows;
        this.accuracy = accuracy;
    }


}
