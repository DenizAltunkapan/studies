package thirdSemester.skiplists;

import java.util.Random;

class SkipList {

    static class Node {
        int key;
        Node[] forward;

        public Node(int key, int level) {
            this.key = key;
            this.forward = new Node[level + 1];
        }
    }

    private final int MAX_LEVEL;
    private final float P;
    private final Node header;
    private int level;
    private final Random random;

    public SkipList(int maxLevel, float p) {
        this.MAX_LEVEL = maxLevel;
        this.P = p;
        this.header = new Node(-1, MAX_LEVEL);
        this.level = 0;
        this.random = new Random();
    }

    private int randomLevel() {
        int newLevel = 0;
        while (random.nextFloat() < P && newLevel < MAX_LEVEL) {
            newLevel++;
        }
        return newLevel;
    }

    public void insert(int key) {
        Node[] update = new Node[MAX_LEVEL + 1];
        Node current = header;

        for (int i = level; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].key < key) {
                current = current.forward[i];
            }
            update[i] = current;
        }

        current = current.forward[0];
        if (current != null && current.key == key) {
            System.out.println("Schlüssel " + key + " existiert bereits. Kein Einfügen durchgeführt.");
            return;
        }

        int newLevel = randomLevel();
        if (newLevel > level) {
            for (int i = level + 1; i <= newLevel; i++) {
                update[i] = header;
            }
            level = newLevel;
        }

        Node newNode = new Node(key, newLevel);
        for (int i = 0; i <= newLevel; i++) {
            newNode.forward[i] = update[i].forward[i];
            update[i].forward[i] = newNode;
        }
        System.out.println("Schlüssel " + key + " eingefügt.");
    }

    public boolean search(int key) {
        Node current = header;

        for (int i = level; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].key < key) {
                current = current.forward[i];
            }
        }

        current = current.forward[0];
        return current != null && current.key == key;
    }

    public void delete(int key) {
        Node[] update = new Node[MAX_LEVEL + 1];
        Node current = header;

        for (int i = level; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].key < key) {
                current = current.forward[i];
            }
            update[i] = current;
        }

        current = current.forward[0];
        if (current == null || current.key != key) {
            System.out.println("Schlüssel " + key + " nicht gefunden. Kein Löschen durchgeführt.");
            return;
        }

        for (int i = 0; i <= level; i++) {
            if (update[i].forward[i] != current) break;
            update[i].forward[i] = current.forward[i];
        }

        while (level > 0 && header.forward[level] == null) {
            level--;
        }
        System.out.println("Schlüssel " + key + " gelöscht.");
    }

    public void print() {
        System.out.println("Skip-Liste:");
        for (int i = level; i >= 0; i--) {
            Node current = header.forward[i];
            System.out.print("Level " + i + ": ");
            while (current != null) {
                System.out.print(current.key + " ");
                current = current.forward[i];
            }
            System.out.println();
        }
    }

    public void draw() {
        Node current = header.forward[0];
        StringBuilder allKeysBuilder = new StringBuilder();
        while (current != null) {
            allKeysBuilder.append(current.key).append(" ");
            current = current.forward[0];
        }
        String[] allKeys = allKeysBuilder.toString().trim().split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = level; i >= 0; i--) {
            sb.append("Level ").append(i).append(": ");

            current = header.forward[i];
            int keyIndex = 0;

            for (String key : allKeys) {
                if (current != null && current.key == Integer.parseInt(key)) {
                    sb.append("[").append(key).append("]");
                    current = current.forward[i];
                } else {
                    sb.append(" ".repeat(key.length() + 2));
                }
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }


    public static void main(String[] args) {
        SkipList skipList = new SkipList(4, 0.5f);

        skipList.insert(3);
        skipList.insert(60);
        skipList.insert(70);
        skipList.insert(90);
        skipList.insert(12);

        skipList.draw();
    }
}