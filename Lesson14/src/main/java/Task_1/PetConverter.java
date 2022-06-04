package Task_1;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PetConverter {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Pet cat = new Pet("Барсик", Status.AVAILABLE,
                List.of(new Photo("Барсик с цветочком",
                                "https://placekitten.com/200/300"),
                        new Photo("Барсик на ручках",
                                "https://placekitten.com/500/605")
                ));

        Animal animalCat = mapToProductDto(cat);
        System.out.println(animalCat);
    }

    private static Animal mapToProductDto(Pet cat) throws NoSuchFieldException, IllegalAccessException {
        Class<Pet> petClass = Pet.class;

        Field nameField = petClass.getDeclaredField("name");
        nameField.setAccessible(true);
        String name = (String) nameField.get(cat);

        Field statusField = petClass.getDeclaredField("status");
        statusField.setAccessible(true);
        Status status = (Status) statusField.get(cat);

        Field photosListField = petClass.getDeclaredField("photosList");
        photosListField.setAccessible(true);
        List<Photo> photosList = (List<Photo>) photosListField.get(cat);

        Animal animal = new Animal();

        String title = name;
        boolean isAvailable = status == Status.AVAILABLE;
        boolean isSold = status == Status.SOLD;
        Map<String, String> photosMap = new HashMap<>();
        for (Photo photo: photosList) {
            photosMap.put(photo.getName(), photo.getURL());
        }

        Class<Animal> animalClass = Animal.class;

        Field titleField = animalClass.getDeclaredField("title");
        titleField.setAccessible(true);
        titleField.set(animal, title);

        Field isAvailableField = animalClass.getDeclaredField("isAvailable");
        isAvailableField.setAccessible(true);
        isAvailableField.set(animal, isAvailable);

        Field isSoldField = animalClass.getDeclaredField("isSold");
        isSoldField.setAccessible(true);
        isSoldField.set(animal, isSold);

        Field photosMapField = animalClass.getDeclaredField("photosMap");
        photosMapField.setAccessible(true);
        photosMapField.set(animal, photosMap);

        return animal;
    }
}
