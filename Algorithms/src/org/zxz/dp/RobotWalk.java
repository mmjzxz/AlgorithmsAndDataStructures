package org.zxz.dp;

/**
 * @author LEGION
 * @date 2022/8/16
 * 链接：https://www.nowcoder.com/questionTerminal/54679e44604f44d48d1bcadb1fe6eb61
 * 来源：牛客网
 * <p>
 * 假设有排成一行的N个位置，记为1~N，开始时机器人在M位置，机器人可以往左或者往右走，
 * 如果机器人在1位置，那么下一步机器人只能走到2位置，如果机器人在N位置，那么下一步机器人只能走到N-1位置。
 * 规定机器人只能走k步，最终能来到P位置的方法有多少种。
 */
public class RobotWalk {
    public static void main(String[] args) {
        int positions = 5;
        int currentPosition = 2;
        int remainSteps = 3;
        int destination = 3;
        System.out.println(walkWaysRecursion(positions, currentPosition, remainSteps, destination));
        int[][] dpCache = new int[positions + 1][remainSteps + 1];
        initDpCache(dpCache);
        System.out.println(walkWaysRecursionWithDpCache(positions, currentPosition, remainSteps, destination, dpCache));
    }

    /**
     * @param positions:       the number of positions
     * @param currentPosition: the current position
     * @param remainSteps:     the remaining steps
     * @param destination:     the destination position
     * @return the number of ways
     */
    public static int walkWaysRecursion(int positions, int currentPosition, int remainSteps, int destination) {
        // 剩余步数为0，如果当前位置与目的地位置相等，则返回1，否则返回0
        if (remainSteps == 0) {
            return currentPosition == destination ? 1 : 0;
        }
        // 当前位置为1，则只能往右走
        if (currentPosition == 1) {
            return walkWaysRecursion(positions, 2, remainSteps - 1, destination);
        }
        // 当前位置为最后一个位置，则只能往左走
        if (currentPosition == positions) {
            return walkWaysRecursion(positions, positions - 1, remainSteps - 1, destination);
        }
        // 当前位置为中间位置，则可以往左走和往右走
        return walkWaysRecursion(positions, currentPosition + 1, remainSteps - 1, destination) +
                walkWaysRecursion(positions, currentPosition - 1, remainSteps - 1, destination);
    }


    /**
     * initialize the dpCache, fill array with -1
     * @param dpCache
     */
    private static void initDpCache(int[][] dpCache) {
        for (int i = 0; i < dpCache.length; i++) {
            for (int j = 0; j < dpCache[i].length; j++) {
                dpCache[i][j] = -1;
            }
        }
    }

    /**
     * @param positions:       the number of positions
     * @param currentPosition: the current position
     * @param remainSteps:     the remaining steps
     * @param destination:     the destination position
     * @param dpCache:         the cache,record the result has been calculated
     * @return the number of ways
     */
    public static int walkWaysRecursionWithDpCache(int positions, int currentPosition, int remainSteps, int destination, int[][] dpCache) {
        if (dpCache[currentPosition][remainSteps] != -1) {
            return dpCache[currentPosition][remainSteps];
        }
        if (remainSteps == 0) {
            dpCache[currentPosition][remainSteps] = currentPosition == destination ? 1 : 0;
        } else if (currentPosition == 1) {
            dpCache[currentPosition][remainSteps] = walkWaysRecursionWithDpCache(positions, 2, remainSteps - 1, destination, dpCache);
        } else if (currentPosition == positions) {
            dpCache[currentPosition][remainSteps] = walkWaysRecursionWithDpCache(positions, positions - 1, remainSteps - 1, destination, dpCache);
        } else {
            dpCache[currentPosition][remainSteps] = walkWaysRecursionWithDpCache(positions, currentPosition + 1, remainSteps - 1, destination, dpCache) +
                    walkWaysRecursionWithDpCache(positions, currentPosition - 1, remainSteps - 1, destination, dpCache);
        }
        return dpCache[currentPosition][remainSteps];
    }
}
