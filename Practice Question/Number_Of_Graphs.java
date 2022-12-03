import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Number_Of_Graphs {

    // giving a 2D array, arr length is the number of people
    // each sub-array is showing each person's relationship with others
    // if == 1, has relation, 0 means no relation
    // find how many groups of people in this 2D array


    // it's a graph search question
    // dfs recursive
    public static int dfs(int[][] relation){
        int people = relation.length;
        boolean[] visited = new boolean[people];
        int count = 0;
        // visited every person
        for(int i = 0; i < people; i++){
            // marked others as visited if they have relationship
            if(visited[i] == false){
                process(i, visited, relation);
                count++;
            }
        }
        return count;
    }
    private static void process(int people, boolean[] visited, int[][] relation){
            // checked relation with others
            for(int j = 0; j < relation.length; j++){
                // only change if other has relation with this person and not be visited
                if(relation[people][j] == 1 && visited[j] == false){
                    visited[j] = true;
                    // dfs --> find relation with new person first
                    process(j, visited, relation);
                }
            }
    }


    // bfs queue
    public static int bfs(int[][] relation){
        int people = relation.length;
        boolean[] visited = new boolean[people];
        int count = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < people; i++){
            if(!visited[i]){
                queue.add(i);
                while (!queue.isEmpty()){
                    int person = queue.poll();
                    // set person itself as visited
                    visited[person] = true;
                    // check the relation with others
                    for(int j = 0; j < people; j++){
                        if(relation[person][j] == 1 && !visited[j]){
                            queue.add(j);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }


    // unionSet
    static class UnionSet<V>{
        static class Node<V>{
            public V value;
            public Node(V value){this.value = value;}
        }
        HashMap<V, Node> nodes = new HashMap<V, Node>();
        HashMap<Node, Node> root = new HashMap<Node, Node>();
        HashMap<Node, Integer> size = new HashMap<Node, Integer>();

        public UnionSet(){};
        public UnionSet(V[] data){
            for(V ele: data){
                Node node = new Node(ele);
                nodes.put(ele, node);
                root.put(node, node);
                size.put(node, 1);
            }
        }
        public void add(V data){
            Node node = new Node(data);
            nodes.put(data, node);
            root.put(node, node);
            size.put(node,1);
        }
        private Node findFather(Node X){
            Stack<Node> path = new Stack<Node>();
            // get the parents
            while(X != root.get(X)){
                path.push(X);
                X = root.get(X);
            }

            // set root of all the node to X;
            while (!path.isEmpty()){
                root.put(path.pop(), X);
            }
            return X;


        }
        public boolean isSameSet(V x, V y){
            if(nodes.containsKey(x) == false || nodes.containsKey(y) == false){
                return false;
            }else{
                Node X = nodes.get(x);
                Node Y = nodes.get(y);
                return findFather(X) == findFather(Y);
            }
        }
        public void union(V x, V y){
            if(nodes.containsKey(x) == false || nodes.containsKey(y) == false){
                return;
            }
            if(isSameSet(x, y) == false){
                Node X = nodes.get(x);
                Node Y = nodes.get(y);
                int xSize = size.get(X),
                        ySize = size.get(Y);
                if(xSize <= ySize){
                    root.put(X, Y);
                    size.put(Y, xSize + ySize);
                    size.remove(X);
                }else{
                    root.put(Y, X);
                    size.put(X, xSize + ySize);
                    size.remove(Y);
                }
            }
        }
    }

    // test
    public static void main(String[] args) {
        int[][] relation1 = new int[][]{{1,1,0}  , {1,1,1},  {0,1,1}}; // 1
        int[][] relation2 = new int[][]{{1,1,0}  , {1,1,0},  {0,0,1}}; // 2
        int[][] relation3 = new int[][]{{1,0,0}  , {0,1,0},  {0,0,1}}; // 3

        System.out.println(bfs(relation1));
        System.out.println(bfs(relation2));
        System.out.println(bfs(relation3));


        // test unionSet
        UnionSet<Integer> union1 = new UnionSet<Integer>();
        for(int p = 0; p<relation3.length; p++){
            union1.add(p);
        }
        for(int i = 0; i < relation3.length; i++){
            for(int j = 0; j < relation3.length; j++){
                if(relation3[i][j] == 1){
                    union1.union(i,j);
                }
            }
        }
        System.out.println(union1.size.size());

    }
}
