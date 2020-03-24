package cn.xpbootcamp.gilded_rose;

import com.spun.util.Asserts;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ShopTest {
    @Test
    public void allItemsHaveNonNegativeQuality() {
        List<Item> items = new ArrayList<>();
        items.add(new AgedBrie());
        for (Item item : items) {
            for (int i = 0; i < 100; i++) {
                Asserts.assertTrue("item.quality() >= 0", item.qualityAtDay(i) >= 0);
            }
            Asserts.assertTrue("item.quality() >= 0", item.qualityAtDay(Integer.MAX_VALUE) >= 0);
        }
    }

    @Test
    public void itemsPassesSellInDateQualityDecreaseAtDoubleRate() {

    }

    @Test
    public void agedBrieQualityIncreaseWhenDateIncrease() {

    }

    @Test
    public void sulfurasHaveUnchangingQuality() {

    }

    @Test
    public void backstagePassQualityIncreaseBeforeStageDate() {

    }

    @Test
    public void backstagePassQualityIncreaseFasterWhenApproachingStageDate() {

    }

    @Test
    public void backstagePassQualityBecomeZeroAfterStageDate() {

    }
}
