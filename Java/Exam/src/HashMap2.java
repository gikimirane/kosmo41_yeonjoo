import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMap2 {

	public static void main(String[] args) {
	
		Map<String, PrintWriter> testMap = new HashMap<String, PrintWriter>();
			Collections.synchronizedMap(testMap);
	
			Iterator it = testMap.keySet().iterator();
			
			for(int i = 1; i <= testMap.size(); i++) {
				System.out.println(testMap.get((i)));
			}
	
			
	}

}
