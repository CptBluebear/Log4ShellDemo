package org.corodiak.l4jspring.repository;

import org.corodiak.l4jspring.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberEntityRepository extends JpaRepository<MemberEntity, Long> {
    MemberEntity findById(String id);
}