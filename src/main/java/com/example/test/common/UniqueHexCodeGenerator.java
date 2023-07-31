package com.example.test.common;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class UniqueHexCodeGenerator {
    @NotNull
    public static String generateUniqueHexCode() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replaceAll("-", "");
    }
}
