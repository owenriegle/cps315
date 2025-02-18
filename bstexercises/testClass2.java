class TestClass2 {
    public static void main(String[] args) {
        BSTree<String> bst = new BSTree<>();
        bst.insert("Gina");
        bst.insert("Maeve");
        bst.insert("Tom");
        bst.insert("Anna");
        bst.insert("Jen");
        bst.insert("Pat");
        bst.insert("Danielle");
        System.out.println("---inorder scan----should give Anna Danielle Gina Jen Maeve Pat Tom ----");
        bst.inOrderScan(bst.root);
        System.out.println();
        System.out.println("---preorder scan---should give Gina Anna Danielle Maeve Jen Tom Pat -------");
        bst.preOrderScan(bst.root);
        System.out.println();
        System.out.println("---postorder scan---should give Danielle Anna Jen Pat Tom Maeve Gina -------");
        bst.postOrderScan(bst.root);
        System.out.println();
        System.out.println("Height of the tree: " + bst.height(bst.root));
        System.out.println();
        System.out.println("----Leaf nodes-----should give Danielle Jen Pat");
        bst.findLeaves(bst.root);
        System.out.print("Enter a name to search for: ");
        java.util.Scanner sc = new java.util.Scanner(System.in);
        String p = sc.next();
        if (bst.search(p)) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }
        sc.close();
    }
}