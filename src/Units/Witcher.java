package Units;

public class Witcher extends Magian {
    public Witcher(String name) {

        super(name, 13, new int [] {1,3}, 3, 3,1);
    }

    @Override
    public String toString() {
        return String.format("%s  mana: %d  accuracy: %d",
                super.getInfo(), this.mana, this.accuracy);
    }
}
