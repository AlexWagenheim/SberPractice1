import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HashMapTest {
    @Test
    public void HashMapSizeTest() {
        HashMap hashMap = new HashMap();

        int size = hashMap.size();

        Assertions.assertEquals(16, size);
    }

    @Test
    public void HashMapIsEmptyTest() {
        HashMap hashMap = new HashMap();

        Assertions.assertTrue(hashMap.isEmpty());

        hashMap.put(100, "a");

        Assertions.assertFalse(hashMap.isEmpty());
    }

    @Test
    public void HashMapContainsKeyTest() {
        HashMap hashMap = new HashMap();

        Assertions.assertFalse(hashMap.containsKey(100));

        hashMap.put(100, "a");
        hashMap.put(200, "b");
        hashMap.put(300, "c");

        Assertions.assertTrue(hashMap.containsKey(200));

        Assertions.assertFalse(hashMap.containsKey(400));
    }

    @Test
    public void HashMapContainsKeyTest2() {
        HashMap hashMap = new HashMap();


        hashMap.put("LADA", "a");
        hashMap.put("BMW", "b");
        hashMap.put("VOLKSWAGEN", "c");

        Assertions.assertFalse(hashMap.containsKey("TOYOTA"));
    }

    @Test
    public void HashMapContainsValueTest() {
        HashMap hashMap = new HashMap();

        hashMap.put(100, "a");
        hashMap.put(200, "b");
        hashMap.put(300, "c");

        Assertions.assertTrue(hashMap.containsValue("c"));

        Assertions.assertFalse(hashMap.containsValue("d"));
    }

    @Test
    public void HashMapGetTest() {
        HashMap hashMap = new HashMap();

        Assertions.assertNull(hashMap.get("LADA"));

        hashMap.put("LADA", "a");
        hashMap.put("BMW", "b");
        hashMap.put("VOLKSWAGEN", "c");

        Assertions.assertEquals("a", hashMap.get("LADA"));
        Assertions.assertNull(hashMap.get("TOYOTA"));
    }

    @Test
    public void HashMapPutTest() {
        HashMap hashMap = new HashMap();

        hashMap.put("LADA", "a");

        Assertions.assertNull(hashMap.put("TOYOTA", "d"));
    }

    @Test
    public void HashMapRemoveTest() {
        HashMap hashMap = new HashMap();

        Assertions.assertNull(hashMap.remove("TOYOTA"));

        hashMap.put("LADA", "a");
        hashMap.put("VOLKSWAGEN", "b");

        Assertions.assertEquals("b", hashMap.remove("VOLKSWAGEN"));
        Assertions.assertNull(hashMap.remove("TOYOTA"));
    }

    @Test
    public void HashMapClearTest() {
        HashMap hashMap = new HashMap();

        hashMap.put("LADA", "a");
        hashMap.put("VOLKSWAGEN", "b");
        hashMap.put("TOYOTA", "c");

        hashMap.clear();

        Assertions.assertTrue(hashMap.isEmpty());
    }

    @Test
    public void HashMapValuesTest() {
        HashMap hashMap = new HashMap();

        hashMap.put("LADA", "a");
        hashMap.put("VOLKSWAGEN", "b");
        hashMap.put("TOYOTA", "c");

        List correct = new LinkedList();

        correct.add("a");
        correct.add("c");
        correct.add("b");

        Assertions.assertEquals(correct.toString(), hashMap.values().toString());
    }

    @Test
    public void HashMapKeySetTest() {
        HashMap hashMap = new HashMap();

        hashMap.put("LADA", "a");
        hashMap.put("VOLKSWAGEN", "b");
        hashMap.put("TOYOTA", "c");

        List correct = new LinkedList();

        correct.add("LADA");
        correct.add("TOYOTA");
        correct.add("VOLKSWAGEN");

        Assertions.assertEquals(correct.toString(), hashMap.keySet().toString());
    }

    @Test
    public void HashMapEntrySetTest() {
        HashMap hashMap = new HashMap();

        hashMap.put("LADA", "a");
        hashMap.put("VOLKSWAGEN", "b");
        hashMap.put("TOYOTA", "c");

        LinkedList correct = new LinkedList();

        correct.add(new HashMap.Entry("LADA", "a"));
        correct.add(new HashMap.Entry("TOYOTA", "c"));
        correct.add(new HashMap.Entry("VOLKSWAGEN", "b"));
        Assertions.assertEquals(correct.toString(), hashMap.entrySet().toString());
    }

    @Test
    public void HashMapToStringTest() {
        HashMap hashMap = new HashMap();

        hashMap.put("LADA", "a");
        hashMap.put("VOLKSWAGEN", "b");
        hashMap.put("TOYOTA", "c");

        Assertions.assertEquals("HashMap{size=16, buckets=[null, null, " +
                    "LinKedList{itemsCount=2, arr=[[key=LADA, value=a], [key=TOYOTA, value=c]]}, " +
                    "null, null, LinKedList{itemsCount=1, arr=[[key=VOLKSWAGEN, value=b]]}, null, " +
                    "null, null, null, null, null, null, null, null, null], itemsCount=3}",
                hashMap.toString());
    }
}