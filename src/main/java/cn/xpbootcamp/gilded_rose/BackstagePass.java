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
        int quality = initialQuality;
        if (day <= stageDate - 10) {
            quality += 2 * (stageDate - day);
        }
        if (day <= stageDate) {
            quality += (stageDate - day);
        }
        return quality;
    }
}
