package sample.mkhldvdv.demo.mapper;

import sample.mkhldvdv.demo.dto.DemoAppUserDto;
import sample.mkhldvdv.demo.model.DemoAppUser;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DemoAppUsersMapper {

    DemoAppUserDto toDto(DemoAppUser entity);
    List<DemoAppUserDto> toDtoList(List<DemoAppUser> entity);
    DemoAppUser toEntity(DemoAppUserDto dto);
    List<DemoAppUser> toEntityList(List<DemoAppUserDto> dto);

}