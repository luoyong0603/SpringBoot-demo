//package com.example.demo.component.redis.build;
//
//import com.example.demo.component.redis.mediat.RedisMediator;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
///**
// * 手机验证码组件
// *
// * @author luoYong
// * @version 1.0
// * @date 2022/1/21 14:06
// */
//@Component
//public class PhoneCodeBuilder {
//
//    @Autowired
//    private RedisMediator redisMediator;
//
//
//    /**
//     * 随机获取六位数字
//     *
//     * @return
//     */
//    public String getCode() {
//        int code = (int) ((Math.random() * 9 + 1) * 100000);
//        return String.valueOf(code);
//    }
//
//    /**
//     * 获取验证码，存入redis中并设置过期时间
//     */
//    public void verifyCode(String phone) {
//        //1、定义手机号、验证码标识、申请间隔
//        String phoneKey = phone + "_count";
//        String codeKey = phone + "_code";
//        //2、每个号码只能发送三次
//        String count = redisMediator.get(phoneKey);
//        //3、从次数进行判断
//        if (count == null) {
//            //说明此号码第一次申请
//            //插入phone标识，并设置过期时间
//            redisMediator.set(phoneKey, "1", Long.valueOf(24 * 60 * 60));
//        } else if (Integer.parseInt(count) <= 2) {
//            //获取当前用户验证码剩余时间
//            long keyExpirationTime = redisMediator.getKeyExpirationTime(phoneKey);
//            System.out.println("keyExpirationTime:" + keyExpirationTime);
//            //获取当前次数
//            String codeCount = redisMediator.get(phoneKey);
//            //次数+1
//            int newCount = Integer.parseInt(codeCount) + 1;
//            redisMediator.set(phoneKey, String.valueOf(newCount), keyExpirationTime);
//        } else {
//            //当天3次机会用完了
//            System.out.println("当天3次机会用完了!请明日再试");
//            return;
//        }
//        //获取随机6位验证码
//        String code = this.getCode();
//        //验证码存入redis并设置过期时间(2min)
//        redisMediator.set(codeKey, code, Long.valueOf(2 * 60));
//    }
//
//
//    /**
//     * 校验验证码是否有效
//     */
//    public boolean checkCode(String phone, String code) {
//        String codeKey = phone + "_code";
//        String redisCode = redisMediator.get(codeKey);
//        if (code.equals(redisCode)) {
//            return true;
//        }
//        return false;
//
//    }
//
//}
