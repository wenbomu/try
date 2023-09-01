import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class solution_for_863_problem {
	
	public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { 
		    	  this.val = x; 
		    	  left = null;
		    	  right = null;
		    	  }
		 }
	
	public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> answer = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        //Set<Integer> visited = new HashSet<>();

        if(root==null){
            return answer;
        }
        //first, store the tree to the hashap
        create_hashmap(root, -1, map);

        if(map.get(target.val)==null){
            return answer;
        }
        if(k==0){
            answer.add(target.val);
        }
        //start bfs
        for(Integer adj:map.get(target.val)){
            bfs(adj, 1, target.val, map, k, answer);
        }
        return answer;
    }

    public static void bfs(int cur_node, int level, int parent, HashMap<Integer, List<Integer>> map, int k, List<Integer> answer){
        if(level==k){
            answer.add(cur_node);
        }
        for(Integer adj:map.get(cur_node)){
            if(adj==parent){
                continue;
            }
            bfs(adj, level+1, cur_node, map, k, answer);
        }
    }

    public static void create_hashmap(TreeNode root, int parent, HashMap<Integer, List<Integer>> map){
        if(root!=null){
            map.putIfAbsent(root.val, new ArrayList<Integer>());
            if(root.left!=null){
                (map.get(root.val)).add(root.left.val);
                create_hashmap(root.left, root.val, map);
            }
            if(root.right!=null){
                (map.get(root.val)).add(root.right.val);
                create_hashmap(root.right, root.val, map);
            }
            if(parent>=0){
                (map.get(root.val)).add(parent);
            }
            
        }
    }
    
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(4);
		TreeNode test = new TreeNode(4);
		System.out.println(distanceK(root, test, 1));
	}

}
