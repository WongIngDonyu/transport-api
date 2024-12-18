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
import org.web.transportapi.dto.TransportDto;
import org.web.transportapi.dto.TransportViewDto;

import java.util.List;
import java.util.UUID;

@Tag(name = "transports")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Успешная обработка запроса"),
        @ApiResponse(responseCode = "400", description = "Ошибка валидации", content = @Content),
        @ApiResponse(responseCode = "404", description = "Ресурс не найден", content = @Content),
        @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера", content = @Content)
})
public interface TransportApi {

    @Operation(summary = "Получить все транспортные средства")
    @GetMapping(value = "/api/transports", produces = MediaType.APPLICATION_JSON_VALUE)
    List<EntityModel<TransportDto>> getAllTransports();

    @Operation(summary = "Получить транспортное средство по ID")
    @GetMapping(value = "/api/transports/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    EntityModel<TransportViewDto> getTransportById(@PathVariable UUID id);

    @Operation(summary = "Создать новое транспортное средство")
    @PostMapping(value = "/api/transports", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    EntityModel<TransportDto> createTransport(@RequestBody TransportViewDto transport);

    @Operation(summary = "Удалить транспортное средство по ID")
    @DeleteMapping(value = "/api/transports/{id}")
    void deleteTransport(@PathVariable UUID id);
}
