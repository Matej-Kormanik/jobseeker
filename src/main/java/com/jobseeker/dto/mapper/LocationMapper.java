package com.jobseeker.dto.mapper;

import com.jobseeker.dto.Location;
import com.jobseeker.persistence.entity.LocationEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocationMapper {

    Location toLocation(LocationEntity locationEntity);
    List<Location> toLocations(List<LocationEntity> locationEntities);

    LocationEntity toEntity(Location location);
    List<LocationEntity> toEntities(List<Location> locations);
}
