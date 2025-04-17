package org.ilankumarani;

import com.ilan.entity.Blog;
import io.ilan.entity.Owner;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TestData {

    public List<Blog> getBlogs(Long id) {
        List<Blog> blogs = Arrays.asList(Blog.builder().id(1L).title("Spring Boot Basics").category("Programming").content("Introduction to Spring Boot...").build(),

                Blog.builder().id(2L).title("Traveling to Japan").category("Travel").content("Here's what you need to know before visiting Japan...").build(),

                Blog.builder().id(3L).title("Healthy Recipes").category("Food").content("Check out these 5 healthy recipes...").build());

        return Objects.isNull(id) ? blogs : blogs.stream().filter(blog -> blog.getId() == id).collect(Collectors.toList());
    }

    public List<Owner> getOwners(Long id) {
        List<Owner> owners = Arrays.asList(Owner.builder().id(1L).name("Alice Smith").email("alice@example.com").build(),

                Owner.builder().id(2L).name("Bob Johnson").email("bob@example.com").build(),

                Owner.builder().id(3L).name("Carol Davis").email("carol@example.com").build());

        return Objects.isNull(id) ? owners : owners.stream().filter(owner -> owner.getId() == id).collect(Collectors.toList());
    }
}
