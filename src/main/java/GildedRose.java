import java.util.ArrayList;
import java.util.List;


public class GildedRose {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String DEXTERITY_VEST = "+5 Dexterity Vest";
    public static final String ELIXIR_OF_THE_MONGOOSE = "Elixir of the Mongoose";
    public static final String CONJURED_MANA_CAKE = "Conjured Mana Cake";
    private static List<Item> items = null;


    public GildedRose() {
        items = new ArrayList<Item>();
        items.add(new Item(DEXTERITY_VEST, 10, 20));
        items.add(new Item(AGED_BRIE, 2, 0));
        items.add(new Item(ELIXIR_OF_THE_MONGOOSE, 5, 7));
        items.add(new Item(SULFURAS, 0, 80));
        items.add(new Item(BACKSTAGE_PASSES, 15, 20));
        items.add(new Item(CONJURED_MANA_CAKE, 3, 6));
    }

    public static void updateQuality()
    {
        for (Item currentItem : items)
        {
            String currentItemName = currentItem.getName();
            ItemHelper itemHelper = new ItemHelper();

            boolean nameIsNotAgedBrie = !AGED_BRIE.equals(currentItemName);
            boolean nameIsBackStagePasses = BACKSTAGE_PASSES.equals(currentItemName);
            boolean nameIsNotBackstagePasses = !nameIsBackStagePasses;
            boolean nameIsNotSulfuras = !SULFURAS.equals(currentItemName);

            boolean norAgedBrieNeitherBackStagePassesNeitherSulfuras = nameIsNotAgedBrie && nameIsNotBackstagePasses && nameIsNotSulfuras;

            if (norAgedBrieNeitherBackStagePassesNeitherSulfuras)
            {
                itemHelper.decreaseQuality(currentItem);
            }
            else
            {
                itemHelper.increaseQuality(currentItem);

                if (nameIsBackStagePasses)
                {
                    itemHelper.treatIncrementForBackstagePass(currentItem);
                }
            }

            if (nameIsNotSulfuras)
            {
                itemHelper.decreaseSellIn(currentItem);
            }

            if (itemHelper.itemIsExpired(currentItem))
            {
                if(norAgedBrieNeitherBackStagePassesNeitherSulfuras){
                    itemHelper.decreaseQuality(currentItem);
                }else if(nameIsBackStagePasses){
                    itemHelper.resetQuality(currentItem);
                }
                else
                {
                    itemHelper.increaseQuality(currentItem);
                }
            }
        }
    }

    public static List<Item> getItems() {
        return items;
    }

    public Item getItemByName(String name){
        if(items == null)
            throw new NullPointerException("GildedRose has not been initialized, call main function");
        for(Item item : items){
            if(name.equals(item.getName()))
                return item;
        }
        return null;
    }
}