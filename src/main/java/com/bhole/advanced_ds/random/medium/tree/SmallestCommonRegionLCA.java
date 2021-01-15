package com.bhole.advanced_ds.random.medium.tree;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/*
Input:
regions = [["Earth","North America","South America"],
["North America","United States","Canada"],
["United States","New York","Boston"],
["Canada","Ontario","Quebec"],
["South America","Brazil"]],
region1 = "Quebec",
region2 = "New York"
Output: "North America"
 */
public class SmallestCommonRegionLCA {


    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String, Integer> map = new HashMap<>();
        Map<Integer, String> intToHeadNameMap = new HashMap<>();
        AtomicInteger counter = new AtomicInteger(1);
        Map<Integer, Integer> nodeToParentMap = new HashMap<>();
        regions.forEach(regionList-> {
            if (!regionList.isEmpty()) {
               String head = regionList.get(0);
               for (int i=0; i<regionList.size(); i++) {
                   String curReg = regionList.get(i);
                   if (!map.containsKey(curReg)) {
                      map.put(curReg, counter.getAndIncrement());
                   }
                   if (i>0) nodeToParentMap.put(map.get(curReg), map.get(head));
               }
                intToHeadNameMap.put(map.get(head), head);
            }
        });
        List<Integer> path1 = new ArrayList<>();
        List<Integer> path2 = new ArrayList<>();
        tracePath(map, nodeToParentMap, intToHeadNameMap, region1, path1);
        tracePath(map, nodeToParentMap, intToHeadNameMap, region2, path2);

        int p1 = path1.size()-1;
        int p2 = path2.size()-1;
        Integer lca = null;
        while (p1>=0 && p2>=0) {
            if (path1.get(p1) == path2.get(p2)) {
                lca = path1.get(p1);
            } else {
               break;
            }
            p1--;p2--;
        }
        if (lca !=null) {
            return intToHeadNameMap.get(lca);
        } else {
            return null;
        }
    }

    private void tracePath(Map<String, Integer> map,Map<Integer, Integer> nodeToParentMap,Map<Integer, String> intToHeadNameMap, String region, List<Integer> path) {
        if (region!=null) {
            Integer regionID = map.get(region);
            if (intToHeadNameMap.containsKey(regionID)) {
               path.add(regionID);
            }
            if (regionID!=null) {
                Integer parent = nodeToParentMap.get(regionID);
                while (parent!=null) {
                    path.add(parent);
                    parent = nodeToParentMap.get(parent);
                }
            } else {
                //log error
            }
        }
    }

    public static void main(String args[]) {
        SmallestCommonRegionLCA lca = new SmallestCommonRegionLCA();
        List<List<String>> regions = List.of(
                List.of("Earth","North America","South America"),
                List.of("North America","United States","Canada"),
                List.of("United States","New York","Boston"),
                List.of("Canada","Ontario","Quebec"),
                List.of("South America","Brazil")
        );
//        System.out.println(lca.findSmallestRegion(regions,"New York", "Quebec"));
//        System.out.println(lca.findSmallestRegion(regions,"Canada", "South America"));
          System.out.println(lca.findSmallestRegion(regions,"Canada", "North America"));

    }




}
