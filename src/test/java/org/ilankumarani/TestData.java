package org.ilankumarani;

import com.ilan.entity.Blog;

import java.util.Arrays;
import java.util.List;

public class TestData {

    public List<Blog> getBlogs(){
        List<Blog> blogs = Arrays.asList(
                Blog.builder()
                        .id(1L)
                        .title("Spring Boot Basics")
                        .category("Programming")
                        .content("Introduction to Spring Boot...")
                        .build(),

                Blog.builder()
                        .id(2L)
                        .title("Traveling to Japan")
                        .category("Travel")
                        .content("Here's what you need to know before visiting Japan...")
                        .build(),

                Blog.builder()
                        .id(3L)
                        .title("Healthy Recipes")
                        .category("Food")
                        .content("Check out these 5 healthy recipes...")
                        .build()
        );

        return blogs;
    }
}
