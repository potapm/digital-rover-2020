package ru.digital.rover.pwl.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.digital.rover.pwl.server.model.BypassDto;
import ru.digital.rover.pwl.server.model.BypassRequest;
import ru.digital.rover.pwl.server.model.InspectionResultDto;
import ru.digital.rover.pwl.server.service.BypassService;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/bypass")
@RestController
public class BypassController {

    private final BypassService bypassService;

    @GetMapping
    public List<BypassDto> getAll() {
        return bypassService.getAll();
    }

    @GetMapping("/{id}")
    public BypassDto findById(@PathVariable Long id) {
        return bypassService.findById(id);
    }

    @PostMapping
    public BypassDto createBypass(@RequestBody BypassRequest bypassRequest) {
        return bypassService.create(bypassRequest);
    }

    @PutMapping("/{id}")
    public BypassDto updateBypass(@PathVariable Long id, @RequestBody BypassRequest bypassRequest) {
        return bypassService.update(id, bypassRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteBypassById(@PathVariable Long id) {
        bypassService.delete(id);
    }

    @PostMapping("/{id}/inspectionResult")
    public BypassDto addInspectionResult(@PathVariable Long id, @RequestBody InspectionResultDto inspectionResultDto){
        return bypassService.addInspectionResult(id, inspectionResultDto);
    }

    @DeleteMapping("/{id}/inspectionResult/{nodeId}")
    public BypassDto removeInspectionResult(@PathVariable Long id, @PathVariable Long nodeId){
        return bypassService.removeInspectionResult(id, nodeId);
    }
}
