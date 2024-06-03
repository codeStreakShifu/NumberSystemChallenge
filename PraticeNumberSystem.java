import java.io.IOException;
import java.util.*;


public class PraticeNumberSystem {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        while(true){

            System.out.println("<-------------------------------------->");
            System.out.print("\tInput decimal number: ");
            int decNum = scan.nextInt();
            System.out.println("<-------------------------------------->");
            Binary toBin = new Binary(decNum);
            Hexadecimal toHex = new Hexadecimal(decNum);
            Octal toOctal = new Octal(decNum);

            System.out.println("\tBinary value: "+toBin.getBinaryValue());
            System.out.println("\tHexadecimal value: "+toHex.getHexValue());
            System.out.println("\tOctal value: "+toOctal.getOctalValue());
            System.out.println("<-------------------------------------->");

            System.out.print("Press any key to continue or 0 to exit....");
            try {
                
                int input = System.in.read();

               
                if (input == '0') {
                    break; 
                }
            } catch (IOException e) {
                e.printStackTrace();

            }
        }

        System.out.print("Thank you, Bye!");
        

    } 
    
}


class Binary {

    ArrayList <Integer> remainder = new ArrayList<>();

    public Binary(int num){
        setRemainderValue(num);
    }

    private void setRemainderValue(int num){
        

        do { 
            int temp = num%2;
            remainder.add(temp);
            num /= 2;

            
        } while (num>0);
  
    }

    public int getBinaryValue(){
        StringBuilder concatValue = new StringBuilder();

        for(int i = remainder.size()-1; i>=0; i--){
         
            concatValue.append(remainder.get(i));
        }


        
        return Integer.parseInt(concatValue.toString());

    }
    
}


class Hexadecimal {

    ArrayList <String> remainder = new ArrayList<>();

    
    
    

    public Hexadecimal(int num){
        setHexValue(num);
    }

    private void setHexValue(int num){

        while(num>0){

            
                switch (num%16) {
                    case 10:
                        remainder.add("A");
                        break;
                    case 11:
                        remainder.add("B");
                        break;
                    case 12:
                        remainder.add("C");                    
                        break;
                    case 13:
                        remainder.add("D");
                        break;
                    case 14:
                        remainder.add("E");
                        break;
                    case 15:
                        remainder.add("F");                    
                        break;
                    default:
                        remainder.add(Integer.toString(num%16));
                }
                
                
            num/=16;
        }

    }

    public String getHexValue(){
        StringBuilder concatValue = new StringBuilder();
        for(int i = remainder.size()-1; i>=0; i--){
         
            concatValue.append(remainder.get(i));
        }


        
        return concatValue.toString();
    }



    
}


class Octal {

    ArrayList <Integer> remainder = new ArrayList<>();

    public Octal(int num){
        setRemainderValue(num);
    }

    private void setRemainderValue(int num){
        

        do { 
            int temp = num%8;
            remainder.add(temp);
            num /= 8;

            
        } while (num>0);
  
    }

    public int getOctalValue(){
        StringBuilder concatValue = new StringBuilder();

        for(int i = remainder.size()-1; i>=0; i--){
         
            concatValue.append(remainder.get(i));
        }


        
        return Integer.parseInt(concatValue.toString());

    }
}