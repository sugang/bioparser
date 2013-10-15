/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isugang.bioparser.gseagmt;

import com.google.common.collect.HashMultimap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author sugang
 */
public class GmtObject {
    public static enum ID_TYPE {GENE_SYMBOL, ENTREZ_ID, ORIGINAL_IDENTIFIER, UNKNOWN};
    
    /**
     * data
     */
    private HashMap<String, String> descriptions = new HashMap<>();
    private HashMultimap<String, String> genesets = HashMultimap.create();
    
    private String name = "Untilted";
    private ID_TYPE idType = ID_TYPE.UNKNOWN;
    
    public GmtObject(){        
    }
    
    public GmtObject(String name, ID_TYPE idType){
        this.name = name;
        this.idType = idType;
    }
    
    public void addEntry(String genesetString, String geneString){
        genesets.put(genesetString, geneString);
    }
    
    public void clear(String genesetString){
        genesets.removeAll(genesetString);
    }
    
    public void clearAll(){
        genesets.clear();
    }
    
    public void addDescription(String genesetString, String descriptionString){
        descriptions.put(genesetString, descriptionString);
    }
    
    public void printStructure(){
        System.out.println(name + ":" + idType);
        System.out.println("------------------");
        
        for(String genesetString : genesets.keySet()){
            
            Set<String> genes = genesets.get(genesetString);
            System.out.println(genesetString + "( " + genes.size() + " )" + " : " + descriptions.get(genesetString));
            System.out.println("--- " + Arrays.toString(genes.toArray()));
        }
    }
    
    public Set<String> getGenesetNames(){
        Set<String> genesetNames = new HashSet<>();
        genesetNames.addAll(genesets.keySet());
        return genesetNames;
    }
    
    public Set<String> getGenesetGenes(String genesetName){
        return genesets.get(genesetName);
    }
    
}
