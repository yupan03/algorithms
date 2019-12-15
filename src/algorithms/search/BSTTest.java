package algorithms.search;

public class BSTTest {

    public static void main(String[] args) {
        BST<Long, String> bst = new BST<Long, String>();

        bst.put(1L, "1");
        bst.put(2L, "2");
        bst.put(4L, "4");
        bst.put(5L, "5");
        bst.put(0L, "0");

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
        System.out.println("向上取数2.5:" + bst.floor((long) 2.5));
        System.out.println("向下取数0.5:" + bst.ceil((long) 0.5));
        
        System.out.println("指定位置的元素3："+ bst.select(3));
        System.out.println("元素3的位置:" + bst.rank(3L));
    }
}