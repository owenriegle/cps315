package graphexercises;

public class testClass1 {
    public static void main(String[] args) {
        Integer a1 = 9;
        Integer a2 = 7;
        Integer a3 = Integer.valueOf(-1);
        Integer a4 = Integer.valueOf(-7);
        Integer a5 = Integer.valueOf(1);
        Integer a6 = Integer.valueOf(13);
        Integer a7 = Integer.valueOf(2);
        Integer a8 = Integer.valueOf(3);
        Integer a9 = Integer.valueOf(8);
        Integer a10 = Integer.valueOf(-10);
        Integer a11 = Integer.valueOf(10);
        BSTree<Integer> bst = new BSTree<>(a1);
        bst.insert(a2);
        bst.insert(a3);
        bst.insert(a4);
        bst.insert(a5);
        bst.insert(a6);
        bst.insert(a7);
        bst.insert(a8);
        bst.insert(a9);
        bst.insert(a10);
        bst.insert(a11);
        // 9
        // 7 13
        // -1 8 10
        // -7 1
        // -10 2
        // 3
        System.out.println("---inorder scan----should give -10 -7 -1 1 2 3 7 8 9 10 13 ----");
        bst.inorderscan();
        System.out.println();
        System.out.println("---preorder scan---should give 9 7 -1 -7 -10 1 2 3 8 13 10 -------");
        bst.preorderscan();
        System.out.println();
        System.out.println("---postorder scan---should give -10 -7 3 2 1 -1 8 7 10 13 9 -------");
        bst.postorderscan();
        System.out.println();
        System.out.println("---levelorder scan---should give 9 7 13 -1 8 10 -7 1 -10 2 3 -------");
        bst.levelorderscan();
        System.out.println();
        System.out.println("Height of the tree: " + bst.height());
        System.out.println();
        System.out.println("----Leaf nodes-----should give -10 3 8 10 ");
        bst.findLeaves();
        System.out.println();
        System.out.print("Enter an int to search for: ");
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int p = sc.nextInt();

        if (bst.search(Integer.valueOf(p))) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }
        sc.close();
    }
}
