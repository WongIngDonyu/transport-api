package org.web.transportapi.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.web.transportapi.dto.RaceDto;
import org.web.transportapi.dto.RaceViewDto;

import java.util.List;
import java.util.UUID;

@Tag(name = "races")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Успешная обработка запроса"),
        @ApiResponse(responseCode = "400", description = "Ошибка валидации", content = @Content),
        @ApiResponse(responseCode = "404", description = "Ресурс не найден", content = @Content),
        @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера", content = @Content)
})
public interface RaceApi {

    @Operation(summary = "Получить все рейсы")
    @GetMapping(value = "/api/races", produces = MediaType.APPLICATION_JSON_VALUE)
    List<EntityModel<RaceDto>> getAllRaces();

    @Operation(summary = "Получить рейс по ID")
    @GetMapping(value = "/api/races/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    EntityModel<RaceViewDto> getRaceById(@PathVariable UUID id);

    @Operation(summary = "Создать новый рейс")
    @PostMapping(value = "/api/races", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    EntityModel<RaceViewDto> createRace(@Valid @RequestBody RaceViewDto race);

    @Operation(summary = "Удалить рейс по ID")
    @DeleteMapping(value = "/api/races/{id}")
    void deleteRace(@PathVariable UUID id);

    @Operation(summary = "Обновить время рейса по ID")
    @PostMapping(value = "/api/races/{id}/update-time", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> updateRaceTime(@PathVariable UUID id, @RequestBody String newTime);
}