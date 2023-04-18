package Units;

public class Monk extends Magian{
    public Monk(String name) {

        super(name, 13, new int [] {1,4}, 3, 3,1);
    }

    @Override
    public String getInfo() {
        return String.format("%s  mana: %d  accuracy: %d",
                super.getInfo(), this.mana, this.accuracy);
    }


}
