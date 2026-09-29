/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        
        Node root = null;
        
        Set<Node> set = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        //set.add(node);

        while(!queue.isEmpty()){
            System.out.println("called while");
            Node top = queue.remove();
            if(top==null){
                continue;
            }
            if(!set.contains(top)){
                Node clonetop = createClone(top);
                if(root==null){
                    System.out.println("called");
                    root = clonetop;
                    System.out.println(root.val);
                }
                set.add(top);
                map.put(top, clonetop);
                for(Node neighbour: top.neighbors){
                    queue.add(neighbour);
                }
            }
        }
        return root;

    }
    public Node createClone(Node node){

        Node nodecopy;
        if(map.containsKey(node)){
            nodecopy= map.get(node);
        } else{
         nodecopy = new Node(node.val);
         map.put(node, nodecopy);
        }

        for(Node neighbour : node.neighbors){
            if(map.containsKey(neighbour)){
                nodecopy.neighbors.add(map.get(neighbour));
            } else{
             Node neighbourclone = new Node(neighbour.val);
             nodecopy.neighbors.add(neighbourclone);
             map.put(neighbour, neighbourclone);
            }
            
        }

        return nodecopy;
    }
}