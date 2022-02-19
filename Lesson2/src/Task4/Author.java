package Task4;

public class Author {
    private String name;
    private GenderType gender;
    private String emale;

    Author(String name, GenderType gender, String emale) {
        this.name = name;
        this.gender = gender;
        this.emale = emale;
    }

    public String getName() {
        return name;
    }

    public GenderType getGender() {
        return gender;
    }

    public String getEmale() {
        return emale;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public void setEmale(String emale) {
        this.emale = emale;
    }

    public String toString() {
        if (gender.equals(GenderType.MALE)) {
            return String.format("%s (пол: муж. e-mail: %s)", name, emale);
        }
        else {
            return String.format("%s (пол: жен. e-mail: %s)", name, emale);
        }

    }
}
