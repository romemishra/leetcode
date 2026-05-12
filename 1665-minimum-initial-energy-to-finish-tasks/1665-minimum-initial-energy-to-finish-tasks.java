class Solution {
    public int minimumEffort(int[][] tasks) {

        Arrays.sort(tasks, (a, b) -> {
            return (b[1] - b[0]) - (a[1] - a[0]);
        });

        int answer = 0;
        int energy = 0;

        for (int[] task : tasks) {

            int actual = task[0];
            int minimum = task[1];

            // Increase energy if current energy is insufficient
            if (energy < minimum) {
                answer += (minimum - energy);
                energy = minimum;
            }

            // Complete the task
            energy -= actual;
        }

        return answer;
    }
}