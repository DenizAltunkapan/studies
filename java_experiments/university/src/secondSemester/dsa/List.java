package secondSemester.dsa;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class List {
    class Node {
        Object obj;
        Node next;

        public Node(Object obj, Node next) {
            this.obj = obj;
            this.next = next;
        }
        public Node(Node n) {
            this(n.obj,n.next);
        }

        public void setElement(Object obj) {
            this.obj = obj;
        }
        public Object getElement() { return obj; }
        public void setNext(Node next) {
            this.next = next;
        }
        public Node getNext() { return next; }
    }

    private Node head;

    public List() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addLast(Object obj) {
        Node n = new Node(obj, null);
        // Sonderfall: Liste ist leer
        if (isEmpty()) {
            head = n;
            return;
        }

        Node l = head;
        // letzten Knoten ermitteln
        while (l.getNext() != null) 
            l = l.getNext();
        // neuen Knoten anfügen
        l.setNext(n);
    }

    public Object removeLast() {
        // Sonderfall: Liste ist leer
        if (isEmpty()) return null;

        // Sonderfall: Liste hat nur ein Element
        if (head.getNext() == null) {
            Object obj = head.getElement();
            head = null; // Liste ist jetzt leer
            return obj;
        }

        Node l = head;
        // vorletzten Knoten ermitteln
        while (l.getNext().getNext() != null)
            l = l.getNext();
        Object obj = l.getNext().getElement();
        l.setNext(null);
        return obj;
    }

    public void addFirst(Object obj) {
        // neuen Knoten hinter head einfügen
        Node n = new Node(obj, head);
        head = n;
    }

    public Object removeFirst() {
        // Sonderfall: Liste ist leer
        if (isEmpty()) return null;

        Object obj = head.getElement();
        head = head.getNext();
        return obj;
    }


    private class ListIterator implements Iterator {
        private Node node = null;
        public ListIterator() {
            node = head;
        }
        public boolean hasNext() {
            return node != null;
        }
        public Object next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Object obj = node.getElement();
            node = node.getNext();
            return obj;
        }
    }

    public Iterator iterator() {
        return new ListIterator();
    }

    public List invertAsCopy() {
        List list = new List();
        Node a = this.head;
        while (a != null) {
            Node b = list.head;
            list.head = new Node(a);
            list.head.setNext(b);
            a = a.getNext();
        }
        return list;
    }

    public static void main(String[] args) {
        List liste = new List();

        liste.addFirst("Eins");
        liste.addFirst("Zwei");
        liste.addFirst("Drei");
        liste.addFirst("Vier");
        liste.addFirst("Fünf");

        List list =liste.invertAsCopy();
        list.iterator().forEachRemaining(System.out::println);
    }
}
