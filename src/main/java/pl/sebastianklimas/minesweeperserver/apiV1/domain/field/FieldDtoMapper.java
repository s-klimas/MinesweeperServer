package pl.sebastianklimas.minesweeperserver.apiV1.domain.field;

import pl.sebastianklimas.minesweeperserver.apiV1.domain.field.dto.FieldDto;

public class FieldDtoMapper {
    public static FieldDto map(Field field) {
        FieldDto fieldDto = new FieldDto();
        fieldDto.setContent(field.getContent());
        fieldDto.setPositionIn2dMatrix(field.getPositionIn2dMatrix());
        return fieldDto;
    }
}
