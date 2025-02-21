package com.test.test;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-09-22 11:29
 */
public class BufferTest {

    @Test
    public void testAppend() {
        String rootPath = BufferTest.class.getResource("/").getPath();
        try (RandomAccessFile file = new RandomAccessFile(rootPath + "data.txt", "rw")) {
            FileChannel channel = file.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (channel.read(buffer) != -1) {
                buffer.flip();
                //buffer.array();
                System.out.println(new String(buffer.array(), "utf-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getPath() {
        String rootPath = BufferTest.class.getResource("/").getPath();
        System.out.println(rootPath);
        System.out.println(new File(rootPath + "data.txt").exists());
    }

    @Test
    public void testFlip() {
        CharBuffer buffer = CharBuffer.allocate(1024);
        System.out.println("limit:" + buffer.limit());
        System.out.println("capacity:" + buffer.capacity());
        buffer.flip();
        System.out.println("limit:" + buffer.limit());
        System.out.println("capacity:" + buffer.capacity());
    }
}
