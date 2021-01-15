package com.bhole.advanced_ds.random.easy;

import java.util.*;
import java.util.stream.Collectors;

/*
input: ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
output: ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
 */
public class SubDomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        if (cpdomains.length == 0) {
            return new ArrayList<>();
        }
        Map<String, Integer> res = new HashMap();
        Arrays.stream(cpdomains).forEach(cpdomain-> {
            if (cpdomain!=null) {
                String arr[] = cpdomain.trim().split("\\s+");
                if (arr.length >= 2) {
                    try {
                        int count = Integer.parseInt(arr[0]);
                        String domain = arr[1];
                        for (int i=domain.length()-1; i>=0; i--) {
                            if (domain.charAt(i) == '.' || i==0) {
                               String tmp = domain.substring(i==0?0:i+1);
                               if(res.containsKey(tmp)) {
                                   res.put(tmp, count+res.get(tmp));
                               } else {
                                   res.put(tmp, count);
                               }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
      return res.entrySet().stream().map(e-> e.getValue()+" "+e.getKey()).collect(Collectors.toList());
    }
    public static void main(String args[]) {
        SubDomainVisitCount subDomainVisitCount = new SubDomainVisitCount();
        List<String> res = subDomainVisitCount.subdomainVisits(new String[] {"900   google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"});
        System.out.println(Arrays.toString(res.toArray()));
    }
}
