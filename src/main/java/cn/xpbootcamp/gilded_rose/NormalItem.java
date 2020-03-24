package cn.xpbootcamp.gilded_rose;

public class NormalItem implements Item {
    private int initialQuality;
    private int sellIn;
    private int qualityDecreaseRate;

    public NormalItem(int initialQuality, int sellIn, int qualityDecreaseRate) {
        this.initialQuality = initialQuality;
        this.sellIn = sellIn;
        this.qualityDecreaseRate = qualityDecreaseRate;
    }

    @Override
    public int sellIn() {
        return sellIn;
    }

    @Override
    public int qualityAtDay(int day) {
        int quality = initialQuality - qualityDecreaseRate * day;
        if (day <= sellIn) {
            return quality;
        }
        quality = quality - qualityDecreaseRate * (day - sellIn);
        return Math.max(quality, 0);
    }
}
