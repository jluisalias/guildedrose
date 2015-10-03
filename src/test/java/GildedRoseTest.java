import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class GildedRoseTest {

	private GildedRose gildedRoseSUT;
    private final int TOTAL_ARTICLES = 6;

    List<Item> items;

    Item dexterityVest;
    Item agedBrie;

	@Before
	public void initGildedRose(){
		gildedRoseSUT = new GildedRose();
        gildedRoseSUT.updateQuality();
	}

    @Test
    public void testGetItems(){
        items = gildedRoseSUT.getItems();
        assertEquals(TOTAL_ARTICLES, items.size());
    }

	@Test
	public void testDexterityVest(){
        Item dexterityVest = gildedRoseSUT.getItemByName("+5 Dexterity Vest");
        assertEquals(19, dexterityVest.getQuality());
        assertEquals(9, dexterityVest.getSellIn());

        gildedRoseSUT.updateQuality();
        assertEquals(18, dexterityVest.getQuality());
        assertEquals(8, dexterityVest.getSellIn());

        for(int count = 0; count < 8; count++){
            gildedRoseSUT.updateQuality();
        }
        assertEquals(10, dexterityVest.getQuality());
        assertEquals(0, dexterityVest.getSellIn());

        for(int count = 0; count < 3; count++){
            gildedRoseSUT.updateQuality();
        }
        assertEquals(4, dexterityVest.getQuality());
        assertEquals(-3, dexterityVest.getSellIn());

        for(int count = 0; count < 2; count++){
            gildedRoseSUT.updateQuality();
        }
        assertEquals(0, dexterityVest.getQuality());
        assertEquals(-5, dexterityVest.getSellIn());

        for(int count = 0; count < 5; count++){
            gildedRoseSUT.updateQuality();
        }
        assertEquals(0, dexterityVest.getQuality());
        assertEquals(-10, dexterityVest.getSellIn());
	}

    @Test
    public void testAgedBrie(){
        Item agedBrie = gildedRoseSUT.getItemByName("Aged Brie");
        assertEquals(1, agedBrie.getQuality());
        assertEquals(1, agedBrie.getSellIn());

        gildedRoseSUT.updateQuality();
        assertEquals(2, agedBrie.getQuality());
        assertEquals(0, agedBrie.getSellIn());

        for(int count = 0; count < 4; count++){
            gildedRoseSUT.updateQuality();
        }
        assertEquals(10, agedBrie.getQuality());
        assertEquals(-4, agedBrie.getSellIn());

        for(int count = 0; count < 20; count++){
            gildedRoseSUT.updateQuality();
        }
        assertEquals(50, agedBrie.getQuality());
        assertEquals(-24, agedBrie.getSellIn());

        for(int count = 0; count < 20; count++){
            gildedRoseSUT.updateQuality();
        }
        assertEquals(50, agedBrie.getQuality());
        assertEquals(-44, agedBrie.getSellIn());
    }

    @Test
    public void testElixirMongoose(){
        Item elixirMongoose = gildedRoseSUT.getItemByName("Elixir of the Mongoose");
        assertEquals(6, elixirMongoose.getQuality());
        assertEquals(4, elixirMongoose.getSellIn());

        gildedRoseSUT.updateQuality();
        assertEquals(5, elixirMongoose.getQuality());
        assertEquals(3, elixirMongoose.getSellIn());

        for(int count = 0; count < 3; count++){
            gildedRoseSUT.updateQuality();
        }
        assertEquals(2, elixirMongoose.getQuality());
        assertEquals(0, elixirMongoose.getSellIn());

        gildedRoseSUT.updateQuality();
        assertEquals(0, elixirMongoose.getQuality());
        assertEquals(-1, elixirMongoose.getSellIn());

        for(int count = 0; count < 9; count++){
            gildedRoseSUT.updateQuality();
        }
        assertEquals(0, elixirMongoose.getQuality());
        assertEquals(-10, elixirMongoose.getSellIn());
    }

    @Test
     public void testSulfurasHandOfRagnarok() {
        Item sulfurasHandOfRagnaros = gildedRoseSUT.getItemByName("Sulfuras, Hand of Ragnaros");
        assertEquals(80, sulfurasHandOfRagnaros.getQuality());
        assertEquals(0, sulfurasHandOfRagnaros.getSellIn());
        for(int count = 0; count < 20; count++){
            gildedRoseSUT.updateQuality();
        }
        assertEquals(80, sulfurasHandOfRagnaros.getQuality());
        assertEquals(0, sulfurasHandOfRagnaros.getSellIn());
    }

    @Test
    public void testBackStage() {
        Item backstagePass = gildedRoseSUT.getItemByName("Backstage passes to a TAFKAL80ETC concert");
        assertEquals(21, backstagePass.getQuality());
        assertEquals(14, backstagePass.getSellIn());
        for(int count = 0; count < 4; count++){
            gildedRoseSUT.updateQuality();
        }
        assertEquals(25, backstagePass.getQuality());
        assertEquals(10, backstagePass.getSellIn());
        for(int count = 0; count < 5; count++){
            gildedRoseSUT.updateQuality();
        }
        assertEquals(35, backstagePass.getQuality());
        assertEquals(5, backstagePass.getSellIn());
        for(int count = 0; count < 5; count++){
            gildedRoseSUT.updateQuality();
        }
        assertEquals(50, backstagePass.getQuality());
        assertEquals(0, backstagePass.getSellIn());
        gildedRoseSUT.updateQuality();
        assertEquals(0, backstagePass.getQuality());
    }

    @Test
    public void testConjuredManaCake() {
        Item conjuredManaCake = gildedRoseSUT.getItemByName("Conjured Mana Cake");
        assertEquals(4, conjuredManaCake.getQuality());
        assertEquals(2, conjuredManaCake.getSellIn());
        gildedRoseSUT.updateQuality();
        assertEquals(2, conjuredManaCake.getQuality()); //While the new funcionality is not done
        assertEquals(1, conjuredManaCake.getSellIn());
        gildedRoseSUT.updateQuality();
        assertEquals(0, conjuredManaCake.getQuality()); //While the new funcionality is not done
        assertEquals(0, conjuredManaCake.getSellIn());
    }
}
