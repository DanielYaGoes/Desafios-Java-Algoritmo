package Exercicio01;

import java.util.LinkedHashMap;
import java.util.Map;

public class CacheLRU<K,V> {
    private final Map<K,V> cache;

    public CacheLRU(int limite){
        this.cache = new LinkedHashMap<K,V>(limite,0.75f,true){
          @Override
          protected boolean removeEldestEntry(Map.Entry<K,V> entry){
                return size() > limite;
            };
        };

    }

    public void put(K key, V value){
        cache.put(key,value);
    }

    public V get(K key){
        return  cache.getOrDefault(key, null);
    }

    public void remove(K key){
        cache.remove(key);
    }

    public int size(){
        return cache.size();
    }

}
