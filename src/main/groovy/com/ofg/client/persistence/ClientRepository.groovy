package com.ofg.client.persistence

import com.ofg.client.model.Client
import org.springframework.data.repository.CrudRepository


interface ClientRepository extends CrudRepository<Client, Long> {
}
