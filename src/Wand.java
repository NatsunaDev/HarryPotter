package HarryPotter;

public class Wand {
    private int size;
    private Core core;

    public Wand(int size, Core core) {
        this.size = size;
        this.core = core;
    }
}


enum Core {
    PHOENIX_FEATHER,
    DRAGON_HEARTSTRING,
    UNICORN_TAIL_HAIR,
    VEELA_HAIR,
    THESTRAL_TAIL_HAIR,
    TROLL_WHISKER,
    CORAL,


}