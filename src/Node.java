class Node implements Comparable {

    private String name;
    private int money;

    Node(String name) {
        this.name = name;
        money = 0;
    }

    Node(String name, int money) {
        this.name = name;
        this.money = money;
    }

    String getName() {
        return name;
    }

    void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "name = " + name + "\tmoney = " + money;
    }

    @Override
    public int compareTo(Object object) {

        if (this.money > ((Node) object).money)
            return 1;

        else if (this.money == ((Node) object).money) {

            if (this.name.compareTo(((Node) object).name) < 0) return 1;
            else return -1;
        } else return -1;
    }
}
