package ru.digital.rover.pwl.server.mapper;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.digital.rover.pwl.server.domain.model.InspectionResult;
import ru.digital.rover.pwl.server.model.InspectionResultDto;

@Transactional
@Component
public class InspectionResultDtoMapper implements Converter<InspectionResultDto, InspectionResult> {

    @Override
    public InspectionResult convert(MappingContext<InspectionResultDto, InspectionResult> context) {
        InspectionResultDto source = context.getSource();
        return new InspectionResult(
                source.getNodeId(),
                source.getWireBreakPercent(),
                source.getIsolatorLostPercent(),
                source.getGvpShiftedPercent(),
                source.getScore()
        );
    }
}
