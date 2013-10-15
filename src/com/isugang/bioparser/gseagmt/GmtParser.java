/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isugang.bioparser.gseagmt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author sugang
 */
public class GmtParser {

    public static GmtObject parse(String name, GmtObject.ID_TYPE idType, InputStream in) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        String ele[];
        GmtObject gmtObject = new GmtObject(name, idType);
        while( (line = reader.readLine()) != null ){
            line = line.trim();
            ele = line.split("\\t", -1);
            if(ele.length <= 2){
                continue; //only has name and descritpion, no child
            }
            
            //parse
            gmtObject.addDescription(ele[0], ele[1]);
            
            for( int i = 2; i < ele.length; i++){
                gmtObject.addEntry(ele[0], ele[i]);
            }
        }
        reader.close();
        return gmtObject;
    }

    public static GmtObject parse(InputStream in) throws IOException{
        return parse("untitled", GmtObject.ID_TYPE.UNKNOWN, in);
    }
    
    
    

}
