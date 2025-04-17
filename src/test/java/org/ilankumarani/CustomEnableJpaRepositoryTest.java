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
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
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



    @Test
    void saveAll() {
		List<Blog> blogs = blogRepository.saveAll(getBlogs(null));
		assertEquals(3, blogs.size());

        List<Owner> owners = ownerRepository.saveAll(getOwners(null));
        assertEquals(3, owners.size());
    }

    void findById(){
        Blog blog = blogRepository.findById(1L).orElse(null);
        Owner owner = ownerRepository.findById(1L).orElse(null);
    }

}
