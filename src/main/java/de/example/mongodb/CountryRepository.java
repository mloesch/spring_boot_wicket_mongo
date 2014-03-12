package de.example.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import de.example.domain.Country;


@Repository
public interface CountryRepository extends MongoRepository<Country, String> {

}
