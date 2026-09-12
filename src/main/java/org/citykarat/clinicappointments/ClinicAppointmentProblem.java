package org.citykarat.clinicappointments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

enum AppointmentStatus {
    SCHEDULED,
    COMPLETED,
    CANCELLED,
    NO_SHOW
}

enum VisitType {
    CONSULTATION,
    FOLLOWUP,
    EMERGENCY
}

class Doctor {
    int doctorId;
    String name;

    Doctor(int doctorId, String name) {
        this.doctorId = doctorId;
        this.name = name;
    }
}

class Appointment {
    int appointmentId;
    int doctorId;
    int patientId;
    int durationMinutes;
    AppointmentStatus status;
    VisitType visitType;

    Appointment(int appointmentId, int doctorId, int patientId, int durationMinutes, AppointmentStatus status, VisitType visitType) {
        this.appointmentId = appointmentId;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.durationMinutes = durationMinutes;
        this.status = status;
        this.visitType = visitType;
    }
}

class AppointmentStats {
    int totalAppointments;
    int completedAppointments;
    double noShowRate;

    AppointmentStats(int totalAppointments, int completedAppointments, double noShowRate) {
        this.totalAppointments = totalAppointments;
        this.completedAppointments = completedAppointments;
        this.noShowRate = noShowRate;
    }
}

public class ClinicAppointmentProblem {
    public static List<Doctor> sampleDoctors() {
        return Arrays.asList(
                new Doctor(1, "Dr Rao"),
                new Doctor(2, "Dr Shah")
        );
    }

    public static List<Appointment> sampleAppointments() {
        return Arrays.asList(
                new Appointment(101, 1, 9001, 40, AppointmentStatus.COMPLETED, VisitType.CONSULTATION),
                new Appointment(102, 1, 9002, 15, AppointmentStatus.COMPLETED, VisitType.FOLLOWUP),
                new Appointment(103, 1, 9003, 30, AppointmentStatus.NO_SHOW, VisitType.CONSULTATION),
                new Appointment(201, 2, 9004, 60, AppointmentStatus.COMPLETED, VisitType.EMERGENCY),
                new Appointment(202, 2, 9005, 20, AppointmentStatus.CANCELLED, VisitType.FOLLOWUP)
        );
    }

    // TODO 1: Return total appointments, completed appointments, and no-show rate.
    public AppointmentStats getAppointmentStats() {

        Map<AppointmentStatus, Long> appointmentMap = appointments.stream().collect(Collectors.groupingBy(app->app.status, Collectors.counting()));
        //throw new UnsupportedOperationException("Implement this");
        int totalAppointments = appointments.size();
        int completedAppointments = appointmentMap.getOrDefault(AppointmentStatus.COMPLETED, 0L).intValue();
        int noShow = appointmentMap.getOrDefault(AppointmentStatus.NO_SHOW, 0L).intValue();
        return new AppointmentStats(totalAppointments, completedAppointments, totalAppointments == 0 ? 0.0 : (double) noShow /totalAppointments);
    }

    // TODO 2: Average completed visit duration by VisitType for one doctor.
    // Ignore CANCELLED and NO_SHOW appointments.
    // Example for doctor 1:
    // CONSULTATION => 40.0
    // FOLLOWUP => 15.0
    public Map<VisitType, Double> getAverageVisitDurationByType(int doctorId) {
        return appointments.stream()
                .filter(appointment -> appointment.doctorId == doctorId
                        && appointment.status == AppointmentStatus.COMPLETED)
                .collect(Collectors.groupingBy(e->e.visitType,
                        Collectors.averagingDouble(e->e.durationMinutes)));
    }

    List<Doctor> doctors = new ArrayList<>(sampleDoctors());
    List<Appointment> appointments = new ArrayList<>(sampleAppointments());
}

