package zebra.zyber.kotlinjpaplayground

import org.springframework.data.jpa.repository.JpaRepository

interface ActorRepository : JpaRepository<Actor, Long> {
}