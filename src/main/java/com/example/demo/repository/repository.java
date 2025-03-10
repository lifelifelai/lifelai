package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.account;

@Repository
public interface repository extends JpaRepository<account, String> {

	
	@Modifying
	@Transactional
	 @Query(value="insert into account VALUES (:cust,:customerId)",nativeQuery = true)
     void sett(@Param("customerId") String cusid,@Param("cust") String custid);
	
	
	
	 @Query(value="select * from account where pas!='已讀' ",nativeQuery = true)
     List<account> ww();
 	
	 @Query(value="select * from account ",nativeQuery = true)
     List<account> ww1();
     
}
