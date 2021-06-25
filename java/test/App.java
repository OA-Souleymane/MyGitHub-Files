package test;

import java.util.ArrayList;


import modele.Capability;
import modele.MessageCommonProperties;
/**
 * Hello world!
 *
 */
public class App 
{
	
	enum Enum{mesure};
	static Capability.CapabilityEunm capability;
    public static void main( String[] args )
    {ArrayList<String> resCol = new ArrayList<String>();
    MessageCommonProperties  j = new Capability(capability.mesure,"name", "type", "operationId", "when", "target", "ts", resCol);
	String ms = j.toJsonStr(j);	//System.out.println( j.convertObjetJson((Object) j));
        System.out.println( ms );
        Capability cap = new Capability().fromJsonStr(ms);
		System.out.println(cap);
        
    }
}
