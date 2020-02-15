import java.util.Collection;

public class BlackMage implements Mage {
    private int manna;
    private MagicStick stick;
    private Collection<String> spells;

    public BlackMage(int strength, MagicStick stick){
        manna=strength;
        this.stick=stick;
    }

    public void setSpells(Collection<String> spells) {
        this.spells = spells;
    }

    @Override
    public void expeliarmus() {
        System.out.println("expeliarmus! ahahah");
    }

    @Override
    public void alohamora() {
        System.out.println("alohamora! Ha-ha-ha");
    }

    @Override
    public void resting() {
        manna+=5;
    }

    @Override
    public void autcast() {
        for(String spell:spells){
            System.out.println(spell);
        }
    }

    @Override
    public void intro() {
        System.out.println("i'n a black mage and this is my stick!"+"\n"+stick.info());
    }
}
