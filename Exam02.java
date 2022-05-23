package com.survivalcoding.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Exam02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] lines = br.readLine().split(" ");

        int a = Integer.parseInt(lines[0]);
        int b = Integer.parseInt(lines[1]);
        int R = Integer.parseInt(lines[2]);

        int N = Integer.parseInt(br.readLine());

        Park park = new Park();

        Gongsa gongsa = new Gongsa(a, b, R);

        park.setGongsa(gongsa);

        for (int i = 0; i < N; i++) {
            String[] treeCoords = br.readLine().split(" ");
            int x = Integer.parseInt(treeCoords[0]);
            int y = Integer.parseInt(treeCoords[1]);
            Tree tree = new Tree(x, y);
            park.addTree(tree);
        }

        for (int i = 0; i < park.getSilentResult().size(); i++) {
            boolean result = park.getSilentResult().get(i);
            if (result) {
                System.out.println("silent");
            } else {
                System.out.println("noisy");
            }
        }

    }
}

class Tree {
    int x;
    int y;

    public Tree(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isSilent(Gongsa gongsa) {
        return Math.pow(x - gongsa.x, 2) + Math.pow(y - gongsa.y, 2) >= Math.pow(gongsa.R, 2);
    }
}

class Gongsa {
    int x;
    int y;
    int R;

    public Gongsa(int x, int y, int r) {
        this.x = x;
        this.y = y;
        R = r;
    }

    public boolean isSilent(Tree tree) {
        return Math.pow(x - tree.x, 2) + Math.pow(y - tree.y, 2) >= Math.pow(R, 2);
    }
}

class Park {
    private Gongsa gongsa;
    private List<Tree> trees = new ArrayList<>();

    public Gongsa getGongsa() {
        return gongsa;
    }

    public void setGongsa(Gongsa gongsa) {
        this.gongsa = gongsa;
    }

    public void addTree(Tree tree) {
        trees.add(tree);
    }

    public List<Boolean> getSilentResult() {
        List<Boolean> results = new ArrayList<>();

//            for (Tree tree: trees) {
//                boolean result = Math.pow(gongsa.x - tree.x, 2) + Math.pow(gongsa.y - tree.y, 2)
//                        >= Math.pow(gongsa.R, 2);
//
//                results.add(result);
//            }
        for (Tree tree: trees) {
            results.add(tree.isSilent(gongsa));
        }

        return results;
    }
}
