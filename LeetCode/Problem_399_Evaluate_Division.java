class Solution {
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        Map<String, List<String>> graph = new HashMap<>();
        Map<String,Double> weight = new HashMap<>();
        int x=0;
        for(List<String> eq : equations){
            graph.putIfAbsent(eq.get(0), new ArrayList<>());
            graph.putIfAbsent(eq.get(1), new ArrayList<>());
            graph.get(eq.get(0)).add(eq.get(1));
            graph.get(eq.get(1)).add(eq.get(0));
            weight.put(eq.get(0)+eq.get(1),values[x]);
            weight.put(eq.get(1)+eq.get(0),1/values[x]);
            weight.put(eq.get(0)+eq.get(0),1.0);
            weight.put(eq.get(1)+eq.get(1),1.0);
            x++;
        }
        List<Double> result = new ArrayList<>();
        for(List<String> q : queries){
            int sb = result.size();
            dfs(graph, weight, q.get(0), q.get(1), 1, result, new HashSet<>());
            if(result.size()==sb)
                result.add(-1.0);
        }
        double[] res = new double[result.size()];
        int ri=0;
        for(double it : result)
            res[ri++]=it;
        return res;
    }
    
    private void dfs(Map<String, List<String>> graph, Map<String,Double> weight, String source, String destination, double cwt, List<Double> result, Set<String> visited){
        if(visited.contains(source))
            return;
        if(source.equals(destination) && weight.containsKey(source+source)){
            result.add(cwt);
            return;
        }
        visited.add(source);
        if(graph.get(source)!=null){
            for(String nei : graph.get(source)){
                if(weight.get(source+nei)!=null)
                    dfs(graph, weight, nei, destination, cwt*weight.get(source+nei), result, visited);
            }
        }
    }    
}
