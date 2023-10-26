package in.bushansirgur.expensetrackerapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.internal.build.AllowPrintStacktrace;

@Getter
@AllArgsConstructor
public class JwtResponse {
    private final String jwtToken;

}
