public class OwnedMagicStick implements MagicStick {
    public int length;
    public String treeType;
    public String core;

    public OwnedMagicStick(){

    }

    public void setCore(String core) {
        this.core = core;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setTreeType(String treeType) {
        this.treeType = treeType;
    }

    @Override
    public String info(){
        String description="length: "+length+"\n"+"tree type: "+treeType+"\n"+"core: "+core;
        return description;
    }
}
