package cn.xpbootcamp.gilded_rose;

public class BackstagePass implements Item {
    private int initialQuality;
    private int stageDate;

    public BackstagePass(int initialQuality, int stageDate) {
        this.initialQuality = initialQuality;
        this.stageDate = stageDate;
    }

    @Override
    public int sellIn() {
        return stageDate;
    }

    @Override
    public int qualityAtDay(int day) {
        if (day > stageDate) {
            return 0;
        }
        if (day <= stageDate - 10) {
            return initialQuality;
        }
        if (day <= stageDate - 5) {
            return initialQuality + 2 * (day - (stageDate - 10));
        }
        return initialQuality + 3 * (day - (stageDate - 5)) + 10;
    }
}
