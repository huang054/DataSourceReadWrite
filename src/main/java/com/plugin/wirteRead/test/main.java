package com.plugin.wirteRead.test;

import com.plugin.wirteRead.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class main {
    @Autowired
    private MemberService memberService;

    public void testRead() {
        for (int i = 0; i < 4; i++) {
            System.out.println(memberService.find("123"));
        }
    }
    public static void main(String[] args) {
        new main().testRead();
    }
}
