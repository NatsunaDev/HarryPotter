import java.util.Random;

public class Wand {
    private int size;
    private Core core;

    public Wand(int size, Core core) {

        this.size = size;
        this.core = core;
    }


    public int getSize() {
        return size;
    }
    public  Core getCore() {
        return core;
    }

    public static Core randomCore() {
        int pick = new Random().nextInt(Core.values().length);
        return Core.values()[pick];
    }

    public static int randomSize() {
        return  1;
    }


}

enum Core {
    PHOENIX_FEATHER,
    DRAGON_HEARTSTRING,
    UNICORN_TAIL_HAIR,
    VEELA_HAIR,
    THESTRAL_TAIL_HAIR,
    TROLL_WHISKER,
    CORAL;
}

