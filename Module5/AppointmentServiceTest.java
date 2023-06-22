package Module5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Map;


import java.util.Date;
import java.util.List;

public class AppointmentServiceTest {
    private AppointmentService appointmentService;
    private Appointment appointment1;
    private Appointment appointment2;

    @BeforeEach
    public void setUp() {
        appointmentService = new AppointmentService();
        appointment1 = new Appointment("A001", new Date(), "Description 1");
        appointment2 = new Appointment("A002", new Date(), "Description 2");
    }

    @Test
    public void testAddAppointment() {
        appointmentService.addAppointment(appointment1);
        assertEquals(appointment1, appointmentService.getAppointment("A001"));
    }

    @Test
    public void testDeleteAppointment() {
        appointmentService.addAppointment(appointment1);
        appointmentService.deleteAppointment("A001");
        assertNull(appointmentService.getAppointment("A001"));
    }

    @Test
    public void testGetAppointment() {
        appointmentService.addAppointment(appointment1);
        appointmentService.addAppointment(appointment2);

        Appointment retrievedAppointment1 = appointmentService.getAppointment("A001");
        assertEquals(appointment1, retrievedAppointment1);

        Appointment retrievedAppointment2 = appointmentService.getAppointment("A002");
        assertEquals(appointment2, retrievedAppointment2);
    }

    @Test
    public void testGetAllAppointments() {
        Appointment appointment = new Appointment("A001", new Date(), "Description");
        appointmentService.addAppointment(appointment);
        List<Appointment> allAppointments = appointmentService.getAllAppointments();
        assertEquals(1, allAppointments.size());
        assertEquals(appointment, allAppointments.get(0));
    }

    @Test
    public void testAddDuplicateAppointment() {
        appointmentService.addAppointment(appointment1);

        // Attempt to add an appointment with the same ID
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.addAppointment(appointment1);
        });
    }

    @Test
    public void testDeleteNonexistentAppointment() {
        // Attempt to delete an appointment that doesn't exist
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.deleteAppointment("A003");
        });
    }

    @Test
    public void testGetNonexistentAppointment() {
        // Attempt to get an appointment that doesn't exist
        assertNull(appointmentService.getAppointment("A003"));
    }
}
