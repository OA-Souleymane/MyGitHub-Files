package pr.pj;

import java.util.ArrayList;

import com.google.gson.Gson;

import modele.Capability;
import modele.MessageCommonProperties;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {ArrayList<String> resCol = new ArrayList<String>();
    MessageCommonProperties  j = new Capability("dd", "ppp", "nnn", "zz", "aaa", "jjj", resCol);
	String ms = j.convertObjetJson(j);	//System.out.println( j.convertObjetJson((Object) j));
        System.out.println( ms );
    }
}
