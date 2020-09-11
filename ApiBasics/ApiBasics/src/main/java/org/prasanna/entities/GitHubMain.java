package org.prasanna.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GitHubMain {
    @JsonProperty("current_user_url")
    private String currentUserUrl;
    @JsonProperty("keys_url")
    private String keysUrl;
    @JsonProperty("rate_limit_url")
    private String rateLimitUrl;
}
