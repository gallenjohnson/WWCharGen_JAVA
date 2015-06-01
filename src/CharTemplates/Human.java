package CharTemplates;


/**
 * Created by Allen on 5/22/2015.
 */
public class Human extends BaseTemplate {



//To iterate over a map:
/*
for(Map.Entry<String,Integer> entry : treeMap.entrySet()) {
  String key = entry.getKey();
  Integer value = entry.getValue();

  System.out.println(key + " => " + value);
}
 */

	Human(){
		setBaseWill(3);
		setWill(3);
		backgrounds.put("Allies", 0);
		backgrounds.put("Contacts", 0);
		backgrounds.put("Influence", 0);
		backgrounds.put("Mentor", 0);
		backgrounds.put("Resources", 0);
		backgrounds.put("Status", 0);
	}

}
