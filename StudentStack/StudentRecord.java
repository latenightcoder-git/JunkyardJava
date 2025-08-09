import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@ToString
public class StudentRecord {
    private int roll;
    private String name;
    private String email;
	
	
	// Manually added constructor
    public StudentRecord(int roll, String name, String email) {
        this.roll = roll;
        this.name = name;
        this.email = email;
    }

    // Getter methods for name, email, etc.
    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public int getRoll() {
        return roll;
    }
	
	@Override
    public String toString() {
        return "Roll: " + roll + ", Name: " + name + ", Email: " + email;
    }
}
