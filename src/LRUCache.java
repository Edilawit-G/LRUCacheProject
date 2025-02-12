import java.util.HashMap;
public class LRUCache {
     // Node class represents a node in the doubly linked list
    private static class Node{
        int key, value; // Key and value stored in the node
        Node prev, next;  // Pointers to the previous and next nodes

         // Constructor to initialize a node with a key and value
        public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    }

    private final int capacity; // Maximum capacity of the cache
    private final HashMap<Integer, Node> cache; // HashMap to store key-node pairs for O(1) access
    private final Node head, tail; // Dummy head and tail nodes to simplify boundary conditions

    // Constructor to initialize the LRU Cache with a given capacity
    public LRUCache(int capacity) {
    this.capacity = capacity;
    this.cache = new HashMap<>();  // Initialize the cache as an empty HashMap

    // Initialize dummy head and tail nodes
    this.head = new Node(0, 0);
    this.tail = new Node(0, 0);

   // Connect head and tail to form an empty doubly linked list
    head.next = tail;
    tail.prev = head;
}
    // Helper method to add a node to the front of the doubly linked list (most recently used)
    private void addToFront(Node node) {
        Node nextNode = head.next; // The current first node in the list
        head.next = node; // Insert the new node after the head
        node.prev = head;
        node.next = nextNode;
        nextNode.prev = node;
    }

     // Helper method to move a node to the front of the list (most recently used)
    private void moveToFront(Node node) {
         // Remove the node from its current position
        node.prev.next = node.next;
        node.next.prev = node.prev;
        // Add the node to the front
        addToFront(node);
    }

    // Helper method to remove the least recently used node (the node before the tail)
    private void removeLRU() {
        Node lru = tail.prev; // The node to be removed (least recently used)
        tail.prev = lru.prev; // Update the tail's previous pointer
        lru.prev.next = tail; // Update the previous node's next pointer
        cache.remove(lru.key); // Remove the node from the cache
    }

    // Method to get the value associated with a key from the cache
    public int get(int key) {
    if (!cache.containsKey(key)) return -1; // If key is not in cache, return -1

    Node node = cache.get(key); // Get the node from the cache
    moveToFront(node); // Move node to front since it's the most recently used
    return node.value; // Return the value associated with the key
}

    // Method to add or update a key-value pair in the cache
    public void put(int key, int value) {
    if (cache.containsKey(key)) {
        // If the key already exists, update its value and move it to the front
        Node node = cache.get(key);
        node.value = value;
        moveToFront(node);
    } else {
        // If the cache is at capacity, remove the least recently used node
        if (cache.size() >= capacity) {
            removeLRU();
        }

        // Create a new node and add it to the cache
        Node newNode = new Node(key, value);
        cache.put(key, newNode); // Add the node to the HashMap
        addToFront(newNode); // Add the node to the front of the list
    }

}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("[Capacity=%d, ", capacity));
        
        if (cache.isEmpty()) {
            sb.append("Empty]");
            return sb.toString();
        }

        sb.append("MRU -> ");
        
        // Start from head.next (first real node) and traverse until tail
        Node current = head.next;
        while (current != tail) {
            sb.append(String.format("(%d:%d)", current.key, current.value));
            if (current.next != tail) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        
        sb.append(" -> LRU]");
        return sb.toString();
    }
}





