package CharTemplates;

import sun.reflect.generics.tree.Tree;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class BaseTemplate extends CORE{

	BaseTemplate(){
		for(int index = 0; index < attributes.length; ++index) {
			attributes[index] = 1;
		}
		primPool = 7;
		secPool = 5;
		terPool = 3;
		abilityPrimPool = 13;
		abilitySecPool = 9;
		abilityTerPool = 5;
		will = 1;
		baseWill = 1;
		nature = "unknown";
		demeanor = "unknown";
		//Attribute Priorities
		primSet = '?';
		secSet = '?';
		terSet = '?';
		//Ability Priorities
		abilityPrimSet = '?';
		abilitySecSet = '?';
		abilityTerSet = '?';

		talents.put("Alertness", 0);
		talents.put("Art", 0);
		talents.put("Athletics", 0);
		talents.put("Awareness", 0);
		talents.put("Brawl", 0);
		talents.put("Empathy", 0);
		talents.put("Expression", 0);
		talents.put("Intimidation", 0);
		talents.put("Leadership", 0);
		talents.put("Streetwise", 0);
		talents.put("Subterfuge", 0);

		skills.put("Crafts", 0);
		skills.put("Drive", 0);
		skills.put("Etiquette", 0);
		skills.put("Firearms", 0);
		skills.put("Martial Arts", 0);
		skills.put("Meditation", 0);
		skills.put("Melee", 0);
		skills.put("Research", 0);
		skills.put("Stealth", 0);
		skills.put("Survival", 0);
		skills.put("Technology", 0);

		knowledges.put("Academics", 0);
		knowledges.put("Computer", 0);
		knowledges.put("Enigmas", 0);
		knowledges.put("Investigation", 0);
		knowledges.put("Law", 0);
		knowledges.put("Medicine", 0);
		knowledges.put("Occult", 0);
		knowledges.put("Politics", 0);
		knowledges.put("Science", 0);
	}


	protected Integer getBackgroundPool(){ return backgroundPool;}


	protected void setBackgroundPool(Integer value){backgroundPool = value;}


	//Attribute Pools
	protected Integer getPrimPool() {
		return primPool;
	}


	protected void setPrimPool(Integer value) {
		primPool = value;
	}


	protected Integer getSecPool() {
		return secPool;
	}


	protected void setSecPool(Integer value) {
		secPool = value;
	}


	protected Integer getTerPool() {
		return terPool;
	}


	protected void setTerPool(Integer value) {
		terPool = value;
	}


	//Ability Pools
	protected Integer getAbilityPrimPool() {
		return abilityPrimPool;
	}


	protected void setAbilityPrimPool(Integer value) {
		abilityPrimPool = value;
	}


	protected Integer getAbilitSecPool() {
		return abilitySecPool;
	}


	protected void setAbilitySecPool(Integer value) {
		abilitySecPool = value;
	}


	protected Integer getAbilityTerPool() {
		return abilityTerPool;
	}


	protected void setAbilityTerPool(Integer value) {
		abilityTerPool = value;
	}


	/*********************Attributes - Getters and Setters********************/
	protected Integer getAttribute(Integer index) {
		return attributes[index];
	}


	protected void setAttribute(Integer index, Integer value) {
		attributes[index] = value;
	}


	protected Integer getStrength() {
		return getAttribute(STRENGTH);
	}


	protected void setStrength(Integer value) {
		setAttribute(STRENGTH, value);
	}


	protected Integer getDexterity() {
		return getAttribute(DEXTERITY);
	}


	protected void setDexterity(Integer value) {
		setAttribute(DEXTERITY, value);
	}


	protected Integer getStamina() {
		return getAttribute(STAMINA);
	}


	protected void setStamina(Integer value) {
		setAttribute(STAMINA, value);
	}


	protected Integer getCharisma() {
		return getAttribute(CHARISMA);
	}


	protected void setCharisma(Integer value) {
		setAttribute(CHARISMA, value);
	}


	protected Integer getManipulation() {
		return getAttribute(MANIPULATION);
	}


	protected void setManipulation(Integer value) {
		setAttribute(MANIPULATION, value);
	}


	protected Integer getAppearance() {
		return getAttribute(APPEARANCE);
	}


	protected void setAppearance(Integer value) {
		setAttribute(APPEARANCE, value);
	}


	protected Integer getPerception() {
		return getAttribute(PERCEPTION);
	}


	protected void setPerception(Integer value) {
		setAttribute(PERCEPTION, value);
	}


	protected Integer getIntelligence() {
		return getAttribute(INTELLIGENCE);
	}


	protected void setIntelligence(Integer value) {
		setAttribute(INTELLIGENCE, value);
	}


	protected Integer getWits() {
		return getAttribute(WITS);
	}


	protected void setWits(Integer value) {
		setAttribute(WITS, value);
	}


	//Generates random values and adds them to an attribute resulting in
	//a score between 1 and 5.
	private void genRandAttributes(Integer attributePool, Integer attrib1,
								   Integer attrib2, Integer attrib3) {
		Random rand = new Random();
		while(attributePool > 0) {
			Integer picker;
			picker = rand.nextInt(3);
			switch(picker){
	            case 0: if(attributes[attrib1] < 5){
	                        attributes[attrib1] += 1;
	                        --attributePool;
	                    }
	                    break;
	            case 1: if(attributes[attrib2] < 5){
	            			attributes[attrib2] +=1;
	                        --attributePool;
	                    }
	                    break;
	            case 2: if(attributes[attrib3] < 5){
	            			attributes[attrib3] += 1;
	                        --attributePool;
	                    }
	                    break;
			}
		}
	}


	//Calls genRandAttributePriority to set attribute priority and
	//genRanAttributes to generate the values for those attributes. Passes in the
	//correct number of the attribute points for each attribute type determined by
	//their priority.
	protected void setRandAttributes() {
		if((primSet == '?') || (secSet == '?') || (terSet == '?')) {
			genRandAttributePriority();
		}

		//Assign Primary Attributes
		switch(primSet) {
			case 'p':   genRandAttributes(primPool, STRENGTH, DEXTERITY, STAMINA);
	        break;

			case 's':   genRandAttributes(primPool, CHARISMA, MANIPULATION, APPEARANCE);
	        break;

			case 'm':   genRandAttributes(primPool, PERCEPTION, INTELLIGENCE, WITS);
	        break;
		}

		//Assign Secondary Attributes
		switch(secSet) {
			case 'p':   genRandAttributes(secPool, STRENGTH, DEXTERITY, STAMINA);
	        break;

			case 's':   genRandAttributes(secPool, CHARISMA, MANIPULATION, APPEARANCE);
	        break;

			case 'm':   genRandAttributes(secPool, PERCEPTION, INTELLIGENCE, WITS);
	        break;
		}

		//Assign Tertiary Attributes
		switch(terSet) {
			case 'p':   genRandAttributes(terPool, STRENGTH, DEXTERITY, STAMINA);
	        break;

			case 's':   genRandAttributes(terPool, CHARISMA, MANIPULATION, APPEARANCE);
	        break;

			case 'm':   genRandAttributes(terPool, PERCEPTION, INTELLIGENCE, WITS);
	        break;
		}

	}


	/*********************Archetypes********************************/
	protected String getNature() {
		return nature;
	}


	protected void setNature(String value) {
		nature = value;
	}


	protected String getDemeanor() {
		return demeanor;
	}


	protected void setDemeanor(String value) {
		demeanor = value;
	}


	private String genRandArchetype() {
		Random rand = new Random();
		return ARCHETYPE_LIST[rand.nextInt(ARCHETYPE_SIZE)];
	}


	protected void setRandNature() {
		setNature(genRandArchetype());
	}


	protected void setRandDemeanor() {
		setDemeanor(genRandArchetype());
	}


	/*********************Attribute Priorities********************************/
	protected char getPrimSet() {
		return primSet;
	}


	protected void setPrimSet(char value) {
		primSet = value;
	}


	protected char getSecSet() {
		return secSet;
	}


	protected void setSecSet(char value) {
		secSet = value;
	}


	protected char getTerSet() {
		return terSet;
	}


	protected void setTerSet(char value) {
		terSet = value;
	}


	//Randomly assigns the character's attribute priorities.
	private void genRandAttributePriority() {
		Random rand = new Random();
		while((primSet == '?') || (secSet == '?') || (terSet == '?')) {
			int firstPick, secondPick = 0;
			firstPick = rand.nextInt(3) + 1;

			switch(firstPick) {
				case 1:	if(primSet == '?') {
							setPrimSet('p');
						}
						break;
				case 2:	if(secSet == '?') {
							setSecSet('p');
						}
						break;
				case 3:	if(terSet == '?') {
							setTerSet('p');
						}
						break;
			}

			secondPick = rand.nextInt(3) + 1;
			while(secondPick == firstPick) {
				secondPick = rand.nextInt(3) + 1;
			}

			switch(secondPick) {
				case 1:	if(primSet == '?') {
							setPrimSet('s');
							if(secSet == '?') {
								setSecSet('m');
							} else {
								setTerSet('m');
							}
						}
						break;
				case 2:	if(secSet == '?') {
							setSecSet('s');
							if(primSet == '?') {
								setPrimSet('m');
							} else {
								setTerSet('m');
							}
						}
						break;
				case 3:	if(terSet == '?') {
							setTerSet('s');
							if(primSet == '?') {
								setPrimSet('m');
							} else {
								setSecSet('m');
							}
						}
						break;
			}
		}
	}


	//Translates the attribute priority char values to something
	//more meaningful when printed out.
	private String attribPriorityTranslator(char value) {
		String result = null;
		switch(value) {
			case 'p':	result = "Physical";
				break;
			case 's':	result = "Social";
				break;
			case 'm':	result = "Mental";
				break;
		}
		return result;
	}


	/*********************Ability Priorities********************************/
	protected char getAbilityPrimSet() {
		return abilityPrimSet;
	}


	protected void setAbilityPrimSet(char value) {
		abilityPrimSet = value;
	}


	protected char getAbilitySecSet() {
		return abilitySecSet;
	}


	protected void setAbilitySecSet(char value) {
		abilitySecSet = value;
	}


	protected char getAbilityTerSet() {
		return abilityTerSet;
	}


	protected void setAbilityTerSet(char value) {
		abilityTerSet = value;
	}


	//Randomly assigns the character's ability priorities.
	private void genRandAbilityPriority() {
		Random rand = new Random();
		while((abilityPrimSet == '?') || (abilitySecSet == '?') || (abilityTerSet == '?')) {
			int firstPick, secondPick = 0;
			firstPick = rand.nextInt(3) + 1;

			switch(firstPick) {
				case 1:	if(abilityPrimSet == '?') {
							setAbilityPrimSet('t');
						}
						break;
				case 2:	if(abilitySecSet == '?') {
							setAbilitySecSet('t');
						}
						break;
				case 3:	if(abilityTerSet == '?') {
							setAbilityTerSet('t');
						}
						break;
			}

			secondPick = rand.nextInt(3) + 1;
			while(secondPick == firstPick) {
				secondPick = rand.nextInt(3) + 1;
			}

			switch(secondPick) {
				case 1:	if(abilityPrimSet == '?') {
							setAbilityPrimSet('s');
							if(abilitySecSet == '?') {
								setAbilitySecSet('k');
							} else {
								setAbilityTerSet('k');
							}
						}
						break;
				case 2:	if(abilitySecSet == '?') {
							setAbilitySecSet('s');
							if(abilityPrimSet == '?') {
								setAbilityPrimSet('k');
							} else {
								setAbilityTerSet('k');
							}
						}
						break;
				case 3:	if(abilityTerSet == '?') {
							setAbilityTerSet('s');
							if(abilityPrimSet == '?') {
								setAbilityPrimSet('k');
							} else {
								setAbilitySecSet('k');
							}
						}
						break;
			}
		}
	}


	//Translates the attribute priority char values to something
	//more meaningful when printed out.
	private String abilityPriorityTranslator(char value) {
		String result = null;
		switch(value) {
			case 't':	result = "Talents";
						break;
			case 's':	result = "Skills";
						break;
			case 'k':	result = "Knowledges";
						break;
		}
		return result;
	}


	private void genRandAbilities(Integer abilityPool, Map<String, Integer> abilitySet){
		String choice;
		Integer value;
		if(abilityPool >= (abilitySet.size() * 5)){
			abilityPool = abilitySet.size() - 1;
		}
		while(abilityPool > 0){
			choice = randSelect(abilitySet);
			value = abilitySet.get(choice);
			if(value < 3) {
				abilitySet.put(choice, (value + 1));
				--abilityPool;
			}
		}
	}


	protected void setRandAbilities() {
		if((abilityPrimSet == '?') || (abilitySecSet == '?') || (abilityTerSet == '?')) {
			genRandAbilityPriority();
		}

		//Assign Primary Attributes
		switch(abilityPrimSet) {
			case 't':   genRandAbilities(abilityPrimPool, talents);
				break;

			case 's':   genRandAbilities(abilityPrimPool, skills);
				break;

			case 'k':   genRandAbilities(abilityPrimPool, knowledges);
				break;
		}

		//Assign Secondary Attributes
		switch(abilitySecSet) {
			case 't':   genRandAbilities(abilitySecPool, talents);
				break;

			case 's':   genRandAbilities(abilitySecPool, skills);
				break;

			case 'k':   genRandAbilities(abilitySecPool, knowledges);
			break;
		}

		//Assign Tertiary Attributes
		switch(abilityTerSet) {
			case 't':   genRandAbilities(abilityTerPool, talents);
				break;

			case 's':   genRandAbilities(abilityTerPool, skills);
				break;

			case 'k':   genRandAbilities(abilityTerPool, knowledges);
				break;
		}

	}

	/************************************************************************************/


	protected Integer getWill() {
		return will;
	}


	protected void setWill(Integer value) {
		will = value;
	}


	protected Integer getBaseWill() {
		return baseWill;
	}


	protected void setBaseWill(Integer value) {
		baseWill = value;
	}


	protected void setRandWill() {
		Random rand = new Random();
		setWill((rand.nextInt((maxWill - baseWill) + 1) + baseWill));
	}


	protected String randSelect(Map<String, Integer> assets){
		Integer size = assets.size();
		Integer choice = new Random().nextInt(size);
		Integer index = 0;
		String selection = null;
		for(Map.Entry<String, Integer> entry : assets.entrySet()){
			if(index == choice){
				selection = entry.getKey();
				break;
			}
			++index;
		}
		return selection;
	}


	protected void setRandBackgrounds(){
		String choice;
		Integer value;
		if(backgroundPool >= (backgrounds.size() * 5)){
			setBackgroundPool((backgrounds.size() * 5) - 1);
		}
		while(backgroundPool > 0){
			choice = randSelect(backgrounds);
			value = backgrounds.get(choice);
			if(value < 5) {
				backgrounds.put(choice, (value + 1));
				--backgroundPool;
			}
		}
	}


	//Outputting the generated values.
	protected void print() {

		System.out.println();
		System.out.println("<<<<<<<<<<<<<Test Print>>>>>>>>>>>>>>>>");
		System.out.println();
		System.out.println("Nature:        " + getNature());
		System.out.println("Demeanor:      " + getDemeanor());
		System.out.println("~Attributes~");
		System.out.println("Primary Set:   " + attribPriorityTranslator(getPrimSet()));
		System.out.println("Secondary Set: " + attribPriorityTranslator(getSecSet()));
		System.out.println("Tertiary Set:  " + attribPriorityTranslator(getTerSet()));
		System.out.println("~Abilities~");
		System.out.println("Primary Set:   " + abilityPriorityTranslator(getAbilityPrimSet()));
		System.out.println("Secondary Set: " + abilityPriorityTranslator(getAbilitySecSet()));
		System.out.println("Tertiary Set:  " + abilityPriorityTranslator(getAbilityTerSet()));
		System.out.println("Willpower:     " + getWill());
		System.out.println();
		System.out.println("**********Physical Attributes**********");
		System.out.println();
		System.out.println("Strength:      " + getStrength());
		System.out.println("Dexterity:     " + getDexterity());
		System.out.println("Stamina:       " + getStamina());
		System.out.println();
		System.out.println("**********Social Attributes**********");
		System.out.println();
		System.out.println("Charisma:      " + getCharisma());
		System.out.println("Manipulation:  " + getManipulation());
		System.out.println("Appearance:    " + getAppearance());
		System.out.println();
		System.out.println("**********Mental Attributes**********");
		System.out.println();
		System.out.println("Perception:    " + getPerception());
		System.out.println("Intelligence:  " + getIntelligence());
		System.out.println("Wits:          " + getWits());
		System.out.println();


		//Print out Backgrounds
		System.out.println("*************Backgrounds*************");
		Integer index = 0;
		for(Map.Entry<String, Integer> entry : backgrounds.entrySet()) {
			++index;
			String key = entry.getKey();
			Integer value = entry.getValue();
			if(key.length() < 7)
				System.out.print(key + ":\t\t" + value);
			else
				System.out.print(key + ":\t" + value);

			if((index % 3) == 0)
				System.out.println();
			else
				System.out.print("\t");
		}
		System.out.println();
		//End Backgrounds print
		System.out.println();
		//Print out Abilities
		System.out.println("*************Abilities*************");
		Iterator<Map.Entry<String, Integer>> talentsIterator = talents.entrySet().iterator();
		Map.Entry<String, Integer> talentEntry;
		Iterator<Map.Entry<String, Integer>> skillsIterator = skills.entrySet().iterator();
		Map.Entry<String, Integer> skillEntry;
		Iterator<Map.Entry<String, Integer>> knowledgeIterator = knowledges.entrySet().iterator();
		Map.Entry<String, Integer> knowledgeEntry;
		while(talentsIterator.hasNext() || skillsIterator.hasNext() || knowledgeIterator.hasNext()){
			if(!talents.isEmpty() && talentsIterator.hasNext()){
				talentEntry = talentsIterator.next();
				if(talentEntry.getKey().length() < 4)
					System.out.print(talentEntry.getKey() + "\t\t\t\t" + talentEntry.getValue() + "\t");
				else if(talentEntry.getKey().length() < 8)
					System.out.print(talentEntry.getKey() + "\t\t\t" + talentEntry.getValue() + "\t");
				else if(talentEntry.getKey().length() < 11)
					System.out.print(talentEntry.getKey() + "\t\t" + talentEntry.getValue() + "\t");
				else
					System.out.print(talentEntry.getKey() + "\t" + talentEntry.getValue() + "\t");
			} else{
				System.out.print("\t\t");
			}
			if(!skills.isEmpty() && skillsIterator.hasNext()){
				skillEntry = skillsIterator.next();
				if(skillEntry.getKey().length() < 8)
					System.out.print(skillEntry.getKey() + "\t\t\t" + skillEntry.getValue() + "\t");
				else if(skillEntry.getKey().length() < 11)
					System.out.print(skillEntry.getKey() + "\t\t" + skillEntry.getValue() + "\t");
				else
					System.out.print(skillEntry.getKey() + "\t" + skillEntry.getValue() + "\t");
			} else{
				System.out.print("\t\t");
			}
			if(!knowledges.isEmpty() && knowledgeIterator.hasNext()){
				knowledgeEntry = knowledgeIterator.next();
				if(knowledgeEntry.getKey().length() < 4)
					System.out.println(knowledgeEntry.getKey() + "\t\t\t\t" + knowledgeEntry.getValue() + "\t");
				else if(knowledgeEntry.getKey().length() < 8)
					System.out.println(knowledgeEntry.getKey() + "\t\t\t" + knowledgeEntry.getValue() + "\t");
				else if(knowledgeEntry.getKey().length() < 13)
					System.out.println(knowledgeEntry.getKey() + "\t\t" + knowledgeEntry.getValue() + "\t");
				else
					System.out.println(knowledgeEntry.getKey() + "\t" + knowledgeEntry.getValue() + "\t");
			} else{
				System.out.println("\t\t");
			}
		}
/*
		for(Map.Entry<String, Integer> talEntry : talents.entrySet()){
			String key = talEntry.getKey();
			Integer value = talEntry.getValue();
			if(key.length() < 7)
				System.out.print(key + ":\t\t" + value + "\t");
			else
				System.out.print(key + ":\t" + value + "\t");

			//Print Skills
			for(Map.Entry<String, Integer> skilEntry : skills.entrySet()){
				key = skilEntry.getKey();
				value = skilEntry.getValue();
				if(key.length() < 7)
					System.out.print(key + ":\t\t" + value + "\t");
				else
					System.out.print(key + ":\t" + value + "\t");

				//Print Knowledges
				for(Map.Entry<String, Integer> knowEntry : knowledges.entrySet()){
					key = knowEntry.getKey();
					value = knowEntry.getValue();
					if(key.length() < 7)
						System.out.println(key + ":\t\t" + value);
					else
						System.out.println(key + ":\t" + value);
				}  //End Print Knowledges
			}  //End Print Skills
		}  //End Print Talents
*/
		System.out.println();
		//End Print Abilities
	}
}

































