package shiftregister;

/**
 *
 * @author YY
 */
public class ShiftRegister implements ILFShiftRegister {
    
    int m_size=-1;
    int m_tap=-1;
    int[] m_register =null;
    
    //constructor
    ShiftRegister(int size, int tap){
        m_size=size;
        m_tap=tap;
        if((tap>=0)&&(tap<size)&(size>0)){
            m_register=new int[m_size];
            for (int i=0;i<m_size;i++){
                m_register[i]=0;
            }
        }
        else{
            System.out.println("Error:invalid tap.");
        }
    }
    
    
    public void setSeed(int[] a){
        if(a.length!=m_size){
            System.out.println("Error:bad seed. (bad input register values)");
        }
        else if (m_register==null){
            System.out.println("Error:bad initialized register");
        }
        else{
            for (int i=0;i<m_size;i++){
                m_register[i]=a[i];
            }
        }
    }
    
    public int shift(){
        if (m_register == null){
            System.out.println("Error:bad initialized register.");
            return -1;
        }
        
        int newBit=(m_register[m_tap]^m_register[m_size-1]);//xor 
        for (int i=m_size-1;i>0;i--){
            m_register[i]=m_register[i-1];
        }
        m_register[0]=newBit;
        return newBit;
        
    }
    
    public int generate (int k){
        
        if (m_register == null){
            System.out.println("Error:bad initialized register.");
            return -1;
        }

        int returnInt=0;
        for (int i=0;i<k;i++){
            returnInt*=2;
            int newBit=shift();
            returnInt+=newBit;
        }
        return returnInt;
    }
    
    public static void main(String[] args) {
        ILFShiftRegister r=new ShiftRegister(13,5);
        int[] seed={1,1,0,0,1,0,0,0,0,1,0,0,1};
        r.setSeed(seed);//??????
        for (int i=0;i<1;i++){
            System.out.print(r.generate(10)+","+"\n");
        }
    }
    
}
