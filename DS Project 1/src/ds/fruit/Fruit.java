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
		return "Fruit [type=" + type + ", Weight=" + Weight + ", Ripeness=" + Ripeness + "]";
	}

	@Override
	public int compareTo(Fruit fr) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
