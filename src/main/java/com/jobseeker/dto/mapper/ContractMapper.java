package com.jobseeker.dto.mapper;

import com.jobseeker.dto.Contract;
import com.jobseeker.persistence.entity.ContractEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContractMapper {

    Contract toContract(ContractEntity contractEntity);
    List<Contract> toContract(List<ContractEntity> contractEntities);

    ContractEntity toEntity(Contract contract);
    List<ContractEntity> toEntity(List<Contract> contracts);

}
