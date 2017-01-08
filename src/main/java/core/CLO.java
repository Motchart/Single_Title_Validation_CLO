package core;

import java.util.ArrayList;
import java.util.List;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(separators = "=")
public class CLO {
	// List  -l="www.alegro.com|alegro.com","www.alegro.com|abc abc"
	@Parameter(names = {"-l", "--list"},variableArity = true,description = "Your List")
	static List<String> list = new ArrayList<String>();
	
	// String -u=www.alegro.com
	@Parameter(names = {"-u", "--url"}, description = "URL") // required = true
	static String url = null;
	
	// String -t=alegro.com
	@Parameter(names = {"-t", "--title_expected"}, description = "Title Expected")
	static String title = null; 
    
    //Help --help
    @Parameter(names = "--help", help = true, hidden = true)
    static Boolean help = false;
    public static void main(String[] v)
    {
    	new JCommander(new CLO(), v);
    	
    	if (help) {new JCommander(new CLO(), v).usage(); System.exit(0);}
    	if (list.size() == 0) {System.out.println("List is empty");}
    	else  {for (String l : list) {System.out.println("List item =" + l);}}
    	if (url == null) {System.err.println("url is empty");}
    	else if (title == null) {System.err.println("title is empty");}
		else {
			System.out.println("URL " + url + ",Title " + title);
		}
	}
}
