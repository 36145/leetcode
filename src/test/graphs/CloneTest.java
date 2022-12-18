package test.graphs;

import java.util.*;

public class CloneTest {

    public Node cloneGraph(Node node) {

        if (node == null)
            return null;

        HashMap<Node, Node> oldToNew = new HashMap<>();
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(node);
        oldToNew.put(node, new Node(node.val));

        while (queue.size() > 0) {
            Node current = queue.poll();
            for (Node neighbor : current.neighbors) {

                if (!oldToNew.containsKey(neighbor)) {
                    Node newClone = new Node(neighbor.val);
                    oldToNew.put(neighbor, newClone);
                    queue.add(neighbor);
                }

                oldToNew.get(current).neighbors.add(oldToNew.get(neighbor));

            }
        }

        return oldToNew.get(node);
    }
}

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

