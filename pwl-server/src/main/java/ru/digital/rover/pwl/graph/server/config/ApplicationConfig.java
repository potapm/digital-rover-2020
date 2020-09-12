package ru.digital.rover.pwl.graph.server.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.neo4j.Neo4jDataAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"ru.digital.rover.ept.server.eptserver"})
//@EnableAutoConfiguration(exclude = {Neo4jDataAutoConfiguration.class, DataSourceAutoConfiguration.class})
public class ApplicationConfig {
}
