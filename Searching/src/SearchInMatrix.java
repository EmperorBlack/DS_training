public class SearchInMatrix {
    public static void main(String args[]){
        int target = -4;
//        int [][]matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
                int [][]matrix = new int[][]{{-9,-7,-7,-5,-3},{-1,0,1,3,3},{5,7,9,11,12},{13,14,15,16,18},{19,21,22,22,22}};
//        int [][]matrix = new int[][]{{1}};
        for(int i = 0;i<matrix.length;i++){
            if(target >= matrix[i][0] && target<= matrix[i][matrix[i].length-1]){
                int j = searchBinary(target,0,matrix[i].length-1,matrix[i]);
                System.out.println("number present in i and j a["+i+"]["+j+"]");
            }
        }




    }
    public static int searchBinary(int target,int l,int h,int ...a){

        if(l>=h){
            if(l==h && a[l] == target){
                return l;
            }
            return -1;
        }
//        while(l<=h){
            int mid = (l+h)/2;
            if(a[mid] == target){
                return mid;
            }else if (a[mid] < target){
                l = mid+1;
                return  searchBinary(target,l,h,a);
            }else{
                h = mid-1;
                return searchBinary(target,l,h,a);
            }
//        }
//        return -1;
    }
}
