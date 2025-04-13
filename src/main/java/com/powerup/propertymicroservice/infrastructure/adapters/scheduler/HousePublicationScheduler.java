package com.powerup.propertymicroservice.infrastructure.adapters.scheduler;

import com.powerup.propertymicroservice.commons.constants.CommonConstants;
import com.powerup.propertymicroservice.domain.enums.PublicationStatus;
import com.powerup.propertymicroservice.domain.model.HouseModel;
import com.powerup.propertymicroservice.domain.ports.out.HousePersistencePort;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static com.powerup.propertymicroservice.infrastructure.utils.constants.InfrastructureConstants.*;

@Component
@RequiredArgsConstructor
public class HousePublicationScheduler {

    public static final Logger LOGGER = LoggerFactory.getLogger(HousePublicationScheduler.class);
    private final HousePersistencePort housePersistencePort;

    @Transactional
    @Scheduled(cron = "0 0 0 * * *")
    public void updatePublicationStatuses() {
        LocalDate currentDate = LocalDate.now(ZoneId.of(CommonConstants.TIME_ZONE));
        LOGGER.info(LOGGER_START_UPDATE_PUBLICATIONS_MESSAGE, currentDate);

        List<HouseModel> houseToPublish = housePersistencePort.findHousesByActivePublicationDate(currentDate);

        for (HouseModel house : houseToPublish) {
            if (!PublicationStatus.PUBLISHED.equals(house.getPublicationStatus())){
                house.setPublicationStatus(PublicationStatus.PUBLISHED);
                housePersistencePort.save(house);
                LOGGER.info(LOGGER_UPDATED_PUBLICATION_MESSAGE, house.getId());
            }
        }
        
        LOGGER.info(LOGGER_FINISH_UPDATE_PUBLICATION_MESSAGE);
    }


}
