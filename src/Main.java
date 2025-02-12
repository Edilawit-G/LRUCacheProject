public class Main {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2); // Set cache capacity to 2
        System.out.println("Initial cache: " + cache);

        // Test put() and get()
        cache.put(1, 1);
        System.out.println("After put(1, 1): " + cache);
        System.out.println("get(1): " + cache.get(1));
        System.out.println("Current cache: " + cache);

        cache.put(2, 2);
        System.out.println("After put(2, 2): " + cache);
        System.out.println("get(2): " + cache.get(2));
        System.out.println("Current cache: " + cache);

        cache.put(3, 3);
        System.out.println("After put(3, 3): " + cache + " (1 was evicted)");
        System.out.println("get(1): " + cache.get(1));
        System.out.println("Current cache: " + cache);

        cache.put(4, 4);
        System.out.println("After put(4, 4): " + cache + " (2 was evicted)");
        System.out.println("get(2): " + cache.get(2));
        System.out.println("get(3): " + cache.get(3));
        System.out.println("get(4): " + cache.get(4));
        System.out.println("Current cache: " + cache);

        // Test updating an existing key
        cache.put(4, 10);
        System.out.println("After put(4, 10): " + cache + " (value updated)");
        System.out.println("get(4): " + cache.get(4));
        System.out.println("Final cache: " + cache);
    }
}
