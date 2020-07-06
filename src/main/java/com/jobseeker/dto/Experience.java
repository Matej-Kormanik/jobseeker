package com.jobseeker.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Experience {

    private Long id;

    private String company;

    private String title;

    private String description;

    private LocalDate fromDate;

    private LocalDate toDate;

    private UserParent user;


    public Experience() {
    }

    public Experience(String company, String title, String description, LocalDate fromDate, LocalDate toDate) {
        this.company = company;
        this.title = title;
        this.description = description;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public Experience(Long id, String company, String title, String description, LocalDate fromDate, LocalDate toDate, UserParent user) {
        this.id = id;
        this.company = company;
        this.title = title;
        this.description = description;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                '}';
    }
}
