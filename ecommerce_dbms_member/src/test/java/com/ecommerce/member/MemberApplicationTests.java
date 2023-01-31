package com.ecommerce.member;

import com.ecommerce.member.dao.MemberDao;
import com.ecommerce.member.entity.MemberEntity;
import com.ecommerce.member.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberApplicationTests {

    @Autowired
    MemberDao memberDao;

    @Autowired
    MemberService memberService;

    @Test
    void contextLoads() {
    }
    @Test
    void testInsert() {
        for (int i = 0; i < 20; i++) {
            MemberEntity memberEntity = new MemberEntity();
            memberEntity.setNickname("test" + i);
            memberService.save(memberEntity);
        }
    }
}
