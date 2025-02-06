package Utility;

public class Utility {
    public boolean inInt(int[] arr, int num){
            for (int i : arr){
                if (i == num){
                    return true;
                }
            }
            return false;
    
    }
    public boolean inString(String[] arr, String num){
            for (String i : arr){
                if (i.equals(num)){
                    return true;
                }
            }
            return false;
    
    }
    public boolean inDouble(double[] arr, double num){
            for (double i : arr){
                if (i == num){
                    return true;
                }
            }
            return false;
    
    }
    public boolean inChar(char[] arr, char num){
            for (char i : arr){
                if (i == num){
                    return true;
                }
            }
            return false;
    
    }
    public boolean inBoolean(boolean[] arr, boolean num){
            for (boolean i : arr){
                if (i == num){
                    return true;
                }
            }
            return false;
    
    }
    
    
}
