package ${basePackage}.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ${basePackage}.po.${className}PO;

/**
 *
 * Created by ${author} on ${date}.
 */
@Repository
public interface ${className}Dao extends JpaRepository<${className}PO, String> {

}
