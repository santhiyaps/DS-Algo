package wf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubDomainCount {
   /* ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]*/
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String,Integer> countMap=new HashMap<>();
        for(String cpdomain:cpdomains){
            String countArr[]=cpdomain.split(" ");
            int count=Integer.parseInt(countArr[0]);
            countMap.put(countArr[1],countMap.getOrDefault(countArr[1],0)+count);
            String domain=countArr[1];
            while(domain.contains(".")){
                domain=domain.substring(domain.indexOf(".")+1);
                System.out.println("domain"+domain);
                countMap.put(domain,countMap.getOrDefault(domain,0)+count);
            }
        }
        List<String>list=new ArrayList<>();
        for(String key: countMap.keySet()){
            list.add(countMap.get(key)+" "+key);
        }
        return list;
    }

    public static void main(String[] args) {
        SubDomainCount subDomainCount=new SubDomainCount();
        List<String>list=subDomainCount.subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"});
        System.out.println(list.toString());
    }
}
