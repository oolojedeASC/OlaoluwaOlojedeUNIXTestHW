package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import animals.AnimalType;
import animals.petstore.pet.attributes.Breed;
import animals.petstore.pet.attributes.Gender;
import animals.petstore.pet.attributes.Skin;
import animals.petstore.pet.types.Snake;

public class SnakeTests {

    private static Snake actualSnake;

    @BeforeAll
    public static void createAnimals() {
        actualSnake = new Snake(AnimalType.DOMESTIC, Skin.SCALES, Gender.UNKNOWN, Breed.UNKNOWN);
    }

    @Test
    @Order(1)
    @DisplayName("Animal Test Type Tests Domestic")
    public void animalTypeTests() {
        assertEquals(AnimalType.DOMESTIC, actualSnake.getAnimalType(), "Animal Type Expected[" + AnimalType.DOMESTIC
                + "] Actual[" + actualSnake.getAnimalType() + "]");
    }

    @Test
    @Order(1)
    @DisplayName("Snake Speak psss Tests")
    public void snakeGoesPsssTest() {
        assertEquals("The snake goes sssh! sssh!", actualSnake.speak(), "I was expecting psss");
    }

    @Test
    @Order(1)
    @DisplayName("Snake Fur is it Hyperallergetic")
    public void snakeHyperAllergeticTests() {
        assertEquals("The snake is not hyperallergetic!", actualSnake.snakeHypoallergenic(),
                "The snake is not hyperallergetic!");
    }

    @Test
    @Order(1)
    @DisplayName("Snake has legs Test")
    public void legTests() {
        Assertions.assertNotNull(actualSnake.getNumberOfLegs());
    }

    @Test
    @Order(2)
    @DisplayName("Snake Gender Test FeMale")
    public void genderTestFeMale() {
        actualSnake = new Snake(AnimalType.WILD, Skin.UNKNOWN, Gender.FEMALE, Breed.UNKNOWN);
        assertEquals(Gender.FEMALE, actualSnake.getGender(), "Expecting Male Gender!");
    }

    @Test
    @Order(2)
    @DisplayName("Snake Breed Test Ball Python")
    public void genderSnakeBreed() {
        actualSnake = new Snake(AnimalType.WILD, Skin.UNKNOWN, Gender.FEMALE, Breed.BALL_PYTHON);
        assertEquals(Breed.BALL_PYTHON, actualSnake.getBreed(), "Expecting Ball Python!");
    }

    @Test
    @Order(2)
    @DisplayName("Snake Speak Hsss Tests")
    public void snakeGoesHsssTest() {
        actualSnake = new Snake(AnimalType.WILD, Skin.UNKNOWN, Gender.UNKNOWN, Breed.UNKNOWN);
        assertEquals("The snake goes hsss! hsss!", actualSnake.speak(), "I was expecting Hsss");
    }

    @Test
    @Order(2)
    @DisplayName("Snake Speak Sssh Tests")
    public void SnakeGoesSsshTest() {
        actualSnake = new Snake(AnimalType.UNKNOWN, Skin.UNKNOWN, Gender.UNKNOWN, Breed.UNKNOWN);
        assertEquals("The snake goes sssh! sssh!", actualSnake.speak(), "I was expecting Sssh");
    }

}
