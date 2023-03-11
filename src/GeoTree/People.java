package GeoTree;

// создаем абстрактный класс с ключевыми характеристиками людей (Имя, Возраст, Пол)
public abstract class People {


    private String fullName;

    private int age;

    private String gender;

    public People(String fullName, int age, String gender) {
        this.fullName = fullName;
        this.age = age;
        if (gender == "man" || gender == "woman") this.gender = String.valueOf(Gender.valueOf(gender));
        else this.gender = null;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        if (this.gender != null) {
            return this.gender.toString();
        } else return "Ошибка: гендер не установлен";
    }

    public void setGender(String gender) {
        if (gender == "man" || gender == "woman") this.gender = String.valueOf(Gender.valueOf(gender));
        else this.gender = null;
    }
}