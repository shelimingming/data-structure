package com.sheliming.graph;

import java.util.Stack;

public class DFSStack {
    /** 存储节点信息*/
    private char[] vertices;

    /** 存储边信息（邻接矩阵）*/
    private  int[][] arcs;

    /** 图的节点数*/
    private int vexnum;

    /** 记录节点是否已被遍历*/
    private boolean[] visited;

    /** 初始化*/
    public DFSStack(int n) {
        vexnum = n;
        vertices = new char[n];
        arcs = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < vexnum; i++) {
            for (int j = 0; j < vexnum; j++) {
                arcs[i][j] = 0;
            }
        }
    }

    /** 添加边*/
    public void addEdge(int i, int j){
        if(i==j){
            return ;
        }
        // 无向图对称的.
        arcs[i][j]=1;
        arcs[j][i]=1;
    }

    /** 设置节点集*/
    public void setVertices(char[] vertices){
        this.vertices=vertices;
    }

    /** 设置节点访问标记*/
    public void setVisited(boolean[] visited){
        this.visited=visited;
    }

    /** 打印遍历节点*/
    public void visit(int i){
        System.out.print(vertices[i]+ " ");
    }

    /**
     *  输出邻接矩阵
     */
    public void pritf(int[][] arcs){
        for(int i=0;i<arcs.length;i++){
            for(int j=0;j<arcs[0].length;j++){
                System.out.print(arcs[i][j]+ "\t");
            }
            System.out.println();
        }
    }

    public  void dfs(){
        // 初始化所有的节点的访问标志
        for (int v = 0; v < visited.length; v++) {
            visited[v] = false;
        }
        Stack<Integer> stack =new Stack<Integer>();
        for(int i=0;i<vexnum;i++){
            if(visited[i]==false){
                visited[i]=true;
                System.out.print(vertices[i]+" ");
                stack.push(i);
            }
            while(!stack.isEmpty()){
                // 当前出栈的节点
                int k = stack.pop();
                for(int j=0;j<vexnum;j++){
                    // 如果是相邻的节点且没有访问过.
                    if(arcs[k][j]==1&&visited[j]==false){
                        visited[j]=true;
                        System.out.print(vertices[j]+" ");
                        stack.push(j);
                        // 这条路结束,返回上一个节点.
                        break;
                    }
                }

            }
        }
        // 输出二维矩阵
        System.out.println();
        pritf(arcs);
    }

    public static void main(String[] args) {
        DFSStack dfs = new DFSStack(9);
        // 添加节点集
        char[] vertices = {'A','B','C','D','E','F','G','H','I'};
        // 设置顶点集
        dfs.setVertices(vertices);
        // 添加边
        dfs.addEdge(0, 1);
        dfs.addEdge(0, 5);
        dfs.addEdge(1, 0);
        dfs.addEdge(1, 2);
        dfs.addEdge(1, 6);
        dfs.addEdge(1, 8);
        dfs.addEdge(2, 1);
        dfs.addEdge(2, 3);
        dfs.addEdge(2, 8);
        dfs.addEdge(3, 2);
        dfs.addEdge(3, 4);
        dfs.addEdge(3, 6);
        dfs.addEdge(3, 7);
        dfs.addEdge(3, 8);
        dfs.addEdge(4, 3);
        dfs.addEdge(4, 5);
        dfs.addEdge(4, 7);
        dfs.addEdge(5, 0);
        dfs.addEdge(5, 4);
        dfs.addEdge(5, 6);
        dfs.addEdge(6, 1);
        dfs.addEdge(6, 3);
        dfs.addEdge(6, 5);
        dfs.addEdge(6, 7);
        dfs.addEdge(7, 3);
        dfs.addEdge(7, 4);
        dfs.addEdge(7, 6);
        dfs.addEdge(8, 1);
        dfs.addEdge(8, 2);
        dfs.addEdge(8, 3);
        System.out.print("深度优先遍历（非递归实现）：");
        dfs.dfs();
    }
}
