package cn.xpbootcamp.gilded_rose;

public class AgedBrie implements Item {
    private int initialQuality;
    private int increaseRate;

    public AgedBrie(int initialQuality, int increaseRate) {
        this.initialQuality = initialQuality;
        this.increaseRate = increaseRate;
    }

    @Override
    public int sellIn() {
        return 0;
    }

    @Override
    public int qualityAtDay(int day) {
        if (day > 50 && increaseRate > 0) {
            return 50;
        }
        int quality = initialQuality + day * increaseRate;
        return Math.min(quality, 50);
    }
}
