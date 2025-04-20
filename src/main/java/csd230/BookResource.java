package csd230;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

@Path("/books")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {

    @Inject
    EntityManager entityManager;
    @Inject
    BookService bookService;

    @GET
    public List<Book> listAll() {
        return bookService.list();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        Gift gift = entityManager.find(Gift.class, id);
        if (gift != null) {
            return Response.ok(gift).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    @POST
    @Transactional // Essential for database writes
    public Response createBook(Book b) {
        if(b.getTitle() == null || b.getTitle().isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Book must have a title").build();
        }
        if (b.getId() != null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("ID must not be provided for a new book").build();
        }

        return bookService.createBook(b);

    }
//    @POST
//    @Transactional // Essential for database writes
//    public Response createGift(Gift giftToCreate) {
//        // Basic validation
//        if (giftToCreate == null || giftToCreate.getName() == null || giftToCreate.getName().isBlank()) {
//            return Response.status(Response.Status.BAD_REQUEST).entity("Gift name cannot be blank").build();
//        }
//        if (giftToCreate.getId() != null) {
//            return Response.status(Response.Status.BAD_REQUEST).entity("ID must not be provided for a new gift").build();
//        }
//        if (giftToCreate.getPrice() != null && giftToCreate.getPrice().compareTo(BigDecimal.ZERO) < 0) {
//            return Response.status(Response.Status.BAD_REQUEST).entity("Price cannot be negative").build();
//        }
//
//        // Use EntityManager to persist
//        entityManager.persist(giftToCreate);
//
//        // Check ID assignment after persist (usually occurs on flush/commit)
//        if (giftToCreate.getId() != null) {
//            return Response.created(URI.create("/gifts/" + giftToCreate.getId()))
//                    .entity(giftToCreate)
//                    .build();
//        } else {
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Could not persist gift or retrieve ID.").build();
//        }
//    }

    @DELETE
    @Path("/{id}")
    @Transactional // Essential for database writes
    public Response deleteGift(@PathParam("id") Long id) {
        Gift giftToDelete = entityManager.find(Gift.class, id);
        if (giftToDelete != null) {
            entityManager.remove(giftToDelete);
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Transactional // Essential for database writes
    public Response updateGift(@PathParam("id") Long id, Gift updatedGiftData) {
        if (updatedGiftData == null || updatedGiftData.getName() == null || updatedGiftData.getName().isBlank()) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Gift name cannot be blank").build();
        }
        if (updatedGiftData.getPrice() != null && updatedGiftData.getPrice().compareTo(BigDecimal.ZERO) < 0) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Price cannot be negative").build();
        }

        Gift existingGift = entityManager.find(Gift.class, id);
        if (existingGift == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        // Update fields of the managed entity
        existingGift.setName(updatedGiftData.getName());
        existingGift.setRecipient(updatedGiftData.getRecipient());
        existingGift.setPrice(updatedGiftData.getPrice());

        // Changes are flushed on transaction commit
        return Response.ok(existingGift).build();
    }
}
