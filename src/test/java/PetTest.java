import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {
    //arrange
    private Person paul = new Person("Paul", "Locan", 33, "male");
    private Person mirjam = new Person("Mirjam", "Powall", 45, "female");
    private Pet pet;

    @BeforeEach
    void setUp() {
        pet = new Pet("Maple", 4, "dog", "male");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void canGetName() {
        //act
        String testName = pet.getName();
        //assert
        assertEquals("Maple", testName);
    }

    @Test
    void canGetAge() {
        //act
        int testAge = pet.getAge();
        //assert
        assertEquals(4, testAge);
    }

    @Test
    void canGetGender() {
        //act
        String testGender = pet.getGender();
        //assert
        assertEquals("male", testGender);
    }

    @Test
    void canGetSpecies() {
        //act
        String testSpecies = pet.getSpecies();
        //assert
        assertEquals("dog", testSpecies);
    }

    @Test
    void canGetEmptyWeight() {
        //act
        float testWeight = pet.getWeight();
        //assert
        assertEquals(0.0, testWeight);
    }

    @Test
    void canGetWeight() {
        //arrange
        Pet testPet = new Pet("Jip", 7, "male", "cat", 13.4f, mirjam);
        //act
        float testWeight = testPet.getWeight();
        //assert
        assertEquals(13.4f, testWeight);
    }

    @Test
    void canGetEmptyOwner() {
        //act
        Person testOwner = pet.getOwner();
        //assert
        assertNull(testOwner);
    }

    @Test
    void canGetOwner() {
        //arrange
        Pet testPet = new Pet("Jip", 7, "male", "cat", 13.4f, mirjam);
        //act
        Person testOwner = testPet.getOwner();
        //assert
        assertEquals(mirjam, testOwner);
    }

    @Test
    void setName() {
        //act
        pet.setName("Major");
        String testName = pet.getName();
        //assert
        assertEquals("Major", testName);
    }

    @Test
    void setAge() {
        //act
        pet.setAge(4);
        int age = pet.getAge();
        //assert
        assertEquals(4, age);
    }

    @Test
    void setWeight() {
        //act
        pet.setWeight(33.2f);
        float testWeight = pet.getWeight();
        //assert
        assertEquals(33.2f, testWeight);
    }

    @Test
    void setOwner() {
        //act
        pet.setOwner(paul);
        Person testOwner = pet.getOwner();
        //assert
        assertEquals(paul, testOwner);
    }
}