//Github Token: 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
package ds.fruit;

import java.util.Objects;

public class Fruit implements Comparable<Fruit>{

	//type definition of the fruit type:
	public enum TYPE{PEAR, GRAPE, APPLE, BANANA;}
	//field declaration:
	public TYPE type;
	
	//The weights of the Fruit represent their weight in kg.
	public float Weight;
	
	//The ripeness of the Fruit is a percentage, stored as a number between 0 and 1.
	public float Ripeness;

	//Constructor
	public Fruit(TYPE type, float weight, float ripeness) throws InvalidFruitWeightException, InvalidFruitRipenessException {
		this.type = type;
		this.Weight = weight;
		this.Ripeness = ripeness;
		
		
		if (this.Weight <= 0) {
			throw new InvalidFruitWeightException("Fruit Weight Invalid");
		}
		
		if (this.Ripeness <= 0 || this.Ripeness > 1) {
			throw new InvalidFruitRipenessException("Fruit Ripeness Value Invalid");
		}
	}

	//Getters
	public TYPE getType() {return type;}
	public float getWeight() {return Weight;}
	public float getRipeness() {return Ripeness;}

	@Override
	public int hashCode() {
		return Objects.hash(Ripeness, Weight, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fruit other = (Fruit) obj;
		return Float.floatToIntBits(Ripeness) == Float.floatToIntBits(other.Ripeness)
				&& Float.floatToIntBits(Weight) == Float.floatToIntBits(other.Weight) && type == other.type;
	}

	@Override
	public String toString() {
		return "Fruit [Type=" + type + ", Weight=" + Weight + ", Ripeness=" + Ripeness + "]";
	}

	@Override
	public int compareTo(Fruit fr) {
		//Comparison 1: Pears > Grapes, Apples > Bananas.
		//Comparison 2: When comparing Grapes and Apples, the Fruit with the higher weight is greater. Fruits are deemed equally weighted if their weights are within 0.05.
		//Comparison 3: The ripeness of a Fruit is used to break ties between two similarly weighted Fruits.
	
		
		//If the current object is pear and the specified object is not pear, we know the current object is greater:
		if (getType().compareTo(TYPE.PEAR) == 0 && fr.getType().compareTo(TYPE.PEAR) != 0) {return 1;}
		//If the specifed object is pear and the current object is not pear, we know the current object is lesser:
		else if (fr.getType().compareTo(TYPE.PEAR) == 0 && getType().compareTo(TYPE.PEAR) != 0) {return -1;}
		
		//Likewise, if the current object is banana and the specified object is not banana, we know the current object is lesser:
		else if (getType().compareTo(TYPE.BANANA) == 0 && fr.getType().compareTo(TYPE.BANANA) != 0) {return -1;}	
		//And if the specified object is banana and the current object is not banana, we know the current object is greater:
		else if (fr.getType().compareTo(TYPE.BANANA) == 0 && getType().compareTo(TYPE.BANANA) != 0) {return 1;}	
		
		//All other combinations of fruit types are deemed equal and will be sorted by Weight/Ripeness.
		
		//First find weights that are deemed to be equal and sort them using their ripeness:
		else if(getWeight() - fr.getWeight() < 0.05 && getWeight() - fr.getWeight() > -0.05) {
			if(getRipeness() > fr.getRipeness()) {return 1;}
			else{return -1;}
		}
		
		//Finally sorting the remaining unequal weight but equal type objects by their weights:
		else if(getWeight() > fr.getWeight()) {return 1;}
		else if(getWeight() < fr.getWeight()) {return -1;}

		return 0;
	
	}
	
	
	
}
