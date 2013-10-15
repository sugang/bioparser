/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isugang.bioparser;

import com.isugang.bioparser.gseagmt.GmtObject;
import com.isugang.bioparser.gseagmt.GmtParser;
import java.io.File;
import java.io.FileInputStream;

/**
 *
 * @author sugang
 */
public class Bioparser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        // Let's add some changes here
        
        // Some new ways to add
        //change
        //File gmtFile = new File("/Users/sugang/Desktop/msigdb.v4.0.entrez.gmt");
        //FileInputStream in = new FileInputStream(gmtFile);
        
        
        //GmtObject obj = GmtParser.parse(gmtFile.getName(), GmtObject.ID_TYPE.ENTREZ_ID, in);
        //obj.printStructure();
        //System.out.println(obj.getGenesetGenes("GSE9037_CTRL_VS_LPS_1H_STIM_IRAK4_KO_BMDM_UP"));
        
        //What is the problem?
        
    }
    
}
