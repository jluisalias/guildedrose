/**
 * Created by jlalias on 3/10/15.
 */
public class ItemHelper {

    private static final int MINIMUM_QUALITY = 0;
    private static final int DOUBLE_INCREMENT_THRESHOLD = 10;
    private static final int TRIPLE_INCREMENT_THRESHOLD = 5;
    private static final int MAXIMUM_QUALITY = 50;
    private static final int QUALITY_STEP = 1;
    private static final int MINIMUM_SELLIN = 0;
    private static final int SELLIN_STEP = 1;

    static void treatIncrementForBackstagePass(Item currentItem) {
        if (isInDoubleIncrement(currentItem))
        {
            increaseQuality(currentItem);
        }

        if (isInTripleIncrement(currentItem))
        {
            increaseQuality(currentItem);
        }
    }

    public static boolean isInTripleIncrement(Item currentItem) {
        return currentItem.getSellIn() <= TRIPLE_INCREMENT_THRESHOLD;
    }

    public static boolean isInDoubleIncrement(Item currentItem) {
        return currentItem.getSellIn() <= DOUBLE_INCREMENT_THRESHOLD;
    }

    public static boolean isMaximumQualityReached(Item currentItem) {
        return currentItem.getQuality() >= MAXIMUM_QUALITY;
    }

    public static boolean hasNotQuality(Item currentItem) {
        return currentItem.getQuality() <= MINIMUM_QUALITY;
    }

    public static void resetQuality(Item currentItem) {
        currentItem.setQuality(MINIMUM_QUALITY);
    }

    public static boolean itemIsExpired(Item currentItem) {
        return currentItem.getSellIn() < MINIMUM_SELLIN;
    }

    public static void decreaseSellIn(Item currentItem) {
        currentItem.setSellIn(currentItem.getSellIn() - SELLIN_STEP);
    }

    public static void increaseQuality(Item currentItem) {
        if (isMaximumQualityReached(currentItem)) return;
        currentItem.setQuality(currentItem.getQuality() + QUALITY_STEP);
    }

    public static void decreaseQuality(Item currentItem) {
        if (hasNotQuality(currentItem)) return;
        currentItem.setQuality(currentItem.getQuality() - QUALITY_STEP);
    }
}
