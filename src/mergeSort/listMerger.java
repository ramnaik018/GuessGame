package mergeSort;

import java.util.concurrent.*;
import java.util.List;
import java.util.ArrayList;

public class listMerger implements Callable<List<Integer>>{
    List<Integer> listToSort;
    ExecutorService ex;   //This executor is passed by main method as a constructor to optimise the multithreading

    public listMerger(List<Integer> listToSort,ExecutorService ex){
        this.listToSort=listToSort;
        this.ex=ex;
    }
    public List<Integer> call() throws Exception {

        // logic to mergeSort function using recursion
        int n=listToSort.size();
        if(n==0||n==1)return listToSort;
        int mid=n/2;
        List<Integer> left=new ArrayList<>();
        for(int i=0;i<mid;i++){
            left.add(listToSort.get(i));
        }
        List<Integer> right=new ArrayList<>();
        for(int i=mid;i<n;i++){
            right.add(listToSort.get(i));
        }

        //System.out.println("left is :" + left +" and right is :"+ right);


        // calling recursively for left half array
        listMerger leftListMerger=new listMerger(left,ex);
        Future<List<Integer>> leftFuture=ex.submit(leftListMerger);

        //calling recursively for right half array
        listMerger rightListMerger=new listMerger(right,ex);
        Future<List<Integer>> rightFuture=ex.submit(rightListMerger);

        List<Integer> sortedLeftList= leftFuture.get();
        List<Integer> sortedRightList=rightFuture.get();

        List<Integer> sortedList=new ArrayList<>();

        int i=0,j=0;
        while(i<mid&&j<(n-mid)){
            if(sortedLeftList.get(i)<sortedRightList.get(j)){
                sortedList.add(sortedLeftList.get(i++));
            }else{
                sortedList.add(sortedRightList.get(j++));
            }
        }
        while(i<mid){
            sortedList.add(sortedLeftList.get(i++));
        }
        while(j<(n-mid)){
            sortedList.add(sortedRightList.get(j++));
        }

        return sortedList;
    }
}
