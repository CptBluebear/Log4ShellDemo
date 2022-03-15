package org.corodiak.l4jspring.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.corodiak.l4jspring.entity.MemberEntity;

@Getter
@AllArgsConstructor
@ToString
public class MemberVo {
    private Long seq;
    private String id;
    private String pw;

    public MemberVo(MemberEntity entity) {
        this.seq = entity.getSeq();
        this.id = entity.getId();
        this.pw = entity.getPw();
    }
}
