package com.bruno.sistema_vendas.repositories;

import com.bruno.sistema_vendas.models.StateModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<StateModel, Long> {
}
