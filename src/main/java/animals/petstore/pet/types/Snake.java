package animals.petstore.pet.types;

import animals.AnimalType;
import animals.petstore.pet.Pet;
import animals.petstore.pet.attributes.Breed;
import animals.petstore.pet.attributes.Gender;
import animals.petstore.pet.attributes.PetType;
import animals.petstore.pet.attributes.Skin;

import java.math.BigDecimal;

public class Snake extends Pet implements PetImpl {

    /* Properties for the snake */
    private int numberOfLegs;
    private Breed breed;

    /**
     * Constructor
     * 
     * @param animalType {@link AnimalType} that defines if it domesticated or wild
     *                   snake
     * @param skinType   The {@link Skin} of the snake
     * @param gender     The {@link Gender} of the snake
     * @param breed      The type of snake {@link Breed}
     */

    // Had a weird error where petstoreid needed to be added to the contructor here,
    // even though it is not
    // In the concgructor of cat and dog.
    public Snake(AnimalType animalType, Skin skinType, Gender gender, Breed breed) {
        this(animalType, skinType, gender, breed, new BigDecimal(0), 0);
    }

    /**
     * Second Constructor
     * 
     * @param animalType {@link AnimalType} that defines if it domesticated or wild
     *                   snake
     * @param skinType   The {@link Skin} of the snake
     * @param gender     The {@link Gender} of the snake
     * @param breed      The type of snake {@link Breed}
     * @param cost       The cost of the snake
     */
    public Snake(AnimalType animalType, Skin skinType, Gender gender, Breed breed, BigDecimal cost, int petStoreId) {
        super(PetType.DOG, cost, gender, petStoreId);
        super.skinType = skinType;
        super.animalType = animalType;
        this.numberOfLegs = 0;
        this.breed = breed;
    }

    /**
     * Check if the snake is allergy friendly determined by skin type
     * 
     * @return A message that tells if the snake is hypoallergenic
     */
    public String snakeHypoallergenic() {
        return super.petHypoallergenic(this.skinType).replaceAll("pet", "snake");
    }

    /**
     * Depending if the snake is domestic, wild, or neither what can the say
     * 
     * @return what snake would speak
     */
    public String speak() {
        String language;
        switch (this.animalType) {
            case DOMESTIC:
                language = "The snake goes sssh! sssh!";
                break;
            case WILD:
                language = "The snake goes hsss! hsss!";
                break;
            default:
                language = "The snake goes " + super.getPetType().speak + "! " + super.getPetType().speak + "!";
                break;
        }
        return language;
    }

    private String numberOfLegs() {
        return "Cats have " + numberOfLegs + " legs!";
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public void setNumberOfLegs(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }

    @Override
    public Breed getBreed() {
        return this.breed;
    }

    public String typeOfPet() {
        return "The type of pet is " + petType + "!";
    }

    public AnimalType getAnimalType() {
        return super.animalType;
    }

    @Override
    public String toString() {
        return super.toString() +
                "The snake is " + this.animalType + "!\n" +
                "The snake breed is " + this.getBreed() + "!\n" +
                this.snakeHypoallergenic() + "!\n" +
                this.speak() + "\n" +
                this.numberOfLegs();
    }

}
