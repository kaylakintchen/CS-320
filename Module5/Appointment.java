package Module5;

import java.util.Date;

public class Appointment {
    private String appointmentId;
    private Date appointmentDate;
    private String description;

    public Appointment(String appointmentId, Date appointmentDate, String description) {
        if (appointmentId == null || appointmentId.isEmpty() || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Invalid appointment ID.");
        }
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid appointment date.");
        }
        if (description == null || description.isEmpty() || description.length() > 50) {
            throw new IllegalArgumentException("Invalid appointment description.");
        }

        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }
}
