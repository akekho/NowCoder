这是一道求联通区的题目。
通过遍历整个矩阵，并递归调用 infect() 函数便可以找到所有的联通区。
infect()函数的功能为以 m[i][j] 为基础向四周扩散，
判断四周是否存在值为 1 的点，若存在则递归调用它，以该点为基础继续向外扩散；
若四周均不存在值为 1 的点，或者已经到达边界，则结束该递归。
注：对于已经遍历过了的岛上的点，将其值置为2，防止重复计算。

/*
给定一个二维数组，所有位置的值不是0就是1. 规定每个位置可以和它上下左右位置上的值相连。
有一个叫做岛的概念，定义如下：
连成一片的1，如果周围都是0，那么这一片1，构成一个岛。
求整张图上有多少个岛。

样例1：
    输入：
    0, 0, 0, 0, 0, 0, 0, 0, 0
    0, 1, 1, 1, 0, 1, 1, 1, 0  
    0, 1, 1, 1, 0, 0, 0, 1, 0 
    0, 1, 1, 0, 0, 0, 0, 0, 0  
    0, 0, 0, 0, 0, 1, 1, 0, 0  
    0, 0, 0, 0, 1, 1, 1, 0, 0 
    0, 0, 0, 0, 0, 0, 0, 0, 0 
    输出：
    3

样例2：
    输入：
    0, 0, 0, 0, 0, 0, 0, 0, 0  
    0, 1, 1, 1, 1, 1, 1, 1, 0  
    0, 1, 1, 1, 0, 0, 0, 1, 0 
    0, 1, 1, 0, 0, 0, 1, 1, 0  
    0, 0, 0, 0, 0, 1, 1, 0, 0  
    0, 0, 0, 0, 1, 1, 1, 0, 0 
    0, 0, 0, 0, 0, 0, 0, 0, 0 
    输出：
    1
*/

public class Islands {
    // 遍历矩阵
	public static int countIslands(int[][] m) {
		if (m == null || m[0] == null) {
			return 0;
		}
		int N = m.length;
		int M = m[0].length;
		int res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (m[i][j] == 1) {
					res++;
					infect(m, i, j, N, M);
				}
			}
		}
		return res;
	}
    // 向外扩散函数，递归
	public static void infect(int[][] m, int i, int j, int N, int M) {
        // 若四周均不存在值为 1 的点，或者已经到达边界，则结束该递归。
		if (i < 0 || i >= N || j < 0 || j >= M || m[i][j] != 1) {
			return;
		}
        // 已经遍历过了的岛上的点将其值置为2，防止重复计算
		m[i][j] = 2;
        // 递归调用该函数向四周扩散
		infect(m, i + 1, j, N, M);
		infect(m, i - 1, j, N, M);
		infect(m, i, j + 1, N, M);
		infect(m, i, j - 1, N, M);
	}

	public static void main(String[] args) {
		int[][] m1 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				        { 0, 1, 1, 1, 0, 1, 1, 1, 0 }, 
				        { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
				        { 0, 1, 1, 0, 0, 0, 0, 0, 0 }, 
				        { 0, 0, 0, 0, 0, 1, 1, 0, 0 }, 
				        { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
				        { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
		System.out.println(countIslands(m1));

		int[][] m2 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
						{ 0, 1, 1, 1, 1, 1, 1, 1, 0 }, 
						{ 0, 1, 1, 1, 0, 0, 0, 1, 0 },
						{ 0, 1, 1, 0, 0, 0, 1, 1, 0 }, 
						{ 0, 0, 0, 0, 0, 1, 1, 0, 0 }, 
						{ 0, 0, 0, 0, 1, 1, 1, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
		System.out.println(countIslands(m2));

	}

}
