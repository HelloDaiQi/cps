package com.daiqi.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ForiAndj {

    public static void main(String[] args) throws Exception{

        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        List<Integer> b = new ArrayList<>();
        b.add(3);

        Set<Integer> c = new HashSet<>();
        Set<Integer> d = new HashSet<>();

       for(int i=0;i<b.size();i++){
           for (int j=0;j<a.size();j++){
               if(b.get(i)==a.get(j)){
                   //a.remove(j);
                   System.out.println("s:"+a.get(i));
               }else {
                   System.out.println("ns:"+a.get(i));
               }
           }
       }

//        for(Integer i:a){
//            System.out.println("ns:"+i);
//        }
//
//        for(Integer i:b){
//            System.out.println("s:"+i);
//        }
//
//       for(Integer i:c){
//           System.out.println("s:"+i);
//       }
//
//        for(Integer i:d){
//            System.out.println("ns:"+i);
//        }
    }
}
