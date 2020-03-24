package cn.xpbootcamp.gilded_rose;

import com.spun.util.Asserts;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ShopTest {
    @Test
    public void allItemsHaveQualityInRange() {
        List<Item> items = new ArrayList<>();
        items.add(new AgedBrie(10, 1));
        items.add(new NormalItem(20, 5, 2));
        items.add(new NormalItem(20, 0, 2));
        items.add(new NormalItem(20, 5, 0));
        items.add(new Sulfuras(2));
        items.add(new BackstagePass(22, 10));
        for (Item item : items) {
            for (int i = 0; i < 100; i++) {
                Asserts.assertTrue("item.qualityAtDay() >= 0", item.qualityAtDay(i) >= 0);
                Asserts.assertTrue("item.qualityAtDay() <= 50", item.qualityAtDay(i) <= 50);
            }
            Asserts.assertTrue("item.qualityAtDay(MAX_VALUE) >= 0", item.qualityAtDay(Integer.MAX_VALUE) >= 0);
            Asserts.assertTrue("item.qualityAtDay(MAX_VALUE) <= 50", item.qualityAtDay(Integer.MAX_VALUE) <= 50);
        }
    }

    @Test
    public void itemsPassesSellInDateQualityDecreaseAtDoubleRate() {
        Item item = new NormalItem(20, 5, 2);
        Asserts.assertEqual("Normal item day 0", item.qualityAtDay(0), 20);
        Asserts.assertEqual("Normal item day 1", item.qualityAtDay(1), 18);
        Asserts.assertEqual("Normal item day 2", item.qualityAtDay(2), 16);
        Asserts.assertEqual("Normal item day 3", item.qualityAtDay(3), 14);
        Asserts.assertEqual("Normal item day 4", item.qualityAtDay(4), 12);
        Asserts.assertEqual("Normal item day 5", item.qualityAtDay(5), 10);
        Asserts.assertEqual("Normal item day 6", item.qualityAtDay(6), 6);
        Asserts.assertEqual("Normal item day 7", item.qualityAtDay(7), 2);
        Asserts.assertEqual("Normal item day 8", item.qualityAtDay(8), 0);
    }

    @Test
    public void agedBrieQualityIncreaseWhenDateIncrease() {
        Item item = new AgedBrie(10, 5);
        Asserts.assertEqual("Aged Brie day 0", item.qualityAtDay(0), 10);
        Asserts.assertEqual("Aged Brie day 1", item.qualityAtDay(1), 15);
        Asserts.assertEqual("Aged Brie day 2", item.qualityAtDay(2), 20);
        Asserts.assertEqual("Aged Brie day 3", item.qualityAtDay(3), 25);
        Asserts.assertEqual("Aged Brie day 4", item.qualityAtDay(4), 30);
        Asserts.assertEqual("Aged Brie day 5", item.qualityAtDay(5), 35);
        Asserts.assertEqual("Aged Brie day 6", item.qualityAtDay(6), 40);
        Asserts.assertEqual("Aged Brie day 7", item.qualityAtDay(7), 45);
        Asserts.assertEqual("Aged Brie day 8", item.qualityAtDay(8), 50);
        Asserts.assertEqual("Aged Brie day 9", item.qualityAtDay(9), 50);
        Asserts.assertEqual("Aged Brie day 10", item.qualityAtDay(10), 50);
    }

    @Test
    public void sulfurasHaveUnchangingQuality() {
        Item item = new Sulfuras(42);
        for (int i = 0; i < 200; i ++) {
            Asserts.assertEqual("Sulfuras", item.qualityAtDay(i), 42);
        }
    }

    @Test
    public void backstagePassQuality() {
        Item item = new BackstagePass(20, 15);
        Asserts.assertEqual("Backstage Pass day 0", item.qualityAtDay(0), 20);
        Asserts.assertEqual("Backstage Pass day 1", item.qualityAtDay(1), 20);
        Asserts.assertEqual("Backstage Pass day 2", item.qualityAtDay(2), 20);
        Asserts.assertEqual("Backstage Pass day 3", item.qualityAtDay(3), 20);
        Asserts.assertEqual("Backstage Pass day 4", item.qualityAtDay(4), 20);
        Asserts.assertEqual("Backstage Pass day 5", item.qualityAtDay(5), 20);
        Asserts.assertEqual("Backstage Pass day 6", item.qualityAtDay(6), 22);
        Asserts.assertEqual("Backstage Pass day 7", item.qualityAtDay(7), 24);
        Asserts.assertEqual("Backstage Pass day 8", item.qualityAtDay(8), 26);
        Asserts.assertEqual("Backstage Pass day 9", item.qualityAtDay(9), 28);
        Asserts.assertEqual("Backstage Pass day 10", item.qualityAtDay(10), 30);
        Asserts.assertEqual("Backstage Pass day 11", item.qualityAtDay(11), 33);
        Asserts.assertEqual("Backstage Pass day 12", item.qualityAtDay(12), 36);
        Asserts.assertEqual("Backstage Pass day 13", item.qualityAtDay(13), 39);
        Asserts.assertEqual("Backstage Pass day 14", item.qualityAtDay(14), 42);
        Asserts.assertEqual("Backstage Pass day 15", item.qualityAtDay(15), 45);
        Asserts.assertEqual("Backstage Pass day 16", item.qualityAtDay(16), 0);
        Asserts.assertEqual("Backstage Pass day 17", item.qualityAtDay(17), 0);
    }

}
