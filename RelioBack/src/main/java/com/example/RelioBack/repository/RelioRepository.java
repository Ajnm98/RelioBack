package com.example.RelioBack.repository;

import com.example.RelioBack.model.Fiestas;
import com.example.RelioBack.model.Relio;
import com.example.RelioBack.model.Usuario;
import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RelioRepository extends JpaRepository<Relio, Long> {
    @Query(value = "select * from relio where id = :relio", nativeQuery = true)
    Relio findById(long relio);

    @Modifying
    @Transactional
    @Query(value = "update relio c set c.personas = :personas, c.lleno = :lleno where c.id = :id", nativeQuery = true)
    void addPerson(@Param("personas") Integer personas,@Param("lleno") Integer lleno,  @Param("id") Integer id);

    @Query(value = "insert into relio_receptores(relio_id, user_id) values(:relio_id, :user_id)", nativeQuery = true)
    void relio_receptores(@Param("relio_id") Integer relio_id, @Param("user_id") long user_id);

    @Modifying
    @Transactional
    @Query(value = "update relio c set c.fecha_inicio = :fecha_inicio where c.id = :id", nativeQuery = true)
    void modifyHourRelio(@Param("fecha_inicio") LocalDateTime fecha_inicio, @Param("id") Integer id);

    @Query(value = "select * from relio where usuario_id_emisor = :relio", nativeQuery = true)
    List<Relio> findEmisorRelio(long relio);

    @Query(value = "select * from relio where usuario_id_emisor = :relio && fecha_inicio >= DATE(NOW())", nativeQuery = true)
    List<Relio> findEmisorRelioVigente(long relio);

    @Query(value = "select relio_id from relio_receptores where user_id = :relio", nativeQuery = true)
    List<Integer> findIntRelio(long relio);

    @Query(value = "select * from relio where id = 18 && fecha_inicio >= DATE(NOW())", nativeQuery = true)
    Relio findReceptorRelioVigente(long relio);


    @Query(value = "select * from relio where usuario_id_emisor = :relio && fecha_inicio < DATE(NOW())", nativeQuery = true)
    List<Relio> findEmisorRelioNoVigente(long relio);

    @Query(value = "select * from relio where id = 18 && fecha_inicio < DATE(NOW())", nativeQuery = true)
    Relio findReceptorRelioNoVigente(long relio);
}
