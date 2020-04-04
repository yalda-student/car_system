class AccountsList {

    private AccountNode first, tail;
    boolean newStatus;
    private int  size = 0;


    void addAccount(String s1, String s2, int newMoney) {

        AccountNode accountNode = new AccountNode(s1, s2, newMoney);
        newStatus = false;

        if (size == 0) {
            first = accountNode;
            tail = accountNode;
            size++;
            accountNode.link = null;

        } else {
            boolean prevStatus;
            AccountNode node = searchAccounts(accountNode);

            if (node != null) {

                prevStatus = node.getStatus();

                int prevMoney = node.getMoney(prevStatus);

                if (newStatus == prevStatus) {

                    node.setMoney(prevMoney + newMoney, newStatus);
                } else {

                    if (newMoney > Math.abs(prevMoney)) {
                        node.setMoney(newMoney - prevMoney, newStatus);

                    } else if (newMoney < Math.abs(prevMoney)) {
                        node.setMoney(Math.abs(prevMoney) - newMoney, prevStatus);

                    } else node.equality(newStatus);
                }

            } else {
                accountNode.link = null;
                tail.link = accountNode;
                tail = accountNode;
                size++;
            }
        }

    }

    AccountNode searchAccounts(AccountNode accountNode) {

        int counter = 0;
        String p1 = accountNode.getPerson1(), p2 = accountNode.getPerson2();
        AccountNode localFirst = first;

        while (localFirst != null && counter < size) {

            if (localFirst.getPerson1().equals(p1)) {
                if (localFirst.getPerson2().equals(p2)) {
                    newStatus = true;
                    return localFirst;
                }
            } else if (localFirst.getPerson1().equals(p2)) {
                if (localFirst.getPerson2().equals(p1)) {
                    newStatus = false;
                    return localFirst;
                }
            }
            if (localFirst.link != null) {

                localFirst = localFirst.link;
                counter++;
            } else break;
        }
        return null;
    }

    AccountNode getFirst() {
        return first;
    }

    int getSize() {
        return size;
    }
}
