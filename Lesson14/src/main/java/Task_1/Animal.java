package Task_1;

import java.util.Map;

public class Animal {
    private String title;
    private boolean isAvailable;
    private boolean isSold;
    private Map<String, String> photosMap;

    @Override
    public String toString() {
        return "Task_1.Animal{" +
                "\n title='" + title + '\'' +
                ", \n isAvailable=" + isAvailable +
                ", \n isSold=" + isSold +
                ", \n photosMap=" + photosMap +
                "\n}";
    }
}