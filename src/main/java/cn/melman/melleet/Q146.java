package cn.melman.melleet;

import java.util.HashMap;

public class Q146 {

    static class LRUCache {
        HashMap<Integer, Node> hash = new HashMap<>();
        Node head = new Node();
        Node tail = new Node();
        int capacity = 0;

        static class Node {
            int key;
            int value;
            Node pre;
            Node next;
        }


        public LRUCache(int capacity) {
            this.capacity = capacity;
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            Node node = hash.get(key);
            if (node == null) {
                return -1;
            }
            putNodeHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = hash.get(key);
            if (node != null) {
                node.value = value;
            } else {
                node = new Node();
                node.key = key;
                node.value = value;
                hash.put(key, node);
                if (hash.size() > capacity) {
                    removeOld();
                }
            }
            putNodeHead(node);
        }

        private void removeOld() {
            Node node = tail.pre;
            hash.remove(node.key);
            tail.pre = node.pre;
            tail.pre.next = tail;
        }

        private void putNodeHead(Node node) {
            if (head.next == node) {
                return;
            }
            Node old = head.next;
            if (node.next != null) {
                node.next.pre = node.pre;
            }
            if (node.pre != null) {
                node.pre.next = node.next;
            }
            head.next = node;
            old.pre = node;
            node.pre = head;
            node.next = old;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);
        int i = cache.get(2);
        System.out.println(i);


    }

}
