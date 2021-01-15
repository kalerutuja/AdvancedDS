package com.bhole.advanced_ds.random.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class MinimumKnightMoves {
    HashMap<Coord, Integer> map;

    public int minKnightMoves(int x, int y) {
        Coord start = new Coord(0, 0);
        map = new HashMap<>();
        map.put(start, 0);
        map.put(new Coord(1,2), 1);
        map.put(new Coord(2,1), 1);
        map.put(new Coord(0,1), 3);
        map.put(new Coord(1,0), 3);

        map.put(new Coord(2,0), 2);
        map.put(new Coord(1,1), 2);
        map.put(new Coord(0,2), 2);

        map.put(new Coord(2,2), 4);

        return minMoves( new Coord(x<0?-x:x,y<0?-y:y));
    }

    private int minMoves(Coord cur) {
        if(cur.is3rdQ()) return Integer.MAX_VALUE;
        //System.out.println("cur="+cur);
        if (cur.x ==0 && cur.y == 0) return 0;
        if (map.containsKey(cur)) {
            return  map.get(cur);
        }
        List<Coord> curMoves = getBackMoves(cur);
        int min = Integer.MAX_VALUE;
        for (Coord move : curMoves) {
            min = Math.min(minMoves(move)+1, min);
        }
        map.put(cur, min);
        //System.out.println("cur="+cur+" min"+min);
        return min;
    }

    private List<Coord> getBackMoves(Coord dest) {
        List<Coord> res = new ArrayList<>();
        res.add(new Coord(Math.abs(dest.x-1), Math.abs(dest.y-2)));
        res.add(new Coord(Math.abs(dest.x-2), Math.abs(dest.y-1)));
        return res;
    }

    class Coord {
        int x=0,y=0;
        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coord coord = (Coord) o;
            return x == coord.x &&
                    y == coord.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public boolean isFirstQ(){
            return this.x>=0 && this.y>=0;
        }

        public boolean is3rdQ() {
            return (this.x)<0 && (this.y)<0;
        }

        @Override
        public String toString() {
            return "Coord{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    public static void main(String args[]) {
        MinimumKnightMoves moves = new MinimumKnightMoves();
        System.out.println(moves.minKnightMoves(5,5));;
    }
}
