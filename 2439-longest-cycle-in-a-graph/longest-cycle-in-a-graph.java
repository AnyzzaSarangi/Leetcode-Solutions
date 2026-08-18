class Solution {
    public int longestCycle(int[] edges) {

        int n = edges.length;

        boolean[] visited = new boolean[n];

        int[] pathStart = new int[n];

        Arrays.fill(pathStart, -1);

        int answer = -1;

        for (int i = 0; i < n; i++) {

            if (visited[i]) {
                continue;
            }

            int current = i;
            int step = 0;

            while (current != -1 && !visited[current]) {

                visited[current] = true;

                pathStart[current] = step++;

                current = edges[current];
            }

            // We reached a node that was already visited.
            // Check whether it belongs to the current traversal.
            if (current != -1 && pathStart[current] != -1) {

                int cycleLength = step - pathStart[current];

                answer = Math.max(answer, cycleLength);
            }

            // Reset pathStart values for this traversal
            current = i;

            while (current != -1 && pathStart[current] != -1) {

                int next = edges[current];

                pathStart[current] = -1;

                current = next;
            }
        }

        return answer;
    }
}