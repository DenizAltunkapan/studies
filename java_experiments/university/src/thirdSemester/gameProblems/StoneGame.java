package thirdSemester.gameProblems;

public class StoneGame {

    /**
     * This method calculates the maximum score that the first player can achieve
     * when playing optimally in the stone game.
     *
     * @param piles An array of integers representing the piles of stones.
     *              Each element in the array corresponds to the number of stones in a pile.
     *              The player can choose a pile from the beginning or the end during their turn.
     */
    public static void stoneGame(int[] piles) {
        int n = piles.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = piles[i];
        }

        for (int len = 2; len <= n; len++) {
            int[] copy = new int[n];
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                copy[i] = Math.max(piles[i] - dp[i + 1], piles[j] - dp[i]);
            }

            dp = copy;
        }

        System.out.println(dp[0]);
    }

    public static void main(String[] args) {
        // Example of a set of piles
        int[] piles = {5, 8, 4, 5};
        stoneGame(piles);
    }
}
