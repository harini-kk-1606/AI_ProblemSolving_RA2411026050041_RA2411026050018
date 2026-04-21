import java.util.*;

public class Navigation {

    static Map<String, List<String>> graph = new HashMap<>();

    static {
        graph.put("A", Arrays.asList("B", "C"));
        graph.put("B", Arrays.asList("D", "E"));
        graph.put("C", Arrays.asList("D"));
        graph.put("D", Arrays.asList("F"));
        graph.put("E", Arrays.asList("F"));
        graph.put("F", new ArrayList<>());
    }

    public static List<String> bfs(String start, String goal) {
        Queue<List<String>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(Arrays.asList(start));

        while (!queue.isEmpty()) {
            List<String> path = queue.poll();
            String node = path.get(path.size() - 1);

            if (node.equals(goal)) return path;

            if (!visited.contains(node)) {
                visited.add(node);
                for (String neighbor : graph.get(node)) {
                    List<String> newPath = new ArrayList<>(path);
                    newPath.add(neighbor);
                    queue.add(newPath);
                }
            }
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        System.out.println("BFS Path: " + bfs("A", "F"));
    }
}