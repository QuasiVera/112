package Units;

public class Spearman extends Infantry {  // копейщик
    public Spearman (String name){

        super(name, 12, new int [] {1,3}, 2, 2);
    }

    @Override
    public String getInfo() {
        return String.format("%s  tool: %d", super.getInfo(), this.tool);
    }


}
