package com.example.demo.component.javaDemo.JavaPackage.serializable;

import java.io.*;

public class SerializableTest {


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user = new User("Tom", 20);

        // 将 User 对象序列化成字节数组
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);
        out.writeObject(user);
        byte[] bytes = bos.toByteArray();

        // 将字节数组反序列化成 User 对象
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream in = new ObjectInputStream(bis);
        User user2 = (User) in.readObject();

        // 验证两个 User 对象是否相同
        System.out.println(user.equals(user2)); // true
    }


}
