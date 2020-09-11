package org.prasanna.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter @Setter
public class RateLimit {
    private int coreLimit;
    private String searchLimit;

    @JsonProperty("resources")
    private void unMarshallNested(Map<String, Object> resources) {
        Map<String, Integer> core = (Map<String, Integer>) resources.get("core");
        coreLimit = core.get("limit");

        Map<String, String> search = (Map<String, String>) resources.get("search");
        searchLimit = String.valueOf(search.get("limit"));
    }
}
