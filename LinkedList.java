package humanresources;

public class LinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    private int count = 0;

    public LinkedList() {
        last = new Node<T>(first, null, null);
        first = new Node<T>(null, null, last);
    }
    public LinkedList(T[] items) {
        for (T t : items) {
            add(t);
        }
    }
    public Node<T> getFirst() {
        return first;
    }

    public void setFirst(Node<T> first) {
        this.first = first;
    }

    public Node<T> getLast() {
        return last;
    }

    public void setLast(Node<T> last) {
        this.last = last;
    }

    public int getCount() {
        return count;
    }

    public void add(T item) {
        Node<T> exLast = last;
        Node<T> newLast = new Node<T>(exLast, item, null);
        last = newLast;
        if (exLast == null) {
            first = newLast;
        } else {
            exLast.next = newLast;
        }
        count++;
    }

    public void addFirst(T item) {
        Node<T> exFirst = first;
        Node<T> newFirst = new Node<T>(null, item, exFirst);
        first = newFirst;
        if (exFirst == null) {
            last = newFirst;
        } else {
            exFirst.prev = newFirst;
        }
        count++;
    }


    public void remove(T item) {
/*        if (item == null) {
            for (Node<T> i = first; i != null; i = i.next) {
                if (i.item == null) {
                    deleteNode(i);
                    return true;
                }
            }
        }Для чего в LinkedList(util) это, может если мы извне присвоим нашему item-у null?*/
        for (Node<T> i = first; i != null; i = i.next) {
            if (item.equals(i.item)) {
                deleteNode(i);
            }
        }
    }

    public int removeCounted(T item) {
        int k = 0;
        for (Node<T> i = first; i != null; i = i.next) {
            if (item.equals(i.item)) {
                deleteNode(i);
                k++;
            }
        }
        return k;
    }

    public boolean isEmpty() {
        return first == null;
    }

    void deleteNode(Node<T> i) {
        T element = i.item;
        Node<T> prev = i.prev;
        Node<T> next = i.next;
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            i.prev = null;
        }
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            i.next = null;
        }
        i.item = null;
        count--;
        //В LinkedList здесь мы return element, для чего это нужно
    }

    @SuppressWarnings("unchecked")
    public T[] toArray() {
        Object[] items = new Object[count];
        int j = 0;
        for (Node<T> i = first; i != null; i = i.next) {
            items[j++] = i.item;
        }
        return (T[]) items;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(first);
        return sb.toString();
    }

    class Node<T> {
        T item;
        Node next;
        Node prev;

        Node() {
        }

        Node(Node prev, T item, Node next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            // Здесь предлагает так - return String.valueOf(item) + next;
            sb.append(item).append(next);
            return sb.toString();
        }
    }
}
