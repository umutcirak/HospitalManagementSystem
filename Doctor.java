public class Doctor {
    private String doctor_id;
    private String name;
    private String surname;
    private String department;
    private String available_hours;
    private String available_dates;
    private String ranking;

    public Doctor(String doctor_id, String name, String surname, String department, String available_hours, String available_dates, String ranking) {
        this.doctor_id = doctor_id;
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.available_hours = available_hours;
        this.available_dates = available_dates;
        this.ranking = ranking;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDepartment() {
        return department;
    }

    public String getAvailable_hours() {
        return available_hours;
    }

    public String getAvailable_dates() {
        return available_dates;
    }

    public String getRanking() {
        return ranking;
    }
}