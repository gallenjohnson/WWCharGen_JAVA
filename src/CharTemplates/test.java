package CharTemplates;



public class test {

	public static void main(String[] args) {
		Human person = new Mage();

		person.setRandNature();
		person.setRandDemeanor();
		person.setRandAttributes();
		person.setBackgroundPool(10);
		person.setRandBackgrounds();
		person.setRandWill();
		person.setRandAbilities();
		person.print();
	}
}

//To iterate over a map:
/*
for(Map.Entry<String,Integer> entry : treeMap.entrySet()) {
  String key = entry.getKey();
  Integer value = entry.getValue();

  System.out.println(key + " => " + value);
}
 */


