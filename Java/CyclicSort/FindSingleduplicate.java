import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class FindAllduplicates{
    public static void main(String[] args) {
        
        int[] arr={4,3,2,7,8,2,3,1};
        int h[]= finddup(arr);
        System.out.println(Arrays.toString(h));
        int[] ar={1,3,4,2,1};
        int h1= Singledup(ar);
        System.out.println(h1);

    }
    //n+1 array ,[1,n] elements present ,only one repeated number 
    private static int Singledup(int[] arr){
        int i=0;
        while(i<arr.length){
            if(arr[i]!=i+1){
              int c=arr[i]-1;
              if(arr[i]!=arr[c]){
                swap(arr,c,i);
              }
              else{
                return arr[i];
              }
            }
            else{
                i++;
            }
            
        }
        return -1;

    }
    private static int[] finddup(int[] arr) {

        List<Integer> list= new ArrayList<>();
        int i=0;
        while(i<arr.length){
            int c=arr[i]-1;
            if(arr[i]!=arr[c]){
                swap(arr,c,i);
            }
            else{
                i++;
            }
        }
    
        for(int j=0;j<arr.length;j++){
            if(arr[j]!=j+1){
                list.add(arr[j]);
            }
        }
        int[] b= new int[list.size()];
        int m=0;
        for(int k:list){
            b[m]=k;m++;
        }
        return b;
    }

    private static void swap(int[] arr, int c, int i) {
        int t=arr[i];
        arr[i]=arr[c];
        arr[c]=t;
    }

}
