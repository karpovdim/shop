package by.karpov.shop.exeptions;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ErrorResponse {
    String statusMessage;
    int status;
    String error;
}
