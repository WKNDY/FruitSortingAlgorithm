package ds.fruit;

public class Fruit {

	//type definition of the fruit type:
	public enum TYPE{PEAR, GRAPE, APPLE, BANANA;}
	//field declaration:
	public TYPE type;
	
	//The weights of the Fruit represent their weight in kg.
	public float Weight;
	
	//The ripeness of the Fruit is a percentage, stored as a number between 0 and 1.
	public float Ripeness;

	//Constructor
	public Fruit(TYPE type, float weight, float ripeness) {
		this.type = type;
		this.Weight = weight;
		this.Ripeness = ripeness;
	}
	
	
	
	
}
