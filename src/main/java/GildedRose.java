import java.util.ArrayList;
import java.util.List;


public class GildedRose {

    public static final int MINIMUM_QUALITY = 0;
    public static final int DOUBLE_INCREMENT_THRESHOLD = 10;
    public static final int TRIPLE_INCREMENT_THRESHOLD = 5;
    public static final int MAXIMUM_QUALITY = 50;
    public static final int QUALITY_STEP = 1;
    public static final int MINIMUM_SELLIN = 0;
    public static final int SELLIN_STEP = 1;
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static List<Item> items = null;

    public GildedRose() {
        items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item(AGED_BRIE, 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item(SULFURAS, 0, 80));
        items.add(new Item(BACKSTAGE_PASSES, 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));
    }

    /**
	 * @param args
	 */
	public static void main(String[] args) {
		
        System.out.println("OMGHAI!");
		
        items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item(AGED_BRIE, 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item(SULFURAS, 0, 80));
        items.add(new Item(BACKSTAGE_PASSES, 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));

        updateQuality();
    }


	
    public static void updateQuality()
    {
        for (int i = 0; i < items.size(); i++)
        {
            Item currentItem = items.get(i);
            String currentItemName = currentItem.getName();

            boolean nameIsNotAgedBrie = !AGED_BRIE.equals(currentItemName);
            boolean nameIsBackStagePasses = BACKSTAGE_PASSES.equals(currentItemName);
            boolean nameIsNotBackstagePasses = !nameIsBackStagePasses;
            boolean nameIsNotSulfuras = !SULFURAS.equals(currentItemName);
            boolean norAgedBrieNeitherBackstagePasses = nameIsNotAgedBrie && nameIsNotBackstagePasses;

            if (norAgedBrieNeitherBackstagePasses)
            {
                if (hasSomeQuality(currentItem))
                {
                    if (nameIsNotSulfuras)
                    {
                        decreaseQuality(currentItem);
                    }
                }
            }
            else
            {
                if (isMaximumQualityNotReached(currentItem))
                {
                    increaseQuality(currentItem);

                    if (nameIsBackStagePasses)
                    {
                        if (isInDoubleIncrement(currentItem))
                        {
                            if (isMaximumQualityNotReached(currentItem))
                            {
                                increaseQuality(currentItem);
                            }
                        }

                        if (isInTripleIncrement(currentItem))
                        {
                            if (currentItem.getQuality() < 50)
                            {
                                increaseQuality(currentItem);
                            }
                        }
                    }
                }
            }

            if (nameIsNotSulfuras)
            {
                decreaseSellIn(currentItem);
            }

            if (itemIsExpired(currentItem))
            {
                if (nameIsNotAgedBrie)
                {
                    if (nameIsNotBackstagePasses)
                    {
                        if (hasSomeQuality(currentItem))
                        {
                            if (nameIsNotSulfuras)
                            {
                                decreaseQuality(currentItem);
                            }
                        }
                    }
                    else
                    {
                        resetQuality(currentItem);
                    }
                }
                else
                {
                    if (isMaximumQualityNotReached(currentItem))
                    {
                        increaseQuality(currentItem);
                    }
                }
            }
        }
    }

    private static boolean isInTripleIncrement(Item currentItem) {
        return currentItem.getSellIn() <= TRIPLE_INCREMENT_THRESHOLD;
    }

    private static boolean isInDoubleIncrement(Item currentItem) {
        return currentItem.getSellIn() <= DOUBLE_INCREMENT_THRESHOLD;
    }

    private static boolean isMaximumQualityNotReached(Item currentItem) {
        return currentItem.getQuality() < MAXIMUM_QUALITY;
    }

    private static boolean hasSomeQuality(Item currentItem) {
        return currentItem.getQuality() > MINIMUM_QUALITY;
    }

    private static void resetQuality(Item currentItem) {
        currentItem.setQuality(MINIMUM_QUALITY);
    }

    private static boolean itemIsExpired(Item currentItem) {
        return currentItem.getSellIn() < MINIMUM_SELLIN;
    }

    private static void decreaseSellIn(Item currentItem) {
        currentItem.setSellIn(currentItem.getSellIn() - SELLIN_STEP);
    }

    private static void increaseQuality(Item currentItem) {
        currentItem.setQuality(currentItem.getQuality() + QUALITY_STEP);
    }

    private static void decreaseQuality(Item currentItem) {
        currentItem.setQuality(currentItem.getQuality() - QUALITY_STEP);
    }

    public static List<Item> getItems() {
        return items;
    }

    public Item getItemByName(String name){
        if(this.items == null)
            throw new NullPointerException("GildedRose has not been initialized, call main function");
        for(Item item : items){
            if(name.equals(item.getName()))
                return item;
        }
        return null;
    }
}