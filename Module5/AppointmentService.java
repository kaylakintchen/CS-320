package Module5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppointmentService {
    private final Map<String, Appointment> appointments;

    public AppointmentService() {
        this.appointments = new HashMap<>();
    }

    public void addAppointment(Appointment appointment) {
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment cannot be null.");
        }

        String appointmentId = appointment.getAppointmentId();
        if (appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment with the same ID already exists.");
        }

        appointments.put(appointmentId, appointment);
    }

    public void deleteAppointment(String appointmentId) {
        if (appointmentId == null) {
            throw new IllegalArgumentException("Appointment ID cannot be null.");
        }

        if (!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment with the specified ID does not exist.");
        }

        appointments.remove(appointmentId);
    }

    public Appointment getAppointment(String appointmentId) {
        if (appointmentId == null) {
            throw new IllegalArgumentException("Appointment ID cannot be null.");
        }

        return appointments.get(appointmentId);
    }

    public List<Appointment> getAllAppointments() {
        return new ArrayList<>(appointments.values());
    }
}

