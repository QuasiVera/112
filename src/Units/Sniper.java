package Units;

public class Sniper extends Shooter {
    public Sniper(String name) {
        super(name, 1, new int [] {1,1}, 1, 1,1);
    }

    @Override
    public String toString() {
        return String.format("%s  arrows: %d  accuracy: %d",
                super.getInfo(), this.arrows, this.accuracy);
    }
}
