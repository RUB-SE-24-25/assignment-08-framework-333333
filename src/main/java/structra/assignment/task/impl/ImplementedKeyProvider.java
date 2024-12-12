package structra.assignment.task.impl;
import structra.assignment.framework.llm.KeyProvider;

import java.util.Optional;

public class ImplementedKeyProvider implements KeyProvider {
    private static final String ENV_VARIABLE_NAME = "GPT_API_KEY";

    @Override
    public String getApiKey() {
        return Optional.ofNullable(System.getenv(ENV_VARIABLE_NAME))
            .filter(apiKey -> !apiKey.isEmpty())
            .orElseThrow(() -> new RuntimeException(
                String.format("API key is not set or empty", ENV_VARIABLE_NAME)
            ));
    }
}