public class Main {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2); // Set cache capacity to 2

        // Test put() and get()
        cache.put(1, 1);  // Cache is {1=1}
        System.out.println(cache.get(1)); // Should print 1

        cache.put(2, 2);  // Cache is {1=1, 2=2}
        System.out.println(cache.get(2)); // Should print 2

        cache.put(3, 3);  // Cache is {2=2, 3=3}, evicts 1
        System.out.println(cache.get(1)); // Should print -1 (not found)

        cache.put(4, 4);  // Cache is {3=3, 4=4}, evicts 2
        System.out.println(cache.get(2)); // Should print -1 (not found)
        System.out.println(cache.get(3)); // Should print 3
        System.out.println(cache.get(4)); // Should print 4

        // Test updating an existing key
        cache.put(4, 10); // Update key 4 to 10, Cache is {3=3, 4=10}
        System.out.println(cache.get(4)); // Should print 10
    }
}
