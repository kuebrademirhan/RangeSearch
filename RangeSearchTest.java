
public class RangeSearchTest {
    @Test
    public void RangeSearch() {}

    @Test
    public void searchRange() {
        Range temp = new Range();
        RangeSearch temp1 = new RangeSearch(null);
        Range[] is = new Range[]{temp};
        temp1 = new RangeSearch(is);
        temp.min = 0;
        temp.max = 2;
        Assert.assertEquals("The result is wrong", is[0], temp1.searchRange(1));
        Range a = new Range();
        a.min = 4;
        a.max = 5;
        Range b = new Range();
        b.min = 2;
        b.max = 3;
        is = new Range[]{temp, a, b};
        temp1 = new RangeSearch(is);
        Assert.assertEquals("The result is wrong", null, temp1.searchRange(3));
        Assert.assertEquals("The result is wrong", is[0], temp1.searchRange(1));

    }

}