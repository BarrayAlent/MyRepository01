package com.ujiuye.service;

import com.ujiuye.util.VerifyCodeUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author Tch
 * @create 2020-01-03-11:09
 */
@Service
public class UserServeiceImpl implements UserServeice {

    @Override
    public Responsebean createCode() {
        File dir = new File("D://upload");
        int w = 200, h = 80;
        String verifyCode = VerifyCodeUtils.generateVerifyCode(5);

        //String codeName=System.currentTimeMillis() + ".jpg";

        String codeName = UUID.randomUUID() + ".jpg";

        File file = new File(dir, codeName);
        try {
            VerifyCodeUtils.outputImage(w, h, file, verifyCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Responsebean response = new Responsebean();
        response.setData(codeName);

        return response;


    }
}
