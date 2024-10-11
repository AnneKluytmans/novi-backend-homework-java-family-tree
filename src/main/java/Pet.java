public class Pet {
    private String name;
    private int age;
    private final String gender;
    private final String species;
    private int weight;
    private Person owner;

    public Pet(String name, int age, String gender, String species, int weight, Person owner) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.species = species;
        this.weight = weight;
        this.owner = owner;
    }

    public Pet(String name, int age, String species, String gender) {
        this.name = name;
        this.age = age;
        this.species = species;
        this.gender = gender;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getSpecies() {
        return species;
    }

    public int getWeight() {
        return weight;
    }

    public Person getOwner() {
        return owner;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

}
