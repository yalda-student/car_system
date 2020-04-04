class maxHeap {

    private int maxSize, n = 0;
    private Node[] accounts;

    maxHeap(int maxSize) {

        this.maxSize = maxSize;
        accounts = new Node[maxSize + 1];
    }

    private boolean isFull() {
        return n == maxSize;
    }

    private boolean isEmpty() {
        return n == 0;
    }

    boolean insert(Node node) {

        boolean flag = true;

        if (isFull())
            return false;

        n++;
        accounts[n] = node;
        int i = n;

        while (i > 1 && flag) {
            if (accounts[i].compareTo(accounts[i / 2]) >= 0)
                swap(i, i / 2);

            else flag = false;
            i = i / 2;
        }
        return true;
    }

    boolean delete() {

        if (isEmpty())
            return false;

        boolean flag = true;
        accounts[1] = accounts[n];
        n--;
        int i = 1;

        while (i <= n / 2 && flag) {

            int minIndex = 2 * i;

            if ((minIndex + 1) <= n && accounts[minIndex + 1].compareTo(accounts[minIndex]) >= 0)
                minIndex = minIndex + 1;


            if (accounts[i].compareTo(accounts[minIndex]) < 0)
                swap(i, minIndex);
            else
                flag = false;
            i = minIndex;
        }
        return true;
    }

    private void swap(int i, int j) {

        Node temp = accounts[i];
        accounts[i] = accounts[j];
        accounts[j] = temp;
    }

    void clear() {

        for (int i = n; i > 1; i--) {

            Node node = this.getMax();
//            System.out.println(node.toString());
            this.delete();
        }
    }

    Node getMax() {
        return accounts[1];
    }
}
