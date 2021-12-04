package day3;

public class Util {

    private int zeros;
    private int ones;

    public void increase(boolean a, boolean b) {
        if (a) this.zeros++;
        if (b) this.ones++;
    }

    public int getCommon() {
        return this.zeros > this.ones ? 0 : 1;
    }

    public int getUncommon() {
        return this.zeros > this.ones ? 1 : 0;
    }

    public int getCommon(int onEqual) {
        if (this.zeros == this.ones) return onEqual;
        return this.getCommon();
    }

    public int getUncommon(int onEqual) {
        if (this.zeros == this.ones) return onEqual;
        return this.getUncommon();
    }
}
