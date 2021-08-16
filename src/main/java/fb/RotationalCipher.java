package fb;

public class RotationalCipher {
   static String rotationalCipher(String input, int rotationFactor) {
       StringBuilder sb=new StringBuilder();
       for(char c:input.toCharArray()){
           int i=(int)c;
           // System.out.println(i)
           if(48 <= i && 57 >= i){
               if((rotationFactor+i)>=57){
                   sb.append((char)(((rotationFactor+i) % 57)+47));
               }else{
                   sb.append((char)(rotationFactor +i));
               }
           }else if(65<= i && 90 >= i){
               if((rotationFactor+i)>=90){
                   sb.append((char)(((rotationFactor+i) % 90)+64));
               }else{
                   sb.append((char)(rotationFactor +i));
               }

           }else if(97 <= i && 122 >= i){
               if((rotationFactor+i)>=122){
                   sb.append((char)(((rotationFactor+i) % 122)+96));
               }else{
                   sb.append((char)(rotationFactor +i));
               }
           }else{
               sb.append(c);
           }
       }
       return sb.toString();
    }

    public static void main(String[] args) {
       // System.out.println(rotationalCipher("Zebra-493?",3));
        String input_1 = "All-convoYs-9-be:Alert1.";
        int rotationFactor_1 = 4;
        String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
        System.out.println(rotationalCipher(input_1, rotationFactor_1));
        // Cheud-726?
       /* String input_2 = "abcdZXYzxy-999.@";
        int rotationFactor_2 = 200;
        String expected_2 = "stuvRPQrpq-999.@";
        System.out.println(rotationalCipher(input_2, rotationFactor_2));*/
    }
}
