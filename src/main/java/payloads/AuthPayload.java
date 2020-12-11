package payloads;
import com.fasterxml.jackson.annotation.JsonProperty;
/*
{
        "username": "admin",
        "password": "password123"
}
*/

public class AuthPayload {

    @JsonProperty
    private String username;
    @JsonProperty
    private String password;

    public AuthPayload(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
