package TestExercicio01;

import Exercicio01.CacheLRU;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class CacheLRUTest {

    @Test
    public void testPutAndGet() {
        CacheLRU<String, String> cache = new CacheLRU<>(3);
        cache.put("a", "valorA");
        cache.put("b", "valorB");

        assertEquals("valorA", cache.get("a"));
        assertEquals("valorB", cache.get("b"));
    }

    @Test
    public void testRemove() {
        CacheLRU<String, String> cache = new CacheLRU<>(3);
        cache.put("a", "valorA");
        cache.remove("a");

        assertNull(cache.get("a"));
        assertEquals(0, cache.size());
    }

    @Test
    public void testSize() {
        CacheLRU<Integer, String> cache = new CacheLRU<>(2);
        cache.put(1, "um");
        cache.put(2, "dois");

        assertEquals(2, cache.size());
    }

    @Test
    public void testEvictionPolicy() {
        CacheLRU<Integer, String> cache = new CacheLRU<>(2);
        cache.put(1, "um");
        cache.put(2, "dois");
        cache.get(1);
        cache.put(3, "três");

        assertNotNull(cache.get(1));
        assertNull(cache.get(2));
        assertNotNull(cache.get(3));
        assertEquals(2, cache.size());
    }
}