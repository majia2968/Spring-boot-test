package com.testing.springboot.init;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter @Setter
@ConfigurationProperties(prefix = "library")
public class LibrarySettings {
    private int size;
}
