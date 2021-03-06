/*
时间限制：1秒
空间限制：32768K

在一条无限长的跑道上，有N匹马在不同的位置上出发开始赛马。当开始赛马比赛后，所有的马开始以自己的速度一直匀速前进。
每匹马的速度都不一样，且全部是同样的均匀随机分布。在比赛中当某匹马追上了前面的某匹马时，被追上的马就出局。
请问按以上的规则比赛无限长的时间后，赛道上剩余的马匹数量的数学期望是多少
输入描述:
每个测试输入包含1个测试用例
输入只有一行，一个正整数N
1 <= N <= 1000

输出描述:
输出一个浮点数，精确到小数点后四位数字，表示剩余马匹数量的数学期望

输入例子1:
1
2

输出例子1:
1.0000
1.5000
 */

/**
 * Approach: Mathematics
 * 这是一个离散分布求数学期望的数学模型，重要的是求出剩余马匹数和对应的概率值
 * 本题切入点在于：赛道是无限长的，这就意味着只要后面马的速度更快，那么它一定就可以超过当前这匹马。
 * 因此我们只需要分析马的 速度 和 位置 即可。
 *  马的速度总可以从大到小排列 v1 > v2 > v3 >… > vN，不同速度的马存活与否和马出现的位置直接相关。
 *  速度最快 v1 的马无论出现在什么位置都能存活，存活概率为 1
 *  速度 v2 只有出现在最快马之前才能存活，由于马的速度是均匀随机分布，就是说v2在最快马之前之后等概，为 1/2
 *  速度 v3 出现在v2之前、v2 v1之间、v1之后也是等概，为 1/3
 * 因此可以通过 E = 1 + 1/2 + 1/3 + … + 1/n 求有马匹数量的数学期望
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();

            double E = 0;
            while (n > 0) {
                E += 1 / (double)(n--);
            }
            System.out.printf("%.4f", E);
        }
    }
}