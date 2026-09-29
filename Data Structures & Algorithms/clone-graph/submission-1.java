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
    //Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        map.put(node, new Node(node.val));

        while(!queue.isEmpty()){
            System.out.println("called while");
            Node top = queue.remove();
            
            for(Node neighbour : top.neighbors){
                if(!map.containsKey(neighbour)){
                    Node clone = new Node(neighbour.val);
                    map.put(neighbour, clone);
                    queue.add(neighbour);
                }
                map.get(top).neighbors.add(map.get(neighbour));
            }
        }
        return map.get(node);

    }
    // public Node createClone(Node node){

    //     Node nodecopy;
    //     if(map.containsKey(node)){
    //         nodecopy= map.get(node);
    //     } else{
    //      nodecopy = new Node(node.val);
    //      map.put(node, nodecopy);
    //     }

    //     for(Node neighbour : node.neighbors){
    //         if(map.containsKey(neighbour)){
    //             nodecopy.neighbors.add(map.get(neighbour));
    //         } else{
    //          Node neighbourclone = new Node(neighbour.val);
    //          nodecopy.neighbors.add(neighbourclone);
    //          map.put(neighbour, neighbourclone);
    //         }
            
    //     }

    //     return nodecopy;
    // }
}