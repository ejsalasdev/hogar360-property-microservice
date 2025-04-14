package com.powerup.propertymicroservice.infrastructure.utils.constants;

public final class InfrastructureConstants {

    public static final String LOGGER_START_UPDATE_PUBLICATIONS_MESSAGE = "Starting publication status update for date: {}";
    public static final String LOGGER_UPDATED_PUBLICATION_MESSAGE = "Publication {} updated to PUBLISHED.";
    public static final String LOGGER_FINISH_UPDATE_PUBLICATION_MESSAGE = "Finished updating publication statuses.";

    private InfrastructureConstants() {
        throw new IllegalStateException("Utility Class");
    }
}
