package humanresources;

public class List {
    public Node first;

    public List() {
        this.first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void add(BusinessTravel info) {
        Node temp = new Node(info);
        temp.next = first;
        first = temp;

    }
    public void print() {
        Node temp = first;
        while (temp != null) {
            System.out.println(temp.item);
            temp = temp.next;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(first);
        return sb.toString();
    }

    private static class Node {
        BusinessTravel item;
        Node next;

        Node(BusinessTravel item) {
            this.item = item;
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
