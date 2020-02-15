import java.util.Collection;

public class WhiteMage implements Mage {
    private int manna;
    private MagicStick stick;
    private Collection<String> spells;

    public WhiteMage(int strength, MagicStick stick){
        manna=strength;
        this.stick=stick;

    }

    public void setSpells(Collection<String> spells) {
        this.spells = spells;
    }

    @Override
    public void expeliarmus() {
        System.out.println("expeliarmus!");
    }

    @Override
    public void alohamora() {
        System.out.println("alohamora!");
    }

    @Override
    public void resting() {
        manna+=6;
    }

    @Override
    public void autcast() {
        for(String spell:spells){
            System.out.println(spell);
        }
    }

    @Override
    public void intro() {
        System.out.println("i'n a white mage and this is my stick!"+"\n"+stick.info());
    }
}
