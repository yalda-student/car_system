
public class test {

    public static void main(String[] args) {

        maxHeap maxHeap = new maxHeap(5);
//
        maxHeap.insert(new Node("m", 5));
        maxHeap.insert(new Node("b", 9));
//        maxHeap.insert(new Node("y", 12));
//        maxHeap.insert(new Node("b", 10));
//        maxHeap.insert(new Node("yalda", 114));
//        maxHeap.insert(new Node("hgf", 1));
//        maxHeap.insert(new Node("ert", 25));
        System.out.println(maxHeap.getMax().toString());
//        maxHeap.clear();
//
//        System.out.printf("%.2f", 5.2);
    }
}
