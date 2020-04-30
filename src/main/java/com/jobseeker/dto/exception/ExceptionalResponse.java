package com.jobseeker.dto.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
public class ExceptionalResponse {

    private Integer httpStatusCode;

    private String httpStatusMessage;

    private String description;

    private LocalDateTime time;

}
