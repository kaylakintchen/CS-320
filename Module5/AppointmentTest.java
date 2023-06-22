package Module5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class AppointmentTest {
    @Test
    public void testValidAppointment() {
        // Arrange
        String appointmentId = "A123456789";
        Date appointmentDate = new Date(); // Use the current date/time
        String description = "Sample Appointment";

        // Act
        Appointment appointment = new Appointment(appointmentId, appointmentDate, description);

        // Assert
        Assertions.assertEquals(appointmentId, appointment.getAppointmentId());
        Assertions.assertEquals(appointmentDate, appointment.getAppointmentDate());
        Assertions.assertEquals(description, appointment.getDescription());
    }

    @Test
    public void testInvalidAppointmentId_Null() {
        // Arrange
        String appointmentId = null;
        Date appointmentDate = new Date();
        String description = "Sample Appointment";

        // Act and Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(appointmentId, appointmentDate, description);
        });
    }

    @Test
    public void testInvalidAppointmentId_Empty() {
        // Arrange
        String appointmentId = "";
        Date appointmentDate = new Date();
        String description = "Sample Appointment";

        // Act and Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(appointmentId, appointmentDate, description);
        });
    }

    @Test
    public void testInvalidAppointmentId_TooLong() {
        // Arrange
        String appointmentId = "A1234567890"; // More than 10 characters
        Date appointmentDate = new Date();
        String description = "Sample Appointment";

        // Act and Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(appointmentId, appointmentDate, description);
        });
    }

    @Test
    public void testInvalidAppointmentDate_InThePast() {
        // Arrange
        String appointmentId = "A123456789";
        Date appointmentDate = new Date(System.currentTimeMillis() - 1000); // 1 second ago
        String description = "Sample Appointment";

        // Act and Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(appointmentId, appointmentDate, description);
        });
    }

    @Test
    public void testInvalidDescription_Null() {
        // Arrange
        String appointmentId = "A123456789";
        Date appointmentDate = new Date();
        String description = null;

        // Act and Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(appointmentId, appointmentDate, description);
        });
    }

    @Test
    public void testInvalidDescription_Empty() {
        // Arrange
        String appointmentId = "A123456789";
        Date appointmentDate = new Date();
        String description = "";

        // Act and Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(appointmentId, appointmentDate, description);
        });
    }

    @Test
    public void testInvalidDescription_TooLong() {
        // Arrange
        String appointmentId = "A123456789";
        Date appointmentDate = new Date();
        String description = "This is a very long appointment description that exceeds the maximum allowed characters.";

        // Act and Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(appointmentId, appointmentDate, description);
        });
    }
}
