package org.corodiak.l4jspring.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.corodiak.l4jspring.entity.MemberEntity;
import org.corodiak.l4jspring.exception.MemberNotFoundException;
import org.corodiak.l4jspring.repository.MemberEntityRepository;
import org.corodiak.l4jspring.vo.MemberVo;
import org.springframework.stereotype.Service;
import org.corodiak.l4jspring.util.BCryptProvider;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberEntityRepository repository;
    private final BCryptProvider bCryptProvider;

    public MemberVo login(String id, String pw) throws MemberNotFoundException {
        MemberEntity entity = repository.findById(id);
        if(entity == null || !bCryptProvider.match(pw, entity.getPw())) {
            throw new MemberNotFoundException(id);
        }
        return new MemberVo(entity);
    }
}
