package wf;

import java.sql.SQLOutput;
import java.util.*;

public class PurchsedUserData {
    public static List<String> findPurchasedUsersData(String[] completedPurchaseUsers, String[] adClicks,
                                                      String[] allUserIps) {
        Map<String, List<String>> adPurchaseMap = new HashMap<>();
        Map<String,String>ipUserId=new HashMap<>();
        for(String ips:allUserIps){
            String ip[]=ips.split(",");
            ipUserId.put(ip[1],ip[0]);
        }
        Set<String>purchasedData=new HashSet<>();
        for(String s:completedPurchaseUsers){
            purchasedData.add(s);
        }

        for(String adClick:adClicks){
            String data[]=adClick.split(",");
            String ipAddress=data[0];
            String adText=data[2];
            if(!adPurchaseMap.containsKey(adText))
                adPurchaseMap.put(adText,new ArrayList<String>());
            List<String>userData=adPurchaseMap.get(adText);
            userData.add(ipUserId.get(ipAddress));
        }

        List<String >result= new ArrayList<>();
        for(String key:adPurchaseMap.keySet()){
           int totalClicks=adPurchaseMap.get(key).size();
           int count=0;
           for(String userId:adPurchaseMap.get(key)){
               if(purchasedData.contains(userId)) {
                   count++;
               }
           }
           String resultStr= count + " of "+ totalClicks + " "+key;
           result.add(resultStr);

        }

        return result;

    }

    public static void main(String[] args) {
        String[] completedPurchaseUsers = {"3123122444", "234111110", "8321125440", "99911063"};

        // "IP Address, timestamp, Ad text"
        String[] adClicks = {"122.121.0.1,2016-11-03 11:41:19,Buy wool coats for your pets",
                "96.3.199.11,2016-10-15 20:18:31,2017 Pet Mittens",
                "122.121.0.250,2016-11-01 06:13:13,The Best Hollywood Coats",
                "82.1.106.8,2016-11-12 23:05:14,Buy wool coats for your pets",
                "92.130.6.144,2017-01-01 03:18:55,Buy wool coats for your pets",
                "122.121.0.155,2017-01-01 03:18:55,Buy wool coats for your pets",
                "92.130.6.145,2017-01-01 03:18:55,2017 Pet Mittens"};

        // "User ID, IP address"
        String[] allUserIps = {"2339985511,122.121.0.155", "234111110,122.121.0.1", "3123122444,92.130.6.145",
                "39471289472,2001:0db8:ac10:fe01:0000:0000:0000:0000", "8321125440,82.1.106.8",
                "99911063,92.130.6.144"};

        System.out.println(findPurchasedUsersData(completedPurchaseUsers, adClicks, allUserIps));
    }
}
