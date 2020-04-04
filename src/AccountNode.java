class AccountNode {

    private String person1, person2;
    private int moneyTo, moneyFrom = 0;
    private boolean status;
    AccountNode link;

    AccountNode(String person1, String person2, int money) {

        this.person1 = person1;
        this.person2 = person2;
        status = true;
        moneyTo = money;
        moneyFrom = -money;
    }

    AccountNode(String person1, String person2) {
        this.person1 = person1;
        this.person2 = person2;
    }

    String getPerson1() {
        return person1;
    }

    String getPerson2() {
        return person2;
    }

    void setMoney(int money, boolean status) {

        if (status) {
            moneyTo = money;
            moneyFrom = -money;

        } else {
            moneyFrom = money;
            moneyTo = -money;
        }
        this.status = status;
    }

    void equality(boolean status) {

        moneyTo = 0;
        moneyFrom = 0;
        this.status = status;
    }

    boolean getStatus() {
        return status;
    }

    int getMoney(boolean status) {

//        System.out.println("\nto = " + moneyTo);
//        System.out.println("from = " + moneyFrom);

        if (this.status == status) {

            if (status) {
//                System.out.println("iff");
                return moneyTo;
            } else return moneyFrom;

        } else {
            if (this.status) {
//                System.out.println("elif");
                return moneyFrom;
            } else {
//                System.out.println("elss");
                return moneyTo;
            }
        }

    }

    @Override
    public String toString() {

        return "p1 = " + person1 + " ,p2 = " + person2;
    }
}
