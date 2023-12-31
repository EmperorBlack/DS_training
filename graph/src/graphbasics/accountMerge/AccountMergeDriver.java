package graphbasics.accountMerge;

import java.util.*;

public class AccountMergeDriver {

    public static void main(String[] args) {


    }
}

class DisjointSet{
    ArrayList<Integer> rank = new ArrayList<>();
    ArrayList<Integer> parent = new ArrayList<>();

    public DisjointSet(int nodeNum) {
        for (int i = 0; i <= nodeNum ; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    public int findParent(int node){

        if(node == parent.get(node)){
            return node;
        }
        int ulParent = findParent(parent.get(node));
        parent.set(node,ulParent);
        return ulParent;
    }

    public boolean unionByRank(int u ,int v){

        int parentU = findParent(u);
        int parentV = findParent(v);
        int rankU = rank.get(parentU);
        int rankV = rank.get(parentV);

        if(parentU != parentV){
            if(rankU > rankV){
                parent.set(parentV,parentU);

            } else if (rankU < rankV) {
                parent.set(parentU,parentV);
            }else{
                parent.set(parentV,parentU);
                rank.set(parentU,rankU+1);
            }
            return true;
        }else{
            return false;
        }

    }
}


class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        int nodeNo = accounts.size();
        DisjointSet dsu = new DisjointSet(nodeNo);
        Map<String,Integer> mapMailNode = new HashMap<>();

        for (int i = 0; i < nodeNo; i++) {

            for (int j = 1; j < accounts.get(i).size(); j++) {

                String mail = accounts.get(i).get(j);
                if(mapMailNode.containsKey(mail)){
                    dsu.unionByRank(i,mapMailNode.get(mail));
                }else{
                    mapMailNode.put(mail,i);
                }
            }

        }

        Set<String>[] mergerdMail = new SortedSet[nodeNo];
        for (int i = 0; i < mergerdMail.length; i++) {
            mergerdMail[i] = new TreeSet<>();
        }

        for (Map.Entry<String,Integer> it : mapMailNode.entrySet()){
            String mail = it.getKey();
            int node = dsu.findParent(it.getValue());
            mergerdMail[node].add(mail);
        }

        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < mergerdMail.length; i++) {
            if(mergerdMail[i].size() > 0){
                ArrayList<String> temp = new ArrayList<>();
                temp.add(accounts.get(i).get(0));
                temp.addAll(mergerdMail[i]);
                result.add(temp);
            }

        }
        return result;

    }
}