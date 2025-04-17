package org.ilankumarani;

import com.ilan.entity.Blog;
import com.ilan.entity.QBlog;
import com.ilan.repository.BlogRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.ilan.entity.Owner;
import io.ilan.entity.QOwner;
import io.ilan.repository.OwnerRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
@SpringBootTest(useMainMethod = SpringBootTest.UseMainMethod.WHEN_AVAILABLE)
class CustomEnableJpaRepositoryTest extends TestData{


    private final EntityManager entityManager;
    private JPAQueryFactory jpaQueryFactory;
	private static final QBlog qBlog = QBlog.blog;
	private static final QOwner qOwner = QOwner.owner;
	private final BlogRepository blogRepository;
	private final OwnerRepository ownerRepository;

    @BeforeAll
    public void beforeAll() {
        jpaQueryFactory = new JPAQueryFactory(entityManager);
    }




    @Order(1)
    @Test
    void saveAll() {
		List<Blog> blogs = blogRepository.saveAll(getBlogs(null));
		assertEquals(3, blogs.size());

        List<Owner> owners = ownerRepository.saveAll(getOwners(null));
        assertEquals(3, owners.size());
    }

    @Order(2)
    @Test
    void findById(){
        Blog blog = blogRepository.findById(1L).orElse(null);
        Owner owner = ownerRepository.findById(1L).orElse(null);
        assertTrue(EqualsBuilder.reflectionEquals(blog, getBlogs(1L).stream().findFirst().orElse(null)));
        assertTrue(EqualsBuilder.reflectionEquals(owner, getOwners(1L).stream().findFirst().orElse(null)));
    }

}
