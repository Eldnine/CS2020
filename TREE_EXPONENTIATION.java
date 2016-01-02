/*
 * This piece code is to calculate exponentiation by tree which is significantly more efficient way to calculate exponentiation (O(log2n))
 */

package cs2020.ps1.pkg1;

/**
 *
 * @author YY
 */
public class PSOne {
    static int MysteryFunction(int argA,int argB){
        int c=1;
        int d=argA;//5
        int e=argB;//5
        while(e>0){
            
            if(2*(e/2)!=e){ 
                c=c*d;//5 25 
            }
            d=d*d;//25 625 625*625
            e=e/2;//2 1 0
            System.out.println(d);
            System.out.println(e);
            System.out.println(c);
        }
        return c;
    }
    public static void main(String args[]){
        int output=MysteryFunction(5,5);//inputs:5^5
        System.out.printf("The answer is "+output+".");
    }
}
