package CharTemplates;

/**
 * Created by Allen on 5/22/2015.
 */
public class Mage extends Human {

	Mage(){
		setBaseWill(5);
		//setWill(5);
		backgroundPool = 7;
		backgrounds.put("Arcane", 0);
		backgrounds.put("Arete", 1);
		backgrounds.put("Avatar", 0);
		backgrounds.put("Dream", 0);
		backgrounds.put("Familiar", 0);
		backgrounds.put("Library", 0);
		backgrounds.put("Node", 0);
		backgrounds.put("Sanctum", 0);

		knowledges.put("Cosmology", 0);
		knowledges.put("Esoterica", 0);

	}
}
