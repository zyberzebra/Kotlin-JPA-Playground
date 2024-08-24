package zebra.zyber.kotlinjpaplayground

import org.springframework.data.jpa.repository.JpaRepository

interface MovieRepository : JpaRepository<Movie, Long> {
}