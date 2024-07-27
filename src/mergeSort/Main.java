package mergeSort;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        List<Integer> arr=Arrays.asList(9,2,7,0,3,4,2,5);
        ExecutorService ex=Executors.newCachedThreadPool();
        listMerger lm=new listMerger(arr,ex);
        Future<List<Integer>> futureList=ex.submit(lm);
        List<Integer> sortedList=new ArrayList<>();
        try{
            sortedList=futureList.get();
        }catch(Exception e){
            System.out.println("Exception thrown by future is :"+e);
        }
        ex.shutdown();

        System.out.println(sortedList);

    }
}
