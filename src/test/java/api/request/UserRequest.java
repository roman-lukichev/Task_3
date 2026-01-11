package api.request;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class UserRequest {
    private String email;
    private String password;
    private String name;
}
