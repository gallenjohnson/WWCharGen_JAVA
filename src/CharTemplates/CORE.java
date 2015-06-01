package CharTemplates;

import java.util.Map;
import java.util.TreeMap;

public class CORE {

	protected final static Integer ARCHETYPE_SIZE = 69;
	protected final static String[/*69*/] ARCHETYPE_LIST =
									{"Analyst", "Architect", "Autocrat",
									 "Autist", "Avant-Garde", "Barbarian",
									 "Benefactor", "Bon Vivant", "Bravo",
									 "Bureaucrat", "Caregiver", "Cavalier",
									 "Child", "Celebrant", "Competitor",
									 "Confidant", "Conformist", "Conniver",
									 "Crackerjack", "Critic", "Curmudgeon",
									 "Decoder", "Defender", "Deviant",
									 "Director", "Explorer", "Fanatic",
									 "Follower", "Gallant", "Guardian",
									 "Honest Abe", "Jester", "Jobsworth",
									 "Judge", "Loner", "Manipulator",
									 "Martyr", "Masochist", "Masquerader",
									 "Mediator", "Monster", "Optimist",
									 "Pedagogue", "Penitent", "Perfectionist",
									 "Plotter", "Poltroon", "Praise-Seeker",
									 "Predator", "Rebel", "Recognition-Seeker",
									 "Reluctant Supernatural", "Renunciate", "Revolutionary",
									 "Rogue", "Sage", "Sensualist",
									 "Show-Off", "Soldier", "Supplicant",
									 "Survivor", "Sycophant", "Theorist",
									 "Thrill-Seeker", "Traditionalist", "Trickster",
									 "Visionary", "Waif", "Wanderer"};

	protected static Integer[] attributes = new Integer[9];
	/*
     * <<Physical Set>>
     * 0 Strength
     * 1 Dexterity
     * 2 Stamina
     * <<Social Set>>
     * 3 Charisma
     * 4 Manipulation
     * 5 Appearance
     * <<Mental Set>>
     * 6 Perception
     * 7 Intelligence
     * 8 Wits
     */
	protected static final Integer STRENGTH =     0;
	protected static final Integer DEXTERITY =    1;
	protected static final Integer STAMINA =      2;
	protected static final Integer CHARISMA =     3;
	protected static final Integer MANIPULATION = 4;
	protected static final Integer APPEARANCE =   5;
	protected static final Integer PERCEPTION =   6;
	protected static final Integer INTELLIGENCE = 7;
	protected static final Integer WITS =         8;

	//Attribute Priorities
	protected static char primSet;
	protected static char secSet;
	protected static char terSet;

	//Ability Priorities
	protected static char abilityPrimSet;
	protected static char abilitySecSet;
	protected static char abilityTerSet;

	protected static Integer primPool;
	protected static Integer secPool;
	protected static Integer terPool;
	protected static Integer will;
	protected static Integer baseWill;
	protected static final Integer maxWill = 10;
	protected static Integer backgroundPool;

	/*Abilities: Talents, Skills, Knowledges, 13/9/5 */

	protected static String nature;
	protected static String demeanor;

	protected static Map<String, Integer> backgrounds = new TreeMap();
	protected static Map<String, Integer> talents = new TreeMap();
	protected static Map<String, Integer> skills = new TreeMap();
	protected static Map<String, Integer> knowledges = new TreeMap();
	protected static Integer abilityPrimPool;
	protected static Integer abilitySecPool;
	protected static Integer abilityTerPool;
}

















