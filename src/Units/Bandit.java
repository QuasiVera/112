package Units;

public class Bandit extends Infantry{
    protected int invisibility; // невидимость, может и не надо, пусть пока будет

    public Bandit(String name, int health, int[] damage, int armor, int tool, int invisibility) {
        super(name, health, damage, armor, tool);
        this.invisibility = invisibility;
    }
    public Bandit(String name) {
        this(name, 10, new int [] {1,3}, 1, 2,4);
    }

    @Override
    public String getInfo() {
        return String.format("%s  invisibility: %d", super.getInfo(), this.invisibility);
    }
}
