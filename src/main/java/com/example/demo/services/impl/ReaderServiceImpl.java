package com.example.demo.services.impl;

import com.example.demo.services.ReaderService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Objects;

@Service
public class ReaderServiceImpl implements ReaderService {

    @Override
    public byte[] getContent(String filePath) {
        return readAllBytes(filePath);
    }

    private byte[] readAllBytes(String fileName) {
        try {
            return Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(fileName)).readAllBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
