/*

    home,  abc
    profile, abc
    test, bcd
*/

class PageHitInfo {
    String pageName;
    String sessionId;
}

class PageTransitionPQNode {
    String transitionKey;
    int count;
}

class FindTopKTransitions {

    public List<String> getTopKTransitions(List<PageHitInfo> pageHitInfos, int k) {

        Map<String, List<String>> sessionIdToPageMap = new HashMap<>();
        for (PageHitInfo pageHitInfo: pageHitInfos) {
            if (sessionIdToPageMap.containsKey(pageHitInfo.getSessionId())) {
                sessionIdToPageMap.get(pageHitInfo.getSessionId).add(pageHitInfo.getPageName());
            } else {
                List<String> pages = new ArrayList<>();
                pages.add(pageHitInfo.getPageName());
                sessionIdToPageMap.put(sessionId, pages);
            }
        }

        Map<String, Integer> pageTransitionToCountMap = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : sessionIdToPageMap.entrySet()) {
            List<String> pages =  entry.getValue();
            if (pages.size() <= 1) continue;
            for (int i = 1; i < pages.size(); i++) {
                String transitionKey = pages.get(i).getPageName() + "->" +  pages.get(i - 1).getPageName();
                if (pageTransitionToCountMap.containsKey(transitionKey))  {
                    pageTransitionToCountMap.put(transitionKey, pageTransitionToCountMap.get(transitionKey) + 1)
                } else {
                    pageTransitionToCountMap.put(transitionKey,  1);
                }
            }
        }

        PriorityQueue<PageTransitionPQNode> pq = new PriorityQueue<>((a, b) -> a.count - b.count);
        for (Map.Entry<String, List<String>> entry : pageTransitionToCountMap.entrySet()) {
            PageTransitionPQNode pqNode = new PageTransitionPQNode(entry.getKey(), entry.getValue());
            if (pq.size() > k) {
                if (pq.peek().getCount() > pqNode.getCount()) {
                    pq.poll();
                    pq.offer(pqNode);
                }
            } else {
                pq.offer(pqNode);
            }
        }

        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        return result;
    }
}
