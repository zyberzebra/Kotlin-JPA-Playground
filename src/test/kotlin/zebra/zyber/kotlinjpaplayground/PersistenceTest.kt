package zebra.zyber.kotlinjpaplayground

import org.hibernate.LazyInitializationException
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDate
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@SpringBootTest
class PersistenceTest {

    @Autowired
    lateinit var actorRepository : ActorRepository

    @Autowired
    lateinit var movieRepository : MovieRepository

    @Test
    fun equalityTest() {
        val actor = Actor(null, name = "Bill Murray")
        val movie = Movie(null, "Groundhog Day", LocalDate.of(1990, 1, 1), setOf(actor))

        assert(movie.id == null)

        val savedMovie = movieRepository.save(movie)

        assert(movie.id != null)
        assert(actor.id != null)

        assertEquals(movie, savedMovie)
        assertEquals(movie.actors.first(),actor)
    }

    @Test
    fun hashTest() {
        val actor = Actor(null, name = "Bill Murray")
        val movie = Movie(null, "Groundhog Day", LocalDate.of(1990, 1, 1), setOf(actor))

        val favoriteMovies = setOf(movie)

        val savedMovie = movieRepository.saveAndFlush(movie)

        val referenceById = movieRepository.getReferenceById(savedMovie.id!!)
        assertFailsWith<LazyInitializationException> { favoriteMovies.contains(referenceById) }
        // Fails with
        // could not initialize proxy - no Sessionorg.hibernate.LazyInitializationException:
        //      failed to lazily initialize a collection of role:
        //      zebra.zyber.kotlinjpaplayground.Movie.actors: could not initialize proxy - no Session

        // Can be Resolved With     @OneToMany(fetch = FetchType.EAGER)
    }

}