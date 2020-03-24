package cn.xpbootcamp.gilded_rose;

public class Sulfuras implements Item {
    private int quality;

    public Sulfuras(int quality) {
        this.quality = quality;
    }

    @Override
    public int sellIn() {
        return 0;
    }

    @Override
    public int qualityAtDay(int day) {
        if (quality < 0) {
            return 0;
        }
        return Math.min(quality, 50);
    }
}
