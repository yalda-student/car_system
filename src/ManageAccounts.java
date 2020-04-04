class ManageAccounts {

    private AccountsList accountsList;
    private int commandNumber, dlSize = 0, clSize = 0;
    private Node[] debtorsList, creditorList;

    ManageAccounts(int commandNumber) {

        this.commandNumber = commandNumber;
        accountsList = new AccountsList();
        debtorsList = new Node[commandNumber];
        creditorList = new Node[commandNumber];
    }

    void addAccounts(String s1, String s2, int money) {

        accountsList.addAccount(s1, s2, money);

        if (!checkInArray(creditorList, clSize, s1)) {
            creditorList[clSize] = new Node(s1);
            clSize++;
        }
        if (!checkInArray(debtorsList, dlSize, s2)) {
            debtorsList[dlSize] = new Node(s2);
            dlSize++;
        }

    }

    String findDebtor() {

        debtorArray();
        maxHeap heap = new maxHeap(debtorsList.length);

        for (int i = 0; i < dlSize; i++)
            heap.insert(debtorsList[i]);

        heap.clear();
        Node max = heap.getMax();
        return max.getName();
    }

    String findCreditor() {

        creditorArray();
        maxHeap heap = new maxHeap(creditorList.length);

        for (int i = 0; i < clSize; i++)
            heap.insert(creditorList[i]);

        heap.clear();
        Node max = heap.getMax();
        return max.getName();
    }

    int getMoney(String person1, String person2) {

        AccountNode node = new AccountNode(person1, person2);
        node = accountsList.searchAccounts(node);
        boolean status;

        if (node != null) {

            status = accountsList.newStatus;
            int money = node.getMoney(status);
            System.out.println(money);
            if (status == node.getStatus())

                if (status)
                    return money;
                else return -money;

            else if (status)
                return money;
            else return -money;

        } else return 0;
    }

    int countDebtors(String personName) {

        int counter = 0, size = 0;
        AccountNode current = accountsList.getFirst();

        while (current != null && size < accountsList.getSize()) {

            if ((current.getPerson1().equals(personName) && !current.getStatus()) || (current.getPerson2().equals(personName) && current.getStatus()))
                counter++;

            current = current.link;
            size++;
        }
        return counter;
    }

    int countCreditors(String personName) {

        int counter = 0, size = 0;
        AccountNode current = accountsList.getFirst();

        while (current != null && size < accountsList.getSize()) {

            if ((current.getPerson1().equals(personName) && current.getStatus()) || (current.getPerson2().equals(personName) && !current.getStatus()))
                counter++;

            current = current.link;
            size++;
        }

        return counter;
    }

    private void creditorArray() {

        AccountNode current = accountsList.getFirst();
        int size = 0;

        for (int i = 0; i < clSize; i++) {

            String name = creditorList[i].getName();
            int sum = 0;

            while (current != null && size < accountsList.getSize()) {
                if (current.getPerson1().equals(name)) {
                    int money = current.getMoney(current.getStatus());
                    if (money > 0)
                        sum = sum + money;
                }
                current = current.link;
                size++;
            }
            creditorList[i].setMoney(sum);
        }
    }

    private void debtorArray() {

        AccountNode current = accountsList.getFirst();
        int size = 0;

        for (int i = 0; i < dlSize; i++) {

            String name = debtorsList[i].getName();
            int sum = 0;

            while (current != null && size < accountsList.getSize()) {
                if (current.getPerson2().equals(name)) {
                    int money = current.getMoney(!current.getStatus());
                    if (money > 0)
                        sum = sum + money;
                }
                current = current.link;
                size++;
            }
//            System.out.println( " name = " + cre);
            System.out.println("sum = " + sum);
            debtorsList[i].setMoney(sum);
        }
    }

    private boolean checkInArray(Node[] array, int size, String name) {

        for (int i = 0; i < size; i++)
            if (array[i].getName().equals(name))
                return true;
        return false;
    }
}
