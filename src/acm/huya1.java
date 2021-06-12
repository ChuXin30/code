package acm;

public class huya1 {
    void print_binary_tree(Node root)
    {

        LinkedList<Node> q = new LinkedList<Node>();
        q.offer(root);
        while(!q.()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++ ){
                Node n = q.poll();
                if(n == null)continue;
                q.offer(n.left);
                q.offer(n.right);
                System.out.print(n.val);
            }
            System.out.println();
        }
    }
}
