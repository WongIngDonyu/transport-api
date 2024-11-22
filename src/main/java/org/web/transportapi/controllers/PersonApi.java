package org.web.transportapi.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.web.transportapi.dto.PersonDto;
import org.web.transportapi.dto.PersonViewDto;

import java.util.List;
import java.util.UUID;

@Tag(name = "persons")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Успешная обработка запроса"),
        @ApiResponse(responseCode = "400", description = "Ошибка валидации", content = @Content),
        @ApiResponse(responseCode = "404", description = "Ресурс не найден", content = @Content),
        @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера", content = @Content)
})
public interface PersonApi {

    @Operation(summary = "Получить всех пользователей")
    @GetMapping(value = "/api/persons", produces = MediaType.APPLICATION_JSON_VALUE)
    List<EntityModel<PersonDto>> getAllPersons();

    @Operation(summary = "Получить пользователя по ID")
    @GetMapping(value = "/api/persons/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    EntityModel<PersonViewDto> getPersonById(@PathVariable UUID id);

    @Operation(summary = "Создать нового пользователя")
    @PostMapping(value = "/api/persons", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    EntityModel<PersonViewDto> createPerson(@Valid @RequestBody PersonViewDto person);

    @Operation(summary = "Удалить пользователя по ID")
    @DeleteMapping(value = "/api/persons/{id}")
    void deletePerson(@PathVariable UUID id);

    @Operation(summary = "Изменить рейс пользователя по ID")
    @PostMapping(value = "/api/persons/{id}/race", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> changePersonRace(@PathVariable UUID id, @RequestParam String raceName);
}
