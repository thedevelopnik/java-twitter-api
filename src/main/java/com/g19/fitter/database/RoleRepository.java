package com.g19.fitter.database;

import org.springframework.data.mongodb.repository.MongoRepository;

interface RoleRepository extends MongoRepository<Role, String> {
}