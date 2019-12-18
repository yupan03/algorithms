package algorithms.search;

public class BSTTest {

    public static void main(String[] args) {
        BST<Integer, String> bst = new BST<Integer, String>();

        bst.put(1, "1");
        bst.put(2, "2");
        bst.put(4, "4");
        bst.put(5, "5");
        bst.put(0, "0");

        System.out.print("先序遍历：");
        bst.recursivePreOrder();
        System.out.println();
        System.out.print("中序遍历：");
        bst.recursiveInOrder();
        System.out.println();
        System.out.print("后序遍历：");
        bst.recursivePostOrder();
        System.out.println();

        System.out.println("二叉树大小:" + bst.size());
        System.out.println("二叉树最小值:" + bst.min());
        System.out.println("二叉树最大值:" + bst.max());
        System.out.println("二叉树向上取数3:" + bst.floor(3));
        System.out.println("二叉树向下取数3:" + bst.ceil(3));

        System.out.println("二叉树指定位置的元素3：" + bst.select(3));
        System.out.println("二叉树元素3的位置:" + bst.rank(3));
        System.out.println("二叉树高度：" + bst.heigh());
        
    }
}