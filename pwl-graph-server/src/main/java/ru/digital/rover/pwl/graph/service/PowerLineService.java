package ru.digital.rover.pwl.graph.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.digital.rover.pwl.graph.domain.PowerLineNode;
import ru.digital.rover.pwl.graph.model.PowerLineNodeDto;
import ru.digital.rover.pwl.graph.model.PowerLineNodeRequest;
import ru.digital.rover.pwl.graph.repositories.PowerLineRepository;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@RequiredArgsConstructor
@Service
public class PowerLineService {

    private final PowerLineRepository powerLineRepository;
    private final ModelMapper modelMapper;

    public List<PowerLineNodeDto> getAll() {
        return powerLineRepository.findAll().parallelStream()
                .map(powerLineNode -> modelMapper.map(powerLineNode, PowerLineNodeDto.class))
                .collect(Collectors.toList());
    }

    public PowerLineNodeDto getById(Long id) {
        return modelMapper.map(powerLineRepository.findById(id).orElseThrow(), PowerLineNodeDto.class);
    }

    public PowerLineNodeDto save(PowerLineNodeRequest powerLineNodeRequest) {
        PowerLineNode node = modelMapper.map(powerLineNodeRequest, PowerLineNode.class);
        return modelMapper.map(powerLineRepository.save(node), PowerLineNodeDto.class);
    }

    public PowerLineNodeDto update(Long id, PowerLineNodeRequest powerLineNodeRequest) {
        PowerLineNode powerLineNode = powerLineRepository.findById(id).orElseThrow();
        modelMapper.map(powerLineNodeRequest, powerLineNode);
        return modelMapper.map(powerLineRepository.save(powerLineNode), PowerLineNodeDto.class);
    }

    public void delete(Long id) {
        powerLineRepository.deleteById(id);
    }

    public PowerLineNodeDto connect(Long id, Long destinationId) {
        PowerLineNode node = powerLineRepository.findById(id).orElseThrow();
        PowerLineNode destination = powerLineRepository.findById(destinationId).orElseThrow();
        node.getNodes().add(destination);
        return modelMapper.map(powerLineRepository.save(node), PowerLineNodeDto.class);
    }

    public PowerLineNodeDto disconnect(Long id, Long destinationId) {
        PowerLineNode node = powerLineRepository.findById(id).orElseThrow();
        node.getNodes().removeIf(n -> n.getId().equals(destinationId));
        return modelMapper.map(powerLineRepository.save(node), PowerLineNodeDto.class);
    }

    public List<PowerLineNodeDto> getLineById(List<String> lineIds) {
        return powerLineRepository.findAllByLineIdsContains(lineIds).parallelStream()
                .map(powerLineNode -> modelMapper.map(powerLineNode, PowerLineNodeDto.class))
                .collect(Collectors.toList());
    }

}
