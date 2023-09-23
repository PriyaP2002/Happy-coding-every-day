import java.util.Arrays;
import java.util.Scanner;

class SearchTargetInAgnosticArray{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Size of Array :"); 
        int n = sc.nextInt();
        int[] arr= new int[n];
        System.out.println("Enter the elements :"); 
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Entered  elements :"); 
        System.out.println(Arrays.toString(arr));
        System.out.println("ENter the Target  :"); 
        int target2=sc.nextInt();
        int P=ans(arr,target2);
        System.out.println("Target Found at :" +P);
        sc.close();
    }
    static int ans(int[] arr,int target){
        int index=PeakinMountain(arr);
        int leftArr=binarySearchAgnostic(arr, 0,index,target);
        
        if(leftArr!=-1){
                    return leftArr;
        }
        return   binarySearchAgnostic(arr, index,arr.length-1,target);
       
    }
    private static int binarySearchAgnostic(int[] arr,int start,int end,int target){
       
     
        boolean Asc;
        if(arr[start]<arr[end]){
               Asc=true;
        }
        else{
            Asc=false;
        }
        while(start<=end){
       
                   int mid= start +(end-start)/2;
                   
                    if(arr[mid]==target){
                        return mid;
                    }
                    else{
                        if(Asc){
                          if(arr[mid]<target){
                            start=mid+1;
                          }
                          else {
                           end=mid-1;
                          }
                        }
                        else{
                            if(arr[mid]>target){
                            start=mid+1;
                          }
                          else {
                           end=mid-1;
                          }
                        }    
                    }
        }
        return -1;
        
    }
    private static int PeakinMountain(int[] arr) {

         int start =0;
         int end=arr.length-1;
         while(start<end){
        
                    int mid= start +(end-start)/2;
                    if(arr[mid]>arr[mid+1]){
                       end=mid;
                    }
                    else {
                       start=mid+1;
                     } 
         }
      
         return start;
     }
}
