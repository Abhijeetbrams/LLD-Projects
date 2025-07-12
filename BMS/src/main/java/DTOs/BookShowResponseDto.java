package DTOs;

import org.springframework.web.bind.annotation.ResponseStatus;

public class BookShowResponseDto {
    private Long bookingId;
    private Double amount;
    private ResponseStatus responseStatus;
    private String failureReason;
}
