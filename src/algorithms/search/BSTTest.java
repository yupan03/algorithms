package algorithms.search;

public class BSTTest {

    public static void main(String[] args) {
        BST<Long, String> bst = new BST<Long, String>(3L, "0");

        bst.put(1L, "3");
        bst.put(0L, "3");
        bst.put(2L, "3");
        bst.put(4L, "3");
        bst.put(5L, "3");

        System.out.print("先序遍历：");
        bst.recursivePreOrder();
        System.out.println();
        System.out.print("中序遍历：");
        bst.recursiveInOrder();
        System.out.println();
        System.out.print("后序遍历：");
        bst.recursivePostOrder();
        System.out.println();

        System.out.println("树大小:" + bst.size());
        System.out.println("最小值:" + bst.min());
        System.out.println("最大值:" + bst.max());
        System.out.println("向上取数:" + bst.floor((long) 2.5));
        System.out.println("向下取数:" + bst.ceil((long) 0.5));
    }
}