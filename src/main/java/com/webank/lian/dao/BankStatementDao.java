package com.webank.lian.dao;

import com.webank.lian.domain.BankStatement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BankStatementDao {

    List<BankStatement> getBankStatement(@Param("personIdentification") String identification, @Param("bankName") String bankName);
    
}

