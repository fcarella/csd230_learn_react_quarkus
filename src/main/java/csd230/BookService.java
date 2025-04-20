package csd230;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;

@ApplicationScoped
public class BookService {
    @Inject
    EntityManager entityManager;

    public String greeting(String name) {
        return "hello " + name;
    }

    @Transactional
    public Response createBook(Book b) {
        entityManager.persist(b);
        // Check ID assignment after persist (usually occurs on flush/commit)
        if (b.getId() != null) {
            return Response.created(URI.create("/books/" + b.getId()))
                    .entity(b)
                    .build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Could not persist book or retrieve ID.").build();
        }

    }

    public List<Book> list() {
        List<Book> l = entityManager.createQuery("SELECT b FROM Book b ORDER BY b.title", Book.class)
                .getResultList();
        System.out.println(l);
        return l;

    }
}
