@Print(style = "arrow", color = Colors.RED)
public class Messages {

    @Print(style = "hurray", color = Colors.PURPLE)
    public String happyBirthday() {
        return "С днём рождения!";
    }

    public String happyNewYear() {
        return "С Новым годом!";
    }

    @Print(style = "!", color = Colors.YELLOW)
    public String warning() {
        return "Предупреждение";
    }

    public String error() {
        return "Ошибка";
    }
}